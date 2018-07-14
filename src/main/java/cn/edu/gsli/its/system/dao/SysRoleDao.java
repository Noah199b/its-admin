package cn.edu.gsli.its.system.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.edu.gsli.its.common.dao.BaseDao;
import cn.edu.gsli.its.system.entity.SysRole;

public interface SysRoleDao extends BaseDao<SysRole> {
	/**获取�?有角色信�?*/
	List<Map<String, Object>> findObjects();
	/**分页获取�?有角色信�?*/
	List<SysRole> findPageObjects(
			@Param("name")String name,
			@Param("startIndex")int startIndex,
			@Param("pageSize")int pageSize);
	/**根据id获取角色信息*/
	SysRole findObjectById(Integer id);
	/**根据参数获取名字记录�?*/
	public int getRowCounts(@Param("name") String name);
	/**根据id删除对象信息*/
	int deleteObject(Integer id);

}
