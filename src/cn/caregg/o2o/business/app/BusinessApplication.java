package cn.caregg.o2o.business.app;

import com.lidroid.xutils.HttpUtils;

import android.app.Application;
import android.content.Context;

/**
 * @ClassName: BusinessApplication
 * @Description: TODO  商家APPlication
 * @author FH 
 * @date 2015年6月30日 下午3:38:10
 * 
*/

public class BusinessApplication extends Application {

	public static Context mContext =null;
	
	
	public static HttpUtils mHttpUtils = null;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}
}
