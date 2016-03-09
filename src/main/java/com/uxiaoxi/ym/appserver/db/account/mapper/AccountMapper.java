package com.uxiaoxi.ym.appserver.db.account.mapper;

import com.uxiaoxi.ym.appserver.db.account.dto.Account;
import com.uxiaoxi.ym.appserver.db.account.dto.AccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table account
     * @mbggenerated  Wed Mar 09 16:44:18 CST 2016
     */
    int countByExample(AccountExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table account
     * @mbggenerated  Wed Mar 09 16:44:18 CST 2016
     */
    int deleteByExample(AccountExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table account
     * @mbggenerated  Wed Mar 09 16:44:18 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table account
     * @mbggenerated  Wed Mar 09 16:44:18 CST 2016
     */
    int insert(Account record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table account
     * @mbggenerated  Wed Mar 09 16:44:18 CST 2016
     */
    int insertSelective(Account record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table account
     * @mbggenerated  Wed Mar 09 16:44:18 CST 2016
     */
    List<Account> selectByExample(AccountExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table account
     * @mbggenerated  Wed Mar 09 16:44:18 CST 2016
     */
    Account selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table account
     * @mbggenerated  Wed Mar 09 16:44:18 CST 2016
     */
    int updateByExampleSelective(@Param("record") Account record,
            @Param("example") AccountExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table account
     * @mbggenerated  Wed Mar 09 16:44:18 CST 2016
     */
    int updateByExample(@Param("record") Account record,
            @Param("example") AccountExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table account
     * @mbggenerated  Wed Mar 09 16:44:18 CST 2016
     */
    int updateByPrimaryKeySelective(Account record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table account
     * @mbggenerated  Wed Mar 09 16:44:18 CST 2016
     */
    int updateByPrimaryKey(Account record);
    
    
}