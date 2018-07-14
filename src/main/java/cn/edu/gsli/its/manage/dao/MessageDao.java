package cn.edu.gsli.its.manage.dao;


import cn.edu.gsli.its.manage.entity.Message;

public interface MessageDao {
	/**
	 * 插入一条信息消息
	 * @param message
	 */
	public void insertMsg(Message message);
}
