package cn.edu.gsli.its.manage.service;

import java.util.Map;

import cn.edu.gsli.its.manage.entity.Auth;

public interface AuthService {

	public Map<String,Object> getAuthObjects(int pageNo, Integer state);

	public Auth getAuthObject(int id);

	public void dueWithAuth(int id, int state, String opinion)throws Exception;
	
}
