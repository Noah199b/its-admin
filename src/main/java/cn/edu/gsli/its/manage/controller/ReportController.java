package cn.edu.gsli.its.manage.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.gsli.its.common.web.JsonResult;
import cn.edu.gsli.its.manage.service.ReportService;

@RequestMapping("/report/")
@Controller
public class ReportController {
	@Resource
	ReportService reportService;
	@RequestMapping("listUI")
	public String listUI(){
		return "manage/report_list";
	}
	@RequestMapping("editUI")
	public String editUI(int id,HttpServletRequest request){
		request.getSession().setAttribute("its_report", reportService.doGetObject(id));
		return "manage/report_edit";
	}
	@RequestMapping("doGetObjects")
	@ResponseBody
	public JsonResult doGetObjects(Integer type,Integer state,int pageNo) {		
		return new JsonResult(reportService.doGetObjects(type, state, pageNo));
	}
	@RequestMapping("dueWithReport")
	@ResponseBody
	public JsonResult dueWithReport(int id,int dueType,String opinion)throws Exception {
		reportService.dueWithReport(id,dueType,opinion);
		return new JsonResult();
	}
}
