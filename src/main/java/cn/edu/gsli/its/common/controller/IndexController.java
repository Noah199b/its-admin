package cn.edu.gsli.its.common.controller;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.gsli.its.common.web.JsonResult;
import cn.edu.gsli.its.system.entity.SysUser;
import cn.edu.gsli.its.system.service.SysUserService;

@Controller
public class IndexController {
	@Autowired
	private SysUserService userService;
	@RequestMapping("/indexUI.do")
	public String indexUI(){
		System.out.println("indexUI");
		//返回的字符串会对应一�?/WEB-INF/pages/index.jsp页面
		return "index";
	}
	@RequestMapping("doFindUserMenus.do")
	@ResponseBody
	public JsonResult doFindUserMenus() {
		SysUser user = (SysUser) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		return new JsonResult(userService.findUserMenus(user.getId()));
	}
}
