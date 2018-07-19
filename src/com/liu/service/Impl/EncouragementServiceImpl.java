package com.liu.service.Impl;

import com.liu.bean.mapper.EncouragementMapper;
import com.liu.bean.po.Encouragement;
import com.liu.service.EncouragementService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
@Component("EncouragementService")
public class EncouragementServiceImpl implements EncouragementService{
   @Resource
   private EncouragementMapper encouragementMapper;
   @Override
   public List<Encouragement> selectAllens() {
      return encouragementMapper.selectAllens();
   }

   @Override
   public int addEncouragement(Encouragement encouragement) {
      return encouragementMapper.addEncouragement(encouragement);
   }

   @Override
   public int editCollectFlag(Encouragement encouragement) {
      return encouragementMapper.editCollectFlag(encouragement);
   }

   @Override
   public int editShowFlag(Encouragement encouragement) {
      return encouragementMapper.editShowFlag(encouragement);
   }

   @Override
   public int deleteEncouragement(int id) {
      return encouragementMapper.deleteEncouragement(id);
   }

   @Override
   public Encouragement queryByid(int id) {
      return encouragementMapper.queryByid(id);
   }
   @Override
   public int editEncouragement(Encouragement encouragement) {
      return encouragementMapper.editEncouragement(encouragement);
   }

   @Override
   public int batchDeleteEncouragements(List<Integer> ids) {
      return encouragementMapper.batchDeleteEncouragements(ids);
   }

   @Override
   public int batchRecommendEncouragements(List<Integer> ids) {
      return encouragementMapper.batchRecommendEncouragements(ids);
   }

   @Override
   public int batchDeprecatedEncouragements(List<Integer> ids) {
      return encouragementMapper.batchDeprecatedEncouragements(ids);
   }

   @Override
   public List<Encouragement> searchByTitle(String enTitle) {
      return encouragementMapper.searchByTitle(enTitle);
   }
}
