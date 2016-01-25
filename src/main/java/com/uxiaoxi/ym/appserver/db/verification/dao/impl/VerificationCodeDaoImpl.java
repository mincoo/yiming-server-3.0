/**
 * VerificationCodeDaoImpl.java
 */
package com.uxiaoxi.ym.appserver.db.verification.dao.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.uxiaoxi.ym.appserver.db.verification.dao.IVerificationCodeDao;
import com.uxiaoxi.ym.appserver.db.verification.dto.VerificationCode;
import com.uxiaoxi.ym.appserver.db.verification.dto.VerificationCodeExample;
import com.uxiaoxi.ym.appserver.db.verification.mapper.VerificationCodeMapper;
import com.uxiaoxi.ym.appserver.framework.db.impl.BaseSupport;

/**
 * @author renhao
 *
 * 2015-1-27
 */
@Repository
public class VerificationCodeDaoImpl  extends BaseSupport<VerificationCode, VerificationCodeMapper> implements IVerificationCodeDao{
    
    public static final long TIMEOUT = 60*15*1000;
    
    @Override 
    public boolean checkCode(Integer code,String content) {
        
        VerificationCodeMapper mapper = this.getSqlSession().getMapper(VerificationCodeMapper.class);
        
        VerificationCodeExample example = new VerificationCodeExample();
        
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis()-TIMEOUT); 
        Date date = cal.getTime();
        
        example.createCriteria().andCreateDtGreaterThanOrEqualTo(date).andVCodeEqualTo(code).andVContentEqualTo(content).andUsedEqualTo(false);
        VerificationCode record = new VerificationCode();
        record.setUsed(true);
        int rt = mapper.updateByExampleSelective(record, example);
        
        if(rt>0) {
            return true;
        } else {
            return false;
        }
    }
    
    
    
}
