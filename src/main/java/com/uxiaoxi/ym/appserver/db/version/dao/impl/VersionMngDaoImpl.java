/**
 * VersionMngDaoImpl.java
 */
package com.uxiaoxi.ym.appserver.db.version.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uxiaoxi.ym.appserver.db.version.dao.IVersionMngDao;
import com.uxiaoxi.ym.appserver.db.version.dto.VersionMng;
import com.uxiaoxi.ym.appserver.db.version.dto.VersionMngExample;
import com.uxiaoxi.ym.appserver.db.version.mapper.VersionMngMapper;
import com.uxiaoxi.ym.appserver.framework.db.impl.BaseSupport;
import com.uxiaoxi.ym.appserver.web.version.form.VersionMngForm;

/**
 * @author renhao
 *
 * 2015年3月27日
 */
@Repository
public class VersionMngDaoImpl extends BaseSupport<VersionMng, VersionMngMapper> implements IVersionMngDao {

    @Override
    public VersionMng getLastVersion(VersionMngForm form) {
        VersionMngMapper mapper = this.getSqlSession().getMapper(VersionMngMapper.class);
        VersionMngExample example = new VersionMngExample();
        example.createCriteria().andOsTypeEqualTo(form.getOstype());
        example.setOrderByClause(" id DESC limit 0,1 ");
        List<VersionMng> list = mapper.selectByExample(example);
        if(list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

}
