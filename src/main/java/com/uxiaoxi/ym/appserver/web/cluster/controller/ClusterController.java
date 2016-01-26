/**
 * ClusterController.java
 */
package com.uxiaoxi.ym.appserver.web.cluster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uxiaoxi.ym.appserver.biz.cluster.IClusterService;
import com.uxiaoxi.ym.appserver.web.cluster.vo.AddChildForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.AddDelUserForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.AddStudentForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterSearchBySnForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterSearchForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterUserListForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ClusterUserSearchForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.CreateClusterForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.ExitForm;
import com.uxiaoxi.ym.appserver.web.cluster.vo.JoinClusterForm;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;

/**
 * @author renhao
 *
 * 2015年3月3日
 */
@Controller
@RequestMapping("/group")
public class ClusterController {

    @Autowired
    private IClusterService clusterService;
    
    @ResponseBody
    @RequestMapping(value = "/getlist")
    public ResResult getListJson(ClusterUserSearchForm form) {
    	return clusterService.getlist(form);

    } 
    
    @ResponseBody
    @RequestMapping(value = "/build")
    public ResResult buildGroupJson(CreateClusterForm form) {
    	return clusterService.createCluster(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/update")
    public ResResult updateGroupJson(CreateClusterForm form) {
    	return clusterService.updateCluster(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/searchbygid")
    public ResResult searchClusterByGidJson(ClusterSearchForm form) {
    	return clusterService.searchClusterByGid(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/join")
    public ResResult joinClusterJson(JoinClusterForm form) {
    	return clusterService.joinCluster(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/adduser")
    public ResResult joinClusterJson(AddDelUserForm form) {
    	return clusterService.addUser(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/deluser")
    public ResResult deluserJson(AddDelUserForm form) {
    	return clusterService.deluser(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/delstudent")
    public ResResult delstudentJson(AddDelUserForm form) {
    	return clusterService.delstudent(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/exit")
    public ResResult exitJson(ExitForm form) {
    	return clusterService.exitgroup(form);
    }

    @ResponseBody
    @RequestMapping(value = "/userlist")
    public ResResult deluserJson(ClusterUserListForm form) {
    	return clusterService.getUserList(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/searchbysn")
    public ResResult getListJsonBySn(ClusterSearchBySnForm form) {
    	return clusterService.searchClusterBySn(form);

    }

    @ResponseBody
    @RequestMapping(value = "/tuserlist")
    public ResResult getTchUserListJson(ClusterUserListForm form) {
    	 return clusterService.getUserListT(form);

    }

    @ResponseBody
    @RequestMapping(value = "/puserlist")
    public ResResult getPtrUserListJson(ClusterUserListForm form) {
    	return clusterService.getUserListP(form);

    }

    @ResponseBody
    @RequestMapping(value = "/suserlist")
    public ResResult getStdUserListJson(ClusterUserListForm form) {
    	return clusterService.getUserListS(form);

    }
    
    @ResponseBody
    @RequestMapping(value = "/addstudent")
    public ResResult addStudentJson(AddStudentForm form) {
    	return clusterService.addStudent(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/addchild")
    public ResResult addChildJson(AddChildForm form) {
    	return clusterService.addChild(form);

    }
    
    
}
