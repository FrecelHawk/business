package cn.caregg.o2o.business.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.http.callback.RequestCallBackString;
import cn.caregg.o2o.business.engine.http.task.BusinessTask;
import cn.caregg.o2o.business.engine.page.control.NavigationControl;
import cn.caregg.o2o.business.engine.page.impl.NavigationBar;
import cn.caregg.o2o.business.ui.base.BaseActivity;
import cn.caregg.o2o.business.utils.ActivityStartUtil;
import cn.caregg.o2o.business.utils.DelayedHandler;
import cn.caregg.o2o.business.utils.ResourceUtils;
import cn.caregg.o2o.business.utils.StringUtils;
import cn.caregg.o2o.business.utils.ToastUtil;
import cn.caregg.o2o.business.utils.ValidityUtil;

/**
 * @ClassName: ForgetPasswdActivity
 * @Description: TODO   忘记密码界面
 * @author FH 
 * @date 2015年7月29日 下午2:12:06
 * 
*/

@ContentView(R.layout.carnest_forget_passwd)
public class ForgetPasswdActivity extends BaseActivity {

	private EditText  phone;
	
	private EditText  pwd;
	
	private EditText  confirmPwd;
	
	private EditText  checkNumber;
	
	@ViewInject(R.id.confirm)
	private Button confirm;
	
	@ViewInject(R.id.getcode)
	private Button checkBut;
	
	@ViewInject(R.id.navigation)
	private ViewGroup navigation;
	
//	验证码
	private String validateCode;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	ViewUtils.inject(this);
    	
		new NavigationControl().setNavigationInf(
				new NavigationBar(navigation, ForgetPasswdActivity.this))
				.setTitle("重置密码");
    	
        initView();
    }

	private void initView() {
		pwd = (EditText) ((ViewGroup)findViewById(R.id.tab2)).findViewById(R.id.edit_txt);
		
		confirmPwd = (EditText) ((ViewGroup)findViewById(R.id.tab3)).findViewById(R.id.edit_txt);
		
		phone = (EditText) ((ViewGroup)findViewById(R.id.tab1)).findViewById(R.id.edit_txt);
        
		checkNumber = (EditText) findViewById(R.id.tab4).findViewById(R.id.edit_txt);
		
//		checkBut = (Button) findViewById(R.id.tab4).findViewById(R.id.button1);
		
		((ImageView) findViewById(R.id.tab4).findViewById(R.id.imageView1))
				.setImageDrawable(ResourceUtils
						.getDrawable(R.drawable.carnest_binding_check));
		
		((ImageView) ((ViewGroup) findViewById(R.id.tab1))
				.findViewById(R.id.imageView1)).setImageDrawable(ResourceUtils
				.getDrawable(R.drawable.carnest_binding_phone));
		
		((TextView)findViewById(R.id.textView1)).setText("密码为6-20位字母，数字取特殊字符组件");
		
		
		
//		提示文字
		pwd.setHint(R.string.passwd);
		
		phone.setHint("注册手机号");
		
		checkNumber.setHint("验证码：");
		
		confirmPwd.setHint(R.string.confirm_pwd);
		
		
//		验证
		setLimit();
		
		confirm.setText(ResourceUtils.getString(R.string.reset_pwd));
		initListener();
	}

	private void setLimit() {
		ValidityUtil.limitInputLength(pwd, 20);
		ValidityUtil.limitInputLength(confirmPwd, 20);
		ValidityUtil.limitInputLength(phone, 11);
		ValidityUtil.limitInputLength(checkNumber, 4);
//		设置输入密码格式
		ValidityUtil.setPasswdFormation(pwd);
		ValidityUtil.setPasswdFormation(confirmPwd);
	}

	private void initListener() {
		confirm.setOnClickListener(new ConfirmClick());
		checkBut.setOnClickListener(new CheckClick());
	}	
    
    
    private class ConfirmClick implements OnClickListener{

		@Override
		public void onClick(View v) {
			
			new BusinessTask()
					.forgetPwd(phone.getText().toString(),
							validateCode,
							StringUtils.trim(pwd.getText().toString()),
							StringUtils.trim(confirmPwd.getText().toString()),
							new RequestCallBackString() {
								
								@Override
								public void onSuccess(String data) {
									if(!StringUtils.isEmpty(data)){
										delayedHandler();
									}
										 
								}

								
								
								@Override
								public void filterFailureMsg(String failureMsg) {
									ToastUtil.shortShow(ForgetPasswdActivity.this, failureMsg);
									
								}
							});
			
		}
    	
    }
    
    /** 
     * @author FH
     * @Description: TODO  延迟三秒 进入首页
     * @throws:throws
    */ 
    
    public void delayedHandler() {
	   DelayedHandler.execute(new Runnable() {
			@Override
			public void run() {
				ActivityStartUtil.start(ForgetPasswdActivity.this, LoginActivity.class);
			}
		}, 3000);
	}
    
    
    public void  getCheckUnmber(String number){
    	this.validateCode = number;
    	checkNumber.setText(number);
    }
    
    private class CheckClick implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			new BusinessTask().sendSMS(phone.getText().toString(), new RequestCallBackString() {
				
				@Override
				public void onSuccess(String data) {
					if(!StringUtils.isEmpty(data))
						 getCheckUnmber(data);
				}
				
				@Override
				public void filterFailureMsg(String failureMsg) {
					ToastUtil.shortShow(ForgetPasswdActivity.this, failureMsg);
				}

			} );

		}
    	
    }
    
}
