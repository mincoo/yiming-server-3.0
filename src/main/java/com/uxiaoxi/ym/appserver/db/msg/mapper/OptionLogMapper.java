package com.uxiaoxi.ym.appserver.db.msg.mapper;

import com.uxiaoxi.ym.appserver.db.msg.dto.OptionLog;
import com.uxiaoxi.ym.appserver.db.msg.dto.OptionLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OptionLogMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table option_log
     * @mbggenerated  Sat Jan 30 20:32:53 CST 2016
     */
    int countByExample(OptionLogExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table option_log
     * @mbggenerated  Sat Jan 30 20:32:53 CST 2016
     */
    int deleteByExample(OptionLogExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table option_log
     * @mbggenerated  Sat Jan 30 20:32:53 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table option_log
     * @mbggenerated  Sat Jan 30 20:32:53 CST 2016
     */
    int insert(OptionLog record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table option_log
     * @mbggenerated  Sat Jan 30 20:32:53 CST 2016
     */
    int insertSelective(OptionLog record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table option_log
     * @mbggenerated  Sat Jan 30 20:32:53 CST 2016
     */
    List<OptionLog> selectByExampleWithBLOBs(OptionLogExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table option_log
     * @mbggenerated  Sat Jan 30 20:32:53 CST 2016
     */
    List<OptionLog> selectByExample(OptionLogExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table option_log
     * @mbggenerated  Sat Jan 30 20:32:53 CST 2016
     */
    OptionLog selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table option_log
     * @mbggenerated  Sat Jan 30 20:32:53 CST 2016
     */
    int updateByExampleSelective(@Param("record") OptionLog record,
            @Param("example") OptionLogExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table option_log
     * @mbggenerated  Sat Jan 30 20:32:53 CST 2016
     */
    int updateByExampleWithBLOBs(@Param("record") OptionLog record,
            @Param("example") OptionLogExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table option_log
     * @mbggenerated  Sat Jan 30 20:32:53 CST 2016
     */
    int updateByExample(@Param("record") OptionLog record,
            @Param("example") OptionLogExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table option_log
     * @mbggenerated  Sat Jan 30 20:32:53 CST 2016
     */
    int updateByPrimaryKeySelective(OptionLog record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table option_log
     * @mbggenerated  Sat Jan 30 20:32:53 CST 2016
     */
    int updateByPrimaryKeyWithBLOBs(OptionLog record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table option_log
     * @mbggenerated  Sat Jan 30 20:32:53 CST 2016
     */
    int updateByPrimaryKey(OptionLog record);
    
    //自定义方法：取消息版本
    Long getMsgVertion();
}