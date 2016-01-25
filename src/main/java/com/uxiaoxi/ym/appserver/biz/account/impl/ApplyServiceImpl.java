/**
 * ApplyServiceImpl.java
 */
package com.uxiaoxi.ym.appserver.biz.account.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uxiaoxi.ym.appserver.biz.account.IApplyService;
import com.uxiaoxi.ym.appserver.db.account.dao.IApplyDao;
import com.uxiaoxi.ym.appserver.db.account.dto.Apply;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;
import com.uxiaoxi.ym.appserver.web.common.vo.StatusConst;

/**
 * @author renhao
 *
 * 2015年2月25日
 */
@Service
public class ApplyServiceImpl implements IApplyService {

    @Autowired
    private IApplyDao applyDao;
    
    @Override
    public ResResult apply(Long userid, Long cluid) {

        ResResult rs = new ResResult();
        rs.setMsg("发送申请失败");
        rs.setStatus(StatusConst.FAILURE);
        
        if(userid == null || cluid == null){
            rs.setMsg("参数不能为空");
            return rs;
        } else {
            Apply record = new Apply();
            record.setAccId(userid);
            record.setCluId(cluid);
            record.setCreateDt(new Date());
            
            applyDao.insert(record);
            
            rs.setMsg("成功发送申请");
            rs.setStatus(StatusConst.SUCCESS);
            
            return rs;
        }
    
    }

}
