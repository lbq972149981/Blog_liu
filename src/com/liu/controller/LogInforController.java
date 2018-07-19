package com.liu.controller;

import com.liu.bean.po.LogInfor;
import com.liu.service.LogInforService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RequestMapping("/template")
@Controller
public class LogInforController {
   @Resource
   private LogInforService logInforService;
   /**
    * 分页查询日志信息
    * @param model
    * @param cur
    * @return
    */
   public Model PageLogs(Model model,String cur){
      int curPage = 1;
      if(cur!=null){
         curPage = Integer.parseInt(cur);
      }
      int count = logInforService.selectLogs().size()/10+1;
      List<LogInfor> logInforList = logInforService.selectLogs(new RowBounds((curPage-1)*10,10));
      model.addAttribute("logInforList",logInforList);
      model.addAttribute("count",count);
      model.addAttribute("curPage",curPage);
      return model;
   }
   /**
    * 分页显示日志信息
    * @param model
    * @param cur
    * @return
    */
   @RequestMapping("/logs.do")
   public String Logs(Model model,String cur){
      model = PageLogs(model,cur);
      return "back_myloginfo";
   }

   /**
    * 按日期查询日志信息
    * @param model
    * @param keyTime
    * @return
    */
   @RequestMapping("/search.do")
   public String search(Model model,String keyTime,String cur){
      int curPage = 1;
      if(cur!=null){
         curPage = Integer.parseInt(cur);
      }
      int count = logInforService.selectByDate(keyTime).size()/10+1;
      List<LogInfor> logInforList = logInforService.selectByDate(keyTime,new RowBounds((curPage-1)*10,10));
      model.addAttribute("logInforList",logInforList);
      model.addAttribute("count",count);
      model.addAttribute("curPage",curPage);
      return "back_myloginfo";
   }

   /**
    * 批量删除登录日志
    * @param delitems
    * @param cur
    * @param model
    * @return
    */
   @RequestMapping("/batchDelete.do")
   public String batchDelete(String delitems,String cur,Model model){
      String[] strs = delitems.split(",");
      List<Integer> ids = new ArrayList<Integer>();
      for(String s:strs){
         ids.add(Integer.parseInt(s));
      }
      logInforService.batchDeleteLogs(ids);
      model = PageLogs(model,cur);
      return "back_myloginfo";
   }
   /**
    * 删除单个日志信息
    * @param id
    * @param model
    * @param cur
    * @return
    */
   @RequestMapping("/delete.do")
   public String deleteLog(String id,Model model,String cur){
      int _id = Integer.parseInt(id);
      System.out.println(_id);
      logInforService.deleteLog(_id);
      model = PageLogs(model,cur);
      return "back_myloginfo";
   }
}
