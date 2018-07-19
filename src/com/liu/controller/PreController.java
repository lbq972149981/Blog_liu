package com.liu.controller;

import com.liu.bean.po.*;
import com.liu.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/template")
public class PreController {
   @Resource
   private ChickSoupService chickSoupService;
   @Resource
   private EncouragementService encouragementService;
   @Resource
   private BlogService blogService;
   @Resource
   private CommentService commentService;
   @Resource
   private UserService userService;
   @Resource
   private ReplyService replyService;
   /**
    * 前台鸡汤列表信息显示
    * @param model
    * @return
    */
   @RequestMapping("/chickSoupshow.do")
   public String chickSoupshow(Model model){
      List<ChickSoup> chickSoupList = chickSoupService.chickSoupListsSortbytime();
      model.addAttribute("chickSoupList",chickSoupList);
      return "pre_ChickenSoup";
   }

   /**
    * 显示励志语录
    * @param model
    * @return
    */
   @RequestMapping("/encouragementshow.do")
   public String encouragementshow(Model model){
      List<Encouragement> encouragementList = encouragementService.selectAllens();
      model.addAttribute("encouragementList",encouragementList);
      return "pre_index";
   }

   /**
    * 推荐且可展示的博文展示
    * @param model
    * @return
    */
   @RequestMapping("/recommendBlogsShow.do")
   public String recommendBlogsShow(Model model){
      List<Blog> blogList = blogService.selectBlogsByrecommend();
      for(Blog b:blogList){
         b.setBsummary(b.getBsummary().substring(0,b.getBsummary().length()/4)+"...");
      }
      model.addAttribute("blogList",blogList);
      return "pre_wayOfProgram";
   }

   /**
    * 阅读单篇博文
    * @param id
    * @param model
    * @return
    */
   @RequestMapping("/readBlog.do")
   public String readBlog(String id,Model model){
      if(id!=null) {
         Blog blog = blogService.selectByid(Integer.parseInt(id));
         System.out.println("修改前" + blog.getReadamount());
         blog.setReadamount(blog.getReadamount() + 1);
         blogService.updateReadamount(blog);
         System.out.println("修改后" + blog.getReadamount());
         model.addAttribute("blog", blog);
      }
      List<Comment> commentUserList = commentService.selectComment(Integer.parseInt(id));
      List<String> nicknameList = new ArrayList<>();
      for(int i=0;i<commentUserList.size();i++){
         String nickname = userService.selectByid(commentUserList.get(i).getUserid()).getNickname();
         nicknameList.add(nickname);
      }
      List<Reply> replyList = replyService.selectReplyByBlog(Integer.parseInt(id));
      List<String> replynicknameList = new ArrayList<>();
      for(int i=0;i<replyList.size();i++){
         String nickname = userService.selectByid(replyList.get(i).getCurruserid()).getNickname();
         replynicknameList.add(nickname);
      }
      model.addAttribute("replyList",replyList);
      model.addAttribute("replynicknameList",replynicknameList);
      model.addAttribute("commentUserList",commentUserList);
      model.addAttribute("nicknameList",nicknameList);
      return "pre_content";
   }

   /**
    * 展示所有博文
    * @param model
    * @return
    */
   @RequestMapping("/allBlogsLists.do")
   public String allBlogsLists(Model model){
      Map<String,Integer> countMap  = new HashMap<>();
      List<Blog> blogList = blogService.BlogLists();

      for(Blog b:blogList){
         b.setBsummary(b.getBsummary().substring(0,b.getBsummary().length()/4)+"...");
         countMap.put(b.getBkeyword(),0);
      }
      for(Blog b:blogList){
         countMap.put(b.getBkeyword(),countMap.get(b.getBkeyword())+1);
      }
      System.out.println(countMap);
      model.addAttribute("blogList",blogList);
      model.addAttribute("countMap",countMap);
      return "pre_CodeFlooding";
   }

   /**
    * 根据关键字查询博文
    * @param key
    * @param model
    * @return
    */
   @RequestMapping("/keyword.do")
   public String keyword(String key,Model model){
      Map<String,Integer> countMap  = new HashMap<>();
      List<Blog> blogList1 = blogService.BlogLists();
      for(Blog b:blogList1){
         countMap.put(b.getBkeyword(),0);
      }
      for(Blog b:blogList1){
         countMap.put(b.getBkeyword(),countMap.get(b.getBkeyword())+1);
      }
      List<Blog> blogList = blogService.searchBlogsBykey(key);
      for(Blog b:blogList){
         b.setBsummary(b.getBsummary().substring(0,b.getBsummary().length()/4)+"...");
      }
      model.addAttribute("blogList",blogList);
      model.addAttribute("countMap",countMap);
      return "pre_CodeFlooding";
   }

   /**
    * 写评论
    * @param commentContent
    * @param bid
    * @param curruserid
    * @param model
    * @return
    */
   @RequestMapping("/addComment.do")
   public synchronized String addComment(String commentContent,String bid,String curruserid,Model model){
      SimpleDateFormat timeformat=new SimpleDateFormat("yyyy-MM-dd hh:mm");
      String date = timeformat.format(System.currentTimeMillis());
      if(bid!=null) {
         Blog blog = blogService.selectByid(Integer.parseInt(bid));
         model.addAttribute("blog", blog);
      }
      Comment comment = new Comment();
      if(bid!=null&&commentContent!=null&&curruserid!=null) {
         comment.setBid(Integer.parseInt(bid));
         comment.setCommentContent(commentContent);
         comment.setUserid(Integer.parseInt(curruserid));
         comment.setCommentTime(date);
         commentService.addComment(comment);
         List<Comment> commentUserList = commentService.selectComment(Integer.parseInt(bid));
         List<String> nicknameList = new ArrayList<>();
         for(int i=0;i<commentUserList.size();i++){
            String nickname = userService.selectByid(commentUserList.get(i).getUserid()).getNickname();
            nicknameList.add(nickname);
         }
         List<Reply> replyList = replyService.selectReplyByBlog(Integer.parseInt(bid));
         List<String> replynicknameList = new ArrayList<>();
         for(int i=0;i<replyList.size();i++){
            String nickname = userService.selectByid(replyList.get(i).getCurruserid()).getNickname();
            replynicknameList.add(nickname);
         }
         model.addAttribute("replyList",replyList);
         model.addAttribute("replynicknameList",replynicknameList);
         model.addAttribute("commentUserList",commentUserList);
         model.addAttribute("nicknameList",nicknameList);
      }
      return "pre_content";
   }
   /**
    * 删除自己的评论
    * @param bid
    * @param userid
    * @param commentid
    * @param model
    * @return
    */
   @RequestMapping("/deleteblogComment.do")
   public synchronized String deleteblogComment(String bid,String userid,String commentid,Model model){
      System.out.println(bid);
      bid = bid.charAt(0)+"";
      commentService.deleteCommentByuserAndblog(Integer.parseInt(commentid));
      if(bid!=null) {
         Blog blog = blogService.selectByid(Integer.parseInt(bid));
         model.addAttribute("blog", blog);
      }
      if(bid!=null&&userid!=null) {
         List<Comment> commentUserList = commentService.selectComment(Integer.parseInt(bid));
         List<String> nicknameList = new ArrayList<>();
         for(int i=0;i<commentUserList.size();i++){
            String nickname = userService.selectByid(commentUserList.get(i).getUserid()).getNickname();
            nicknameList.add(nickname);
         }
         List<Reply> replyList = replyService.selectReplyByBlog(Integer.parseInt(bid));
         List<String> replynicknameList = new ArrayList<>();
         for(int i=0;i<replyList.size();i++){
            String nickname = userService.selectByid(replyList.get(i).getCurruserid()).getNickname();
            replynicknameList.add(nickname);
         }
         model.addAttribute("replyList",replyList);
         model.addAttribute("replynicknameList",replynicknameList);
         model.addAttribute("commentUserList",commentUserList);
         model.addAttribute("nicknameList",nicknameList);
      }
      return "pre_content";
   }

   /**
    * 点赞
    * @param bid
    * @param userid
    * @param commentid
    * @param model
    * @return
    */
   @RequestMapping("/praiseblogComment.do")
   public String  praiseblogComment(String bid,String userid,String commentid,Model model){
      commentService.praiseblogComment(Integer.parseInt(commentid));
      if(bid!=null) {
         Blog blog = blogService.selectByid(Integer.parseInt(bid));
         model.addAttribute("blog", blog);
      }
      if(bid!=null&&userid!=null) {
         List<Comment> commentUserList = commentService.selectComment(Integer.parseInt(bid));
         List<String> nicknameList = new ArrayList<>();
         for(int i=0;i<commentUserList.size();i++){
            String nickname = userService.selectByid(commentUserList.get(i).getUserid()).getNickname();
            nicknameList.add(nickname);
         }
         List<Reply> replyList = replyService.selectReplyByBlog(Integer.parseInt(bid));
         List<String> replynicknameList = new ArrayList<>();
         for(int i=0;i<replyList.size();i++){
            String nickname = userService.selectByid(replyList.get(i).getCurruserid()).getNickname();
            replynicknameList.add(nickname);
         }
         model.addAttribute("replyList",replyList);
         model.addAttribute("replynicknameList",replynicknameList);
         model.addAttribute("commentUserList",commentUserList);
         model.addAttribute("nicknameList",nicknameList);
      }
      return "pre_content";
   }
   /**
    * 取消点赞
    * @param bid
    * @param userid
    * @param commentid
    * @param model
    * @return
    */
   @RequestMapping("/unpraiseblogComment.do")
   public  String unpraiseblogComment(String bid,String userid,String commentid,Model model){
      commentService.unpraiseblogComment(Integer.parseInt(commentid));
      if(bid!=null) {
         Blog blog = blogService.selectByid(Integer.parseInt(bid));
         model.addAttribute("blog", blog);
      }
      if(bid!=null&&userid!=null) {
         List<Comment> commentUserList = commentService.selectComment(Integer.parseInt(bid));
         List<String> nicknameList = new ArrayList<>();
         for(int i=0;i<commentUserList.size();i++){
            String nickname = userService.selectByid(commentUserList.get(i).getUserid()).getNickname();
            nicknameList.add(nickname);
         }
         List<Reply> replyList = replyService.selectReplyByBlog(Integer.parseInt(bid));
         List<String> replynicknameList = new ArrayList<>();
         for(int i=0;i<replyList.size();i++){
            String nickname = userService.selectByid(replyList.get(i).getCurruserid()).getNickname();
            replynicknameList.add(nickname);
         }
         model.addAttribute("replyList",replyList);
         model.addAttribute("replynicknameList",replynicknameList);
         model.addAttribute("commentUserList",commentUserList);
         model.addAttribute("nicknameList",nicknameList);

      }
      return "pre_content";
   }

   /**
    * 回复评论
    * @param reply
    * @param bid
    * @param userid
    * @param commentid
    * @param replyContent
    * @param model
    * @return
    */
   @RequestMapping("/replyContent.do")
   //String bid,String userid,String curruserid,String replyContent
   public String replyContent(Reply reply,String bid,String userid,String commentid,String replyContent,Model model){
      SimpleDateFormat timeformat=new SimpleDateFormat("yyyy-MM-dd hh:mm");
      String date = timeformat.format(System.currentTimeMillis());
      if(reply!=null&&replyContent!=null) {
         reply.setReplyContent(replyContent.replace(",", ""));
         reply.setReplyTime(date);
         reply.setCommentid(Integer.parseInt(commentid));
         replyService.addBlogUserReply(reply);
      }
      if(bid!=null) {
         Blog blog = blogService.selectByid(Integer.parseInt(bid));
         model.addAttribute("blog", blog);
      }
      if(bid!=null&&userid!=null) {
         List<Comment> commentUserList = commentService.selectComment(Integer.parseInt(bid));
         List<String> nicknameList = new ArrayList<>();
         for(int i=0;i<commentUserList.size();i++){
            String nickname = userService.selectByid(commentUserList.get(i).getUserid()).getNickname();
            nicknameList.add(nickname);
         }
         List<Reply> replyList = replyService.selectReplyByBlog(Integer.parseInt(bid));
         List<String> replynicknameList = new ArrayList<>();
         for(int i=0;i<replyList.size();i++){
            String nickname = userService.selectByid(replyList.get(i).getCurruserid()).getNickname();
            replynicknameList.add(nickname);
         }
         model.addAttribute("commentUserList",commentUserList);
         model.addAttribute("nicknameList",nicknameList);
         model.addAttribute("replyList",replyList);
         model.addAttribute("replynicknameList",replynicknameList);
      }
      return "pre_content";
   }

   /**
    * 删除回复
    * @param bid
    * @param userid
    * @param replyid
    * @param model
    * @return
    */
   @RequestMapping("/deleteblogReply.do")
   public synchronized String deleteblogReply(String bid,String userid,String replyid,Model model){
      System.out.println(bid);
      bid = bid.charAt(0)+"";
      replyService.deleteblogReply(Integer.parseInt(replyid));
      if(bid!=null) {
         Blog blog = blogService.selectByid(Integer.parseInt(bid));
         model.addAttribute("blog", blog);
      }
      if(bid!=null&&userid!=null) {
         List<Comment> commentUserList = commentService.selectComment(Integer.parseInt(bid));
         List<String> nicknameList = new ArrayList<>();
         for(int i=0;i<commentUserList.size();i++){
            String nickname = userService.selectByid(commentUserList.get(i).getUserid()).getNickname();
            nicknameList.add(nickname);
         }
         List<Reply> replyList = replyService.selectReplyByBlog(Integer.parseInt(bid));
         List<String> replynicknameList = new ArrayList<>();
         for(int i=0;i<replyList.size();i++){
            String nickname = userService.selectByid(replyList.get(i).getCurruserid()).getNickname();
            replynicknameList.add(nickname);
         }
         model.addAttribute("replyList",replyList);
         model.addAttribute("replynicknameList",replynicknameList);
         model.addAttribute("commentUserList",commentUserList);
         model.addAttribute("nicknameList",nicknameList);
      }
      return "pre_content";
   }

   @RequestMapping("/replyReplyment.do")
   //String bid,String userid,String curruserid,String replyContent
   public String replyReplyment(Reply reply,String bid,String userid,String rreplyid,String replyContent,String commentid,Model model){
      SimpleDateFormat timeformat=new SimpleDateFormat("yyyy-MM-dd hh:mm");
      String date = timeformat.format(System.currentTimeMillis());
      System.out.println(rreplyid);
      System.out.println(commentid);
      if(reply!=null&&replyContent!=null) {
         reply.setReplyContent(replyContent.replace(",", ""));
         reply.setReplyTime(date);
         reply.setRreplyid(Integer.parseInt(rreplyid));
         reply.setCommentid(Integer.parseInt(commentid));
         replyService.addBlogUserReplyment(reply);
      }
      if(bid!=null) {
         Blog blog = blogService.selectByid(Integer.parseInt(bid));
         model.addAttribute("blog", blog);
      }
      if(bid!=null&&userid!=null) {
         List<Comment> commentUserList = commentService.selectComment(Integer.parseInt(bid));
         List<String> nicknameList = new ArrayList<>();
         for(int i=0;i<commentUserList.size();i++){
            String nickname = userService.selectByid(commentUserList.get(i).getUserid()).getNickname();
            nicknameList.add(nickname);
         }
         List<Reply> replyList = replyService.selectReplyByBlog(Integer.parseInt(bid));
         List<String> replynicknameList = new ArrayList<>();
         for(int i=0;i<replyList.size();i++){
            String nickname = userService.selectByid(replyList.get(i).getCurruserid()).getNickname();
            replynicknameList.add(nickname);
         }
         model.addAttribute("commentUserList",commentUserList);
         model.addAttribute("nicknameList",nicknameList);
         model.addAttribute("replyList",replyList);
         model.addAttribute("replynicknameList",replynicknameList);
      }
      return "pre_content";
   }
}

