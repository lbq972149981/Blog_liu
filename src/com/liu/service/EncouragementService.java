package com.liu.service;

import com.liu.bean.po.Encouragement;

import java.util.List;

public interface EncouragementService {
   public List<Encouragement> selectAllens();
   public int addEncouragement(Encouragement encouragement);
   public int editCollectFlag(Encouragement encouragement);
   public int editShowFlag(Encouragement encouragement);
   public int deleteEncouragement(int id);
   public Encouragement queryByid(int id);
   public int editEncouragement(Encouragement encouragement);
   public int batchDeleteEncouragements(List<Integer> ids);
   public int batchRecommendEncouragements(List<Integer> ids);
   public int batchDeprecatedEncouragements(List<Integer> ids);
   public List<Encouragement> searchByTitle(String enTitle);
}
