package cn.edu.gsli.its.manage.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.gsli.its.common.web.JsonResult;
import cn.edu.gsli.its.manage.entity.Notice;
import cn.edu.gsli.its.manage.service.NoticeService;
@RequestMapping("/notice/")
@Controller
public class NoticeController {
	@Resource
	NoticeService noticeService;
	@RequestMapping("listUI")
	public String listUI(){
		return "manage/notice_list";
	}
	@RequestMapping("editUI")
	public String editUI(){
		return "manage/notice_edit";
	}	
	@RequestMapping("doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects(String name,
			Integer valid,
			int pageCurrent) {
		System.out.println(name+","+valid);
		return new JsonResult(noticeService.findObjects(name, valid, pageCurrent));
	}	
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(Notice notice) throws Exception {
		noticeService.doSaveObject(notice);
		return new JsonResult();
	}	
	@RequestMapping("doValidById")
	@ResponseBody
	public JsonResult doValidById(Integer checkedIds,Integer valid) throws Exception {
		noticeService.doValidById(checkedIds, valid);
		return new JsonResult();
	}	
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(Notice notice) throws Exception {
		noticeService.doUpdateObject(notice);
		return new JsonResult();
	}	
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(int id) throws Exception {	
		return new JsonResult(noticeService.doFindObjectById(id));
	}	
}
