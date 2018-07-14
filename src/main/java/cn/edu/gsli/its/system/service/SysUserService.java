package cn.edu.gsli.its.system.service;

import java.util.List;
import java.util.Map;

import cn.edu.gsli.its.system.entity.SysUser;

public interface SysUserService {
	
	Map<String, Object> findPageObjects(String username, 
			Integer currentPage);
	void saveObject(SysUser user,String roleIds);
	Map<String,Object> findUserById(Integer userId);
	void updateObject(SysUser user,String roleIds);
	void validById(Integer userId, Integer valid);
	List<String> findUserPermissions(Integer userId);
	List<Map<String,Object>> findUserMenus(Integer userId);
	List<Map<String, Object>> findSysRoles();
	
	

}
