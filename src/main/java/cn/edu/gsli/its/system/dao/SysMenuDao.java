package cn.edu.gsli.its.system.dao;

import java.util.List;
import java.util.Map;

import cn.edu.gsli.its.common.dao.BaseDao;
import cn.edu.gsli.its.system.entity.SysMenu;


public interface SysMenuDao extends BaseDao<SysMenu> {

	List<Map<String,Object>> findObjects();
	int getRowCount();
	List<Map<String, Object>> findZtreeNodes();
	int hasChild(Integer menuId);
	Map<String,Object> findMapById(Integer id);
	int deleteObject(Integer id);

}
