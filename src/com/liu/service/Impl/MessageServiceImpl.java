package com.liu.service.Impl;


import com.liu.bean.mapper.MessageMapper;
import com.liu.bean.po.Message;
import com.liu.service.MessageService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("MessageService")
public class MessageServiceImpl implements MessageService {
   @Resource
   private MessageMapper messageMapper;

   @Override
   public int addMessage(Message message) {
      return messageMapper.addMessage(message);
   }

   @Override
   public List<Message> messageLists() {
      return messageMapper.messageLists();
   }

   @Override
   public int deleteMessage(int id) {
      return messageMapper.deleteMessage(id);
   }

   @Override
   public int batchDeleteMessages(List<Integer> ids) {
      return messageMapper.batchDeleteMessages(ids);
   }

   @Override
   public List<Message> searchMessageBytime(String time) {
      return messageMapper.searchMessageBytime(time);
   }

   @Override
   public List<Message> searchMessageByUsername(String username) {
      return messageMapper.searchMessageByUsername(username);
   }
}
