package cn.edu.gsli.its.manage.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.gsli.its.common.web.JsonResult;
import cn.edu.gsli.its.manage.entity.News;
import cn.edu.gsli.its.manage.service.NewsService;

@RequestMapping("/news/")
@Controller
public class NewsController {
	@Resource
	NewsService newsService;
	@RequestMapping("listUI")
	public String listUI(){
		return "manage/news_list";
	}
	@RequestMapping("editUI")
	public String editUI(Integer id,HttpServletRequest request){
		request.getSession().setAttribute("its_news",id==null?null:newsService.getNewsById(id));
		return "manage/news_edit";
	}	
	@RequestMapping("doSaveNews")
	@ResponseBody
	public JsonResult doSaveNews(News news) throws Exception {
		newsService.doSaveNews(news);
		return new JsonResult();
	}
	@RequestMapping("doUpdateNews")
	@ResponseBody
	public JsonResult doUpdateNews(News news) throws Exception {
		newsService.doUpdateNews(news);
		return new JsonResult();
	}
	@RequestMapping("doGetObjects")
	@ResponseBody
	public JsonResult doGetObjects(String search,int pageNo) throws Exception {
		System.out.println(search);
		return new JsonResult(newsService.doGetObjects(search,pageNo));
	}
	@RequestMapping("doGetNewsContent")
	@ResponseBody
	public JsonResult doGetNewsContent(int id) throws Exception {
		News news=newsService.getNewsById(id);
		String content=new String(news.getContent());
		System.out.println(content);
		return new JsonResult(content);
	}
	@RequestMapping("doDeleteNews")
	@ResponseBody
	public JsonResult doDeleteNews(int id) throws Exception {
		newsService.doDeleteNews(id);
		return new JsonResult();
	}
}
