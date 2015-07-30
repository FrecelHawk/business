package cn.caregg.o2o.business.engine.parse;

import com.google.gson.reflect.TypeToken;

/**
 * @ClassName: ResponseParse
 * @Description: TODO  结果集解析
 * @author FH 
 * @date 2015年7月28日 下午2:04:05
 * 
*/

public interface ResponseParse {

	/** 
	 * @author FH
	 * @Description: TODO  解析对象
	 * @throws:throws
	*/ 
	
	public <E>  E  paserObject(Object result,Class<E> clazz);
	
	
	/** 
	 * @author FH
	 * @Description: TODO  解析集合
	 * @throws:throws
	*/ 
	
	public <E> E  paserCollection(Object result,TypeToken<E> typeToken);
}
