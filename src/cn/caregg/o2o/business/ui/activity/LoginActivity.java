package cn.caregg.o2o.business.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.ui.base.BaseActivity;
import cn.caregg.o2o.business.utils.ResourceUtils;

import com.lidroid.xutils.ViewUtils;
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
		
	}

	private void initView() {
		((ImageView)((ViewGroup)findViewById(R.id.login_tab2))
		           .findViewById(R.id.imageView1))
		           .setImageDrawable(ResourceUtils.getDrawable(R.drawable.carnest_login_txt));
		
		((ImageView)((ViewGroup)findViewById(R.id.login_tab4))
				        .findViewById(R.id.imageView3))
				        .setImageDrawable(ResourceUtils.getDrawable(R.drawable.carnest_login_password_bg));
		
		 phone = (EditText) ((ViewGroup)findViewById(R.id.login_tab3)).findViewById(R.id.login_edit_txt);
		 
		 passwd = (EditText) ((ViewGroup)findViewById(R.id.login_tab4)).findViewById(R.id.login_edit_txt);
		 
		 passwd.setHint(ResourceUtils.getString(R.string.passwd));
	}
	
	
	public void login(View view){
		
	};
	
	
	public void forgetPasswd(View view){
		
	};
	
	public void applyAccount(View view){
		
	};
}
