package cn.edu.gsli.its.manage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.edu.gsli.its.common.dao.BaseDao;
import cn.edu.gsli.its.manage.entity.Project;
/**数据持久层对�?(方法名必�?
 * 与ProjectMapper中的id值对�?)*/
public interface ProjectDao 
        extends BaseDao<Project>{
	/**获得表中�?有记�?
	 * @param name 模糊查询时输入的项目
	 * @param valid 项目启用、禁用状态�??(1,0)
	 * @param startIndex 表示从哪条记录开始取数据
	 * @param pageSize 表示每页显示多少条记�?
	 * @return 表示查询到的当前页的�?有记�?
	 * 当方法中的参数个数多�?1个时�?要使�?
	 * @param 注解进行声明
	 * */
	List<Project> findObjects(
	@Param("name")String name,
	@Param("valid")Integer valid,
	@Param("startIndex")int startIndex,
	@Param("pageSize")int pageSize);
	/**获得总记录数
	 * @param name 模糊查询时输入的项目
	 * @param valid 项目启用、禁用状态�??(1,0)
	 * @return 总记录数
	 */
	int getRowCount(
			@Param("name")String name,
			@Param("valid")Integer valid);
	/**将对象信息写入到表中*/
	//int insertObject(Project entity);
	
	/**修改表中记录信息*/
	//int updateObject(Project entity);

	/**禁用或启动项目信�?
	 * String idStr=1,2,3;
	 * String ids[]=ids.split(",");[1,2,3];
	 * @param 要修改的id的�??
	 * @param 将valid具体修改为什么�???(1,0)
	 * @return 为被修改的记录的行数
	 * */
	int validById(
			@Param("ids")String[] ids,
			@Param("valid")int valid);
	
	/**根据id执行查询操作
	 * @param id 来自页面上的某条记录的id�?
	 * */
	//Project findObjectById(Integer id);
	
	/**查询�?有启用项目的id以及名字*/
	List<Map<String,Object>>
	findPrjIdAndNames();
	
	Project findObjectById(Integer id);
	
	
	
	
	
}
