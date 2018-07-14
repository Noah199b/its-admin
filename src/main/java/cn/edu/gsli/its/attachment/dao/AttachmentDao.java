package cn.edu.gsli.its.attachment.dao;

import java.util.List;

import cn.edu.gsli.its.attachment.entity.Attachment;

public interface AttachmentDao {
	int insertObject(Attachment entity);
	/**根据摘要信息获取记录�?*/
	int getRowCountByDigest(String fileDisgest);
	/**获得�?有上传的文件信息*/
	List<Attachment> findObjects();
	/**根据id查找某个对象*/
	Attachment findObjectById(Integer id);
	
}
