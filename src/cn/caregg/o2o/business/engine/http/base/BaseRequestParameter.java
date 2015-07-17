package cn.caregg.o2o.business.engine.http.base;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: BaseRequestParameter
 * @Description: TODO  请求参数
 * @author FH 
 * @date 2015年7月13日 上午9:53:01
 * 
*/

public abstract class BaseRequestParameter {

	
	public static <K,V> Map<K,V> getMap(){
		return new HashMap<K, V>();
	}
	
	
}
