package cn.caregg.o2o.business.app;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;

import com.lidroid.xutils.HttpUtils;

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
	
	public static LinkedList<String> releaseList =null;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		mContext = BusinessApplication.this;
		mHttpUtils = new HttpUtils();
		releaseList = new LinkedList<String>();
	}
	
	
	public static  void cleanAll(){
		 int index =releaseList.size();
		 for(int i=0;i<index;i++){
			String finishId = releaseList.removeFirst();
			 if(null!=finishId)
				 mContext.sendBroadcast(new Intent(finishId));
		 }
		 releaseList.clear();
			 
	}
}
