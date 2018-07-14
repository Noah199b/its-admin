package cn.edu.gsli.its.manage.service;

import java.util.Map;

import cn.edu.gsli.its.manage.entity.Notice;

public interface NoticeService {
	
	Map<String,Object> findObjects(
   		 String name,
   		 Integer valid,
   		 int pageCurrent);
	
	public void doSaveObject(Notice notice)throws Exception;
	
	public void doValidById(Integer checkedIds,Integer valid)throws Exception;
	
	public void doUpdateObject(Notice notice)throws Exception;
	
	public Notice doFindObjectById(int id);
}
