package com.liu.controller;

import com.liu.bean.po.ChickSoup;
import com.liu.bean.po.User;
import com.liu.service.ChickSoupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/template")
public class ChickSoupController {
   @Resource
   private ChickSoupService chickSoupService;

   /**
    * 鸡汤列表信息
    * @param model
    * @return
    */
   @RequestMapping("/chickSoupLists.do")
   public String chickSoupLists(Model model){
      List<ChickSoup> chickSoupList = chickSoupService.chickSoupLists();
      model.addAttribute("chickSoupList",chickSoupList);
      return "back_ClickSoup";
   }

   /**
    * 增加鸡汤
    * @param chickSoup
    * @param model
    * @return
    */
   @RequestMapping("/addChickSoup.do")
   public String addChickSoup(ChickSoup chickSoup,Model model){
      if("null".equals(chickSoup.getCshowFlag())||null==chickSoup.getCshowFlag()){
         chickSoup.setCshowFlag("off");
      }
      chickSoupService.addChickSoup(chickSoup);
      List<ChickSoup> chickSoupList = chickSoupService.chickSoupLists();
      model.addAttribute("chickSoupList",chickSoupList);
      return "back_ClickSoup";
   }

   /**
    * 跳转鸡汤编辑页面信息
    * @param cid
    * @param model
    * @return
    */
   @RequestMapping("/editChickSoupJump.do")
   public String editChickSoupJump(String cid,Model model){
      ChickSoup chickSoup = chickSoupService.selectByid(Integer.parseInt(cid));
      model.addAttribute("chickSoup",chickSoup);
      return "back_EditClickSoup";
   }

   /**
    * 编辑指定id鸡汤
    * @param chickSoup
    * @param model
    * @return
    */
   @RequestMapping("/editChickSoup.do")
   public String editChickSoup(ChickSoup chickSoup,Model model){
      if("null".equals(chickSoup.getCshowFlag())||null==chickSoup.getCshowFlag()){
         chickSoup.setCshowFlag("off");
      }
      int row = chickSoupService.editChickSoup(chickSoup);
      List<ChickSoup> chickSoupList = chickSoupService.chickSoupLists();
      model.addAttribute("chickSoupList",chickSoupList);
      return "back_ClickSoup";
   }
   /**
    * 指定id删除鸡汤
    * @param cid
    * @param model
    * @return
    */
   @RequestMapping("/deleteChickSoup.do")
   public String deleteChickSoup(String cid, Model model){
      chickSoupService.deleteChickSoup(Integer.parseInt(cid));
      List<ChickSoup> chickSoupList = chickSoupService.chickSoupLists();
      model.addAttribute("chickSoupList",chickSoupList);
      return "back_ClickSoup";
   }

   /**
    * 批量删除鸡汤
    * @param delitems
    * @param model
    * @return
    */
   @RequestMapping("/batchDeleteChickSoups.do")
   public String batchDeleteChickSoups(String delitems,Model model){
      String[] strs = delitems.split(",");
      List<Integer> ids = new ArrayList<Integer>();
      for(String s:strs){
         ids.add(Integer.parseInt(s));
      }
      chickSoupService.batchDeleteChickSoups(ids);
      List<ChickSoup> chickSoupList = chickSoupService.chickSoupLists();
      model.addAttribute("chickSoupList",chickSoupList);
      return "back_ClickSoup";
   }

   /**
    * 根据时间或标题关键字查询鸡汤
    * @param searchText
    * @param model
    * @return
    */
   @RequestMapping("/searchChickSoups.do")
   public String searchChickSoups(String searchText,Model model){
      boolean flag = true;
      List<ChickSoup> chickSoupList = null;
      for(char c :searchText.toCharArray()){
         if((c>='0'&&c<='9')||c=='-'||c==' '||c==':'){
            flag = true;
         }else {
            flag=false;
            break;
         }
      }
      if (flag){
         chickSoupList = chickSoupService.searchChickSoupsBytime(searchText);
      }else {
         chickSoupList = chickSoupService.searchChickSoupsBytitle(searchText);
      }
      model.addAttribute("chickSoupList",chickSoupList);
      return "back_ClickSoup";
   }

   /**
    * 鸡汤是否展示
    * @param cid
    * @param cshowFlag
    * @param model
    * @return
    */
   @RequestMapping("/editShowFlag.do")
   public String editShowFlag(String cid,String cshowFlag,Model model){
      ChickSoup chickSoup = new ChickSoup();
      chickSoup.setCshowFlag(cshowFlag);
      chickSoup.setCid(Integer.parseInt(cid));
      chickSoupService.editshowFlag(chickSoup);
      List<ChickSoup> chickSoupList = chickSoupService.chickSoupLists();
      model.addAttribute("chickSoupList",chickSoupList);
      return "back_ClickSoup";
   }
}
