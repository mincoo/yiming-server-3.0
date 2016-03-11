/**
 * OfficialAccUserDaoImpl.java
 */
package com.uxiaoxi.ym.appserver.db.msg.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uxiaoxi.ym.appserver.db.msg.dao.IOfficialAccUserDao;
import com.uxiaoxi.ym.appserver.db.msg.dto.OfficialAccUser;
import com.uxiaoxi.ym.appserver.db.msg.dto.OfficialAccUserExample;
import com.uxiaoxi.ym.appserver.db.msg.mapper.OfficialAccUserMapper;
import com.uxiaoxi.ym.appserver.framework.db.impl.BaseSupport;
import com.uxiaoxi.ym.appserver.web.msg.form.MsgOaTagChangeForm;

/**
 * @author renhao
 *
 *         2015年2月26日
 */
@Repository
public class OfficialAccUserDaoImpl extends BaseSupport<OfficialAccUser, OfficialAccUserMapper> implements IOfficialAccUserDao {
    
    @Override
    public int updateMsgOaFlg(MsgOaTagChangeForm form) {
        OfficialAccUser record = new OfficialAccUser();
        record.setAccId(form.getUid());
        record.setOffAccId(form.getOaid());
        record.setMsgFlg(form.getStatus());

        OfficialAccUserMapper mapper = this.getSqlSession().getMapper(
                OfficialAccUserMapper.class);
        OfficialAccUserExample example = new OfficialAccUserExample();
        example.createCriteria().andOffAccIdEqualTo(form.getOaid())
                .andAccIdEqualTo(form.getUid());
        return mapper.updateByExampleSelective(record, example);
    }
    
    @Override
    public OfficialAccUser searchByOaidAndUid(Long oaid,Long uid) {

        OfficialAccUserMapper mapper = this.getSqlSession().getMapper(
                OfficialAccUserMapper.class);
        OfficialAccUserExample example = new OfficialAccUserExample();
        example.createCriteria().andOffAccIdEqualTo(oaid)
                .andAccIdEqualTo(uid);
        
        List<OfficialAccUser> list = mapper.selectByExample(example);
        if(list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }

}
