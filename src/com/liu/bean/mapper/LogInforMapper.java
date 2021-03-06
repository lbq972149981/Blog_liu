package com.liu.bean.mapper;

import com.liu.bean.po.LogInfor;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface LogInforMapper {
   public int insertLogs(LogInfor logInfor);
   public List<LogInfor> selectLogs(RowBounds rowBounds);
   public List<LogInfor> selectLogs();
   public List<LogInfor> selectByDate(String date);
   public List<LogInfor> selectByDate(String date,RowBounds rowBounds);
   public int batchDeleteLogs(List<Integer> ids);
   public int deleteLog(int id);
}
