package cn.edu.gsli.its.manage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.gsli.its.common.exception.ServiceException;
import cn.edu.gsli.its.common.web.PageObject;
import cn.edu.gsli.its.manage.dao.ReportDao;
import cn.edu.gsli.its.manage.entity.Report;
import cn.edu.gsli.its.manage.service.ReportService;
@Service
public class ReportServiceImpl implements ReportService {
	@Resource
	ReportDao reportDao;
	@Override
	public Map<String, Object> doGetObjects(Integer type,Integer state,int pageNo) {
		PageObject page=new PageObject();
		page.setPageCurrent(pageNo);
		page.setPageSize(5);
		int count=reportDao.findReportsCount(type,state);
		page.setRowCount(count);
		page.setStartIndex(page.getPageSize()*(pageNo-1));
		List<Report> report=reportDao.findReports(type,state, page.getStartIndex(), page.getPageSize());
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("page", page);
		map.put("pageCount", page.getPageCount());
		map.put("report",report);
		return map;
	}
	@Override
	public Report doGetObject(int id) {
		return reportDao.findById(id);
	}
	@Override
	public void dueWithReport(int id, int dueType, String opinion) throws Exception{
		if("".equals(opinion))throw new ServiceException("处理意见不能为空！");
		if(dueType==4) {
			reportDao.updateState(id, 0, null);
		}else {
			Report report=reportDao.findById(id);
			if(report.getType()==0) {//用户禁用
				reportDao.updateUserValid(report.getReportId());
			}else if(report.getType()==1){//话题删除
				reportDao.deleteArticle(report.getReportId());
			}else {//资源删除
				reportDao.deleteResource(report.getReportId());
			}
			reportDao.updateState(id, 1, opinion);
		}		
	}
}
