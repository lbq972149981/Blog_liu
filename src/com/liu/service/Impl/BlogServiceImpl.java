package com.liu.service.Impl;

import com.liu.bean.mapper.BlogMapper;
import com.liu.bean.po.Blog;
import com.liu.service.BlogService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
@Component("BlogService")
public class BlogServiceImpl implements BlogService{
   @Resource
   private BlogMapper blogMapper;
   @Override
   public List<Blog> BlogLists() {
      return blogMapper.BlogLists();
   }

   @Override
   public int addBlog(Blog blog) {
      return blogMapper.addBlog(blog);
   }

   @Override
   public int batchDeleteBlogs(List<Integer> ids) {
      return blogMapper.batchDeleteBlogs(ids);
   }

   @Override
   public int deleteBlog(int id) {
      return blogMapper.deleteBlog(id);
   }

   @Override
   public Blog selectByid(int id) {
      return blogMapper.selectByid(id);
   }

   @Override
   public int editBlog(Blog blog) {
      return blogMapper.editBlog(blog);
   }

   @Override
   public int batchRecommendBlogs(List<Integer> ids) {
      return blogMapper.batchRecommendBlogs(ids);
   }

   @Override
   public int batchDeprecatedBlogs(List<Integer> ids) {
      return blogMapper.batchDeprecatedBlogs(ids);
   }

   @Override
   public int updateShowFlag(Blog blog) {
      return blogMapper.updateShowFlag(blog);
   }

   @Override
   public List<Blog> searchBlogsByTime(String time) {
      return blogMapper.searchBlogsByTime(time);
   }

   @Override
   public List<Blog> searchBlogsBykey(String key) {
      return blogMapper.searchBlogsBykey(key);
   }

   @Override
   public List<Blog> searchBlogBytitle(String title) {
      return blogMapper.searchBlogBytitle(title);
   }

   @Override
   public List<Blog> selectBlogsByrecommend() {
      return blogMapper.selectBlogsByrecommend();
   }

   @Override
   public int updateReadamount(Blog blog) {
      return blogMapper.updateReadamount(blog);
   }
}
