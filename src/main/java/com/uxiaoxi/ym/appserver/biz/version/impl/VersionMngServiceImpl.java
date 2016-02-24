/**
 * VersionMngServiceImpl.java
 */
package com.uxiaoxi.ym.appserver.biz.version.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uxiaoxi.ym.appserver.biz.version.IVersionMngService;
import com.uxiaoxi.ym.appserver.db.version.dao.IVersionMngDao;
import com.uxiaoxi.ym.appserver.db.version.dto.VersionMng;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;
import com.uxiaoxi.ym.appserver.web.version.form.VersionMngForm;
import com.uxiaoxi.ym.appserver.web.version.vo.VersionVO;

/**
 * @author renhao
 *
 * 2015年3月27日
 */
@Service
public class VersionMngServiceImpl implements IVersionMngService {

    @Autowired
    private IVersionMngDao versionMngDao;

    @Override
    public ResResult getVersion(VersionMngForm form) {
        
        VersionMng version = versionMngDao.getLastVersion(form);
        VersionVO vo = new VersionVO(version);
        
        return new ResResult(vo);
    }
}
