/**
 * IAccountDao.java
 */
package com.uxiaoxi.ym.appserver.db.account.dao;

import com.uxiaoxi.ym.appserver.db.account.dto.Account;
import com.uxiaoxi.ym.appserver.framework.db.IBaseSupport;
import com.uxiaoxi.ym.appserver.framework.page.model.Page;
import com.uxiaoxi.ym.appserver.web.common.vo.SqlBean;

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

    public Page<Account> getData(SqlBean sqlBean, Integer page_no, Integer page_size);

}
