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
        return this.getList(form);

    }

    @RequestMapping(value = "/getlist", params = "callback")
    public ResResult getListJsonp(ClusterUserSearchForm form) {
        return this.getList(form);
    }

    private ResResult getList(ClusterUserSearchForm form){
        return clusterService.getlist(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/build")
    public ResResult buildGroupJson(CreateClusterForm form) {
        return this.buildGroup(form);
    }

    @RequestMapping(value = "/build", params = "callback")
    public ResResult buildGroupJsonp(CreateClusterForm form) {
        return this.buildGroup(form);
    }
    
    private ResResult buildGroup(CreateClusterForm form){
        return clusterService.createCluster(form);
    }
    
    
    @ResponseBody
    @RequestMapping(value = "/update")
    public ResResult updateGroupJson(CreateClusterForm form) {
        return this.updateGroup(form);
    }

    @RequestMapping(value = "/update", params = "callback")
    public ResResult updateGroupJsonp(CreateClusterForm form) {
        return this.updateGroup(form);
    }
    
    private ResResult updateGroup(CreateClusterForm form){
        return clusterService.updateCluster(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/searchbygid")
    public ResResult searchClusterByGidJson(ClusterSearchForm form) {
        return this.searchClusterByGid(form);
    }

    @RequestMapping(value = "/searchbygid", params = "callback")
    public ResResult searchClusterByGidJsonp(ClusterSearchForm form) {
        return this.searchClusterByGid(form);
    }
    
    private ResResult searchClusterByGid(ClusterSearchForm form) {
        return clusterService.searchClusterByGid(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/join")
    public ResResult joinClusterJson(JoinClusterForm form) {
        return this.joinCluster(form);
    }

    @RequestMapping(value = "/join", params = "callback")
    public ResResult joinClusterJsonp(JoinClusterForm form) {
        return this.joinCluster(form);
    }
    
    private ResResult joinCluster(JoinClusterForm form) {
        return clusterService.joinCluster(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/adduser")
    public ResResult joinClusterJson(AddDelUserForm form) {
        return this.addUser(form);
    }

    @RequestMapping(value = "/adduser", params = "callback")
    public ResResult joinClusterJsonp(AddDelUserForm form) {
        return this.addUser(form);
    }

    private ResResult addUser(AddDelUserForm form){
        return clusterService.addUser(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/deluser")
    public ResResult deluserJson(AddDelUserForm form) {
        return this.deluser(form);
    }

    @RequestMapping(value = "/deluser", params = "callback")
    public ResResult deluserJsonp(AddDelUserForm form) {
        return this.deluser(form);
    }
    
    private ResResult deluser(AddDelUserForm form){
        return clusterService.deluser(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/delstudent")
    public ResResult delstudentJson(AddDelUserForm form) {
        return this.delstudent(form);
    }

    @RequestMapping(value = "/delstudent", params = "callback")
    public ResResult delstudentJsonp(AddDelUserForm form) {
        return this.delstudent(form);
    }
    
    private ResResult delstudent(AddDelUserForm form){
        return clusterService.delstudent(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/exit")
    public ResResult exitJson(ExitForm form) {
        return this.exitgroup(form);
    }

    @RequestMapping(value = "/exit", params = "callback")
    public ResResult exitJsonp(ExitForm form) {
        return this.exitgroup(form);
    }
    
    private ResResult exitgroup(ExitForm form){
        return clusterService.exitgroup(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/userlist")
    public ResResult deluserJson(ClusterUserListForm form) {
        return this.getUserList(form);
    }

    @RequestMapping(value = "/userlist", params = "callback")
    public ResResult deluserJsonp(ClusterUserListForm form) {
        return this.getUserList(form);
    }
    
    private ResResult getUserList(ClusterUserListForm form){
        return clusterService.getUserList(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/searchbysn")
    public ResResult getListJsonBySn(ClusterSearchBySnForm form) {
        return this.searchClusterBySn(form);

    }

    @RequestMapping(value = "/searchbysn", params = "callback")
    public ResResult getListJsonpBySn(ClusterSearchBySnForm form) {
        return this.searchClusterBySn(form);
    }

    private ResResult searchClusterBySn(ClusterSearchBySnForm form){
        return clusterService.searchClusterBySn(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/tuserlist")
    public ResResult getTchUserListJson(ClusterUserListForm form) {
        return this.getUserListT(form);

    }

    @RequestMapping(value = "/tuserlist", params = "callback")
    public ResResult getTchUserListJsonp(ClusterUserListForm form) {
        return this.getUserListT(form);
    }

    private ResResult getUserListT(ClusterUserListForm form){
        return clusterService.getUserListT(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/puserlist")
    public ResResult getPtrUserListJson(ClusterUserListForm form) {
        return this.getUserListP(form);

    }

    @RequestMapping(value = "/puserlist", params = "callback")
    public ResResult getPtrUserListJsonp(ClusterUserListForm form) {
        return this.getUserListP(form);
    }

    private ResResult getUserListP(ClusterUserListForm form){
        return clusterService.getUserListP(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/suserlist")
    public ResResult getStdUserListJson(ClusterUserListForm form) {
        return this.getUserListS(form);

    }

    @RequestMapping(value = "/suserlist", params = "callback")
    public ResResult getStdUserListJsonp(ClusterUserListForm form) {
        return this.getUserListS(form);
    }

    private ResResult getUserListS(ClusterUserListForm form){
        return clusterService.getUserListS(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/addstudent")
    public ResResult addStudentJson(AddStudentForm form) {
        return this.addStudent(form);
    }

    @RequestMapping(value = "/addstudent", params = "callback")
    public ResResult addStudentJsonp(AddStudentForm form) {
        return this.addStudent(form);
    }

    private ResResult addStudent(AddStudentForm form){
        return clusterService.addStudent(form);
    }
    
    @ResponseBody
    @RequestMapping(value = "/addchild")
    public ResResult addChildJson(AddChildForm form) {
        return this.addChild(form);

    }

    @RequestMapping(value = "/addchild", params = "callback")
    public ResResult addChildJsonp(AddChildForm form) {
        return this.addChild(form);
    }

    private ResResult addChild(AddChildForm form){
        return clusterService.addChild(form);
    }
    
    
    
}
