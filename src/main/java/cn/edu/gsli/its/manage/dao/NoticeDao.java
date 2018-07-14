package cn.edu.gsli.its.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.gsli.its.manage.entity.Notice;

public interface NoticeDao {
	/**
	 * 保存新公告
	 * @param notice
	 * @return
	 */
	public int save(Notice notice);
	/**
	 * 根据公告ID改变公告状态
	 * @param id 为公告ID
	 * @param state 为公告状态标识
	 * @return
	 */
	public int stateById(@Param("id")int id,@Param("state")int state);
	/**
	 * 修改公告
	 * @param notice
	 * @return
	 */
	public int update(Notice notice);
	/**
	 * 删除公告
	 * @param id
	 * @return
	 */
	public int delete(@Param("id")int id);
	/**
	 * 模糊查询
	 * @param key 为内容关键字
	 * @return
	 */
	public List<Notice> findObjects(
			@Param("key")String key,
			@Param("state")Integer state,
			@Param("startIndex")int startIndex,
			@Param("pageSize")int pageSize);
	/**
	 * 模糊查询总数
	 * @param key 为内容关键字
	 * @return
	 */
	public int findObjectsCount(@Param("key")String key,
			@Param("state")Integer state);
	
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	public Notice findById(@Param("id")int id);
}
