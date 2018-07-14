package cn.edu.gsli.its.attachment.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cn.edu.gsli.its.attachment.entity.Attachment;


public interface AttachmentService {
    /**实现文件上传*/
	public void uploadObject(String title,
			MultipartFile mFile);
	public List<Attachment> findObjects();
	public Attachment findObjectById(Integer id);
	
}
