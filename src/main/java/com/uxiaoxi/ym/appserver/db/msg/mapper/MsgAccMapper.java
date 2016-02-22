package com.uxiaoxi.ym.appserver.db.msg.mapper;

import com.uxiaoxi.ym.appserver.db.msg.dto.MsgAcc;
import com.uxiaoxi.ym.appserver.db.msg.dto.MsgAccExample;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgDataForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgListForm;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgActionForm;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgDataPatInfo;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgListVO;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgVO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MsgAccMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table msg_acc
     * @mbggenerated  Sat Jan 30 20:07:20 CST 2016
     */
    int countByExample(MsgAccExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table msg_acc
     * @mbggenerated  Sat Jan 30 20:07:20 CST 2016
     */
    int deleteByExample(MsgAccExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table msg_acc
     * @mbggenerated  Sat Jan 30 20:07:20 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table msg_acc
     * @mbggenerated  Sat Jan 30 20:07:20 CST 2016
     */
    int insert(MsgAcc record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table msg_acc
     * @mbggenerated  Sat Jan 30 20:07:20 CST 2016
     */
    int insertSelective(MsgAcc record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table msg_acc
     * @mbggenerated  Sat Jan 30 20:07:20 CST 2016
     */
    List<MsgAcc> selectByExample(MsgAccExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table msg_acc
     * @mbggenerated  Sat Jan 30 20:07:20 CST 2016
     */
    MsgAcc selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table msg_acc
     * @mbggenerated  Sat Jan 30 20:07:20 CST 2016
     */
    int updateByExampleSelective(@Param("record") MsgAcc record,
            @Param("example") MsgAccExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table msg_acc
     * @mbggenerated  Sat Jan 30 20:07:20 CST 2016
     */
    int updateByExample(@Param("record") MsgAcc record,
            @Param("example") MsgAccExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table msg_acc
     * @mbggenerated  Sat Jan 30 20:07:20 CST 2016
     */
    int updateByPrimaryKeySelective(MsgAcc record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table msg_acc
     * @mbggenerated  Sat Jan 30 20:07:20 CST 2016
     */
    int updateByPrimaryKey(MsgAcc record);

    List<MsgListVO> getlist(MsgListForm form);
    
    MsgVO getdata(MsgDataForm form);
    
    List<MsgDataPatInfo> getDataAcc(Long id);
    
    void msgAction(MsgActionForm form);
    
    Long getSum(Map<String,Object> map);
    
    Long getLastVer(Long uid);
}