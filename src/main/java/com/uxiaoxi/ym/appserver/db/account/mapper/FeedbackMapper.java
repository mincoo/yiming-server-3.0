package com.uxiaoxi.ym.appserver.db.account.mapper;

import com.uxiaoxi.ym.appserver.db.account.dto.Feedback;
import com.uxiaoxi.ym.appserver.db.account.dto.FeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeedbackMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table feedback
     * @mbggenerated  Sat Jan 30 20:07:31 CST 2016
     */
    int countByExample(FeedbackExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table feedback
     * @mbggenerated  Sat Jan 30 20:07:31 CST 2016
     */
    int deleteByExample(FeedbackExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table feedback
     * @mbggenerated  Sat Jan 30 20:07:31 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table feedback
     * @mbggenerated  Sat Jan 30 20:07:31 CST 2016
     */
    int insert(Feedback record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table feedback
     * @mbggenerated  Sat Jan 30 20:07:31 CST 2016
     */
    int insertSelective(Feedback record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table feedback
     * @mbggenerated  Sat Jan 30 20:07:31 CST 2016
     */
    List<Feedback> selectByExample(FeedbackExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table feedback
     * @mbggenerated  Sat Jan 30 20:07:31 CST 2016
     */
    Feedback selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table feedback
     * @mbggenerated  Sat Jan 30 20:07:31 CST 2016
     */
    int updateByExampleSelective(@Param("record") Feedback record,
            @Param("example") FeedbackExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table feedback
     * @mbggenerated  Sat Jan 30 20:07:31 CST 2016
     */
    int updateByExample(@Param("record") Feedback record,
            @Param("example") FeedbackExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table feedback
     * @mbggenerated  Sat Jan 30 20:07:31 CST 2016
     */
    int updateByPrimaryKeySelective(Feedback record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table feedback
     * @mbggenerated  Sat Jan 30 20:07:31 CST 2016
     */
    int updateByPrimaryKey(Feedback record);
}