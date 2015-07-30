package cn.caregg.o2o.business.engine.http.callback;


import cn.caregg.o2o.business.utils.StringUtils;

import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.util.LogUtils;


public abstract class BaseRequestCallBack<T> extends RequestCallBack<T> {

	private String TAG = "json onSuccess: ";

	public void setTAG(String TAG) {
		this.TAG = TAG;
	}
	
	@Override
	public void onSuccess(ResponseInfo<T> responseInfo) {
		LogUtils.i(TAG + responseInfo.result);
		if(null!=responseInfo(responseInfo.result))
		        onSuccess(responseInfo(responseInfo.result));
		else 
			  onFailure(responseInfo.result.toString());
	}
	

	@Override
	public void onFailure(HttpException error, String msg) {
		if (!StringUtils.isEmpty(msg) && (msg.contains("Bad Gateway") || msg.contains("Not Found")))
			msg = "服务器连接失败！";
		onFailure(msg);
	}

	public  abstract void onSuccess(T data);

	public abstract void  onFailure(String failureMsg);
	
	public abstract  T  responseInfo(T result);
	
	

}
