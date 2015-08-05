package cn.caregg.o2o.business.engine.http.param;

import java.util.Map;

import cn.caregg.o2o.business.engine.http.base.BaseRequestParameter;

/**
 * @ClassName: UserRequestParameter
 * @Description: TODO  商家请求参数
 * @author FH 
 * @date 2015年7月16日 下午4:32:49
 * 
*/

public class BusinessRequestParameter extends BaseRequestParameter {

	
	public static Map<String,String> getLoginMap(String telephone,String password){
		Map<String, String> map = getMap();
		map.put("telephone", telephone);
		map.put("password", password);
		return map;
	}
	
	
	public static Map<String, String> getRestPwd(String telephone,
			String validateCode, String password, String password2) {
		Map<String,String> map = getMap();
		map.put("telephone", telephone);
		map.put("validateCode", validateCode);
		map.put("password", password);
		map.put("password2", password2);
		return map;
	}
	
	
	public static Map<String,String> getSendSMSvalidateCode(String telephone){
		Map<String,String> map = getMap();
		map.put("telephone", telephone);
		return map;
	}
	
	
	public static Map<String,String>  getMainPage(String serviceOrgSeq){
		Map<String, String> map = getMap();
		map.put("serviceOrgSeq", serviceOrgSeq);
		return map;
	}
}
