package com.liu.bean.po;
//mid, musername, memail, mcontent, mTime
public class Message {
   private int mid;
   private String musername;
   private String memail;
   private String mcontent;

   public int getMid() {
      return mid;
   }

   public void setMid(int mid) {
      this.mid = mid;
   }

   public String getMusername() {
      return musername;
   }

   public void setMusername(String musername) {
      this.musername = musername;
   }

   public String getMemail() {
      return memail;
   }

   public void setMemail(String memail) {
      this.memail = memail;
   }

   public String getMcontent() {
      return mcontent;
   }

   public void setMcontent(String mcontent) {
      this.mcontent = mcontent;
   }

   public String getmTime() {
      return mTime;
   }

   public void setmTime(String mTime) {
      this.mTime = mTime;
   }

   private String mTime;
}
