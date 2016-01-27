/**
 * ClusterController.java
 */
package com.uxiaoxi.ym.appserver.web.cluster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uxiaoxi.ym.appserver.biz.cluster.IClusterService;
import com.uxiaoxi.ym.appserver.web.cluster.form.AddChildForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.AddDelUserForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.ClusterSearchBySnForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.ClusterUserListForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.ClusterUserSearchForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.CreateClusterForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.ExitForm;
import com.uxiaoxi.ym.appserver.web.cluster.form.JoinClusterForm;
import com.uxiaoxi.ym.appserver.web.common.vo.ResResult;

/**
 * @author renhao
 *
 *         2015年3月3日
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
    @RequestMapping(value = "/join")
    public ResResult joinClusterJson(JoinClusterForm form) {
        return clusterService.joinCluster(form);
    }

    @ResponseBody
    @RequestMapping(value = "/deluser")
    public ResResult deluserJson(AddDelUserForm form) {
        return clusterService.deluser(form);
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
    @RequestMapping(value = "/addchild")
    public ResResult addChildJson(AddChildForm form) {
        return clusterService.addChild(form);
    }

}
