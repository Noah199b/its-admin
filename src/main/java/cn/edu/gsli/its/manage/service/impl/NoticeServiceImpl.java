package cn.edu.gsli.its.manage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import cn.edu.gsli.its.common.exception.ServiceException;
import cn.edu.gsli.its.common.web.PageObject;
import cn.edu.gsli.its.manage.dao.NoticeDao;
import cn.edu.gsli.its.manage.entity.Notice;
import cn.edu.gsli.its.manage.service.NoticeService;
import cn.edu.gsli.its.system.entity.SysUser;
@Service
public class NoticeServiceImpl implements NoticeService {
	@Resource
	NoticeDao noticeDao;
	@Override
	public Map<String, Object> findObjects(String name, Integer valid, int pageCurrent) {
		//1.通过dao对象的方法获取当前页项目信息
		//1.1定义每页�?多显�?2条数�?
		int pageSize=5;
		//1.2计算当前页开始查找的位置
		int startIndex=(pageCurrent-1)*pageSize;
		//1.3�?始查询当前页的数�?
		List<Notice> list=noticeDao.findObjects(name,valid,startIndex,pageSize);
		//2.获得总记录数,计算总页�?,然后进行封装
		//2.1 查询总记录数
		int rowCount=noticeDao.findObjectsCount(name,valid);
		//2.3封装分页信息(自己定义PageObject)
		PageObject pageObject=new PageObject();
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setStartIndex(startIndex);
		//3.将数据封装到map(两个对象�?要传回页�?)
		Map<String,Object> map=
		new HashMap<String,Object>();
		//3.1封装当前页数�?
		map.put("list", list);
		//3.2封装分页对象信息
		map.put("pageObject", pageObject);
		return map;
	}
	@Override
	public void doSaveObject(Notice notice) throws Exception {
		if(notice.getContent().length()>255 || notice.getContent().length()<10)
			throw new ServiceException("公告内容的长度应在10-255个字之间！");
		SysUser user = (SysUser) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		notice.setCreatedUser(user.getUsername());
		int n=noticeDao.save(notice);
		if(n==0)throw new ServiceException("添加失败，请稍后重试！");
	}
	@Override
	public void doValidById(Integer checkedIds, Integer valid)throws Exception {
		int n=noticeDao.stateById(checkedIds, valid);	
		if(n==0)throw new ServiceException("修改失败，请稍后重试！");
	}
	@Override
	public void doUpdateObject(Notice notice) throws Exception {
		if(notice.getContent().length()>255 || notice.getContent().length()<10)
			throw new ServiceException("公告内容的长度应在10-255个字之间！");
		SysUser user = (SysUser) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		notice.setModifiedUser(user.getUsername());
		int n=noticeDao.update(notice);
		if(n==0)throw new ServiceException("修改失败，请稍后重试！");
	}
	@Override
	public Notice doFindObjectById(int id) {
		return noticeDao.findById(id);
	}
}
