package com.liu.controller;

import com.liu.bean.po.*;
import com.liu.service.*;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/template")
public class CommentController {
   @Resource
   private CommentService commentService;
   @Resource
   private ReplyService replyService;
   /**
    * 显示评论列表
    * @param model
    * @return
    */
   @RequestMapping("/showCommentExtList.do")
   public String selectCommentExt(Model model){
      List<CommentExt> commentExtList = commentService.selectCommentExt();
      model.addAttribute("commentExtList",commentExtList);
      return "back_commentManage";
   }
   /**
    * 单个删除评论
    * @param model
    * @param commentid
    * @return
    */
   @RequestMapping("/deleteComment.do")
   public String deleteComment(Model model,Integer commentid){
      System.out.println(commentid);
      List<Reply> replyList = replyService.selectReplys();
      for(Reply reply:replyList){
         if(reply.getCommentid()==commentid){
            replyService.deleteblogReply(reply.getReplyid());
         }
      }
      commentService.deleteCommentByuserAndblog(commentid);
      List<CommentExt> commentExtList = commentService.selectCommentExt();
      model.addAttribute("commentExtList",commentExtList);
      return "back_commentManage";
   }

   /**
    * 批量删除评论
    * @param model
    * @param delitems
    * @return
    */
   @RequestMapping("/batchDeleteComments.do")
   public String batchDeleteComments(Model model,String delitems){
      String[] strs = delitems.split(",");
      System.out.println(strs);
      List<Integer> commentidList = new ArrayList<>();
      List<Reply> replyList = replyService.selectReplys();
      for(String id:strs){
         commentidList.add(Integer.parseInt(id));
      }
      System.out.println(commentidList);
      //83 84 85 86
      for(Integer commentid:commentidList){
         for(Reply reply:replyList){
            if(reply.getCommentid()==commentid){
               replyService.deleteblogReply(reply.getReplyid());
            }
         }
         commentService.deleteCommentByuserAndblog(commentid);
      }
      List<CommentExt> commentExtList = commentService.selectCommentExt();
      model.addAttribute("commentExtList",commentExtList);
      return "back_commentManage";
   }

   /**
    * 查询评论信息
    * @param searchText
    * @param model
    * @return
    */
   @RequestMapping("/searchComments.do")
   public String searchComments(String searchText,Model model){
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
      List<CommentExt> commentExtList = null;
      if(flag){
         commentExtList = commentService.selectCommentExtBytime(searchText);
      }else if (titleflag){
         commentExtList = commentService.selectCommentExtBykeyword(searchText.toLowerCase());
      }else {
         commentExtList = commentService.selectCommentExtBytitle(searchText);
      }
      model.addAttribute("commentExtList",commentExtList);
      return "back_commentManage";
   }
}
