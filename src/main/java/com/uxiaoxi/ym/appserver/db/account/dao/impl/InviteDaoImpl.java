/**
 * InviteDaoImpl.java
 */
package com.uxiaoxi.ym.appserver.db.account.dao.impl;

import org.springframework.stereotype.Repository;

import com.uxiaoxi.ym.appserver.db.account.dao.IInviteDao;
import com.uxiaoxi.ym.appserver.db.account.dto.Invite;
import com.uxiaoxi.ym.appserver.db.account.mapper.InviteMapper;
import com.uxiaoxi.ym.appserver.framework.db.impl.BaseSupport;

/**
 * @author renhao
 *
 * 2015年2月25日
 */
@Repository
public class InviteDaoImpl extends BaseSupport<Invite, InviteMapper> implements IInviteDao{

}
