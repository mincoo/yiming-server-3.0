package com.uxiaoxi.ym.appserver.db.msg.dto;

import java.util.Date;

public class MsgAcc {
    private Long id;

    private Long msgId;

    private Long cluId;

    private Long accId;

    private Integer readed;

    private Date createDt;

    private Boolean useYn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public Long getCluId() {
        return cluId;
    }

    public void setCluId(Long cluId) {
        this.cluId = cluId;
    }

    public Long getAccId() {
        return accId;
    }

    public void setAccId(Long accId) {
        this.accId = accId;
    }

    public Integer getReaded() {
        return readed;
    }

    public void setReaded(Integer readed) {
        this.readed = readed;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Boolean getUseYn() {
        return useYn;
    }

    public void setUseYn(Boolean useYn) {
        this.useYn = useYn;
    }
}