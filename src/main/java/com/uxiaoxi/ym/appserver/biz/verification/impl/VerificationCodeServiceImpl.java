/**
 * VerificationCodeServiceImpl.java
 */
package com.uxiaoxi.ym.appserver.biz.verification.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uxiaoxi.ym.appserver.biz.verification.IVerificationCodeService;
import com.uxiaoxi.ym.appserver.db.verification.dao.IVerificationCodeDao;
import com.uxiaoxi.ym.appserver.db.verification.dto.VerificationCode;
import com.uxiaoxi.ym.appserver.web.common.vo.ResultBean;

/**
 * @author renhao
 * 
 *         2015-1-30
 */
@Service
public class VerificationCodeServiceImpl implements IVerificationCodeService{

    @Autowired
    private IVerificationCodeDao verificationCodeDao;

    @Override
    public ResultBean add(String code, String content,int type) {

        VerificationCode vcode = new VerificationCode();
        Date date = new Date();
        vcode.setCreateDt(date);
        vcode.setvCode(Integer.valueOf(code));
        vcode.setvType(type);
        vcode.setvContent(content);
        vcode.setUsed(false);

        return verificationCodeDao.insert(vcode);
    }
}
