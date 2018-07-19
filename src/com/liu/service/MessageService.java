package com.liu.service;

import com.liu.bean.po.Message;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface MessageService {
   public int addMessage(Message message);
   public List<Message> messageLists();
   public int deleteMessage(int id);
   public int batchDeleteMessages(List<Integer> ids);
   public List<Message> searchMessageBytime(String time);
   public List<Message> searchMessageByUsername(String username);
}
