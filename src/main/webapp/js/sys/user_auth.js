$(function() {
    /* jqgrid =====start===== */
    var separate = ",";
    $('#list').jqGrid({
        url : '/sys/auth/data',
        datatype : 'json',
        mtype : 'POST',
        autowidth : true,
        colNames : [ 'ID', '名称', '权限' ],
        colModel : [ {
            name : 'id',
            index : 'id',
            width : 80,
            align:'center',
            editable : true,
            hidden:true
        }, {
            name : 'name',
            index : 'name',
            width : 250,
            align:'center',
            editrules : {
                required : true
            },
            editable : true
        }, {
            name : 'uriIds',
            index : 'uri_ids',
            width : 250,
            align:'center',
            editable : true
        } ],
        rowNum : 10,
        rowList : [ 10, 20, 30 ],
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
                url : '/sys/auth/edit',
                closeAfterEdit : true,
                closeOnEscape : true
            });
        },
        pager : '#pager',
        sortname : 'id',
        viewrecords : true,
        sortorder : 'desc',
        editurl : '/sys/auth/edit',
        caption : '角色管理',

        onSelectRow : function(id) {
            if (id) {
                var treeObj = $.fn.zTree.getZTreeObj("ztree");
                treeObj.checkAllNodes(false);
                var rowdata = $("#list").getRowData(id);
                var uriIds = (rowdata.uriIds).split(separate);
                var size = uriIds.length;
                for ( var i = 0; i < size; i++) {
                    var nodes = treeObj.getNodesByParam("id", uriIds[i], null);
                    if(nodes.length>0) {
                        treeObj.checkNode(nodes[0], true, false);
                    }
                }
                
                $("#role_id").val(id);
                $("#role_name").val(rowdata.name);
            }
        }
    });
    $('#list').jqGrid('navGrid', '#pager', {
        edit : true,
        add : true,
        del : true
    }, {
        url : '/sys/auth/edit',
        closeAfterEdit : true,
        closeOnEscape : true
    }, {
        url : '/sys/auth/add',
        closeAfterAdd : true,
        clearAfterAdd : true,
        closeOnEscape : true
    }, {
        url : '/sys/auth/del',
        closeOnEscape : true
    }, {
        multipleSearch : true,
        multipleGroup : false,
        closeAfterSearch : true,
        showQuery : false,
        searchOnEnter : true,
        closeOnEscape : true
    }, {});

    /* jqgrid =====end===== */

    /* ZTree =====start===== */
    var setting = {
        check : {
            enable : true,
            chkStyle : "checkbox",
            chkboxType : {
                "Y" : "ps",
                "N" : "ps"
            }
        },
        data : {
            simpleData : {
                enable : true,
                idKey : "id",
                pIdKey : "pid",
                rootPId : 0
            },
            key : {
                name : "name",
                title : "title"
            }
        },
        async : {
            enable : true,
            dataType : "text",
            url : "/sys/auth/treedata",
            autoParam : [ "id=id" ]
        }
    };

    $.fn.zTree.init($("#ztree"), setting, null);

    $("#setUserAuth").click(function getChecked() {
        var treeObj = $.fn.zTree.getZTreeObj("ztree");
        var nodes = treeObj.getCheckedNodes(true);
        var uriIds = "";

        var size = nodes.length;
        for ( var i = 0; i < size; i++) {
            uriIds = uriIds + nodes[i].id ;
            if (i !== size - 1) {
                uriIds = uriIds + separate;
            }
        }

        $("#role_uriIds").val(uriIds);
        
        var data = $("#auth_form").serialize();
        $.ajax({
            type : 'POST',
            url : '/sys/auth/auth',
            data : data,
            success : function(json) {
                $("#list").trigger('reloadGrid');
            },
            dataType : 'json'
        });
    });

    /* ZTree =====end===== */
    
    $(window).bind('resize', function() {
        $("#list").setGridHeight($(window).height()-210);
    });
    
    $("#list").setGridHeight($(window).height()*0.68);
});