package com.liu.bean.mapper;

import com.liu.bean.po.User;

import java.util.List;

public interface UserMapper {
   public int updateUser(User user);
   public List<User> selectUsers();
   public int alterpwd(User user);
   public int insertUser(User user);
   public List<User> searchregisterDateCount(String date);
   public List<User> selectByrole(String role);
   public int updateSilenceFlag(int id);
   public int deleteUser(int id);
   public int batchDeleteUsers(List<Integer> ids);
   public int batchSilenceUsers(List<Integer> ids);
   public int RemoveSilenceUser(int id);

   public List<User> searchUsersByregisterDate(String registerDate);
   public List<User> searchUsersBySex(String sex);

   public int updateloginFlag(User user);
   public User selectByid(int id);

   public List<String> selectnicknameByids(List<Integer> ids);
}
