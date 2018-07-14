package cn.edu.gsli.its.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.gsli.its.manage.entity.Auth;

public interface AuthDao {
	
	public int findAuthCount(@Param("state")Integer state);
	public List<Auth> findAuth(
			@Param("state")Integer state,
			@Param("start")int start,
			@Param("size")int size);
	public Auth findById(@Param("id")int id);
	
	public void dueWithAuth(
			@Param("id")int id,
			@Param("state")int state,
			@Param("opinion")String opinion,
			@Param("user")String user);
	public void updateValidByUsername(
			@Param("username")String username,
			@Param("valid")int valid);
}
