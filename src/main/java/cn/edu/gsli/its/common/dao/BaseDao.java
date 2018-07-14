package cn.edu.gsli.its.common.dao;
/***
 * 閫氳繃姝ゆ帴鍙ｅ疄鐜板瀛愮被鍏辨?х殑鎻愬彇
 * @author adminitartor
 * @param <T>
 * 閫氳繃绫讳笂鐨勬硾鍨?<T>绾︽潫绫讳腑:
 * 1)鏂规硶鐨勫弬鏁扮被鍨?
 * 2)鏂规硶鐨勮繑鍥炲?肩被鍨?
 */
public interface BaseDao<T> {
	int insertObject(T entity);
	int updateObject(T entity);
}




