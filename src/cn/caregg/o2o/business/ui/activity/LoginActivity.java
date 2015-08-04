package cn.caregg.o2o.business.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.app.BusinessApplication;
import cn.caregg.o2o.business.config.BusinessAPI;
import cn.caregg.o2o.business.engine.domain.Business;
import cn.caregg.o2o.business.engine.http.callback.RequestCallBackString;
import cn.caregg.o2o.business.engine.http.task.BusinessTask;
import cn.caregg.o2o.business.engine.parse.ResultPaser;
import cn.caregg.o2o.business.ui.base.BaseActivity;
import cn.caregg.o2o.business.utils.ActivityStartUtil;
import cn.caregg.o2o.business.utils.PhoneUtil;
import cn.caregg.o2o.business.utils.ResourceUtils;
import cn.caregg.o2o.business.utils.StringUtils;
import cn.caregg.o2o.business.utils.ValidityUtil;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.ContentView;

/**
 * @ClassName: LoginActivity
 * @Description: TODO   登录页面
 * @author FH 
 * @date 2015年7月13日 上午11:03:08
 * 
*/
@ContentView(R.layout.carnest_business_login)
public class LoginActivity extends BaseActivity {

	private EditText  phone;
	
	private EditText  passwd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
		initView();
		testData();
	}

	private void testData() {
		phone.setText("13501015801");
		passwd.setText("123456");
	}

	private void initView() {
		((ImageView)((ViewGroup)findViewById(R.id.login_tab2))
		           .findViewById(R.id.imageView1))
		           .setImageDrawable(ResourceUtils.getDrawable(R.drawable.carnest_login_txt));
		
		((ImageView)((ViewGroup)findViewById(R.id.login_tab4))
				        .findViewById(R.id.imageView3))
				        .setImageDrawable(ResourceUtils.getDrawable(R.drawable.carnest_login_password_bg));
		
		 phone = (EditText) ((ViewGroup)findViewById(R.id.login_tab3)).findViewById(R.id.login_edit_txt);
		 
		 phone.setInputType(EditorInfo.TYPE_CLASS_PHONE);
		 
		 //设置输入电话长度
		 ValidityUtil.limitInputLength(phone, 11);
		 
		 passwd = (EditText) ((ViewGroup)findViewById(R.id.login_tab4)).findViewById(R.id.login_edit_txt);
		 
		 passwd.setHint(ResourceUtils.getString(R.string.passwd));
		 
		 //改变化密码输入
		 ValidityUtil.setPasswdFormation(passwd);
		 
		 //输放密码长度
		ValidityUtil.limitInputLength(passwd, 20);
		 
	}
	
	
	/** 
	 * @author FH
	 * @Description: TODO  执行登录
	 * @throws:throws
	*/ 
	private void executeLogin(String data) {
		Business  business = ResultPaser.paserObject(data, Business.class);
		if(business.getFlag().equals("1")){
				BusinessApplication.serviceOrgEToken = business.getServiceOrgEToken();
				BusinessApplication.business = business;
				Toast.makeText(LoginActivity.this,
								business.getMessage(), Toast.LENGTH_SHORT)
								.show();
				ActivityStartUtil.start(LoginActivity.this,NavigationManagerActivity.class);
				  return ;
		}
		Toast.makeText(LoginActivity.this,
				business.getMessage(),
				Toast.LENGTH_SHORT).show();
		
	}
	
	
	
	public void login(View view){
		new BusinessTask().login(phone.getText().toString(),
				             passwd.getText().toString(), 
				             new RequestCallBackString() {
			
			@Override
			public void onSuccess(String data) {
				if(!StringUtils.isEmpty(data)){
					executeLogin(data);
				}
				
			}

			@Override
			public void filterFailureMsg(String failureMsg) {
				LogUtils.e(failureMsg);
			}
		});
	};
	
	
	public void forgetPasswd(View view){
		ActivityStartUtil.start(LoginActivity.this, ForgetPasswdActivity.class);
	}
	
	public void applyAccount(View view){
		PhoneUtil.defaultBrowserOpen(BusinessAPI.PORTAL, LoginActivity.this);
	}
}
