package cn.caregg.o2o.business.engine.http.base;

import cn.caregg.o2o.business.app.BusinessApplication;

/**
 * @ClassName: BusinessRquestParams
 * @Description: TODO  商家的请求头设置
 * @author FH 
 * @date 2015年7月28日 上午11:41:32
 * 
*/

public class BusinessRequestParams extends RequestParamsByHeader {

	@Override
	protected void addHeaders() {
		// TODO Auto-generated method stub
		super.addHeaders();
		addHeader("serviceOrgEToken", BusinessApplication.serviceOrgEToken);
	}
}
