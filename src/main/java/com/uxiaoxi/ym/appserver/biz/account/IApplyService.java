/**
 * IApplyService.java
 */
package com.uxiaoxi.ym.appserver.biz.account;

import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;

/**
 * @author renhao
 *
 * 2015年2月25日
 */
public interface IApplyService {

    /**
     * 
     * 
     * @param userid
     * @param cluid
     * @return
     */
    public ResResult apply(Long userid, Long cluid);

}
