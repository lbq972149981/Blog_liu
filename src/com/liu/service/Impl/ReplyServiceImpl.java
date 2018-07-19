package com.liu.service.Impl;


import com.liu.bean.mapper.ReplyMapper;
import com.liu.bean.po.Reply;
import com.liu.bean.po.ReplymentExt;
import com.liu.service.ReplyService;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;

@Component("ReplyService")
public class ReplyServiceImpl implements ReplyService {
   @Resource
   private ReplyMapper replyMapper;

   @Override
   public int addBlogUserReply(Reply reply) {
      return replyMapper.addBlogUserReply(reply);
   }

   @Override
   public int addBlogUserReplyment(Reply reply) {
      return replyMapper.addBlogUserReplyment(reply);
   }

   @Override
   public List<Reply> selectReplyByBlog(int bid) {
      return replyMapper.selectReplyByBlog(bid);
   }

   @Override
   public int deleteblogReply(int replyid) {
      return replyMapper.deleteblogReply(replyid);
   }

   @Override
   public List<ReplymentExt> selectReplymentExt() {
      return replyMapper.selectReplymentExt();
   }

   @Override
   public List<Reply> selectReplys() {
      return replyMapper.selectReplys();
   }

   @Override
   public Reply selectByreplyid(int replyid) {
      return replyMapper.selectByreplyid(replyid);
   }

   @Override
   public List<ReplymentExt> selectReplymentExtBytime(String time) {
      return replyMapper.selectReplymentExtBytime(time);
   }

   @Override
   public List<ReplymentExt> selectReplymentExtBykeyword(String keyword) {
      return replyMapper.selectReplymentExtBykeyword(keyword);
   }

   @Override
   public List<ReplymentExt> selectReplymentExttitle(String title) {
      return replyMapper.selectReplymentExttitle(title);
   }
}
