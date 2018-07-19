package com.liu.bean.mapper;

import com.liu.bean.po.Blog;

import java.util.List;

public interface BlogMapper {
   public List<Blog> BlogLists();
   public int addBlog(Blog blog);
   public int batchDeleteBlogs(List<Integer> ids);
   public int deleteBlog(int id);
   public Blog selectByid(int id);
   public int editBlog(Blog blog);
   public int batchRecommendBlogs(List<Integer> ids);
   public int batchDeprecatedBlogs(List<Integer> ids);
   public int updateShowFlag(Blog blog);
   public List<Blog> searchBlogsByTime(String time);
   public List<Blog> searchBlogsBykey(String key);
   public List<Blog> searchBlogBytitle(String title);
   public List<Blog> selectBlogsByrecommend();
   public int updateReadamount(Blog blog);
}
