package cn.caregg.o2o.business.engine.http.param;

import java.util.Map;

import cn.caregg.o2o.business.engine.http.base.BaseRequestParameter;

/**
 * @ClassName: UserRequestParameter
 * @Description: TODO  用户请求参数
 * @author FH 
 * @date 2015年8月3日 下午2:50:19
 * 
*/

public class UserRequestParameter extends BaseRequestParameter {

	/** 
	 * @author FH
	 * @Description: TODO    用户搜索
	 * @param page           当前页数
	 * @param rows           当页记录数 
	 * @param serviceOrgSeq  商家序列号
	 * @param phoneOrName    输入搜索内容
	 * @return Map<String,Object> 
	 * @throws:throws
	*/ 
	
	public static Map<String,Object> findCarOwner(String page,String rows,String serviceOrgSeq,String phoneOrName){
		Map<String, Object> map = getMap();
		Map<String,String> where = getMap();
		where.put("serviceOrgSeq", serviceOrgSeq);
		where.put("phoneOrName", phoneOrName);
		map.put("page", page);
		map.put("rows", rows);
		map.put("where", where);
		return map;
	}
	
	
	
	/** 
	 * @author FH
	 * @Description: TODO       查看用户详情
	 * @param carOwnerSeq      	商家序号
	 * @param serviceOrgSeq     车主序号
	 * @return Map<String,Object> 
	 * @throws:throws
	*/ 
	
	public static Map<String,Object> findCarOwnerBySeq(String carOwnerSeq,String serviceOrgSeq){
		  Map<String, Object> map = getMap();
		  map.put("serviceOrgSeq", serviceOrgSeq);
		  map.put("carOwnerSeq",carOwnerSeq);
		  return map;
	}
	
	
	/** 
	 * @author FH
	 * @Description: TODO        意见反馈
	 * @param serviceUserSeq     商家序号
	 * @param feedbackContent    意见反馈内容
	 * @param feedbackType       意见反馈类别
	 * @return Map<String,Object> 
	 * @throws:throws
	*/ 
	
	public static Map<String,Object> feedback(String serviceUserSeq,String feedbackContent,String feedbackType){
		Map<String, Object> map = getMap();
		map.put("serviceUserSeq", serviceUserSeq);
		map.put("feedbackContent",feedbackContent);
		map.put("feedbackType", feedbackType);
		return map;
	}
	
	
	/** 
	 * @author FH
	 * @Description: TODO         绑定手机号
	 * @param telephone           手机号
	 * @param validateCode        验证码
	 * @return Map<String,Object> 
	 * @throws:throws
	*/ 
	
	public static Map<String,Object> bindingTelephone(String telephone,String validateCode){
		Map<String, Object> map = getMap();
		map.put("telephone",telephone);
		map.put("validateCode",validateCode);
		return map;
	}
	
}
