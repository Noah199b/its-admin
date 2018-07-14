package cn.edu.gsli.its.manage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.gsli.its.common.exception.ServiceException;
import cn.edu.gsli.its.common.web.PageObject;
import cn.edu.gsli.its.manage.dao.ProjectDao;
import cn.edu.gsli.its.manage.entity.Project;
import cn.edu.gsli.its.manage.service.ProjectService;
@Transactional
@Service
public class ProjectServiceImpl 
       implements ProjectService {
	/**使用@Resource注解为属性注入�?�时,
	 * 是先按名字查�?,还是先按类型查找?*/
	@Resource
	private ProjectDao projectDao;

	@Transactional(readOnly=true,
			propagation=Propagation.REQUIRED
			,rollbackFor=ServiceException.class)
	/**查询,获取项目信息*/
	@Override
	public Map<String,Object> findObjects(
			String name,
			Integer valid,
			int pageCurrent) {
		//1.通过dao对象的方法获取当前页项目信息
		//1.1定义每页�?多显�?2条数�?
		int pageSize=5;
		//1.2计算当前页开始查找的位置
		int startIndex=(pageCurrent-1)*pageSize;
		//1.3�?始查询当前页的数�?
		List<Project> list=
		projectDao.findObjects(
		name,valid,startIndex,pageSize);
		//2.获得总记录数,计算总页�?,然后进行封装
		//2.1 查询总记录数
		int rowCount=
		projectDao.getRowCount(name,valid);
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
	/**
	 * 启用或禁用项目信�?
	 * @param idStr 包含页面上�?�中的多个id�?,
	 * 具体格式:"11,12,13,15"
	 * @param valid 具体启用和禁用的�?
	 * */
	@Override
	public void validById(String idStr,Integer valid) {
		System.out.println("valid="+valid);
		//1.对参数进行业务验�?(提高系统的容错能�?)
		if(idStr==null||idStr.trim().length()==0)
		throw new ServiceException("至少选择一项！");
		if(valid!=0&&valid!=1)
		throw new ServiceException("valid值必须是0或1");
		//2.将字符串解析为数�?(获得选中的所有id�?)
		String[] ids=idStr.split(",");
		//3.执行启用或禁用的更新操作
		projectDao.validById(ids,valid);
	}
	/**执行写入操作
	 * @param entity 封装了用户页面上输入的数�?
	 * */
	@Transactional(rollbackFor=ServiceException.class)
	@Override
	public void saveObject(Project entity){
		//1.对参数进行业务验�?
		if(entity==null)
		throw new ServiceException("写入的数据不能为空");
		//2.执行写入操作(返回值默认为写入的行�?)
		int rows=
		projectDao.insertObject(entity);
		//3.对结果进行业务判�?
		if(rows!=1)
		throw new ServiceException("insert error");
	}
	/**根据id查找project对象*/
	@Override
	public Project findObjectById(
			Integer id) {
		//1.判定id的有效�??
		if(id==null||id<=0)
		throw new ServiceException(
				"id值无�?:id="+id);
		//2.根据id查找对应的对�?
		Project project=
		projectDao.findObjectById(id);
		//3.判定结果是否正确
		if(project==null)
		throw new ServiceException(
		"没有找到对应的记�?");
		//4.返回结果
		return project;
	}
	/**执行修改操作
	 * @param entity指向的对象封装了页面上要
	 * 修改的数�?.
	 * */
	@Override
	public void updateObject(Project entity) {
		//1.判定参数的有效�??
		if(entity==null)
		throw new ServiceException("被修改的记录不能空");
		//2.执行修改操作
		int rows=projectDao.updateObject(entity);
		//3.根据结果判定是否修改成功
		if(rows!=1)
		throw new RuntimeException("修改失败");
	}
}








