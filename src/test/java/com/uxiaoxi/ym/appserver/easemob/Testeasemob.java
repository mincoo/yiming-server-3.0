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
import com.uxiaoxi.ym.appserver.biz.cluster.impl.ClusterServiceImpl;
import com.uxiaoxi.ym.appserver.db.account.dao.IAccountDao;
import com.uxiaoxi.ym.appserver.db.account.dto.Account;
import com.uxiaoxi.ym.appserver.db.cluster.dao.IClusterDao;
import com.uxiaoxi.ym.appserver.db.cluster.dao.IClusterUserDao;
import com.uxiaoxi.ym.appserver.db.cluster.dto.Cluster;
import com.uxiaoxi.ym.appserver.db.cluster.dto.ClusterUser;
import com.uxiaoxi.ym.appserver.framework.page.model.Page;
import com.uxiaoxi.ym.appserver.framework.util.StringUtil;
import com.uxiaoxi.ym.appserver.web.common.vo.SqlBean;
import com.uxiaoxi.ym.easemob.comm.Constants;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
        "classpath:dispatcher-servlet.xml" })
public class Testeasemob {

    @Autowired
    private IAccountDao accountDao;

    @Autowired
    private IClusterDao clusterDao;

    @Autowired
    private IClusterUserDao clusterUserDao;

    @Test
    @SuppressWarnings("unchecked")
    public void testCreatImUsers() {

        // 查出用户
        int pageNO = 1;
        int pageSize = 30;
        SqlBean sqlbean = new SqlBean();
        sqlbean.setOrderby("t.id asc ");

        Page<Account> page = accountDao.getData(sqlbean, pageNO, pageSize);
        while (pageNO <= page.getTotalPageCount()) {

            for (Account account : (List<Account>) page.getData()) {
                // 环信注册IM用户[单个]
                ObjectNode datanode = JsonNodeFactory.instance.objectNode();
                datanode.put("username", "u" + account.getId());
                datanode.put(
                        "password",
                        StringUtil.md5(Constants.DEFAULT_PASSWORD
                                + String.valueOf(account.getId())));
                AccountServiceImpl.createNewIMUserSingle(datanode);

                System.out.println("注册" + account.getName() + ",uid="
                        + account.getId());

            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            pageNO = pageNO + 1;

            page = accountDao.getData(sqlbean, pageNO, pageSize);
        }

    }

    @Test
    @SuppressWarnings("unchecked")
    public void testCreatImCluster() {

        // 查出用户
        int pageNO = 1;
        int pageSize = 30;
        SqlBean sqlbean = new SqlBean();
        sqlbean.setOrderby("t.id asc ");

        Page<Cluster> page = clusterDao.getData(sqlbean, pageNO, pageSize);
        while (pageNO <= page.getTotalPageCount()) {

            for (Cluster cluster : (List<Cluster>) page.getData()) {

                // IM中创建群组
                ObjectNode dataObjectNode = JsonNodeFactory.instance
                        .objectNode();
                dataObjectNode.put("groupname", "g" + cluster.getId());
                dataObjectNode.put("desc", cluster.getTitle());
                dataObjectNode.put("approval", true);
                dataObjectNode.put("public", true);
                dataObjectNode.put("maxusers", 200);
                dataObjectNode.put("owner", "u" + cluster.getCreateBy());

                ClusterServiceImpl.creatChatGroups(dataObjectNode);

                System.out.println("注册" + cluster.getTitle() + ",gid="
                        + cluster.getId());

            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            pageNO = pageNO + 1;

            page = clusterDao.getData(sqlbean, pageNO, pageSize);
        }
    }

    @Test
    public void testImClusterJoin() {

        List<Cluster> list = clusterDao.getData();

        for (Cluster cluster : list) {

            // IM中创建群组 中加人
            List<ClusterUser> cluUserlist = clusterUserDao.selectByGid(cluster
                    .getId());
            for (ClusterUser clusterUser : cluUserlist) {
                if (clusterUser.getAccId().intValue() != cluster.getCreateBy()
                        .intValue()) {
                    String addToChatgroupid = ClusterServiceImpl
                            .getGroupId(cluster.getId());
                    String toAddUsername = "u" + clusterUser.getAccId();
                    ClusterServiceImpl.addUserToGroup(addToChatgroupid,
                            toAddUsername);

                    System.out.println(clusterUser.getAccId() + "加入班级");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
