package cn.caregg.o2o.business.engine.http.callback;

import org.json.JSONException;
import org.json.JSONObject;

import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.util.LogUtils;

/**
 * @ClassName: BaseStringRequestCallBack
 * @Description: 请求回调包装类
 * @author Kevinliu 
 * @date 2015年1月31日 下午4:03:57
 * 
 * @param <T>
*/

public abstract class BaseRequestCallBack<T> extends RequestCallBack<T> {

	private String TAG = "json onSuccess: ";

	public void setTAG(String TAG) {
		this.TAG = TAG;
	}

	
	@Override
	public void onSuccess(ResponseInfo<T> responseInfo) {
		LogUtils.d(TAG + responseInfo.result);
		
		if(test(responseInfo)){
			return;
		} 
 
		try {
			JSONObject jsonObject = new JSONObject(responseInfo.result.toString());
			Integer state = (Integer) jsonObject.get("state");
			if (state == 1) {
				//				onSuccess(jsonObject.getString("message"));
				onSuccess(jsonObject.getJSONObject("data"));
			} else {
				//		responseInfo.result 进行errorCode处理
				onFailure(jsonObject.getString("message"));
			}

		} catch (JSONException e) {
			onFailure("JSON 解析异常！");
			e.printStackTrace(); 
		}

	}
	
	
	public boolean test(ResponseInfo<T> responseInfo){
		try {
			JSONObject jsonObject = new JSONObject(responseInfo.result.toString());
			Integer state;
			if(null==jsonObject.get("status")){
				return false;
			}else{
				state = (Integer) jsonObject.get("status");
			}
			if (state == 1) {
				//				onSuccess(jsonObject.getString("message"));
				onSuccess(jsonObject.getJSONObject("data"));

			} else {
				//		responseInfo.result 进行errorCode处理
				onFailure(jsonObject.getString("message"));
			}
			return true;

		} catch (JSONException e) {
//			onFailure("JSON 解析异常！");
//			e.printStackTrace();
		}
		return false;
	}


	@Override
	public void onFailure(HttpException error, String msg) {

		onFailure(msg);

	}

	public abstract void onSuccess(JSONObject result);

	public abstract void onFailure(String failureMsg);
	

}
