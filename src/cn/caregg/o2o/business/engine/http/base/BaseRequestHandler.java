package cn.caregg.o2o.business.engine.http.base;

import java.io.UnsupportedEncodingException;

import org.apache.http.entity.StringEntity;

import cn.caregg.o2o.business.app.BusinessApplication;

import com.google.gson.Gson;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

/**
 * @ClassName: BaseRequestHandler
 * @Description: 请求基类
 * @author Kevinliu 
 * @date 2015年1月30日 上午10:04:29
 * 
*/

public class BaseRequestHandler implements IRequestHandler{

	public <T> void send(String url, HttpMethod method, Object obj, RequestCallBack<T> callBack) {
	    send(url, method, obj, new BusinessRequestParams(), callBack);
	}
	
	public <T> void send(String url,HttpMethod method,RequestCallBack<T> callBack){
		BusinessApplication.mHttpUtils.send(method, url, new BusinessRequestParams(), callBack);
	}
	
	
	public <T> void send(String url,HttpMethod method,RequestParams params,RequestCallBack<T> callBack){
		BusinessApplication.mHttpUtils.send(method, url, params, callBack);
	}

	@Override
	public <T> void send(String url, HttpMethod method, Object obj, RequestParams params, RequestCallBack<T> callBack) {
		// TODO Auto-generated method stub
		String Json = new Gson().toJson(obj);
		try {
			params.setBodyEntity(new StringEntity(Json, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		BusinessApplication.mHttpUtils.send(method, url, params, callBack);
	}

}
