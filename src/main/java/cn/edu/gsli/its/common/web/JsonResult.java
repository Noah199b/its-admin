package cn.edu.gsli.its.common.web;
/**借助此对象封装Controller方法上有
 * @ResponseBody注解的方法的返回�?,
 * 目的:统一返回值类�?,便于在页面上�?
 * 行统�?处理
 * */
public class JsonResult {
	private static final int SUCCESS=1;
	private static final int ERROR=0;
	/**状�??*/
	private int state;
	/**对应状�?�的消息*/
	private String message;
	/**具体业务数据*/
	private Object data;
	/**此构造方法应用于data为null的场�?*/
	public JsonResult(){
		this.state=SUCCESS;//1
		this.message="OK";
	}
	/**有具体业务数据返回时,使用此构造方�?*/
	public JsonResult(Object data){
		this();
		this.data=data;
	}
	/**出现异常以后要调用此方法封装异常信息*/
	public JsonResult(Throwable t){
		this.state=ERROR;
		this.message=t.getMessage();
	}
	public Object getData() {
		return data;
	}
	public int getState() {
		return state;
	}
	public String getMessage() {
		return message;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}
