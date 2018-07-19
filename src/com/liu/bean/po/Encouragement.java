package com.liu.bean.po;
public class Encouragement {
   private int id;
   private String enTitle;
   private String enContent;
   private String enTime;
   private String showFlag;
   private String enIssuer;
   private String collectFlag;
   private String recommendFlag;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getEnTitle() {
      return enTitle;
   }

   public void setEnTitle(String enTitle) {
      this.enTitle = enTitle;
   }

   public String getEnContent() {
      return enContent;
   }

   public void setEnContent(String enContent) {
      this.enContent = enContent;
   }

   public String getEnTime() {
      return enTime;
   }

   public void setEnTime(String enTime) {
      this.enTime = enTime;
   }

   public String getShowFlag() {
      return showFlag;
   }

   public void setShowFlag(String showFlag) {
      this.showFlag = showFlag;
   }

   public String getEnIssuer() {
      return enIssuer;
   }

   public void setEnIssuer(String enIssuer) {
      this.enIssuer = enIssuer;
   }

   public String getCollectFlag() {
      return collectFlag;
   }

   public void setCollectFlag(String collectFlag) {
      this.collectFlag = collectFlag;
   }

   public String getRecommendFlag() {
      return recommendFlag;
   }

   public void setRecommendFlag(String recommendFlag) {
      this.recommendFlag = recommendFlag;
   }
}
