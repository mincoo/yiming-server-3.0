package com.uxiaoxi.ym.appserver.db.account.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uxiaoxi.ym.appserver.db.account.dto.Account;
import com.uxiaoxi.ym.appserver.db.account.dto.AccountExample;
import com.uxiaoxi.ym.appserver.web.account.vo.SearchByPhoneForm;
import com.uxiaoxi.ym.appserver.web.account.vo.SearchForm;
import com.uxiaoxi.ym.appserver.web.account.vo.SearchUserResultVO;

public interface AccountMapper {
    int countByExample(AccountExample example);

    int deleteByExample(AccountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Account record);

    int insertSelective(Account record);

    List<Account> selectByExample(AccountExample example);

    Account selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
    
    List<SearchUserResultVO> searchUser(SearchForm form);
    
    SearchUserResultVO searchUserByPhone(SearchByPhoneForm form);
}