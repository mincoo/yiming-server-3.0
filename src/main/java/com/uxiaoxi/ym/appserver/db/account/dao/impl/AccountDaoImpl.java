/**
 * AccountDaoImpl.java
 */
package com.uxiaoxi.ym.appserver.db.account.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uxiaoxi.ym.appserver.db.account.dao.IAccountDao;
import com.uxiaoxi.ym.appserver.db.account.dto.Account;
import com.uxiaoxi.ym.appserver.db.account.dto.AccountExample;
import com.uxiaoxi.ym.appserver.db.account.mapper.AccountMapper;
import com.uxiaoxi.ym.appserver.framework.db.impl.BaseSupport;
import com.uxiaoxi.ym.appserver.web.account.form.SearchByPhoneForm;
import com.uxiaoxi.ym.appserver.web.account.form.SearchForm;
import com.uxiaoxi.ym.appserver.web.account.vo.SearchUserResultVO;

/**
 * @author renhao
 *
 * 2015-1-27
 */
@Repository
public class AccountDaoImpl extends BaseSupport<Account, AccountMapper> implements IAccountDao {

    @Override
    public Account getAccountByMobile(String phone) {
        
        AccountMapper mapper = this.getSqlSession().getMapper(AccountMapper.class);
        
        AccountExample example = new AccountExample();
        example.createCriteria().andPhoneEqualTo(phone);
        
        List<Account>  list = mapper.selectByExample(example);
        
        if(list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
        
    }
    
    @Override
    public List<SearchUserResultVO> searchByName(SearchForm form){
        AccountMapper mapper = this.getSqlSession().getMapper(AccountMapper.class);
        return mapper.searchUser(form);
    }
    
    @Override
    public SearchUserResultVO searchByPhone(SearchByPhoneForm form){
        AccountMapper mapper = this.getSqlSession().getMapper(AccountMapper.class);
        return mapper.searchUserByPhone(form);
    }
    
    @Override
    public String getName(Long uid){
        AccountMapper mapper = this.getSqlSession().getMapper(AccountMapper.class);
        Account account = mapper.selectByPrimaryKey(uid);
        return account.getName();
    }

}
