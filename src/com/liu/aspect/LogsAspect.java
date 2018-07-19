package com.liu.aspect;

import com.liu.bean.po.LogInfor;
import com.liu.bean.po.User;
import com.liu.service.LogInforService;
import com.liu.service.UserService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.junit.Test;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.List;

@Component("LogsAspect")
@Service
@Aspect
@SessionAttributes(value = {"logInforList"})
public class LogsAspect {
   public List<LogInfor> logInforList;
   @Resource
   private LogInforService logInforService;
   @Resource
   private UserService userService;
   @After("execution(* com.liu.controller.UserController.login(..))")
   public void insertLogs(){
      ModelAndView modelAndView = new ModelAndView();
      SimpleDateFormat timeformat=new SimpleDateFormat("yyyy-MM-dd hh:mm");
      String date = timeformat.format(System.currentTimeMillis());
      String ip = InetAddress.getLoopbackAddress().getHostAddress();
      String username = null;
      for(User user :userService.selectUsers()){
         if("管理员".equals(user.getRole())){
            username = user.getUsername();
            break;
         }
      }
      LogInfor logInfor = new LogInfor();
      logInfor.setOperateTime(date);
      logInfor.setUsername(username);
      logInfor.setOperateIp(ip);
      logInforService.insertLogs(logInfor);
   }
   @Test
   public void test(){
      System.out.println(InetAddress.getLoopbackAddress().getHostAddress());
   }
}


