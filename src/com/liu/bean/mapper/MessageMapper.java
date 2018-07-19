package com.liu.bean.mapper;
import com.liu.bean.po.Message;

import java.util.List;

public interface MessageMapper {
   public int addMessage(Message message);
   public List<Message> messageLists();
   public int deleteMessage(int id);
   public int batchDeleteMessages(List<Integer> ids);
   public List<Message> searchMessageBytime(String time);
   public List<Message> searchMessageByUsername(String username);
}
