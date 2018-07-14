package cn.edu.gsli.its.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.gsli.its.manage.entity.Report;

public interface ReportDao {
	
	public List<Report> findReports(
			@Param("type")Integer type,
			@Param("state")Integer state,
			@Param("start")int start,
			@Param("size")int size);
	
	public int findReportsCount(
			@Param("type")Integer type,
			@Param("state")Integer state);
	
	public Report findById(@Param("id")int id);
	
	public void updateState(
			@Param("id")int id,
			@Param("state")int state,
			@Param("opinion")String opinion);
	/**删除话题*/
	public void deleteArticle(@Param("id")int id);
	/**删除话题*/
	public void deleteResource(@Param("id")int id);
	/**禁用用户*/
	public void updateUserValid(@Param("id")int id);
}
