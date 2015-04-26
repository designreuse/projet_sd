/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nephtysorg.controller;

import javax.servlet.http.HttpServletRequest;
import com.nephtysorg.model.pojo.Group;
import com.nephtysorg.model.pojo.User;
import com.nephtysorg.model.service.GroupService;
import com.nephtysorg.model.service.GroupServiceImpl;
import com.nephtysorg.model.service.UserService;
import com.nephtysorg.model.service.UserServiceImpl;
import com.nephtysorg.model.utils.Callout;
import com.nephtysorg.model.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 *
 * @author cfollet
 */
@Controller
public class UserGroupController {
    
    @Autowired
    private GroupService groupService;
    @Autowired
    private UserService userService;
    
   // @TODO  Sécurité
    @RequestMapping(value="/user_group/discard/{id_group}/{id_user}", method=RequestMethod.GET)
    public ModelAndView getDiscard(@PathVariable("id_group") Integer id_group, @PathVariable("id_user") Integer id_user, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        ModelAndView mv;
        Group group = this.groupService.getGroupById(id_group);
        User user = SessionUtil.getSessionUser(request);
        if (user == null) {
            mv = new ModelAndView("redirect:/user/login");
            return mv;
        }else {
            user = this.userService.getUserById(id_user);
            this.groupService.discard(user, group);
            redirectAttributes.addFlashAttribute("callout",  new Callout("success", "Fellicitation", "Le lien de "+ user.getLogin() +" au groupe "+ group.getName() +" à été supprimé."));
            mv = new ModelAndView("redirect:/home");
            return mv;
        }
    }
    
    
    @RequestMapping(value="/user_group/accept/{id_group}/{id_user}", method=RequestMethod.GET)
    public ModelAndView getAccept(@PathVariable("id_group") Integer id_group, @PathVariable("id_user") Integer id_user, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        ModelAndView mv;
        Group group = this.groupService.getGroupById(id_group);
        User user = SessionUtil.getSessionUser(request);
        if (user == null) {
            mv = new ModelAndView("redirect:/user/login");
            return mv;
        }else {
            user = this.userService.getUserById(id_user);
            this.groupService.accept(user, group);
            redirectAttributes.addFlashAttribute("callout",  new Callout("success", "Fellicitation", "L'utilisateur "+user.getLogin()+" à été accepté dans le groupe "+group.getName()+"."));
            mv = new ModelAndView("redirect:/home");
            return mv;
        }
    }
}
