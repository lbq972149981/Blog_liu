package com.liu.controller;

import com.liu.bean.po.Encouragement;
import com.liu.bean.po.User;
import com.liu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/template")
public class UserManageController {
   @Resource
   private UserService userService;

   /**
    * 显示用户信息列表
    * @param model
    * @return
    */
   @RequestMapping("/userLists.do")
   public String userLists(Model model){
      List<User> userList =  userService.selectByrole("普通用户");
      if(userList!=null)
         model.addAttribute("userList",userList);
      return "back_userManage";
   }

   /**
    * 将指定用户禁言
    * @param id
    * @param model
    * @return
    */
   @RequestMapping("/updateSilenceFlag.do")
   public String updateSilenceFlag(String id,Model model){
      userService.updateSilenceFlag(Integer.parseInt(id));
      List<User> userList =  userService.selectByrole("普通用户");
      if(userList!=null)
         model.addAttribute("userList",userList);
      return "back_userManage";
   }

   /**
    * 删除指定用户
    * @param id
    * @param model
    * @return
    */
   @RequestMapping("/deleteUser.do")
   public String deleteUser(String id,Model model){
      userService.deleteUser(Integer.parseInt(id));
      List<User> userList =  userService.selectByrole("普通用户");
      if(userList!=null)
         model.addAttribute("userList",userList);
      return "back_userManage";
   }

   /**
    * 批量删除用户
    * @param model
    * @param delitems
    * @return
    */
   @RequestMapping("/batchDeleteUsers.do")
   public String batchDeleteUsers(Model model,String delitems){
      String[] strs = delitems.split(",");
      List<Integer> ids = new ArrayList<Integer>();
      for(String s:strs){
         ids.add(Integer.parseInt(s));
      }
      userService.batchDeleteUsers(ids);
      List<User> userList =  userService.selectByrole("普通用户");
      if(userList!=null)
         model.addAttribute("userList",userList);
      return "back_userManage";
   }

   /**
    * 解除用户禁言
    * @param id
    * @param model
    * @return
    */
   @RequestMapping("/RemoveSilenceUser.do")
   public String batchDeprecatedEncouragement(String id,Model model){
      userService.RemoveSilenceUser(Integer.parseInt(id));
      List<User> userList =  userService.selectByrole("普通用户");
      model.addAttribute("userList",userList);
      return "back_userManage";
   }
   /**
    * 模糊查询用户信息
    * @param searchUsers
    * @return
    */
   @RequestMapping("/searchUsers.do")
   public String searchUsers(String searchUsers,Model model){
      System.out.println(searchUsers);
      boolean flag = true;
      List<User> userList = null;
      for(char c :searchUsers.toCharArray()){
         if((c>='0'&&c<='9')||c=='-'||c==' '||c==':'){
            flag = true;
         }else {
            flag=false;
            break;
         }
      }
      if("男".equals(searchUsers)||"女".equals(searchUsers)){
         userList = userService.searchUsersBySex(searchUsers);
      }else if (flag){
         userList = userService.searchUsersByregisterDate(searchUsers);
      }else {
         userList = null;
      }
      model.addAttribute("userList",userList);
      return "back_userManage";
   }
}
