package com.liu.controller;

import com.liu.bean.po.User;
import com.liu.service.ChickSoupService;
import com.liu.service.EncouragementService;
import com.liu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/template")
public class RecordInforController {
   @Resource
   private UserService userService;
   @Resource
   private EncouragementService encouragementService;
   @Resource
   private ChickSoupService chickSoupService;
   /**
    * 记录用户总人数和今日注册人数
    * 记录励文总数
    * @return
    */
   @RequestMapping(value = "/countInfor.do",method = RequestMethod.GET)
   public @ResponseBody List<Integer> countInfor(){
      List<User> userList = userService.selectUsers();
      SimpleDateFormat timeformat=new SimpleDateFormat("yyyy-MM-dd");
      String date = timeformat.format(System.currentTimeMillis());
      int registerCount = userService.searchregisterDateCount(date).size();
      int userCount = userList.size();
      int encouragementCount = encouragementService.selectAllens().size();
      int chickSoupCount = chickSoupService.chickSoupLists().size();
      List<Integer> countInfor = new ArrayList<>();
      countInfor.add(registerCount);
      countInfor.add(userCount);
      countInfor.add(encouragementCount);
      countInfor.add(chickSoupCount);
      return countInfor;
   }
   @RequestMapping("/backmain.do")
   public String backmain(){
      return "back_index";
   }
}
