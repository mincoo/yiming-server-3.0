/**
 * IVerificationCodeDao.java
 */
package com.uxiaoxi.ym.appserver.db.verification.dao;

import com.uxiaoxi.ym.appserver.db.verification.dto.VerificationCode;
import com.uxiaoxi.ym.appserver.framework.db.IBaseSupport;

/**
 * @author renhao
 *
 * 2015-1-27
 */
public interface IVerificationCodeDao extends IBaseSupport<VerificationCode> {

    /**
     * 验证验证码
     * 验证码验证一次后失效
     * 
     * @param code 验证码
     * @param content 验证内容
     * @return ture 合法 ，false 不合法
     */
    public boolean checkCode(Integer code, String content);

}
