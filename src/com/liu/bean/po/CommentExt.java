package com.liu.bean.po;

public class CommentExt {
   private int commentid;
   private int bid;
   private int userid;
   private String commentTime;
   private String commentContent;
   private int praise;
   private User user;
   private Blog blog;

   public int getCommentid() {
      return commentid;
   }

   public void setCommentid(int commentid) {
      this.commentid = commentid;
   }

   public String getCommentTime() {
      return commentTime;
   }

   public void setCommentTime(String commentTime) {
      this.commentTime = commentTime;
   }

   public String getCommentContent() {
      return commentContent;
   }

   public void setCommentContent(String commentContent) {
      this.commentContent = commentContent;
   }

   public int getPraise() {
      return praise;
   }

   public void setPraise(int praise) {
      this.praise = praise;
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

   public int getUserid() {
      return userid;
   }

   public void setUserid(int userid) {
      this.userid = userid;
   }

   public int getBid() {
      return bid;
   }

   public void setBid(int bid) {
      this.bid = bid;
   }
}
