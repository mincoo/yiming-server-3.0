$(function() {
    $('#list').jqGrid(
            {
                url : '/sys/uri/data',
                datatype : 'json',
                mtype : 'POST',
                autowidth : true,
                colNames : [ 'ID', '父ID', '名称', 'URL', 'Target','type', '排序','状态' ],
                colModel : [ {
                    name : 'id',
                    index : 'id',
                    width : 60,
                    align:'center',
                    editable:true,
                    hidden:true
                }, {
                    name : 'pid',
                    index : 'pid',
                    width : 70,
                    align:'center',
                    editrules:{required:true},
                    editable:true,
                    editoptions:{size:5}
                }, {
                    name : 'name',
                    index : 'name',
                    width : 85,
                    align:'center',
                    editrules:{required:true},
                    editable:true
                }, {
                    name : 'url',
                    index : 'url',
                    width : 95,
                    editrules:{required:true},
                    editable:true
                }, {
                    name : 'target',
                    index : 'target',
                    width : 95,
                    editable:true,
                    editoptions:{size:10}
                }, {
                    name : 'type',
                    index : 'type',
                    width : 70,
                    align:'center',
                    editrules:{required:true},
                    editable:true,
                    edittype:'select',
                    editoptions:{value:'1:菜单;2:页面;3:ajax'}
                }, {
                    name : 'sort',
                    index : 'sort',
                    width : 70,
                    align:'center',
                    editable:true,
                    editrules:{required:true},
                    edittype:'text',
                    editoptions:{defaultValue:'0',size:5}
                }, {
                    name : 'useYn',
                    index : 'use_yn',
                    width : 70,
                    align:'center',
                    editable:true,
                    edittype:'select',
                    editoptions:{value:'true:启用;false:禁用'}
                }],
                rowNum : 23,
                rowList : [ 30, 60, 100 ],
                jsonReader : {
                    root : 'data',
                    page : 'pageNO',
                    total : 'totalPageCount',
                    records : 'totalCount'
                },
                prmNames : {
                    page : 'page_no',
                    rows : 'page_size',
                    search : 'search'
                },
                ondblClickRow : function(id) {
                    jQuery(this).editGridRow(id, {
                        url : '/sys/uri/edit',
                        closeAfterEdit : true,
                        closeOnEscape : true
                    });
                },
                pager : '#pager',
                sortname : 'id',
                viewrecords : true,
                sortorder : 'desc',
                editurl:'/sys/uri/edit',
                caption : 'URI管理'
            });
    $('#list').jqGrid('navGrid', '#pager', {
        edit : true,
        add : true,
        del : true
    }, {
        url:'/sys/uri/edit',
        closeAfterEdit:true,
        closeOnEscape:true
    }, {
        url:'/sys/uri/add',
        closeAfterAdd:true,
        clearAfterAdd:true,
        closeOnEscape:true
    }, {
        url:'/sys/uri/del',
        closeOnEscape:true
    }, {
        multipleSearch : true,
        multipleGroup : false,
        closeAfterSearch : true,
        showQuery : false,
        searchOnEnter : true,
        closeOnEscape : true
    }, {});
    
    $(window).bind('resize', function() {
        $("#list").setGridWidth($(window).width()-270);
        $("#list").setGridHeight($(window).height()-210);
    });
    
    $("#list").setGridHeight($(window).height()*0.68);
});