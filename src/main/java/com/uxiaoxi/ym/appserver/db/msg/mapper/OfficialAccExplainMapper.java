package com.uxiaoxi.ym.appserver.db.msg.mapper;

import com.uxiaoxi.ym.appserver.db.msg.dto.OfficialAccExplain;
import com.uxiaoxi.ym.appserver.db.msg.dto.OfficialAccExplainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OfficialAccExplainMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table official_acc_explain
     *
     * @mbggenerated Mon Feb 22 16:29:57 CST 2016
     */
    int countByExample(OfficialAccExplainExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table official_acc_explain
     *
     * @mbggenerated Mon Feb 22 16:29:57 CST 2016
     */
    int deleteByExample(OfficialAccExplainExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table official_acc_explain
     *
     * @mbggenerated Mon Feb 22 16:29:57 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table official_acc_explain
     *
     * @mbggenerated Mon Feb 22 16:29:57 CST 2016
     */
    int insert(OfficialAccExplain record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table official_acc_explain
     *
     * @mbggenerated Mon Feb 22 16:29:57 CST 2016
     */
    int insertSelective(OfficialAccExplain record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table official_acc_explain
     *
     * @mbggenerated Mon Feb 22 16:29:57 CST 2016
     */
    List<OfficialAccExplain> selectByExample(OfficialAccExplainExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table official_acc_explain
     *
     * @mbggenerated Mon Feb 22 16:29:57 CST 2016
     */
    OfficialAccExplain selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table official_acc_explain
     *
     * @mbggenerated Mon Feb 22 16:29:57 CST 2016
     */
    int updateByExampleSelective(@Param("record") OfficialAccExplain record, @Param("example") OfficialAccExplainExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table official_acc_explain
     *
     * @mbggenerated Mon Feb 22 16:29:57 CST 2016
     */
    int updateByExample(@Param("record") OfficialAccExplain record, @Param("example") OfficialAccExplainExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table official_acc_explain
     *
     * @mbggenerated Mon Feb 22 16:29:57 CST 2016
     */
    int updateByPrimaryKeySelective(OfficialAccExplain record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table official_acc_explain
     *
     * @mbggenerated Mon Feb 22 16:29:57 CST 2016
     */
    int updateByPrimaryKey(OfficialAccExplain record);
}