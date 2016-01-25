/**
 * LocalDaoImpl.java
 */
package com.uxiaoxi.ym.appserver.db.test.dao.impl;

import org.springframework.stereotype.Repository;

import com.uxiaoxi.ym.appserver.db.test.dao.ILocalDao;
import com.uxiaoxi.ym.appserver.db.test.dto.Local;
import com.uxiaoxi.ym.appserver.db.test.mapper.LocalMapper;
import com.uxiaoxi.ym.appserver.framework.db.impl.BaseSupport;

/**
 * @author renhao
 *
 * 2015年3月19日
 */
@Repository
public class LocalDaoImpl  extends BaseSupport<Local, LocalMapper> implements ILocalDao{

}
