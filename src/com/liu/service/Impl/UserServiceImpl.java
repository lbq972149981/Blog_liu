package com.liu.service.Impl;
import com.liu.bean.mapper.UserMapper;
import com.liu.bean.po.User;
import com.liu.service.UserService;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;
@Component("userService")
public class UserServiceImpl implements UserService{
   @Resource
   private UserMapper userMapper;

   @Override
   public int updateUser(User user) {
      return userMapper.updateUser(user);
   }

   @Override
   public List<User> selectUsers() {
      return userMapper.selectUsers();
   }

   @Override
   public int alterpwd(User user) {
      return userMapper.alterpwd(user);
   }

   @Override
   public int insertUser(User user) {
      return userMapper.insertUser(user);
   }

   @Override
   public List<User> searchregisterDateCount(String date) {
      return userMapper.searchregisterDateCount(date);
   }

   @Override
   public List<User> selectByrole(String role) {
      return userMapper.selectByrole(role);
   }

   @Override
   public int updateSilenceFlag(int id) {
      return userMapper.updateSilenceFlag(id);
   }

   @Override
   public int deleteUser(int id) {
      return userMapper.deleteUser(id);
   }

   @Override
   public int batchDeleteUsers(List<Integer> ids) {
      return userMapper.batchDeleteUsers(ids);
   }

   @Override
   public int batchSilenceUsers(List<Integer> ids) {
      return userMapper.batchSilenceUsers(ids);
   }

   @Override
   public int RemoveSilenceUser(int id) {
      return userMapper.RemoveSilenceUser(id);
   }

   @Override
   public List<User> searchUsersByregisterDate(String registerDate) {
      return userMapper.searchUsersByregisterDate(registerDate);
   }

   @Override
   public List<User> searchUsersBySex(String sex) {
      return userMapper.searchUsersBySex(sex);
   }

   @Override
   public int updateloginFlag(User user) {
      return userMapper.updateloginFlag(user);
   }

   @Override
   public User selectByid(int id) {
      return userMapper.selectByid(id);
   }

   @Override
   public List<String> selectnicknameByids(List<Integer> ids) {
      return userMapper.selectnicknameByids(ids);
   }
}
