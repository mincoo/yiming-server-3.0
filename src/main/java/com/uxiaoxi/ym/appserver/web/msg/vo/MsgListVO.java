/**
 * MsgListVO.java
 */
package com.uxiaoxi.ym.appserver.web.msg.vo;

import java.util.List;

/**
 * @author renhao
 *
 *         2015年3月11日
 */
public class MsgListVO {

    private Long mid;

    private Long gid;

    private Long uid;

    private Integer type;

    private String url;
    
    private String content;

    private String gname;

    private String uname;

    private String stime;

    private Integer stype;

    private String face;

    private String select1;

    private String select2;

    private Long sum1;

    private Long sum2;

    private Integer selected;

    private Long size;

    private List<MsgDataPatInfo> list;

    /**
     * @return the mid
     */
    public Long getMid() {
        return mid;
    }

    /**
     * @param mid
     *            the mid to set
     */
    public void setMid(Long mid) {
        this.mid = mid;
    }

    /**
     * @return the type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     *            the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the gname
     */
    public String getGname() {
        return gname;
    }

    /**
     * @param gname
     *            the gname to set
     */
    public void setGname(String gname) {
        this.gname = gname;
    }

    /**
     * @return the uname
     */
    public String getUname() {
        return uname;
    }

    /**
     * @param uname
     *            the uname to set
     */
    public void setUname(String uname) {
        this.uname = uname;
    }

    /**
     * @return the stime
     */
    public String getStime() {
        return stime;
    }

    /**
     * @param stime
     *            the stime to set
     */
    public void setStime(String stime) {
        this.stime = stime;
    }

    /**
     * @return the gid
     */
    public Long getGid() {
        return gid;
    }

    /**
     * @param gid
     *            the gid to set
     */
    public void setGid(Long gid) {
        this.gid = gid;
    }

    /**
     * @return the uid
     */
    public Long getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * @return the stype
     */
    public Integer getStype() {
        return stype;
    }

    /**
     * @param stype the stype to set
     */
    public void setStype(Integer stype) {
        this.stype = stype;
    }

    /**
     * @return the face
     */
    public String getFace() {
        return face;
    }

    /**
     * @param face the face to set
     */
    public void setFace(String face) {
        this.face = face;
    }

    /**
     * @return the select1
     */
    public String getSelect1() {
        return select1;
    }

    /**
     * @param select1 the select1 to set
     */
    public void setSelect1(String select1) {
        this.select1 = select1;
    }

    /**
     * @return the select2
     */
    public String getSelect2() {
        return select2;
    }

    /**
     * @param select2 the select2 to set
     */
    public void setSelect2(String select2) {
        this.select2 = select2;
    }

    /**
     * @return the sum1
     */
    public Long getSum1() {
        return sum1;
    }

    /**
     * @param sum1 the sum1 to set
     */
    public void setSum1(Long sum1) {
        this.sum1 = sum1;
    }

    /**
     * @return the sum2
     */
    public Long getSum2() {
        return sum2;
    }

    /**
     * @param sum2 the sum2 to set
     */
    public void setSum2(Long sum2) {
        this.sum2 = sum2;
    }

    /**
     * @return the selected
     */
    public Integer getSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(Integer selected) {
        this.selected = selected;
    }

    /**
     * @return the size
     */
    public Long getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(Long size) {
        this.size = size;
    }

    /**
     * @return the list
     */
    public List<MsgDataPatInfo> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<MsgDataPatInfo> list) {
        this.list = list;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

}
