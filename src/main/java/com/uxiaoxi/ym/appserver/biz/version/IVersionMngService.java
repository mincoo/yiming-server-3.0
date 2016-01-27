/**
 * IVersionMngService.java
 */
package com.uxiaoxi.ym.appserver.biz.version;

import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;
import com.uxiaoxi.ym.appserver.web.version.form.VersionMngForm;

/**
 * @author renhao
 *
 * 2015年3月27日
 */
public interface IVersionMngService {

    /**
     * @param form
     * @return
     */
    public ResResult getVersion(VersionMngForm form);

}
