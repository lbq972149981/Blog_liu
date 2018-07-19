package com.liu.controller;

import com.liu.bean.po.Blog;
import com.liu.bean.po.Message;
import com.liu.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/template")
public class MessageController {
   @Resource
   private MessageService messageService;

   /**
    * 显示留言列表
    * @param model
    * @return
    */
   @RequestMapping("/messageLists.do")
   public String messageList(Model model){
      List<Message> messageList = messageService.messageLists();
      model.addAttribute("messageList",messageList);
      return "back_messageManage";
   }

   /**
    * 添加留言
    * @param message
    * @return
    */
   @RequestMapping("/addMessage.do")
   public String addMessage(Message message){
      SimpleDateFormat timeformat=new SimpleDateFormat("yyyy-MM-dd hh:mm");
      String date = timeformat.format(System.currentTimeMillis());
      message.setmTime(date);
      messageService.addMessage(message);
      return "pre_contact";
   }

   /**
    * 删除单个留言
    * @param model
    * @param id
    * @return
    */
   @RequestMapping("/deleteMessage.do")
   public String deleteMessage(Model model,String id){
      messageService.deleteMessage(Integer.parseInt(id));
      List<Message> messageList = messageService.messageLists();
      model.addAttribute("messageList",messageList);
      return "back_messageManage";
   }

   /**
    * 通过时间和用户名查询留言
    * @param searchText
    * @param model
    * @return
    */
   @RequestMapping("/searchMessages.do")
   public String searchMessages(String searchText,Model model){
      boolean flag = true;
      List<Message> messageList = null;
      for(char c :searchText.toCharArray()){
         if((c>='0'&&c<='9')||c=='-'||c==' '||c==':'){
            flag = true;
         }else {
            flag=false;
            break;
         }
      }
      if(flag){
         messageList = messageService.searchMessageBytime(searchText);
      }else {
         messageList = messageService.searchMessageByUsername(searchText);
      }
      model.addAttribute("messageList",messageList);
      return "back_messageManage";
   }

   /**
    * 批量删除留言
    * @param delitems
    * @param model
    * @return
    */
   @RequestMapping("/batchDeletesMessages.do")
   public String batchDeletesMessages(String delitems,Model model){
      String[] strs = delitems.split(",");
      List<Integer> ids = new ArrayList<>();
      for(String id:strs){
         ids.add(Integer.parseInt(id));
      }
      messageService.batchDeleteMessages(ids);
      List<Message> messageList = messageService.messageLists();
      model.addAttribute("messageList",messageList);
      return "back_messageManage";
   }
}
