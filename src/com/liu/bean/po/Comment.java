package com.liu.bean.po;
//commentid, bid, userid, commentContent, commentTime
public class Comment {
   private Integer commentid;
   private Integer bid;
   private Integer userid;
   private String commentContent;
   private String commentTime;
   private Integer praise;
   public Integer getCommentid() {
      return commentid;
   }

   public void setCommentid(Integer commentid) {
      this.commentid = commentid;
   }

   public Integer getBid() {
      return bid;
   }

   public void setBid(Integer bid) {
      this.bid = bid;
   }

   public Integer getUserid() {
      return userid;
   }

   public void setUserid(Integer userid) {
      this.userid = userid;
   }

   public String getCommentContent() {
      return commentContent;
   }

   public void setCommentContent(String commentContent) {
      this.commentContent = commentContent;
   }

   public String getCommentTime() {
      return commentTime;
   }

   public void setCommentTime(String commentTime) {
      this.commentTime = commentTime;
   }

   public Integer getPraise() {
      return praise;
   }

   public void setPraise(Integer praise) {
      this.praise = praise;
   }
}
