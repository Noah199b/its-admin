package cn.edu.gsli.its.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.gsli.its.manage.entity.News;

public interface NewsDao {
	public int save(News news);
	public int delete(@Param("id")int id);
	public News findById(@Param("id")Integer id);
	public int update(News news);
	public List<News> search(@Param("search")String search,
			@Param("start")int start,@Param("size")int size);
	public int searchCount(@Param("search")String search);
}
