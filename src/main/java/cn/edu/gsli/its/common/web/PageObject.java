package cn.edu.gsli.its.common.web;

import java.io.Serializable;

/**封装具体的分页信�?*/
public class PageObject implements Serializable{
	private static final long serialVersionUID = -8753809986545361268L;
	/**当前�?*/
	private int pageCurrent=1;
	/**每页�?多能显示的记录数*/
	private int pageSize=3;
	/**总记录数*/
	private int rowCount;
	/**上一页的�?后一条记录位�?
	 * 对应:limit startIndex,pageSize;
	 */
	private int startIndex;
	public int getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getPageCount() {
	  	int pages = rowCount/pageSize;
    	if(0 != rowCount%pageSize) {
    		pages +=1;
    	}
        return pages;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
	
	
	
	
	
	
}
