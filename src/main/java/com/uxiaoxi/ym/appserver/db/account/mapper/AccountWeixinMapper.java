package com.uxiaoxi.ym.appserver.db.account.mapper;

import com.uxiaoxi.ym.appserver.db.account.dto.AccountWeixin;
import com.uxiaoxi.ym.appserver.db.account.dto.AccountWeixinExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountWeixinMapper {
    int countByExample(AccountWeixinExample example);

    int deleteByExample(AccountWeixinExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AccountWeixin record);

    int insertSelective(AccountWeixin record);

    List<AccountWeixin> selectByExample(AccountWeixinExample example);

    AccountWeixin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AccountWeixin record, @Param("example") AccountWeixinExample example);

    int updateByExample(@Param("record") AccountWeixin record, @Param("example") AccountWeixinExample example);

    int updateByPrimaryKeySelective(AccountWeixin record);

    int updateByPrimaryKey(AccountWeixin record);
}