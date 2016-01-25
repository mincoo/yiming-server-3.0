/**
 * ApplyDaoImpl.java
 */
package com.uxiaoxi.ym.appserver.db.account.dao.impl;

import org.springframework.stereotype.Repository;

import com.uxiaoxi.ym.appserver.db.account.dao.IApplyDao;
import com.uxiaoxi.ym.appserver.db.account.dto.Apply;
import com.uxiaoxi.ym.appserver.db.account.mapper.ApplyMapper;
import com.uxiaoxi.ym.appserver.framework.db.impl.BaseSupport;

/**
 * @author renhao
 *
 * 2015年2月25日
 */
@Repository
public class ApplyDaoImpl extends BaseSupport<Apply, ApplyMapper> implements IApplyDao{

}
