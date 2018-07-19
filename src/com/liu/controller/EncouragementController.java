package com.liu.controller;

import com.liu.bean.po.Encouragement;
import com.liu.service.EncouragementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/template")
public class EncouragementController {
   @Resource
   private EncouragementService encouragementService;

   /**
    * 显示励文列表
    * @param model
    * @return
    */
   @RequestMapping("/encouragements.do")
   public String encouragements(Model model){
      List<Encouragement> encouragementList = encouragementService.selectAllens();
      model.addAttribute("encouragementList",encouragementList);
      return "back_mainPage";
   }

   /**
    * 添加一篇励文
    * @param model
    * @param encouragement
    * @return
    */
   @RequestMapping("/addEncouragement.do")
   public String addEncouragement(Model model,Encouragement encouragement){
      if("null".equals(encouragement.getRecommendFlag())||null==encouragement.getRecommendFlag()){
         encouragement.setRecommendFlag("off");
      }
      if("null".equals(encouragement.getShowFlag())||null==encouragement.getShowFlag()){
         encouragement.setShowFlag("off");
      }
      encouragement.setCollectFlag("off");
      int row = encouragementService.addEncouragement(encouragement);
      List<Encouragement> encouragementList = encouragementService.selectAllens();
      model.addAttribute("encouragementList",encouragementList);
      return "back_mainPage";
   }

   /**
    * 删除指定励文
    * @param id
    * @param model
    * @return
    */
   @RequestMapping("/deleteEncouragement.do")
   public String deleteEncouragement(String id,Model model){
      System.out.println(id);
      encouragementService.deleteEncouragement(Integer.parseInt(id));
      List<Encouragement> encouragementList = encouragementService.selectAllens();
      model.addAttribute("encouragementList",encouragementList);
      return "back_mainPage";
   }

   /**
    * 批量删除励文
    * @param delitems
    * @param model
    * @return
    */
   @RequestMapping("/batchDeleteEncouragement.do")
   public String batchDeleteEncouragement(String delitems,Model model){
      String[] strs = delitems.split(",");
      List<Integer> ids = new ArrayList<Integer>();
      for(String s:strs){
         ids.add(Integer.parseInt(s));
      }
      System.out.println(ids);
      encouragementService.batchDeleteEncouragements(ids);
      List<Encouragement> encouragementList = encouragementService.selectAllens();
      model.addAttribute("encouragementList",encouragementList);
      return "back_mainPage";
   }
   /**
    * 批量推荐励文
    * @param delitems
    * @param model
    * @return
    */
   @RequestMapping("/batchRecommendEncouragement.do")
   public String batchRecommendEncouragement(String delitems,Model model){
      System.out.println(delitems);
      String[] strs = delitems.split(",");
      List<Integer> ids = new ArrayList<Integer>();
      for(String s:strs){
         ids.add(Integer.parseInt(s));
      }
      encouragementService.batchRecommendEncouragements(ids);
      List<Encouragement> encouragementList = encouragementService.selectAllens();
      model.addAttribute("encouragementList",encouragementList);
      return "back_mainPage";
   }

   /**
    * 批量取消推荐励文
    * @param delitems
    * @param model
    * @return
    */
   @RequestMapping("/batchDeprecatedEncouragement.do")
   public String batchDeprecatedEncouragement(String delitems,Model model){
      System.out.println(delitems);
      String[] strs = delitems.split(",");
      List<Integer> ids = new ArrayList<Integer>();
      for(String s:strs){
         ids.add(Integer.parseInt(s));
      }
      encouragementService.batchDeprecatedEncouragements(ids);
      List<Encouragement> encouragementList = encouragementService.selectAllens();
      model.addAttribute("encouragementList",encouragementList);
      return "back_mainPage";
   }

   /**
    * 跳转修改励文页面
    * @param id
    * @param model
    * @return
    */
   @RequestMapping("/editEncouragementJump.do")
   public String editEncouragementJump(String id,Model model){
      Encouragement encouragement = encouragementService.queryByid(Integer.parseInt(id));
      model.addAttribute("encouragement",encouragement);
      model.addAttribute("id",id);
      return "back_EditEncouragment";
   }

   /**
    * 修改励文
    * @param id
    * @param encouragement
    * @param model
    * @return
    */
   @RequestMapping("/editEncouragement.do")
   public String editEncouragement(String id,Encouragement encouragement,Model model){
      if("null".equals(encouragement.getRecommendFlag())||null==encouragement.getRecommendFlag()){
         encouragement.setRecommendFlag("off");
      }
      if("null".equals(encouragement.getShowFlag())||null==encouragement.getShowFlag()){
         encouragement.setShowFlag("off");
      }
      encouragement.setId(Integer.parseInt(id));
      encouragementService.editEncouragement(encouragement);
      List<Encouragement> encouragementList = encouragementService.selectAllens();
      model.addAttribute("encouragementList",encouragementList);
      return "back_mainPage";
   }
   /**
    * 励文是否被展示
    * @param id
    * @param showflag
    * @param model
    * @return
    */
   @RequestMapping("/showEncouragement.do")
   public String showEncouragement(String id,String showflag,Model model){
      Encouragement encouragement = new Encouragement();
      encouragement.setShowFlag(showflag);
      encouragement.setId(Integer.parseInt(id));
      encouragementService.editShowFlag(encouragement);
      List<Encouragement> encouragementList = encouragementService.selectAllens();
      model.addAttribute("encouragementList",encouragementList);
      return "back_mainPage";
   }

   /**
    * 励文是否被收藏
    * @param id
    * @param collectflag
    * @param model
    * @return
    */
   @RequestMapping("/collectEncouragement.do")
   public String collectEncouragement(String id,String collectflag,Model model){
      Encouragement encouragement = new Encouragement();
      encouragement.setCollectFlag(collectflag);
      encouragement.setId(Integer.parseInt(id));
      encouragementService.editCollectFlag(encouragement);
      List<Encouragement> encouragementList = encouragementService.selectAllens();
      model.addAttribute("encouragementList",encouragementList);
      return "back_mainPage";
   }
   /**
    * 根据enTitle中的关键字查询励文
    * @param searchText
    * @param model
    * @return
    */
   @RequestMapping("/searchEncouragement.do")
   public String searchEncouragement(String searchText,Model model){
      System.out.println(searchText);
      List<Encouragement> encouragementList = encouragementService.searchByTitle(searchText);
      model.addAttribute("encouragementList",encouragementList);
      return  "back_mainPage";
   }
}
