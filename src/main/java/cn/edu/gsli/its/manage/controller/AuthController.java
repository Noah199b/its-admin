package cn.edu.gsli.its.manage.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.gsli.its.common.web.JsonResult;
import cn.edu.gsli.its.manage.entity.Auth;
import cn.edu.gsli.its.manage.service.AuthService;

@RequestMapping("/auth/")
@Controller
public class AuthController {
	@Resource
	AuthService authService;
	@RequestMapping("listUI")
	public String listUI(){
		return "manage/auth_list";
	}
	@RequestMapping("editUI")
	public String editUI(int id,HttpServletRequest request){
		Auth auth=authService.getAuthObject(id);
		request.getSession().setAttribute("authInfo", auth);
		return "manage/auth_edit";
	}
	@RequestMapping("doGetObjects")
	@ResponseBody
	public JsonResult getAuthObjects(int pageNo,Integer state) {		
		return new JsonResult(authService.getAuthObjects(pageNo,state));
	}
	@RequestMapping("dueWithAuth")
	@ResponseBody
	public JsonResult dueWithAuth(int id,int state,String opinion)throws Exception {
		authService.dueWithAuth(id,state,opinion);
		return new JsonResult();
	}
}
