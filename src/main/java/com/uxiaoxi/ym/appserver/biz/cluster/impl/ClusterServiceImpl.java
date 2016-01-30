/**
 * ClusterServiceImpl.java
 */
package com.uxiaoxi.ym.appserver.biz.cluster.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.uxiaoxi.ym.appserver.web.cluster.form.ClusterSearchForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.ClusterUserListForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.ClusterUserSearchForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.CreateClusterForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.ExitForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.JoinClusterForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.UpdateRemarkForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterByGidVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterBySnResult;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterBySnVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterUserListResultVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterUserListVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterUserSearchResult;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterUserSearchResultVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterVO;
import com.uxiaoxi.ym.appserver.web.cluster.vo.SearchCNameVO;
import com.uxiaoxi.ym.appserver.web.common.vo.ListResult;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;
import com.uxiaoxi.ym.appserver.web.common.vo.StatusConst;
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
        clu.setCreateDt(new Date());

        // 生成班号,从2046开始
        int maxSn = clusterDao.searchMaxSn();
        if (maxSn != 0) {
            clu.setSn(String.valueOf(maxSn + 1));
        } else {
            clu.setSn("2046");
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

        // 增加极光 tag
        Account account = accountDao.selectByKey(form.getUid());
        if (StringUtils.isNotBlank(account.getRegid())) {
            Set<String> tagsToAdd = new HashSet<String>();
            tagsToAdd.add(CommonUtil.buildGtag(clu.getId()));
            JpushUtil.updateDeviceTagAlias(account.getRegid(), null, tagsToAdd,
                    null, account.getVersion());
        }

        ResResult rs = new ResResult(StatusConst.SUCCESS,
                StatusConst.STRSUCCESS, vo);
        return rs;
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

        return new ResResult(StatusConst.SUCCESS, StatusConst.STRSUCCESS, vo);
    }

    @Override
    public ResResult getlist(ClusterUserSearchForm form) {
        List<ClusterUserSearchResultVO> list = clusterUserDao.searchByUid(form);
        if (list == null) {
            list = new ArrayList<ClusterUserSearchResultVO>();
        }
        List<ClusterUserSearchResult> l = new ArrayList<ClusterUserSearchResult>();
        ListResult<ClusterUserSearchResult> sr = new ListResult<ClusterUserSearchResult>();

        sr.setSize(new Long(list.size()));

        // if( list.size()>0) {
        // sr.setLast(list.get(list.size()-1).getId());
        // } else {
        // sr.setLast(form.getStart());
        // }

        // TODO 是否有必要去掉id
        for (ClusterUserSearchResultVO vo : list) {

            // 老师数
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("gid", vo.getGid());
            param.put("type", new Long(StatusConst.TEACHER));
            vo.setTnum(new Long(clusterDao.countUserByType(param)));

            // 家长数
            param.put("type", new Long(StatusConst.PATRIARCH));
            vo.setPnum(new Long(clusterDao.countUserByType(param)));

            // 学生数
            // vo.setSnum(new Long(studentDao.countByGid(vo.getGid())));

            l.add(vo.toClusterUserSearchResult());
        }
        sr.setList(l);

        return new ResResult(StatusConst.SUCCESS, StatusConst.STRSUCCESS, sr);
    }

    @Override
    public ResResult searchClusterByGid(ClusterSearchForm form) {

        ClusterByGidVO clusterByGidVO = clusterDao.searchByGid(form);
        if (clusterByGidVO != null) {
            // 老师数
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("gid", form.getGid());
            param.put("type", new Long(StatusConst.TEACHER));
            clusterByGidVO.setTnum(new Long(clusterDao.countUserByType(param)));

            // 家长数
            param.put("type", new Long(StatusConst.PATRIARCH));
            clusterByGidVO.setPnum(new Long(clusterDao.countUserByType(param)));

            // 学生数
            param.put("type", new Long(StatusConst.STUDENT));
            clusterByGidVO.setSnum(new Long(clusterDao.countUserByType(param)));

            return new ResResult(StatusConst.SUCCESS, StatusConst.STRSUCCESS,
                    clusterByGidVO);
        } else {
            return new ResResult(StatusConst.FAILURE, "不存在班级", null);
        }

    }

    @Override
    @Transactional
    public ResResult joinCluster(JoinClusterForm form) {

        // 验重
        ClusterUser cu = clusterUserDao.searchByGidAndUid(form.getGid(),
                form.getUid());
        if (cu != null) {
            return new ResResult(StatusConst.SUCCESS, "已经在组里了", null);
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

        // 增加极光 tag
        Account account = accountDao.selectByKey(form.getUid());
        if (StringUtils.isNotBlank(account.getRegid())) {
            Set<String> tagsToAdd = new HashSet<String>();
            tagsToAdd.add(CommonUtil.buildGtag(form.getGid()));
            JpushUtil.updateDeviceTagAlias(account.getRegid(), null, tagsToAdd,
                    null, account.getVersion());
        }

        return new ResResult(StatusConst.SUCCESS, StatusConst.STRSUCCESS, null);
    }

    @Override
    @Transactional
    public ResResult addUser(AddDelUserForm form) {

        // 验重
        ClusterUser cu = clusterUserDao.searchByGidAndUid(form.getGid(),
                form.getNid());
        if (cu != null) {
            return new ResResult(StatusConst.SUCCESS, "已经在组里了", null);
        }

        ClusterUser record = new ClusterUser();
        record.setAccId(form.getNid());
        record.setCluId(form.getGid());
        record.setCreateDt(new Date());
        if (form.getType() != null) {
            record.setAccType(form.getType());
        }

        // 别名不存在时，设置用户真实姓名
        record.setAccName(accountDao.getName(form.getNid()));

        clusterUserDao.insert(record);
        log.debug(form.getUid() + "添加用户" + form.getNid() + "到组" + form.getGid());

        // 增加极光 tag
        Account account = accountDao.selectByKey(form.getNid());
        if (StringUtils.isNotBlank(account.getRegid())) {
            Set<String> tagsToAdd = new HashSet<String>();
            tagsToAdd.add(CommonUtil.buildGtag(form.getGid()));
            JpushUtil.updateDeviceTagAlias(account.getRegid(), null, tagsToAdd,
                    null, account.getVersion());
        }

        return new ResResult(StatusConst.SUCCESS, StatusConst.STRSUCCESS, null);

    }

    @Override
    public ResResult deluser(AddDelUserForm form) {

        clusterUserDao.deluser(form);
        // 增加log部分
        log.info(form.getUid() + "删除用户" + form.getNid() + "从组" + form.getGid());

        return new ResResult(StatusConst.SUCCESS, StatusConst.STRSUCCESS, null);
    }

    @Override
    public ResResult exitgroup(ExitForm form) {

        clusterUserDao.exitgroup(form);
        // 增加log部分
        log.info(form.getUid() + "从组" + form.getGid() + "退出");

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
        
        List<ClusterUserListVO> lt = new ArrayList<ClusterUserListVO>();
        for (ClusterUserListVO vo : tlist) {
            String remark = remarkDao.selectRemark(form.getUid(),vo.getUid(),form.getGid());
            vo.setRemark(remark);
            lt.add(vo); 
        }
        
        List<ClusterUserListVO> lp = new ArrayList<ClusterUserListVO>();
        for (ClusterUserListVO vo : plist) {
            String remark = remarkDao.selectRemark(form.getUid(),vo.getUid(),form.getGid());
            String childname = clusterUserDao.selectChildName(vo.getUid(),form.getGid()); 
            vo.setRemark(remark);
            vo.setChildname(childname);
            lp.add(vo); 
        }
        
        
        sr.setTlist(lt);
        sr.setTsize(new Long(lt.size()));
        sr.setPlist(lp);
        sr.setPsize(new Long(lp.size()));
        
        return new ResResult(StatusConst.SUCCESS, StatusConst.STRSUCCESS, sr);

    }

    @Override
    public ResResult searchClusterBySn(ClusterSearchBySnForm form) {
        ClusterBySnVO clusterBySnVO = null;
        ClusterBySnResult clusterBySnResult = clusterDao.searchBySn(form);
        if (clusterBySnResult != null) {
            clusterBySnVO = new ClusterBySnVO(clusterBySnResult);

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
        record.setCluId(form.getGid());
        record.setRemark(form.getRemark());
        record.setCreateDt(new Date());
        
        String remark = remarkDao.selectRemark(form.getUid(), form.getNid(), form.getGid());
        if(remark !=null){
            remarkDao.updateByPrimaryKeySelective(record);
        }else{
            remarkDao.insert(record); 
        }

        return new ResResult(null);
    }
    
    @Override
    public ResResult searchcname(Long uid) {
        
        String cname = null;
        List<ClusterUser>  culist = clusterUserDao.getAllByUid(uid);
        
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

}
