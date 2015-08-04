package cn.caregg.o2o.business.engine.http.param;

import java.util.Map;

import cn.caregg.o2o.business.engine.http.base.BaseRequestParameter;

public class NoticeReqeustParameter extends BaseRequestParameter{

	
	/** 
	 * @author FH
	 * @Description: TODO     消息通知
	 * @param page            当前页数
	 * @param rows            每页的数
	 * @param serviceUserSep  商家用户序号
	 * @return 结果集
	 * @throws:throws
	*/ 
	
	public static Map<String,Object>  pullPageMap(String page,String rows,String  serviceUserSeq){
		Map<String, Object> map = getMap();
		Map<String, String> where = getMap();
		 where.put("serviceUserSeq", serviceUserSeq);
		 map.put("page", page);
		 map.put("rows", rows);
		 map.put("where", where);
		return map;
	}  
	
	
	
	/** 
	 * @author FH
	 * @Description: TODO       标记全部已读
	 * @param serviceUserSeq    商家序号
	 * @return Map<String,Object> 
	 * @throws:throws
	*/ 
	
	public static Map<String,String> allArticle(String  serviceUserSeq){
		Map<String, String> map = getMap();
		map.put("serviceUserSeq", serviceUserSeq);
		return map;
	}
	
	
	
	/** 
	 * @author FH
	 * @Description: TODO        单条未读消息
	 * @param serviceUserSeq     商家用户序号
	 * @param noticeInfoSeq      消息序号
	 * @return Map<String,String> 
	 * @throws:throws
	*/ 
	
	public static Map<String,String> singleArticle(String serviceUserSeq,String noticeInfoSeq){
		Map<String, String> map = getMap();
		map.put("serviceUserSeq", serviceUserSeq);
		map.put("noticeInfoSeq",noticeInfoSeq);
		return map;
	}
}
