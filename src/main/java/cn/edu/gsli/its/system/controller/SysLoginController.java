package cn.edu.gsli.its.system.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.gsli.its.common.service.SysShiroService;
import cn.edu.gsli.its.common.web.JsonResult;

@Controller
public class SysLoginController {
	@Autowired
	private SysShiroService loginService;
	@RequestMapping("/loginUI")
	public String login(){
		return "login";
	}
	/**登录操作*/
	@RequestMapping("/login")
	@ResponseBody
	public JsonResult login(String username,String password){
		System.out.println(username+"/"+password);
	    loginService.login(username, password);
		return new JsonResult();
	}
}
