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
    	JSONObject  json = null;
    	String strJson = "";
    	try {
    		json = new JSONObject(result.toString());
			int state = json.getInt("state");
			if(state == 1) strJson = json.getString("data");
			  else strJson = json.getString("message");
		} catch (JSONException e) {
			e.printStackTrace();
		}
    	return strJson;
    }
	
}
