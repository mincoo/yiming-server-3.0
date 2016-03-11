package com.uxiaoxi.ym.appserver.web.msg.form;

/**
 * 
 * 学校考勤表单
 * 
 * @author renhao
 *
 */
public class SchoolCheckForm extends BaseForm {

    /**
     * 姓名
     */
    private String name;

    /**
     * 到校/离校时间
     * 格式 yyyy年MM月dd日 hh:mm:ss
     * 
     */
    private String stime;
    
    
    /**
     * 学校名称
     */
    private String schoolName;
    
    /**
     * 到校还是离校
     * 
     * true:到校
     * false:离校
     * 
     */
    private Boolean direction;
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }


    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Boolean getDirection() {
        return direction;
    }

    public void setDirection(Boolean direction) {
        this.direction = direction;
    }

    
}
