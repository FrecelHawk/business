package cn.caregg.o2o.business.test;



import com.lidroid.xutils.HttpUtils;

import cn.caregg.o2o.business.app.BusinessApplication;
import cn.caregg.o2o.business.engine.http.callback.RequestCallBackString;
import cn.caregg.o2o.business.engine.http.task.NoticeTask;
import cn.caregg.o2o.business.engine.http.task.BusinessTask;


import android.test.AndroidTestCase;

/**
 * @ClassName: TestApi
 * @Description: TODO
 * @author FH 
 * @date 2015年7月16日 上午11:33:25
 * 
*/

public class TestApi extends AndroidTestCase{

	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		BusinessApplication.mHttpUtils = new HttpUtils();
	}
	
	public void get(){
		System.out.println("TESST");
	}
	
	public void post(){
		
//		login();
		new NoticeTask().pullPage("1", "10", "1", new RequestCallBackString() {
			
			@Override
			public void onSuccess(String data) {
				System.out.println(data);
			}
			
			@Override
			public void filterFailureMsg(String failureMsg) {
				System.out.println(failureMsg);
			}
		});
	}

	public void login() {
		new BusinessTask().login("13501015801","123456", new RequestCallBackString(){

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				System.out.println(result);
			}

			@Override
			public void filterFailureMsg(String failureMsg) {
				System.out.println(failureMsg);
			}
			
		});
	}
	
	
	public void delete(){
		
	}
	
	
	public void put(){
		
	}
}
