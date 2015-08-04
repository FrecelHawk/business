package cn.caregg.o2o.business.engine.parse;

import com.google.gson.reflect.TypeToken;


/**
 * @ClassName: ResultPaser
 * @Description: TODO   结果解析调用 
 * @author FH 
 * @date 2015年7月28日 下午2:34:27
 * 
*/

public class ResultPaser {

	private static ResponseParse  parse;
	
	static{
		parse = new JsonParse();
	}
	
	public static <E> E  paserObject(Object result,Class<E> clazz){
		return parse.paserObject(result, clazz);
	}
	
	public static <E> E  paserCollection(Object result,TypeToken<E> typeToken){
		return parse.paserCollection(result, typeToken);
	}
	
}
