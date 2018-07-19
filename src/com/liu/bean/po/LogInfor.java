package com.liu.bean.po;
public class LogInfor {
   private Integer id;
   private String username;
   private String operateTime;
   private String operateIp;
   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getOperateTime() {
      return operateTime;
   }

   public void setOperateTime(String operateTime) {
      this.operateTime = operateTime;
   }

   public String getOperateIp() {
      return operateIp;
   }

   public void setOperateIp(String operateIp) {
      this.operateIp = operateIp;
   }
}
