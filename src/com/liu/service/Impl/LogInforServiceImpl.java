package com.liu.service.Impl;

import com.liu.bean.mapper.LogInforMapper;
import com.liu.bean.po.LogInfor;
import com.liu.service.LogInforService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;

@Component("logInforService")
public class LogInforServiceImpl implements LogInforService {
   @Resource
   private LogInforMapper logInforMapper;

   @Override
   public int insertLogs(LogInfor logInfor) {
      return logInforMapper.insertLogs(logInfor);
   }

   @Override
   public List<LogInfor> selectLogs(RowBounds rowBounds) {
      return logInforMapper.selectLogs(rowBounds);
   }

   @Override
   public List<LogInfor> selectByDate(String date) {
      return logInforMapper.selectByDate(date);
   }

   @Override
   public List<LogInfor> selectByDate(String date, RowBounds rowBounds) {
      return logInforMapper.selectByDate(date,rowBounds);
   }

   @Override
   public List<LogInfor> selectLogs() {
      return logInforMapper.selectLogs();
   }

   @Override
   public int batchDeleteLogs(List<Integer> ids) {
      return logInforMapper.batchDeleteLogs(ids);
   }

   @Override
   public int deleteLog(int id) {
      return logInforMapper.deleteLog(id);
   }
}
