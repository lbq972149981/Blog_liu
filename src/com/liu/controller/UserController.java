package com.liu.controller;

import com.liu.bean.po.Blog;
import com.liu.bean.po.Encouragement;
import com.liu.bean.po.LogInfor;
import com.liu.bean.po.User;
import com.liu.service.BlogService;
import com.liu.service.EncouragementService;
import com.liu.service.LogInforService;
import com.liu.service.UserService;
import freemarker.ext.beans.MapModel;
import jdk.nashorn.internal.runtime.GlobalConstants;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestMapping("/template")
@Controller
public class UserController {
   @Resource
   private UserService userService;
   @Resource
   private EncouragementService encouragementService;
   /**
    * 用户登录
    * @param model 视图传值
    * @param username 用户名
    * @param password 用户密码
    * @return
    */
   @RequestMapping("/login.do")
   public String login(HttpSession httpSession, Model model, String username, String password, HttpServletRequest request, String code){
      String yzm = request.getSession().getAttribute("rand").toString();
      List<User> userList = userService.selectUsers();
      int userNum = userList.size()-1;
      if(userList!=null){
         for(User u:userList){
            if(u.getUsername().equals(username)&&u.getPassword().equals(password)&&code.equals(yzm)){
               if("管理员".equals(u.getRole())){
                  model.addAttribute("username",username);
                  return "back_index";
               }else {
                  User loguser = new User();
                  loguser.setUserid(u.getUserid());
                  loguser.setLoginFlag("on");
                  userService.updateloginFlag(loguser);
                  httpSession.setAttribute("userid",loguser.getUserid());
                  return "indexBackground1";
               }
            }
         }
      }
      return "login";
   }
   @RequestMapping(value = "/loginJump.do")
   public String loginJump(Model model){
      List<Encouragement> encouragementList = encouragementService.selectAllens();
      model.addAttribute("encouragementList",encouragementList);
      return "pre_index";
   }
   @RequestMapping("/loginout.do")
   public void loginout(String userid){
      User user = new User();
      user.setLoginFlag("off");
      user.setUserid(Integer.parseInt(userid));
      userService.updateloginFlag(user);
   }
   /**
    * 修改个人信息
    * @param user 用户
    * @return
    */
   @RequestMapping("/ModifyUserInfor.do")
   public String ModifyUserInfor(Model model,User user){
      int rows = userService.updateUser(user);
      return "back_main";
   }
   @RequestMapping("/alterpwd.do")
   public String alterpwd(String username,String password,String newpassword){
      List<User> userList = userService.selectUsers();
      if(userList!=null) {
         for(User user:userList){
            if (user.getUsername().equals(username)&&user.getPassword().equals(password)){
               User u = new User();
               u.setPassword(newpassword);
               u.setUsername(username);
               int row = userService.alterpwd(u);
               return "back_main";
            }
         }
      }
      return "back_changepwd";
   }
   @RequestMapping("/pre_index.do")
   public String pre_index(){
      return "pre_index";
   }

   /**
    * 注册用户
    * @param user
    * @return
    */
   @RequestMapping("/register.do")
   public String register(User user){
      System.out.println("************");
      List<User> userList = userService.selectUsers();
      boolean flag = true;
      if(user!=null&&userList!=null) {
         for(User u:userList) {
            if(u.getUsername().equals(user.getUsername())) {
               flag = false;
               return "register";
            }
         }
         if(flag) {
            SimpleDateFormat timeformat=new SimpleDateFormat("yyyy-MM-dd hh:mm");
            String registerDate = timeformat.format(System.currentTimeMillis());
            user.setRole("普通用户");
            user.setRegisterDate(registerDate);
            int row = userService.insertUser(user);
         }
      }
      return "login1";
   }
   @Test
   public void test(){
      SimpleDateFormat timeformat=new SimpleDateFormat("yyyy-MM-dd hh:mm");
      String registerDate = timeformat.format(System.currentTimeMillis());
      System.out.println(registerDate);
   }
}
