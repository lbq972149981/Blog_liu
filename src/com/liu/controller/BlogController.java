package com.liu.controller;

import com.liu.bean.po.Blog;
import com.liu.bean.po.ChickSoup;
import com.liu.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/template")
public class BlogController {
   @Resource
   private BlogService blogService;

   /**
    * 添加一篇博文
    * @param blog
    * @param model
    * @return
    */
   @RequestMapping("/addBlog.do")
   public String addBlog(Blog blog, Model model){
      System.out.println(blog.getBrecommendFlag());
      System.out.println(blog.getBshowFlag());
      if("null".equals(blog.getBrecommendFlag())||null==blog.getBrecommendFlag()){
         blog.setBrecommendFlag("off");
      }
      if("null".equals(blog.getBshowFlag())||null==blog.getBshowFlag()){
         blog.setBshowFlag("off");
      }
      System.out.println(blog.getBrecommendFlag());
      System.out.println(blog.getBshowFlag());
      blogService.addBlog(blog);
      List<Blog> blogList = blogService.BlogLists();
      model.addAttribute("blogList",blogList);
      return "back_Blog";
   }

   /**
    * 显示博文列表
    * @param model
    * @return
    */
   @RequestMapping("/BlogLists.do")
   public String BlogLists(Model model){
      List<Blog> blogList = blogService.BlogLists();
      if(blogList!=null)
         model.addAttribute("blogList",blogList);
      return "back_Blog";
   }

   /**
    * 查找博文
    * @param searchText
    * @param model
    * @return
    */
   @RequestMapping("/searchBlogs.do")
   public String searchBlogs(String searchText,Model model){
      boolean flag = true;
      boolean titleflag = true;
      List<Blog> blogList = null;
      for(char c :searchText.toCharArray()){
         if((c>='0'&&c<='9')||c=='-'||c==' '||c==':'){
            flag = true;
         }else {
            flag=false;
            break;
         }
      }
      for(int i=0;i<searchText.length();i++){
         if(searchText.charAt(i)>'a'&&searchText.charAt(i)<'z'||searchText.charAt(i)>'A'&&searchText.charAt(i)<'Z'){
            titleflag = true;
         }else {
            titleflag = false;
            break;
         }
      }
      System.out.println(titleflag);
      if(flag){
         blogList = blogService.searchBlogsByTime(searchText);
      }else if (titleflag){
         blogList = blogService.searchBlogsBykey(searchText.toLowerCase());
      }else {
         blogList = blogService.searchBlogBytitle(searchText);
      }
      model.addAttribute("blogList",blogList);
      return "back_Blog";
   }

   /**
    * 删除博文
    * @param model
    * @param bid
    * @return
    */
   @RequestMapping("/deleteBlog.do")
   public String deleteBlog(Model model,String bid){
      blogService.deleteBlog(Integer.parseInt(bid));
      List<Blog> blogList = blogService.BlogLists();
      if(blogList!=null)
         model.addAttribute("blogList",blogList);
      return "back_Blog";
   }

   /**
    * 展示博文
    * @param bid
    * @param model
    * @param bshowFlag
    * @return
    */
   @RequestMapping("/showBlog.do")
   public String showBlog(String bid,Model model,String bshowFlag){
      Blog blog = new Blog();
      blog.setBid(Integer.parseInt(bid));
      blog.setBshowFlag(bshowFlag);
      blogService.updateShowFlag(blog);
      List<Blog> blogList = blogService.BlogLists();
      if(blogList!=null)
         model.addAttribute("blogList",blogList);
      return "back_Blog";
   }

   /**
    * 跳转到编辑页面
    * @param bid
    * @param model
    * @return
    */
   @RequestMapping("/editBlogJump.do")
   public String editBlogJump(String bid,Model model){
      Blog blog = blogService.selectByid(Integer.parseInt(bid));
      model.addAttribute("blog",blog);
      return "back_EditBlog";
   }

   /**
    * 修改博文
    * @param blog
    * @param model
    * @return
    */
   @RequestMapping("/editBlog.do")
   public String editBlog(Blog blog,Model model,String brecommendFlag){
      System.out.println(brecommendFlag);
      System.out.println(blog.getBrecommendFlag());
      System.out.println(blog.getBshowFlag());
      if("null".equals(blog.getBrecommendFlag())||null==blog.getBrecommendFlag()){
         blog.setBrecommendFlag("off");
      }
      if("null".equals(blog.getBshowFlag())||null==blog.getBshowFlag()){
         blog.setBshowFlag("off");
      }
      System.out.println(blog.getBrecommendFlag());
      System.out.println(blog.getBshowFlag());
      blogService.editBlog(blog);
      List<Blog> blogList = blogService.BlogLists();
      if(blogList!=null)
         model.addAttribute("blogList",blogList);
      return "back_Blog";
   }

   /**
    * 批量删除博文
    * @param delitems
    * @param model
    * @return
    */
   @RequestMapping("/batchDeletesBlogs.do")
   public String batchDeletesBlogs(String delitems,Model model){
      String[] strs = delitems.split(",");
      List<Integer> ids = new ArrayList<>();
      for(String id:strs){
         ids.add(Integer.parseInt(id));
      }
      blogService.batchDeleteBlogs(ids);
      List<Blog> blogList = blogService.BlogLists();
      if(blogList!=null)
         model.addAttribute("blogList",blogList);
      return "back_Blog";
   }

   /**
    * 批量推荐博文
    * @param delitems
    * @param model
    * @return
    */
   @RequestMapping("/batchRecommendsBlogs.do")
   public String batchRecommendsBlogs(String delitems,Model model){
      String[] strs = delitems.split(",");
      List<Integer> ids = new ArrayList<>();
      for(String id:strs){
         ids.add(Integer.parseInt(id));
      }
      blogService.batchRecommendBlogs(ids);
      List<Blog> blogList = blogService.BlogLists();
      if(blogList!=null)
         model.addAttribute("blogList",blogList);
      return "back_Blog";
   }

   /**
    * 批量取消推荐博文
    * @param delitems
    * @param model
    * @return
    */
   @RequestMapping("/batchDeprecatedsBlogs.do")
   public String batchDeprecatedsBlogs(String delitems,Model model){
      String[] strs = delitems.split(",");
      List<Integer> ids = new ArrayList<>();
      for(String id:strs){
         ids.add(Integer.parseInt(id));
      }
      blogService.batchDeprecatedBlogs(ids);
      List<Blog> blogList = blogService.BlogLists();
      if(blogList!=null)
         model.addAttribute("blogList",blogList);
      return "back_Blog";
   }

   /**
    * 显示推荐博文信息
    * @return
    */
   @RequestMapping("/recommendBlogs.do")
   public @ResponseBody List<Blog> recommendBlogs(){
      return blogService.selectBlogsByrecommend();
   }
}
