package com.liu.controller;

import com.liu.bean.po.CommentExt;
import com.liu.bean.po.Reply;
import com.liu.bean.po.ReplymentExt;
import com.liu.bean.po.User;
import com.liu.service.ReplyService;
import com.liu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/template")
public class ReplyController {
   @Resource
   private ReplyService replyService;
   @Resource
   private UserService userService;

   /**
    * 显示回复列表
    * @param model
    * @return
    */
   @RequestMapping("/showReplymentExtList.do")
   public String selectReplymentExt(Model model){
      List<ReplymentExt> replymentExtList = replyService.selectReplymentExt();
      List<String> nicknameList  = new ArrayList<>();
      for(ReplymentExt replymentExt:replymentExtList){
         nicknameList.add(userService.selectByid(replymentExt.getCurruserid()).getNickname());
      }
      model.addAttribute("replymentExtList",replymentExtList);
      model.addAttribute("nicknameList",nicknameList);
      return "back_replyManage";
   }

   /**
    * 单个删除回复
    * @param id
    * @param rreplyid
    * @param model
    * @return
    */
   @RequestMapping("/deleteReplyment.do")
   public String deleteReplyment(Integer id,Integer rreplyid,Model model){
      System.out.println(id);
      System.out.println(rreplyid);
      List<Reply> replyList = replyService.selectReplys();
      if(rreplyid==0){
         for(Reply reply:replyList){
            if(reply.getRreplyid()==id){
               replyService.deleteblogReply(reply.getReplyid());
            }
         }
      }
      replyService.deleteblogReply(id);
      List<ReplymentExt> replymentExtList = replyService.selectReplymentExt();
      List<String> nicknameList  = new ArrayList<>();
      for(ReplymentExt replymentExt:replymentExtList){
         nicknameList.add(userService.selectByid(replymentExt.getCurruserid()).getNickname());
      }
      model.addAttribute("replymentExtList",replymentExtList);
      model.addAttribute("nicknameList",nicknameList);
      return "back_replyManage";
   }

   /**
    * 批量删除回复
    * @param delitems
    * @param model
    * @return
    */
   @RequestMapping("/batchDeleteReplyment.do")
   public String batchDeleteReplyment(String delitems,Model model){
      System.out.println(delitems);
      String[] strs = delitems.split(",");
      List<Integer> replyidList = new ArrayList<>();
      List<Reply> replyList = replyService.selectReplys();
      for(String id:strs){
         replyidList.add(Integer.parseInt(id));
      }
      for(Integer replyid:replyidList){
         //54 55
         int rreplyid = replyService.selectByreplyid(replyid).getRreplyid();
         if(rreplyid!=0){
            replyService.deleteblogReply(replyid);
         }else {
            for(Reply reply:replyList){
               if(reply.getRreplyid()==replyid){
                  replyService.deleteblogReply(reply.getReplyid());
               }
            }
            replyService.deleteblogReply(replyid);
         }
      }
      List<ReplymentExt> replymentExtList = replyService.selectReplymentExt();
      List<String> nicknameList  = new ArrayList<>();
      for(ReplymentExt replymentExt:replymentExtList){
         nicknameList.add(userService.selectByid(replymentExt.getCurruserid()).getNickname());
      }
      model.addAttribute("replymentExtList",replymentExtList);
      model.addAttribute("nicknameList",nicknameList);
      return "back_replyManage";
   }
   @RequestMapping("/searchReplys.do")
   public String searchReplys(String searchText,Model model){
      boolean flag = true;
      boolean titleflag = true;
      for(char c :searchText.toCharArray()){
         if((c>='0'&&c<='9')||c=='-'||c==' '||c==':'){
            flag = true;
         }else {
            flag=false;
            break;
         }
      }
      for(int i=0;i<searchText.length();i++){
         if(searchText.charAt(i)>'a'&&searchText.charAt(i)<'z'||searchText.charAt(i)>'A'&&searchText.charAt(i)<'Z'){
            titleflag = true;
         }else {
            titleflag = false;
            break;
         }
      }
      List<ReplymentExt> replymentExtList = null;
      if(flag){
         replymentExtList = replyService.selectReplymentExtBytime(searchText);
      }else if (titleflag){
         replymentExtList = replyService.selectReplymentExtBykeyword(searchText.toLowerCase());
      }else {
         replymentExtList = replyService.selectReplymentExttitle(searchText);
      }
      List<String> nicknameList  = new ArrayList<>();
      for(ReplymentExt replymentExt:replymentExtList){
         nicknameList.add(userService.selectByid(replymentExt.getCurruserid()).getNickname());
      }
      model.addAttribute("replymentExtList",replymentExtList);
      model.addAttribute("nicknameList",nicknameList);
      return "back_replyManage";
   }
}
