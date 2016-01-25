$(document).ready(function() {
    /* jqgrid =====start===== */
    var separate = ",";
    $('#list').jqGrid(
            {
                url : '/account/data',
                datatype : 'json',
                mtype : 'POST',
                autowidth : true,
                hidegrid:false,
                colNames : [ 'ID', '帐号','密码', '姓名', '拼音缩写', '部门', '部门id', '权限',
                        '权限id','计算工资?', '启用' ],
                colModel : [ {
                    name : 'id',
                    index : 'u.id',
                    width : 45,
                    editable : true,
                    hidden:true
                }, {
                    name : 'account',
                    index : 'u.account',
                    width : 85,
                    editrules : {
                        required : true
                    },
                    editable : true
                }, {
                    name : 'password',
                    index : 'u.password',
                    width : 85,
                    align:'center',
                    editable : true,
                    formatter : passwordStar
                }, {
                    name : 'name',
                    index : 'i.name',
                    width : 60,
                    align:'center',
                    editrules : {
                        required : true
                    },
                    editable : true
                }, {
                    name : 'alias',
                    index : 'i.alias',
                    width : 60,
                    align:'center',
                    editable : true
                }, {
                    name : 'dept_names',
                    index : 'dept_names',
                    width : 145,
                    sortable:false,
                    editable : false
                }, {
                    name : 'dept_ids',
                    index : 'dept_ids',
                    hidden : true,
                    sortable:false,
                    width : 80,
                    editable : false
                }, {
                    name : 'role_names',
                    index : 'role_names',
                    sortable:false,
                    width : 65,
                    editable : false
                }, {
                    name : 'role_ids',
                    index : 'role_ids',
                    hidden : true,
                    sortable:false,
                    width : 80,
                    editable : false
                }, {
                    name : 'hasSalary',
                    index : 'u.has_salary',
                    width : 50,
                    align:'center',
                    editable : true,
                    edittype : 'select',
                    formatter:useynFormat,
                    editoptions : {
                        value : 'true:启用;false:禁用'
                    }
                }, {
                    name : 'useYn',
                    index : 'u.use_yn',
                    width : 50,
                    align:'center',
                    editable : true,
                    edittype : 'select',
                    formatter:useynFormat,
                    editoptions : {
                        value : 'true:启用;false:禁用'
                    }
                } ],
                ondblClickRow : function(id) {
                    jQuery(this).editGridRow(id, {
                        url : '/account/edit',
                        closeAfterEdit : true,
                        closeOnEscape : true
                    });
                },
                rowNum : 25,
                rowList : [ 25, 50, 100 ],
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
                pager : '#pager',
                sortname : 'id',
                viewrecords : true,
                sortorder : 'desc',
                editurl : '/account/edit',
                caption : '用户管理',
                onSelectRow : function(id) {
                    if (id) {
 
                        var treeObj = $.fn.zTree.getZTreeObj("dept_tree");
                        treeObj.checkAllNodes(false);
                        var rowdata = $("#list").getRowData(id);
                        var deptIds = (rowdata.dept_ids).split(separate);
                        var size = deptIds.length;
                        for ( var i = 0; i < size; i++) {
                            var nodes = treeObj.getNodesByParam("id",
                                    deptIds[i], null);
                            if (nodes.length > 0) {
                                treeObj.checkNode(nodes[0], true, false);
                            }
                        }
                        $("#dept_user_id").val(id);

                        var treeObj = $.fn.zTree.getZTreeObj("role_tree");
                        treeObj.checkAllNodes(false);
                        var rowdata = $("#list").getRowData(id);
                        var roleIds = (rowdata.role_ids).split(separate);
                        var size = roleIds.length;
                        for ( var i = 0; i < size; i++) {
                            var nodes = treeObj.getNodesByParam("id",
                                    roleIds[i], null);
                            if (nodes.length > 0) {
                                treeObj.checkNode(nodes[0], true, false);
                            }
                        }
                        $("#user_id").val(id);
                    }
                }
            });
    $('#list').jqGrid('navGrid', '#pager', {
        edit : true,
        add : true,
        del : true
    }, {
        url : '/account/edit',
        closeAfterEdit : true,
        closeOnEscape : true
    }, {
        url : '/account/add',
        closeAfterAdd : true,
        clearAfterAdd : true,
        closeOnEscape : true
    }, {
        url : '/account/del',
        closeOnEscape : true
    }, {
        sopt:['cn','nc','nu','nn','eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en'],
        multipleSearch : true,
        multipleGroup : false,
        closeAfterSearch : true,
        showQuery : false,
        searchOnEnter : true,
        closeOnEscape : true
    }, {});

    function useynFormat (cellvalue, options, rowObject)
    {   
        if(cellvalue == true ) {
            return "启用";
        } else {
            return "禁用";
        }
       
    }
    /* jqgrid =====end===== */

    /* ZTree =====start===== */
    var dept_setting = {
        check : {
            enable : true,
            chkStyle : "checkbox",
            chkboxType : {
                "Y" : "",
                "N" : ""
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
            url : "/account/depttree"
        }
    };

    $.fn.zTree.init($("#dept_tree"), dept_setting, null);

    $("#setUserDept").click(function getChecked() {
        var treeObj = $.fn.zTree.getZTreeObj("dept_tree");
        var nodes = treeObj.getCheckedNodes(true);
        var deptIds = "";

        var size = nodes.length;
        for ( var i = 0; i < size; i++) {
            deptIds = deptIds + nodes[i].id;
            if (i !== size - 1) {
                deptIds = deptIds + separate;
            }
        }

        $("#dept_ids").val(deptIds);

        var data = $("#dept_form").serialize();
        $.ajax({
            type : 'POST',
            url : '/account/updatedept',
            data : data,
            success : function(json) {
                $("#list").trigger('reloadGrid');
            },
            dataType : 'json'
        });
    });

    /* ZTree =====end===== */

    /* ZTree2 =====start===== */
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
            url : "/account/roletree"
        }
    };

    $.fn.zTree.init($("#role_tree"), setting, null);

    $("#setUserRole").click(function getChecked() {
        var treeObj = $.fn.zTree.getZTreeObj("role_tree");
        var nodes = treeObj.getCheckedNodes(true);
        var roleIds = "";

        var size = nodes.length;
        for ( var i = 0; i < size; i++) {
            roleIds = roleIds + nodes[i].id;
            if (i !== size - 1) {
                roleIds = roleIds + separate;
            }
        }

        $("#role_ids").val(roleIds);

        var data = $("#role_form").serialize();
        $.ajax({
            type : 'POST',
            url : '/account/updaterole',
            data : data,
            success : function(json) {
                $("#list").trigger('reloadGrid');
            },
            dataType : 'json'
        });
    });

    /* ZTree2 =====end===== */
    
    
    $(window).bind('resize', function() {
        $("#list").setGridHeight($(window).height()-210);
    });
    
    $("#list").setGridHeight($(window).height()*0.68);
});