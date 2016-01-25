/**
 * InviteServiceImpl.java
 */
package com.uxiaoxi.ym.appserver.biz.account.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uxiaoxi.ym.appserver.biz.account.IInviteService;
import com.uxiaoxi.ym.appserver.db.account.dao.IInviteDao;
import com.uxiaoxi.ym.appserver.db.account.dto.Invite;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;
import com.uxiaoxi.ym.appserver.web.common.vo.StatusConst;

/**
 * @author renhao
 *
 * 2015年2月25日
 */
@Service
public class InviteServiceImpl implements IInviteService{

    @Autowired
    private IInviteDao inviteDao;
    
    @Override
    public ResResult invite(Long userid, String mobile, Long cluid) {
        ResResult rs = new ResResult();
        rs.setMsg("发送邀请失败");
        rs.setStatus(StatusConst.FAILURE);
        
        if(userid == null || StringUtils.isBlank(mobile) || cluid == null){
            rs.setMsg("参数不能为空");
            return rs;
        } else {
            Invite record = new Invite();
            record.setAccId(userid);
            record.setCluId(cluid);
            record.setInvitedMobile(mobile);
            record.setCreateDt(new Date());
            
            inviteDao.insert(record);
            
            rs.setMsg("成功发送邀请");
            rs.setStatus(StatusConst.SUCCESS);
            
            return rs;
        }
  
    }

    
}
