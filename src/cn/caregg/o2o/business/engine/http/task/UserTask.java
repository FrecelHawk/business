package cn.caregg.o2o.business.engine.http.task;

import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

import cn.caregg.o2o.business.config.BusinessAPI;
import cn.caregg.o2o.business.engine.http.base.BaseRequestHandler;
import cn.caregg.o2o.business.engine.http.callback.BaseRequestCallBack;
import cn.caregg.o2o.business.engine.http.param.UserRequestParameter;

/**
 * @ClassName: UserTask
 * @Description: TODO   用户请求处理
 * @author FH 
 * @date 2015年8月3日 下午2:48:36
 * 
*/

public class UserTask {

	
	public <E>  void   findCarOwner(String page,String rows,String serviceOrgSeq,String phoneOrName, BaseRequestCallBack<E> callBack){
		new BaseRequestHandler().send(BusinessAPI.FIND_CAR_OWNER, HttpMethod.POST,UserRequestParameter.findCarOwner(page, rows, serviceOrgSeq, phoneOrName), callBack);
	}
	
	public <E> void  findCarOwnerBySeq(String carOwnerSeq,String serviceOrgSeq, BaseRequestCallBack<E> callBack){
		new BaseRequestHandler().send(BusinessAPI.FIND_CAROWNER_BY_SEQ, HttpMethod.POST,UserRequestParameter.findCarOwnerBySeq(carOwnerSeq, serviceOrgSeq),callBack);
	}
	
	
	public <E> void  feedback(String serviceUserSeq, String feedbackContent, String feedbackType,BaseRequestCallBack<E> callBack){
		new BaseRequestHandler().send(BusinessAPI.FEEDBACK, HttpMethod.POST,UserRequestParameter.feedback(serviceUserSeq, feedbackContent, feedbackType),callBack);
	}
}
