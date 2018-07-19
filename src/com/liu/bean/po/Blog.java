package com.liu.bean.po;
//bid, btitle, bshowFlag, brecommendFlag, bkeyword, bIssuer, bTime, bsummary, bcontent, readamount
public class Blog {
   private int bid;
   private int readamount;
   private String btitle;
   private String bshowFlag;
   private String brecommendFlag;
   private String bkeyword;
   private String bIssuer;
   private String bTime;
   private String bsummary;
   private String bcontent;
   private int praiseamount;

   public int getBid() {
      return bid;
   }

   public void setBid(int bid) {
      this.bid = bid;
   }

   public int getReadamount() {
      return readamount;
   }

   public void setReadamount(int readamount) {
      this.readamount = readamount;
   }

   public String getBtitle() {
      return btitle;
   }

   public void setBtitle(String btitle) {
      this.btitle = btitle;
   }

   public String getBshowFlag() {
      return bshowFlag;
   }

   public void setBshowFlag(String bshowFlag) {
      this.bshowFlag = bshowFlag;
   }

   public String getBrecommendFlag() {
      return brecommendFlag;
   }

   public void setBrecommendFlag(String brecommendFlag) {
      this.brecommendFlag = brecommendFlag;
   }

   public String getBkeyword() {
      return bkeyword;
   }

   public void setBkeyword(String bkeyword) {
      this.bkeyword = bkeyword;
   }

   public String getbIssuer() {
      return bIssuer;
   }

   public void setbIssuer(String bIssuer) {
      this.bIssuer = bIssuer;
   }

   public String getbTime() {
      return bTime;
   }

   public void setbTime(String bTime) {
      this.bTime = bTime;
   }

   public String getBsummary() {
      return bsummary;
   }

   public void setBsummary(String bsummary) {
      this.bsummary = bsummary;
   }

   public String getBcontent() {
      return bcontent;
   }

   public void setBcontent(String bcontent) {
      this.bcontent = bcontent;
   }

   public int getPraiseamount() {
      return praiseamount;
   }

   public void setPraiseamount(int praiseamount) {
      this.praiseamount = praiseamount;
   }
}
