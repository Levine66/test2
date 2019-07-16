package com.mine.controller;

import com.mine.bean.UserInfo;
import com.mine.service.IUserInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserInfoController {

    @Autowired
    IUserInfoService userInfoService;

    @RequestMapping("findAll.do")
    public ModelAndView findAll(){
        List<UserInfo> users = userInfoService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("users",users);
        mv.setViewName("allUser");
        return mv;
    }

    @RequestMapping("toAddUser.do")
    public ModelAndView toAdd(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addUser");
        return mv;
    }
    @RequestMapping("save.do")
    public ModelAndView  add(int id,String username,String password){
        UserInfo user = new UserInfo(); //新建一个userInfo对象，
        user.setId(id);                 //设置属性
        user.setUsername(username);
        user.setPassword(password);

        userInfoService.add(user);      //跳转到展示页面
        List<UserInfo> users = userInfoService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("users",users);
        mv.setViewName("allUser");
        return mv;
    }

    @RequestMapping("delete.do")
    public ModelAndView delete(int id){
        userInfoService.delete(id);

        List<UserInfo> users = userInfoService.findAll();//跳转到展示页面
        ModelAndView mv = new ModelAndView();
        mv.addObject("users",users);
        mv.setViewName("allUser");
        return mv;
    }

    public UserInfo find(int id){
        UserInfo user = userInfoService.find(id);
        return user;
    }

    @RequestMapping("toUpdate.do")
    public ModelAndView toUpdate(@Param("id") int id){
        UserInfo user = find(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",user);
        mv.setViewName("updateUser");
        return mv;
    }

    @RequestMapping("update.do")
    public ModelAndView update(int id,String username,String password){

        UserInfo user = new UserInfo();
        user.setId(id);                 //设置属性
        user.setUsername(username);
        user.setPassword(password);

        userInfoService.update(user);

        List<UserInfo> users = userInfoService.findAll();//跳转到展示页面
        ModelAndView mv = new ModelAndView();
        mv.addObject("users",users);
        mv.setViewName("allUser");
        return mv;
    }
}
