/**
 * FeedbackDaoImpl.java
 */
package com.uxiaoxi.ym.appserver.db.account.dao.impl;


import org.springframework.stereotype.Repository;

import com.uxiaoxi.ym.appserver.db.account.dao.IFeedbackDao;
import com.uxiaoxi.ym.appserver.db.account.dto.Feedback;
import com.uxiaoxi.ym.appserver.db.account.mapper.FeedbackMapper;
import com.uxiaoxi.ym.appserver.framework.db.impl.BaseSupport;

/**
 * @author renhao
 *
 * 2015-1-27
 */
@Repository
public class FeedbackDaoImpl extends BaseSupport<Feedback, FeedbackMapper> implements IFeedbackDao {


}
