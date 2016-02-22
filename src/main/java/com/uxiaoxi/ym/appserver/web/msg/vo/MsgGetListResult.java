/**
 * MsgGetListResult.java
 */
package com.uxiaoxi.ym.appserver.web.msg.vo;

import com.uxiaoxi.ym.appserver.web.common.vo.ListResult;

/**
 * @author zoujy
 *
 */
public class MsgGetListResult extends ListResult<MsgListVO> {
    
    private Long version;

    /**
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    
}

