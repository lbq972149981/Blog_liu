package com.liu.service.Impl;


import com.liu.bean.mapper.CommentMapper;
import com.liu.bean.po.Comment;
import com.liu.bean.po.CommentExt;
import com.liu.service.CommentService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("CommentService")
public class CommentServiceImpl implements CommentService {
   @Resource
   private CommentMapper commentMapper;

   @Override
   public int addComment(Comment comment) {
      return commentMapper.addComment(comment);
   }

   @Override
   public List<Comment> selectComment(int bid) {
      return commentMapper.selectComment(bid);
   }

   @Override
   public int deleteCommentByuserAndblog(int commentid) {
      return commentMapper.deleteCommentByuserAndblog(commentid);
   }

   @Override
   public int praiseblogComment(int commentid) {
      return commentMapper.praiseblogComment(commentid);
   }

   @Override
   public int unpraiseblogComment(int commentid) {
      return commentMapper.unpraiseblogComment(commentid);
   }

   @Override
   public List<CommentExt> selectCommentExt() {
      return commentMapper.selectCommentExt();
   }

   @Override
   public List<CommentExt> selectCommentExtBytime(String time) {
      return commentMapper.selectCommentExtBytime(time);
   }

   @Override
   public List<CommentExt> selectCommentExtBytitle(String title) {
      return commentMapper.selectCommentExtBytitle(title);
   }

   @Override
   public List<CommentExt> selectCommentExtBykeyword(String keyword) {
      return commentMapper.selectCommentExtBykeyword(keyword);
   }


}
