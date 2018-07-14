package cn.edu.gsli.its.manage.service;

import java.util.Map;

import cn.edu.gsli.its.manage.entity.Report;

public interface ReportService {
	public Map<String,Object> doGetObjects(Integer type,Integer state,int pageNo);
	
	public Report doGetObject(int id);

	public void dueWithReport(int id, int dueType, String opinion)throws Exception;
	
}
