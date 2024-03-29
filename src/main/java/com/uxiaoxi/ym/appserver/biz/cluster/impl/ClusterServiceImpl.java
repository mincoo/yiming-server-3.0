/**
 * ClusterServiceImpl.java
 */
package com.uxiaoxi.ym.appserver.biz.cluster.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.glassfish.jersey.client.JerseyWebTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.uxiaoxi.ym.appserver.biz.cluster.IClusterService;
import com.uxiaoxi.ym.appserver.db.account.dao.IAccountDao;
import com.uxiaoxi.ym.appserver.db.account.dto.Account;
import com.uxiaoxi.ym.appserver.db.cluster.dao.IClusterDao;
import com.uxiaoxi.ym.appserver.db.cluster.dao.IClusterUserDao;
import com.uxiaoxi.ym.appserver.db.cluster.dao.IRemarkDao;
import com.uxiaoxi.ym.appserver.db.cluster.dto.Cluster;
import com.uxiaoxi.ym.appserver.db.cluster.dto.ClusterUser;
import com.uxiaoxi.ym.appserver.db.cluster.dto.Remark;
import com.uxiaoxi.ym.appserver.framework.util.CommonUtil;
import com.uxiaoxi.ym.appserver.web.cluster.form.AddDelUserForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.ClusterSearchBySnForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.ClusterUserListForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.ClusterUserSearchForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.CreateClusterForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.ExitForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.JoinClusterForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.UpdateRemarkForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterBySnResult;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterBySnVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterUserListResultVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterUserListVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterUserSearchResultVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.SearchCNameVO;
import com.uxiaoxi.ym.appserver.web.common.vo.ListResult;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;
import com.uxiaoxi.ym.appserver.web.common.vo.StatusConst;
import com.uxiaoxi.ym.easemob.comm.Constants;
import com.uxiaoxi.ym.easemob.comm.HTTPMethod;
import com.uxiaoxi.ym.easemob.comm.Roles;
import com.uxiaoxi.ym.easemob.utils.JerseyUtils;
import com.uxiaoxi.ym.easemob.vo.ClientSecretCredential;
import com.uxiaoxi.ym.easemob.vo.Credential;
import com.uxiaoxi.ym.easemob.vo.EndPoints;
import com.uxiaoxi.ym.jpush.JpushUtil;

/**
 * @author renhao
 *
 *         2015年3月3日
 */
@Service
public class ClusterServiceImpl implements IClusterService {

    private static final Logger log = LoggerFactory
            .getLogger(ClusterServiceImpl.class);
    
    private static final JsonNodeFactory factory = new JsonNodeFactory(false);
    private static final String APPKEY = Constants.APPKEY;

    // 通过app的client_id和client_secret来获取app管理员token
    private static Credential credential = new ClientSecretCredential(
            Constants.APP_CLIENT_ID, Constants.APP_CLIENT_SECRET,
            Roles.USER_ROLE_APPADMIN);

    @Autowired
    private IAccountDao accountDao;

    @Autowired
    private IClusterDao clusterDao;

    @Autowired
    private IClusterUserDao clusterUserDao;
    
    @Autowired
    private IRemarkDao remarkDao;

    @Override
    @Transactional
    public ResResult createCluster(CreateClusterForm form) {

        Cluster clu = new Cluster();
        clu.setTitle(form.getName());
        clu.setCreateBy(form.getUid());
        clu.setProvince(form.getProvince());
        clu.setCity(form.getCity());
        clu.setDistrict(form.getDistrict());
        clu.setSchool(form.getSchool());
        clu.setLongitude(form.getLongitude());
        clu.setLatitude(form.getLatitude());
        clu.setFace(form.getFace());
        clu.setMaxUser(Long.valueOf(StatusConst.MAXUSERS));
        clu.setCreateDt(new Date());

        // 生成班号
        int maxSn = clusterDao.searchMaxSn();
        if (maxSn != 0) {
            clu.setSn(String.valueOf(maxSn + 1));
        } else {
            clu.setSn(StatusConst.SNSTART);
        }

        clusterDao.insert(clu);

        ClusterVO vo = new ClusterVO(clu);

        // 把自己加入组中
        ClusterUser cu = new ClusterUser();
        cu.setAccId(form.getUid());
        cu.setCluId(clu.getId());
        // 创建者必为老师，设置acc_type为1,TODO暂不实现
        // cu.setAccType(1);
        cu.setCreateDt(new Date());
        clusterUserDao.insert(cu);

//        // 增加极光 tag
//        Account account = accountDao.selectByKey(form.getUid());
//        if (StringUtils.isNotBlank(account.getRegid())) {
//            Set<String> tagsToAdd = new HashSet<String>();
//            tagsToAdd.add(CommonUtil.buildGtag(clu.getId()));
//            JpushUtil.updateDeviceTagAlias(account.getRegid(), null, tagsToAdd,
//                    null, account.getVersion());
//        }
        
        // IM中创建群组 
        ObjectNode dataObjectNode = JsonNodeFactory.instance.objectNode();
        dataObjectNode.put("groupname", "g"+ clu.getId());
        dataObjectNode.put("desc", form.getName());
        dataObjectNode.put("approval", true);
        dataObjectNode.put("public", true);
        dataObjectNode.put("maxusers", 200);
        dataObjectNode.put("owner", "u"+form.getUid());
//        ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
//        dataObjectNode.put("members", arrayNode);
        creatChatGroups(dataObjectNode);

        return new ResResult(vo);
    }

    @Override
    @Transactional
    public ResResult updateCluster(CreateClusterForm form) {

        Cluster clu = new Cluster();
        clu.setId(form.getGid());
        clu.setTitle(form.getName());
        clu.setProvince(form.getProvince());
        clu.setCity(form.getCity());
        clu.setDistrict(form.getDistrict());
        clu.setSchool(form.getSchool());
        clu.setLongitude(form.getLongitude());
        clu.setLatitude(form.getLatitude());
        clu.setFace(form.getFace());

        clusterDao.updateByPrimaryKeySelective(clu);

        ClusterVO vo = new ClusterVO(clu);

        return new ResResult(vo);
    }

    @Override
    public ResResult getlist(ClusterUserSearchForm form) {
        
        ObjectNode chatgroupidsNode = getAllChatgroupids();
        if ("404".equals(chatgroupidsNode.get("statusCode").toString())) {
//            Cluster cluster = clusterDao.selectByKey(id);
            
        }
        
        
        List<ClusterUserSearchResultVO> list = clusterUserDao.searchByUid(form);
        if (list == null) {
            list = new ArrayList<ClusterUserSearchResultVO>();
        }
        
        ListResult<ClusterUserSearchResultVO> sr = new ListResult<ClusterUserSearchResultVO>();

        sr.setSize(Long.valueOf(list.size()));
        sr.setList(list);

        return new ResResult(sr);
    }

    @Override
    @Transactional
    public ResResult joinCluster(JoinClusterForm form) {
        
        //加入IM群组
        String addToChatgroupid = getGroupId(form.getGid());
        String toAddUsername = "u"+form.getUid();
        addUserToGroup(addToChatgroupid, toAddUsername);


        // 验重
        ClusterUser cu = clusterUserDao.searchByGidAndUid(form.getGid(),
                form.getUid());
        if (cu != null) {
            return new ResResult(StatusConst.SUCCESS, "已经在组里了", null);
        }
        
        //是否超班级人数上限
        Cluster c =clusterDao.selectByKey(form.getGid());
        
        List<ClusterUser> lt = clusterUserDao.selectByGid(form.getGid());
        if(lt.size()>=c.getMaxUser()){
            return new ResResult(StatusConst.FAILURE, "人数超过班级上限，请联系管理员", null);
        }

        ClusterUser record = new ClusterUser();
        record.setAccId(form.getUid());
        record.setCluId(form.getGid());
        record.setChildName(form.getCname());
        record.setCreateDt(new Date());
        if (form.getType() != null) {
            record.setAccType(form.getType());
        }
        
        // 别名不存在时，设置用户真实姓名
        record.setAccName(accountDao.getName(form.getUid()));

        clusterUserDao.insert(record);

//        // 增加极光 tag
//        Account account = accountDao.selectByKey(form.getUid());
//        if (StringUtils.isNotBlank(account.getRegid())) {
//            Set<String> tagsToAdd = new HashSet<String>();
//            tagsToAdd.add(CommonUtil.buildGtag(form.getGid()));
//            JpushUtil.updateDeviceTagAlias(account.getRegid(), null, tagsToAdd,
//                    null, account.getVersion());
//        }
        
        return new ResResult(null);
    }

    @Override
    public ResResult deluser(AddDelUserForm form) {

        clusterUserDao.deluser(form);
        // 增加log部分
        log.info(form.getUid() + "删除用户" + form.getNid() + "从组" + form.getGid());
        
        //IM组中减人
        String delFromChatgroupid = getGroupId(form.getGid());
        String toRemoveUsername = "u"+form.getNid();
        deleteUserFromGroup(delFromChatgroupid, toRemoveUsername);

        return new ResResult(StatusConst.SUCCESS, StatusConst.STRSUCCESS, null);
    }

    @Override
    public ResResult exitgroup(ExitForm form) {
        
        //创建者删除班级
        if(clusterDao.isCreateBy(form)){
            
            clusterUserDao.exitgroupAll(form);
            // 增加log部分
            log.info("组" + form.getGid() + "解散");
            
            //IM中删除群组
            String toDelChatgroupid = getGroupId(form.getGid());
            deleteChatGroups(toDelChatgroupid) ;
            
            //普通成员退出班级
        }else{
            clusterUserDao.exitgroup(form);
            // 增加log部分
            log.info(form.getUid() + "从组" + form.getGid() + "退出");
            
            //IM组中减人
            String delFromChatgroupid = getGroupId(form.getGid());
            String toRemoveUsername = "u"+form.getUid();
            deleteUserFromGroup(delFromChatgroupid, toRemoveUsername);            
        }

        return new ResResult(StatusConst.SUCCESS, StatusConst.STRSUCCESS, null);
    }

    @Override
    public ResResult getUserList(ClusterUserListForm form) {

        List<ClusterUserListVO> tlist = clusterUserDao.searchByGidT(form);
        List<ClusterUserListVO> plist = clusterUserDao.searchByGidP(form);
        
        if (tlist == null) {
            tlist = new ArrayList<ClusterUserListVO>();
        }
        if (plist == null) {
            plist = new ArrayList<ClusterUserListVO>();
        }
        
        ClusterUserListResultVO<ClusterUserListVO> sr = new ClusterUserListResultVO<ClusterUserListVO>();
        
        //老师list：备注追加
        List<ClusterUserListVO> lt = new ArrayList<ClusterUserListVO>();
        for (ClusterUserListVO vo : tlist) {
            String remark = "";
            if(vo.getUid()!=null){
                Remark rm = remarkDao.selectRemark(form.getUid(),vo.getUid());
                if (rm != null){
                    remark = rm.getRemark();
                }
            }
            vo.setRemark(remark);
            lt.add(vo); 
        }
        
        //家长list：备注&学生姓名追加
        List<ClusterUserListVO> lp = new ArrayList<ClusterUserListVO>();
        for (ClusterUserListVO vo : plist) {
            String remark = "";
            Remark rm = remarkDao.selectRemark(form.getUid(),vo.getUid());
            if (rm != null){
                remark = rm.getRemark();
            }
            String childname = clusterUserDao.selectChildName(vo.getUid(),form.getGid()); 
            vo.setRemark(remark);
            vo.setChildname(childname);
            lp.add(vo); 
        }
        
        
        sr.setTlist(lt);
        sr.setTsize(new Long(lt.size()));
        sr.setPlist(lp);
        sr.setPsize(new Long(lp.size()));
        
        return new ResResult(sr);

    }

    @Override
    public ResResult searchClusterBySn(ClusterSearchBySnForm form) {
        ClusterBySnVO clusterBySnVO = null;
        ClusterBySnResult clusterBySnResult = clusterDao.searchBySn(form);
        if (clusterBySnResult != null) {
            clusterBySnVO = new ClusterBySnVO(clusterBySnResult);

            //创建者姓名：在班级里有昵称时取昵称，否则取用户姓名
            if (clusterBySnResult.getUnamef() != null
                    && "".equals(clusterBySnResult.getUnamef())) {
                clusterBySnVO.setUname(clusterBySnResult.getUnamef());
            } else {
                clusterBySnVO.setUname(clusterBySnResult.getUnames());
            }

            return new ResResult(clusterBySnVO);
        } else {
            return new ResResult(StatusConst.FAILURE, "不存在班级", null);
        }
    }

    @Override
    public ResResult updateRemark(UpdateRemarkForm form) {
        
        Remark record = new Remark();
        record.setAccId(form.getUid());
        record.setAccIdObj(form.getNid());
        record.setRemark(form.getRemark());
        
        Remark rm = remarkDao.selectRemark(form.getUid(), form.getNid());
        
        //更新
        if(rm !=null){
            record.setId(rm.getId());
            record.setCreateDt(rm.getCreateDt());;
            remarkDao.updateByPrimaryKey(record);
            
        //插入
        }else{
            record.setCreateDt(new Date());
            remarkDao.insert(record); 
        }

        return new ResResult(null);
    }
    
    @Override
    public ResResult searchcname(Long uid) {
        
        String cname = null;
        List<ClusterUser>  culist = clusterUserDao.getAllByUid(uid);
        
        //取用户关联的任意一个孩子姓名
        for(ClusterUser cu : culist) {
            if(cu.getChildName()!=null && !"".equals(cu.getChildName())){
                cname = cu.getChildName();
                break;
            };
        }
        
        SearchCNameVO vo = new SearchCNameVO();
        vo.setUid(uid);
        vo.setCname(cname);
        
        return new ResResult(vo);
    }
    
    /**
     * 创建群组
     * 
     */
    public static ObjectNode creatChatGroups(ObjectNode dataObjectNode) {

        ObjectNode objectNode = factory.objectNode();

        // check appKey format
        if (!JerseyUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", APPKEY)) {
            log.error("Bad format of Appkey: " + APPKEY);

            objectNode.put("message", "Bad format of Appkey");

            return objectNode;
        }

        // check properties that must be provided
        if (!dataObjectNode.has("groupname")) {
            log.error("Property that named groupname must be provided .");

            objectNode.put("message", "Property that named groupname must be provided .");

            return objectNode;
        }
        if (!dataObjectNode.has("desc")) {
            log.error("Property that named desc must be provided .");

            objectNode.put("message", "Property that named desc must be provided .");

            return objectNode;
        }
        if (!dataObjectNode.has("public")) {
            log.error("Property that named public must be provided .");

            objectNode.put("message", "Property that named public must be provided .");

            return objectNode;
        }
        if (!dataObjectNode.has("approval")) {
            log.error("Property that named approval must be provided .");

            objectNode.put("message", "Property that named approval must be provided .");

            return objectNode;
        }
        if (!dataObjectNode.has("owner")) {
            log.error("Property that named owner must be provided .");

            objectNode.put("message", "Property that named owner must be provided .");

            return objectNode;
        }
//        if (!dataObjectNode.has("members") || !dataObjectNode.path("members").isArray()) {
//            log.error("Property that named members must be provided .");
//
//            objectNode.put("message", "Property that named members must be provided .");
//
//            return objectNode;
//        }

        try {

            JerseyWebTarget webTarget = EndPoints.CHATGROUPS_TARGET.resolveTemplate("org_name", APPKEY.split("#")[0])
                    .resolveTemplate("app_name", APPKEY.split("#")[1]);

            objectNode = JerseyUtils.sendRequest(webTarget, dataObjectNode, credential, HTTPMethod.METHOD_POST, null);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return objectNode;
    }
    
    /**
     * 在群组中添加一个人
     * 
     */
    public static ObjectNode addUserToGroup(String chatgroupid, String userName) {

        ObjectNode objectNode = factory.objectNode();

        // check appKey format
        if (!JerseyUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", APPKEY)) {
            log.error("Bad format of Appkey: " + APPKEY);

            objectNode.put("message", "Bad format of Appkey");

            return objectNode;
        }

        try {

            JerseyWebTarget webTarget = EndPoints.CHATGROUPS_TARGET.resolveTemplate("org_name", APPKEY.split("#")[0])
                    .resolveTemplate("app_name", APPKEY.split("#")[1]).path(chatgroupid).path("users")
                    .path(userName);

            objectNode = JerseyUtils.sendRequest(webTarget, null, credential, HTTPMethod.METHOD_POST, null);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return objectNode;
    }

    /**
     * 在群组中减少一个人
     * 
     */
    public static ObjectNode deleteUserFromGroup(String chatgroupid, String userName) {
        ObjectNode objectNode = factory.objectNode();

        // check appKey format
        if (!JerseyUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", APPKEY)) {
            log.error("Bad format of Appkey: " + APPKEY);

            objectNode.put("message", "Bad format of Appkey");

            return objectNode;
        }

        try {
            JerseyWebTarget webTarget = EndPoints.CHATGROUPS_TARGET.resolveTemplate("org_name", APPKEY.split("#")[0])
                    .resolveTemplate("app_name", APPKEY.split("#")[1]).path(chatgroupid).path("users")
                    .path(userName);

            objectNode = JerseyUtils.sendRequest(webTarget, null, credential, HTTPMethod.METHOD_DELETE, null);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return objectNode;
    }
    
    /**
     * 删除群组
     * 
     */
    public static ObjectNode deleteChatGroups(String chatgroupid) {
        ObjectNode objectNode = factory.objectNode();

        // check appKey format
        if (!JerseyUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", APPKEY)) {
            log.error("Bad format of Appkey: " + APPKEY);

            objectNode.put("message", "Bad format of Appkey");

            return objectNode;
        }

        try {

            JerseyWebTarget webTarget = EndPoints.CHATGROUPS_TARGET.resolveTemplate("org_name", APPKEY.split("#")[0])
                    .resolveTemplate("app_name", APPKEY.split("#")[1]).path(chatgroupid);

            objectNode = JerseyUtils.sendRequest(webTarget, null, credential, HTTPMethod.METHOD_DELETE, null);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return objectNode;
    }
    
    /**
     * 获取APP中所有的群组ID
     * 
     * 
     * @return
     */
    public static ObjectNode getAllChatgroupids() {

        ObjectNode objectNode = factory.objectNode();

        // check appKey format
        if (!JerseyUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", APPKEY)) {
            log.error("Bad format of Appkey: " + APPKEY);

            objectNode.put("message", "Bad format of Appkey");

            return objectNode;
        }

        try {

            JerseyWebTarget webTarget = EndPoints.CHATGROUPS_TARGET.resolveTemplate("org_name", APPKEY.split("#")[0])
                    .resolveTemplate("app_name", APPKEY.split("#")[1]);

            objectNode = JerseyUtils.sendRequest(webTarget, null, credential, HTTPMethod.METHOD_GET, null);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return objectNode;
    }
    
    /**
     * 群组批量添加成员
     * 
     * @param toAddBacthChatgroupid
     * @param usernames
     * @return
     */
    public static ObjectNode addUsersToGroupBatch(String toAddBacthChatgroupid, ObjectNode usernames) {
        ObjectNode objectNode = factory.objectNode();
        // check appKey format
        if (!JerseyUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", APPKEY)) {
            log.error("Bad format of Appkey: " + APPKEY);
            objectNode.put("message", "Bad format of Appkey");
            return objectNode;
        }
        if (StringUtils.isBlank(toAddBacthChatgroupid.trim())) {
            log.error("Property that named toAddBacthChatgroupid must be provided .");
            objectNode.put("message", "Property that named toAddBacthChatgroupid must be provided .");
            return objectNode;
        }
        // check properties that must be provided
        if (null != usernames && !usernames.has("usernames")) {
            log.error("Property that named usernames must be provided .");
            objectNode.put("message", "Property that named usernames must be provided .");
            return objectNode;
        }

        try {
            objectNode = JerseyUtils.sendRequest(EndPoints.CHATGROUPS_TARGET.path(toAddBacthChatgroupid).path("users"), usernames,
                    credential, HTTPMethod.METHOD_POST, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return objectNode;
    }
    
    /**
     * 通过服务器gid，获取群组ID
     * 
     * 
     * @return
     */
    public static  String getGroupId(Long gid) {

        ObjectNode chatgroupidsNode = getAllChatgroupids();
        JsonNode jsonNode =  chatgroupidsNode.path("data");
        String addToChatgroupid = "";
        
        for(int i=0;i<jsonNode.size();i++){
            JsonNode subNode = jsonNode.path(i);
            if(("g"+gid).equals(subNode.path("groupname").toString().replaceAll("\"", ""))){
                addToChatgroupid = subNode.path("groupid").toString().replaceAll("\"", "");
                break;
            }
        }
        
        return addToChatgroupid;
    }
}
