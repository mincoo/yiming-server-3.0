/**
 * IVersionMngDao.java
 */
package com.uxiaoxi.ym.appserver.db.version.dao;

import com.uxiaoxi.ym.appserver.db.version.dto.VersionMng;
import com.uxiaoxi.ym.appserver.framework.db.IBaseSupport;
import com.uxiaoxi.ym.appserver.web.version.form.VersionMngForm;

/**
 * @author renhao
 *
 * 2015年3月27日
 */
public interface IVersionMngDao extends IBaseSupport<VersionMng> {

    /**
     * @param form
     * @return
     */
    public VersionMng getLastVersion(VersionMngForm form);

}
