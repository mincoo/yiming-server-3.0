/**
 * IVerificationCodeService.java
 */
package com.uxiaoxi.ym.appserver.biz.verification;

import com.uxiaoxi.ym.appserver.web.common.vo.ResultBean;

/**
 * @author renhao
 *
 * 2015-1-30
 */
public interface IVerificationCodeService {

    /**
     * 将验证码插入数据库
     * 
     * @param code 验证码
     * @param content 验证的内容，如手机号等
     * @return 操作结果对象
     */
    public ResultBean add(String code, String content,int type);

}
