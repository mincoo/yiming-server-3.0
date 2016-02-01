/**
 * IAccountDao.java
 */
package com.uxiaoxi.ym.appserver.db.account.dao;

import com.uxiaoxi.ym.appserver.db.account.dto.Account;
import com.uxiaoxi.ym.appserver.framework.db.IBaseSupport;

/**
 * @author renhao
 *
 * 2015-1-27
 */
public interface IAccountDao extends IBaseSupport<Account> {

    /**
     * @param mobile
     * @return
     */
    public Account getAccountByMobile(String phone);

    /**
     * @param uid
     * @return
     */
    public String getName(Long uid);

}
