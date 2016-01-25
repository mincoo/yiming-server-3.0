$(function() {
    $('#list').jqGrid(
            {
                url : '/sys/dept/data',
                datatype : 'json',
                mtype : 'POST',
                autowidth : true,
                colNames : [ 'ID', '名称', '缩写', '负责人','从属部门', '排序','启用' ],
                colModel : [ {
                    name : 'id',
                    index : 'id',
                    width : 50,
                    align:'center',
                    hidden:true,
                    editable:true
                }, {
                    name : 'name',
                    index : 'name',
                    width : 100,
                    align:'center',
                    editrules:{required:true},
                    editable:true,
                    editoptions:{size:5}
                }, {
                    name : 'alias',
                    index : 'alias',
                    width : 90,
                    align:'center',
                    editrules:{required:true},
                    editable:true
                }, {
                    name : 'managerId',
                    index : 'manager_id',
                    width : 90,
                    align:'center',
                    editrules:{required:true},
                    editable:true
                }, {
                    name : 'parentId',
                    index : 'parent_id',
                    width : 90,
                    align:'center',
                    editable:true,
                    editoptions:{size:10}
                }, {
                    name : 'sort',
                    index : 'sort',
                    width : 65,
                    align:'center',
                    editable:true,
                    editrules:{required:true},
                    edittype:'text',
                    editoptions:{defaultValue:'0',size:5}
                }, {
                    name : 'useYn',
                    index : 'use_yn',
                    width : 65,
                    align:'center',
                    editable:true,
                    edittype:'select',
                    editoptions:{value:'true:启用;false:禁用'}
                }],
                rowNum : 23,
                rowList : [ 30,60,100 ],
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
                        url : '/sys/dept/edit',
                        closeAfterEdit : true,
                        closeOnEscape : true
                    });
                },
                pager : '#pager',
                sortname : 'id',
                viewrecords : true,
                sortorder : 'desc',
                editurl:'/sys/dept/edit',
                caption : 'URI管理'
            });
    $('#list').jqGrid('navGrid', '#pager', {
        edit : true,
        add : true,
        del : true
    }, {
        url:'/sys/dept/edit',
        closeAfterEdit:true,
        closeOnEscape:true
    }, {
        url:'/sys/dept/add',
        closeAfterAdd:true,
        clearAfterAdd:true,
        closeOnEscape:true
    }, {
        url:'/sys/dept/del',
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