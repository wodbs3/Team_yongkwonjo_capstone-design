package com.bu.bumoim.dao;

import java.util.List;

import com.bu.bumoim.domain.GroupList;

public interface GroupDao {

   List<GroupList> selectGroupList(GroupList grouplist);
   public int insertGroup(GroupList grouplist);
   
   public GroupList groupDuplicationCheck(String grouplist_name);
   
   public GroupList findGroupDetail(int grouplist_number); // 그룹 정보 찾기
}