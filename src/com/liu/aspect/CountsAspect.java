package com.liu.aspect;

import com.liu.bean.po.LogInfor;
import com.liu.bean.po.User;
import com.liu.service.LogInforService;
import com.liu.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.junit.Test;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
@Component("userAspect")
@Service
@Aspect
@RequestMapping("/template")
public class CountsAspect {
   @Resource
   private UserService userService;
   /**
    * 记录用户总人数和今日注册人数
    * @return
    */
/*   @After("execution(* com.liu.controller.UserController.login(..))")
   @RequestMapping(value = "/countInfor.do",method = RequestMethod.GET)
   public @ResponseBody List<Integer> countInfor(){
      List<User> userList = userService.selectUsers();
      SimpleDateFormat timeformat=new SimpleDateFormat("yyyy-MM-dd");
      String date = timeformat.format(System.currentTimeMillis());
      int registerCount = userService.searchregisterDateCount(date).size();
      int userCount = userList.size();
      List<Integer> countInfor = new ArrayList<>();
      countInfor.add(registerCount);
      countInfor.add(userCount);
      return countInfor;
   }*/
}


