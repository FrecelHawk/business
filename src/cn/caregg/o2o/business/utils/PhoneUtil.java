package cn.caregg.o2o.business.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * @ClassName: PhoneUtil
 * @Description: TODO
 * @author FH 
 * @date 2015年6月30日 下午4:31:06
 * 
*/

public class PhoneUtil {

	public static String getTVIMEI(Context ctx) {
		
		return "";
	}
	
	/** 
	 * @author FH
	 * @Description: TODO  使用默认浏览器加载路径
	 * @throws:throws
	*/ 
	
	public static void defaultBrowserOpen(String url,Context context){
		Intent intent = new Intent();
		intent.setAction("android.intent.action.VIEW");
		intent.setData(Uri.parse(url));
		context.startActivity(intent);
	}
	
	
	/** 
	 * @author FH
	 * @Description: TODO  打电话
	 * @param context  控件
	 * @param mobile   手机号码
	 * @throws:throws
	*/ 
	
	public static void callPhone(Context context,String mobile){
		try{
			Intent i = new Intent("android.intent.action.CALL");
			i.setData(Uri.parse("tel:"+mobile));
			context.startActivity(i);
		}catch(Exception e){
			e.printStackTrace();
			new Exception("call phone exception!");
		}
	}
}
