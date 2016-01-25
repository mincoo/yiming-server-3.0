package com.uxiaoxi.ym.appserver.db.msg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.uxiaoxi.ym.appserver.db.msg.dto.MsgAcc;
import com.uxiaoxi.ym.appserver.db.msg.dto.MsgAccExample;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgDataForm;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgForm;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgReadStateForm;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgReadStateVO;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgVO;
import com.uxiaoxi.ym.appserver.web.msg.vo.MsgWithContentVO;

public interface MsgAccMapper {
    int countByExample(MsgAccExample example);

    int deleteByExample(MsgAccExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MsgAcc record);

    int insertSelective(MsgAcc record);

    List<MsgAcc> selectByExample(MsgAccExample example);

    MsgAcc selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MsgAcc record, @Param("example") MsgAccExample example);

    int updateByExample(@Param("record") MsgAcc record, @Param("example") MsgAccExample example);

    int updateByPrimaryKeySelective(MsgAcc record);

    int updateByPrimaryKey(MsgAcc record);
    
    List<MsgVO> getlist(MsgForm form);

    MsgWithContentVO getdata(MsgDataForm form);
    
    List<MsgReadStateVO> getReadState(MsgReadStateForm form);
}