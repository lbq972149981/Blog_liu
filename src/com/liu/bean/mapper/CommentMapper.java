package com.liu.bean.mapper;


import com.liu.bean.po.Comment;
import com.liu.bean.po.CommentExt;

import java.util.List;

public interface CommentMapper {
   public int addComment(Comment comment);
   public List<Comment> selectComment(int bid);
   public int deleteCommentByuserAndblog(int commentid);
   public int praiseblogComment(int commentid);
   public int unpraiseblogComment(int commentid);


   public List<CommentExt> selectCommentExt();
   public List<CommentExt> selectCommentExtBytime(String time);
   public List<CommentExt> selectCommentExtBytitle(String title);
   public List<CommentExt> selectCommentExtBykeyword(String keyword);
}
