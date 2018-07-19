package com.liu.bean.po;
//cid, ctitle, cContent, cIssuer, cTime, cshowFlag, chicksoupcol
public class ChickSoup {
   private int cid;
   private String ctitle;
   private String cContent;
   private String cIssuer;
   private String cTime;
   private String cshowFlag;



   public String getCtitle() {
      return ctitle;
   }

   public void setCtitle(String ctitle) {
      this.ctitle = ctitle;
   }

   public String getcContent() {
      return cContent;
   }

   public void setcContent(String cContent) {
      this.cContent = cContent;
   }

   public String getcIssuer() {
      return cIssuer;
   }

   public void setcIssuer(String cIssuer) {
      this.cIssuer = cIssuer;
   }

   public String getcTime() {
      return cTime;
   }

   public void setcTime(String cTime) {
      this.cTime = cTime;
   }

   public String getCshowFlag() {
      return cshowFlag;
   }

   public void setCshowFlag(String cshowFlag) {
      this.cshowFlag = cshowFlag;
   }

   public int getCid() {
      return cid;
   }

   public void setCid(int cid) {
      this.cid = cid;
   }
}
