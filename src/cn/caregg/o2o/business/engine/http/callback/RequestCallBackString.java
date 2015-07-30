package cn.caregg.o2o.business.engine.http.callback;

import org.json.JSONException;
import org.json.JSONObject;



/**
 * @ClassName: RequestCallBackString
 * @Description: TODO
 * @author FH 
 * @date 2015年7月17日 下午1:00:49
 * 
*/

public  abstract class RequestCallBackString extends BaseRequestCallBack<String> {

	
    @Override
    public String responseInfo(String result) {
    	return responseHandler(result);
    }

    
    public String  responseHandler(String result){
    	JSONObject json = getJson(result);
    	String strJson = null;
    	if(null!=json){
    		  try {
				if(json.getInt("state")==1)
					  strJson = json.getString("data");
			} catch (JSONException e) {
				e.printStackTrace();
			}
    	}
    	return strJson;
    }
    
    
    @Deprecated
	public String oldResponseHandler(String result) {
		JSONObject  json = null;
    	String strJson = null;
    	try {
    		json = new JSONObject(result.toString());
			int state = json.getInt("state");
			if(state == 1) strJson = json.getString("data");
			  else onFailure(json.getString("message"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
    	return strJson;
	}
    
    public JSONObject  getJson(String result){
    	JSONObject  json = null;
    	   try {
			json = new JSONObject(result.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
    	return json;
    }
    
    
    @Override
    public void onFailure(String failureMsg) {
    	JSONObject json = getJson(failureMsg);
    	if(null!=json){
    		  try {
					filterFailureMsg(json.getString("message"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
    /** 
     * @author FH
     * @Description: TODO  过滤失败的错误信息
     * @param failureMsg void 
     * @throws:throws
    */ 
    
    public abstract void filterFailureMsg(String failureMsg);
    
	
}
