package cn.edu.gsli.its.manage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import cn.edu.gsli.its.common.exception.ServiceException;
import cn.edu.gsli.its.common.web.PageObject;
import cn.edu.gsli.its.manage.dao.NewsDao;
import cn.edu.gsli.its.manage.entity.News;
import cn.edu.gsli.its.manage.service.NewsService;
import cn.edu.gsli.its.system.entity.SysUser;
@Service
public class NewsServiceImpl implements NewsService {
	@Resource
	NewsDao newsDao;
	SysUser user = (SysUser) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
	@Override
	public void doSaveNews(News news) throws Exception{
		if(news.getTitle().length()<10 || news.getTitle().length()>50)
			throw new ServiceException("标题长度为10-50字，请检查后重试！");
		if(news.getSubTitle().length()<10 || news.getSubTitle().length()>50)
			throw new ServiceException("副标题长度为10-50字，请检查后重试！");
		news.setCreatedUser(user.getUsername());
		news.setModifiedUser(user.getUsername());
		if(news.getType()==0) {
			news.setLink("");
		}else{
			news.setContent("<p></p>".getBytes());
		}
		int n=newsDao.save(news);
		if(n==0)throw new ServiceException("保存失败，请稍后重试！");
	}
	@Override
	public News getNewsById(Integer id) {
		return newsDao.findById(id);	
	}
	@Override
	public void doUpdateNews(News news) throws Exception {
		if(news.getTitle().length()<10 || news.getTitle().length()>50)
			throw new ServiceException("标题长度为10-50字，请检查后重试！");
		if(news.getSubTitle().length()<10 || news.getSubTitle().length()>50)
			throw new ServiceException("副标题长度为10-50字，请检查后重试！");
		news.setModifiedUser(user.getUsername());
		if(news.getType()==0) {
			news.setLink("");
		}else{
			news.setContent("<p></p>".getBytes());
		}
		int n=newsDao.update(news);
		if(n==0)throw new ServiceException("保存失败，请稍后重试！");
	}
	@Override
	public Map<String, Object> doGetObjects(String search, int pageNo) {
		int count=newsDao.searchCount(search);
		PageObject page=new PageObject();
		page.setPageCurrent(pageNo);
		page.setPageSize(5);
		page.setRowCount(count);
		page.setStartIndex((pageNo-1)*page.getPageSize());
		List<News> list	=newsDao.search(search, page.getStartIndex(), page.getPageSize());
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("pageCount", page.getPageCount());
		map.put("page", page);
		map.put("news", list);
		return map;
	}
	@Override
	public void doDeleteNews(int id) throws Exception {
		int n=newsDao.delete(id);
		if(n==0)throw new ServiceException("删除失败，请稍后重试！");		
	}
}
