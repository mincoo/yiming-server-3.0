/**
 * IInviteService.java
 */
package com.uxiaoxi.ym.appserver.biz.account;

import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;

/**
 * @author renhao
 *
 * 2015年2月25日
 */
public interface IInviteService {

    /**
     * @param userid
     * @param mobile
     * @param cluid
     * @return
     */
    public ResResult invite(Long userid, String mobile, Long cluid);

}
