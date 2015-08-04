package cn.caregg.o2o.business.engine.http.task;

import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

import cn.caregg.o2o.business.config.BusinessAPI;
import cn.caregg.o2o.business.engine.http.base.BaseRequestHandler;
import cn.caregg.o2o.business.engine.http.callback.BaseRequestCallBack;
import cn.caregg.o2o.business.engine.http.param.NoticeReqeustParameter;

/**
 * @ClassName: NoticeTask
 * @Description: TODO  通知请求
 * @author FH 
 * @date 2015年7月31日 下午5:56:33
 * 
*/

public class NoticeTask {


	public <E>  void  pullPage(String page,String rows,String  serviceUserSep,BaseRequestCallBack<E> callBack){
		 new BaseRequestHandler().send(BusinessAPI.FINDNOTICE, HttpMethod.POST, NoticeReqeustParameter.pullPageMap(page, rows, serviceUserSep), callBack);
	}
	
	
	public <E> void  allArticle(String serviceUserSeq,BaseRequestCallBack<E> callBack){
		new BaseRequestHandler().send(BusinessAPI.ALLARTICLE, HttpMethod.POST,NoticeReqeustParameter.allArticle(serviceUserSeq), callBack);
	}
	
	
	public <E> void  singleArticle(String serviceUserSeq,String noticeInfoSeq,BaseRequestCallBack<E> callBack){
		new BaseRequestHandler().send(BusinessAPI.ALLARTICLE, HttpMethod.POST, NoticeReqeustParameter.singleArticle(serviceUserSeq, noticeInfoSeq),callBack);
	}
	
}
