package com.liu.service;

import com.liu.bean.po.Comment;
import com.liu.bean.po.Reply;
import com.liu.bean.po.ReplymentExt;

import java.util.List;

public interface ReplyService {
   public int addBlogUserReply(Reply reply);
   public int addBlogUserReplyment(Reply reply);
   public List<Reply> selectReplyByBlog(int bid);
   public int deleteblogReply(int replyid);

   public List<ReplymentExt> selectReplymentExt();
   public List<Reply> selectReplys();
   public Reply selectByreplyid(int replyid);

   public List<ReplymentExt> selectReplymentExtBytime(String time);
   public List<ReplymentExt> selectReplymentExtBykeyword(String keyword);
   public List<ReplymentExt> selectReplymentExttitle(String title);
}
