package cn.caregg.o2o.business.engine.http.base;



import com.lidroid.xutils.http.RequestParams;

/**
 * @ClassName: RequestParamsByHeader
 * @Description: requestParams的包装类，封装了headers
 * @author Kevinliu 
 * @date 2015年1月22日 上午10:50:50
 * 
*/

public class RequestParamsByHeader extends RequestParams {
	
	public RequestParamsByHeader() {
		super();
		addHeaders();
	}


	public RequestParamsByHeader(String charset) {
		super(charset);
		addHeaders();
	}
	private void addHeaders() {
		addHeader("Content-Type", "application/json");
		addHeader("charset", "utf-8");
//		addHeader("Authorization", PhoneUtil.getTVIMEI(BusinessApplication.mContext));
//		addHeader("reqFrom", "2");
	}
	
	

}
