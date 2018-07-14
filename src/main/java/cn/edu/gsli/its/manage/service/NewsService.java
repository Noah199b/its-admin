package cn.edu.gsli.its.manage.service;

import java.util.Map;

import cn.edu.gsli.its.manage.entity.News;

public interface NewsService {
	public void doSaveNews(News news)throws Exception;
	
	public News getNewsById(Integer id);

	public void doUpdateNews(News news)throws Exception;

	public Map<String,Object> doGetObjects(String search,int pageNo);

	public void doDeleteNews(int id)throws Exception;
}
