

/* 日期格式化-----------------------*/
function dateFormater(cellvalue, options, rowObject) {
    if (cellvalue) {
        var d = new Date(cellvalue).format("yyyy-MM-dd hh:mm");
        return d;
    } else {
        return '';
    }
}

/* 日期格式化-----------------------*/
function dateFormatS(cellvalue, options, rowObject) {
    if (cellvalue) {
        var d = new Date(cellvalue).format("yyyy-MM-dd hh:mm:ss");
        return d;
    } else {
        return '';
    }
}

function dateFormatD(cellvalue, options, rowObject) {
    if (cellvalue) {
        var d = new Date(cellvalue).format("yyyy-MM-dd");
        return d;
    } else {
        return '';
    }
}

/* 密码替换为****** -----------------------*/
function passwordStar(cellvalue, options, rowObject) {
    return '******';
}

/* 操作记录结果-----------------------*/
function resultFormater(cellvalue, options, rowObject) {
    if (cellvalue==1) {
        return '成功';
    } else {
        return '失败';
    }
}

/*  -----*/
function formater_has_not(cellvalue, options, rowObject) {
    if (cellvalue) {
        return '有';
    } else {
        return '无';
    }
}
