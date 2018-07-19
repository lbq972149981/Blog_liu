package com.liu.bean.po;
//replyid, bid, userid, replyContent, replyTime
public class Reply {
   private int replyid;
   private int bid;
   private int userid;
   private String replyContent;
   private String replyTime;
   private Integer curruserid;
   private Integer commentid;
   private Integer praise;
   private Integer rreplyid;
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

   public String getReplyContent() {
      return replyContent;
   }

   public void setReplyContent(String replyContent) {
      this.replyContent = replyContent;
   }

   public String getReplyTime() {
      return replyTime;
   }

   public void setReplyTime(String replyTime) {
      this.replyTime = replyTime;
   }

   public Integer getCurruserid() {
      return curruserid;
   }

   public void setCurruserid(Integer curruserid) {
      this.curruserid = curruserid;
   }

   public Integer getCommentid() {
      return commentid;
   }

   public void setCommentid(Integer commentid) {
      this.commentid = commentid;
   }

   public Integer getPraise() {
      return praise;
   }

   public void setPraise(Integer praise) {
      this.praise = praise;
   }

   public Integer getRreplyid() {
      return rreplyid;
   }

   public void setRreplyid(Integer rreplyid) {
      this.rreplyid = rreplyid;
   }
}
