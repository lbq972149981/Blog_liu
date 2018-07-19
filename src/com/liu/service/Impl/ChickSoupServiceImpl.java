package com.liu.service.Impl;


import com.liu.bean.mapper.ChickSoupMapper;
import com.liu.bean.po.ChickSoup;
import com.liu.service.ChickSoupService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("ChickSoupService")
public class ChickSoupServiceImpl implements ChickSoupService {
   @Resource
   private ChickSoupMapper chickSoupMapper;
   @Override
   public List<ChickSoup> chickSoupLists() {
      return chickSoupMapper.chickSoupLists();
   }

   @Override
   public int addChickSoup(ChickSoup chickSoup) {
      return chickSoupMapper.addChickSoup(chickSoup);
   }

   @Override
   public int deleteChickSoup(int id) {
      return chickSoupMapper.deleteChickSoup(id);
   }

   @Override
   public ChickSoup selectByid(int id) {
      return chickSoupMapper.selectByid(id);
   }

   @Override
   public int editChickSoup(ChickSoup chickSoup) {
      return chickSoupMapper.editChickSoup(chickSoup);
   }

   @Override
   public int batchDeleteChickSoups(List<Integer> ids) {
      return chickSoupMapper.batchDeleteChickSoups(ids);
   }

   @Override
   public List<ChickSoup> searchChickSoupsBytitle(String title) {
      return chickSoupMapper.searchChickSoupsBytitle(title);
   }

   @Override
   public List<ChickSoup> searchChickSoupsBytime(String time) {
      return chickSoupMapper.searchChickSoupsBytime(time);
   }

   @Override
   public int editshowFlag(ChickSoup chickSoup) {
      return chickSoupMapper.editshowFlag(chickSoup);
   }

   @Override
   public List<ChickSoup> chickSoupListsSortbytime() {
      return chickSoupMapper.chickSoupListsSortbytime();
   }
}
