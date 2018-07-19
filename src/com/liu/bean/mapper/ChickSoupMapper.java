package com.liu.bean.mapper;


import com.liu.bean.po.ChickSoup;

import java.util.List;

public interface ChickSoupMapper {
   public List<ChickSoup> chickSoupLists();
   public int addChickSoup(ChickSoup chickSoup);
   public int deleteChickSoup(int id);
   public ChickSoup selectByid(int id);
   public int editChickSoup(ChickSoup chickSoup);
   public int batchDeleteChickSoups(List<Integer> ids);
   public List<ChickSoup> searchChickSoupsBytitle(String title);
   public List<ChickSoup> searchChickSoupsBytime(String time);
   public int editshowFlag(ChickSoup chickSoup);
   public List<ChickSoup> chickSoupListsSortbytime();
}
