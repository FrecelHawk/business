package cn.caregg.o2o.business.engine.http.task;


import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

import cn.caregg.o2o.business.config.BusinessAPI;
import cn.caregg.o2o.business.engine.http.base.BaseRequestHandler;
import cn.caregg.o2o.business.engine.http.param.UserRequestParameter;

/**
 * @ClassName: UserTask
 * @Description: TODO
 * @author FH 
 * @date 2015年7月16日 下午4:37:56
 * 
*/

public class UserTask {



	/** 
	 * @author FH
	 * @Description: TODO  登录
	 * @param map
	 * @param callBack void 
	 * @throws:throws
	*/ 
	public <T> void login(String phone,String pwd,RequestCallBack<T> callBack){
		new BaseRequestHandler().send(BusinessAPI.USER_LOGIN,
				HttpMethod.POST, UserRequestParameter.getLoginMap(phone, pwd),
				callBack);
	}
	
	
	/** 
	 * @author FH
	 * @Description: TODO   忘记密码   在登录接口里显示是重置密码
	 * @param telephone
	 * @param validateCode
	 * @param password
	 * @param password2
	 * @param callBack void 
	 * @throws:throws
	*/ 
	
	public <T> void forgetPwd(String telephone, String validateCode, String password, String password2, RequestCallBack<T> callBack){
		new BaseRequestHandler()
				.send(BusinessAPI.USER_RESTPWD, HttpMethod.POST,
						UserRequestParameter.getRestPwd(telephone,
								validateCode, password, password2), callBack);
	}
	
	
	/** 
	 * @author FH
	 * @Description: TODO    短信验证
	 * @param phone
	 * @param callBack void 
	 * @throws:throws
	*/ 
	
	public <T> void sendSMS(String phone,RequestCallBack<T> callBack){
		new BaseRequestHandler().send(BusinessAPI.SEND_SMS+"/"+phone,HttpMethod.GET,callBack);
	}
}

