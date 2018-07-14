package cn.edu.gsli.its.system.service;

import java.util.List;
import java.util.Map;

import cn.edu.gsli.its.system.entity.SysMenu;

public interface SysMenuService {

	List<Map<String, Object>> findObjects();
	List<Map<String, Object>> findZtreeNodes();
	void saveObject(SysMenu entity);
	Map<String, Object> findMapById(Integer menuId);
	void updateObject(SysMenu entity);
	void deleteObject(Integer menuId);

}
