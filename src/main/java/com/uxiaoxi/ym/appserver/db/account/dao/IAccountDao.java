/**
 * IAccountDao.java
 */
package com.uxiaoxi.ym.appserver.db.account.dao;

import java.util.List;

import com.uxiaoxi.ym.appserver.db.account.dto.Account;
import com.uxiaoxi.ym.appserver.framework.db.IBaseSupport;
import com.uxiaoxi.ym.appserver.web.account.form.SearchByPhoneForm;
import com.uxiaoxi.ym.appserver.web.account.form.SearchForm;
import com.uxiaoxi.ym.appserver.web.account.vo.SearchUserResultVO;

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
     * @param name
     * @param startid
     * @return
     */
    public List<SearchUserResultVO> searchByName(SearchForm form);
    
    /**
     * @param phone
     * @return
     */
    public SearchUserResultVO searchByPhone(SearchByPhoneForm form);
    
    /**
     * @param uid
     * @return
     */
    public String getName(Long uid);

}
