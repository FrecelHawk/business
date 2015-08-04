package cn.caregg.o2o.business.test;

import com.lidroid.xutils.HttpUtils;

import cn.caregg.o2o.business.app.BusinessApplication;
import cn.caregg.o2o.business.engine.http.callback.RequestCallBackString;
import cn.caregg.o2o.business.engine.http.task.BusinessTask;
import android.test.AndroidTestCase;

public class TestUserTask extends AndroidTestCase {

	public TestUserTask() {
	}

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		BusinessApplication.mHttpUtils = new HttpUtils();
	}
	
//	测试登录
	public void login(){
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
//	测试重置
	public void resetPwd(){
		new BusinessTask().forgetPwd("13501015801", "9245", "123456", "123456", new RequestCallBackString() {
			
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
//	测试发送短信
	public void sendSMS(){
		new BusinessTask().sendSMS("13501015801",  new RequestCallBackString() {
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
	
}
