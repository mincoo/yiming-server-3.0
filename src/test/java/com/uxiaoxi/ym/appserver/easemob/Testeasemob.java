package com.uxiaoxi.ym.appserver.easemob;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.uxiaoxi.ym.appserver.biz.account.impl.AccountServiceImpl;
import com.uxiaoxi.ym.appserver.db.account.dao.IAccountDao;
import com.uxiaoxi.ym.appserver.db.account.dto.Account;
import com.uxiaoxi.ym.appserver.framework.page.model.Page;
import com.uxiaoxi.ym.appserver.framework.util.StringUtil;
import com.uxiaoxi.ym.appserver.web.common.vo.SqlBean;
import com.uxiaoxi.ym.easemob.comm.Constants;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:dispatcher-servlet.xml"})
public class Testeasemob {

    @Autowired
    private IAccountDao accountDao ;
    
    @Test
    @SuppressWarnings("unchecked")
    public void testCreatImUser(){
        
        
        // 查出用户
        int pageNO =2 ;
        int pageSize = 30;
        SqlBean sqlbean = new SqlBean();
        sqlbean.setOrderby( "t.id asc " );
        
        Page<Account> page = accountDao.getData(sqlbean, pageNO, pageSize);
        
        while(pageNO <= page.getTotalPageCount()) {
             page = accountDao.getData(sqlbean, pageNO, pageSize);
            
            for(Account account : (List<Account>)page.getData()) {
                //环信注册IM用户[单个]
                ObjectNode datanode = JsonNodeFactory.instance.objectNode();
                datanode.put("username","u"+account.getId());
                datanode.put("password", StringUtil.md5(Constants.DEFAULT_PASSWORD+String.valueOf(account.getId())));
                AccountServiceImpl.createNewIMUserSingle(datanode);
                
                System.out.println("注册"+account.getName()+",uid="+account.getId());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } 
                
            }
            pageNO = pageNO + 1;
        }
        
        
    }
}
