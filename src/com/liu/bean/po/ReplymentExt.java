package com.liu.bean.po;

public class ReplymentExt {
   private int replyid;
   private int bid;
   private int userid;
   private int commentid;
   private String replyTime;
   private String replyContent;
   private int curruserid;
   private int praise;
   private int rreplyid;
   private User user;
   private Blog blog;
   private Comment comment;
   public Comment getComment() {
      return comment;
   }

   public void setComment(Comment comment) {
      this.comment = comment;
   }
   public int getReplyid() {
      return replyid;
   }

   public void setReplyid(int replyid) {
      this.replyid = replyid;
   }

   public int getBid() {
      return bid;
   }

   public void setBid(int bid) {
      this.bid = bid;
   }

   public int getUserid() {
      return userid;
   }

   public void setUserid(int userid) {
      this.userid = userid;
   }

   public String getReplyTime() {
      return replyTime;
   }

   public void setReplyTime(String replyTime) {
      this.replyTime = replyTime;
   }

   public String getReplyContent() {
      return replyContent;
   }

   public void setReplyContent(String replyContent) {
      this.replyContent = replyContent;
   }

   public int getCurruserid() {
      return curruserid;
   }

   public void setCurruserid(int curruserid) {
      this.curruserid = curruserid;
   }

   public int getPraise() {
      return praise;
   }

   public void setPraise(int praise) {
      this.praise = praise;
   }

   public int getRreplyid() {
      return rreplyid;
   }

   public void setRreplyid(int rreplyid) {
      this.rreplyid = rreplyid;
   }

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }

   public Blog getBlog() {
      return blog;
   }

   public void setBlog(Blog blog) {
      this.blog = blog;
   }

   public int getCommentid() {
      return commentid;
   }

   public void setCommentid(int commentid) {
      this.commentid = commentid;
   }
}
