package cn.caregg.o2o.business.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.page.constant.BindingPhoneConstanct;
import cn.caregg.o2o.business.engine.page.control.NavigationControl;
import cn.caregg.o2o.business.engine.page.impl.NavigationBar;
import cn.caregg.o2o.business.ui.base.BaseActivity;
import cn.caregg.o2o.business.ui.view.ClearEditText;
import cn.caregg.o2o.business.utils.ResourceUtils;
import cn.caregg.o2o.business.utils.ToastUtil;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

@ContentView(R.layout.carnest_modify_binding_phone)
public class BindingPhoneAcitivity extends BaseActivity {

	@ViewInject(R.id.navigation)
	private ViewGroup  navigation;
	
	@ViewInject(R.id.getcode)
	private Button  getCode;
	
	@ViewInject(R.id.button1)
	private Button  confirm;
	
	@ViewInject(R.id.describe)
	private TextView  describe;
	
	private ClearEditText  pwd;
	
	private ClearEditText  phone;
	
	private ClearEditText   code;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
		
		new NavigationControl().setNavigationInf(
				new NavigationBar(navigation, BindingPhoneAcitivity.this))
				.setTitle("修改绑定手机");
		
		initView();
        initListener();
        
	}

	public void initListener() {
		getCode.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ToastUtil.shortShow(BindingPhoneAcitivity.this, "验证码");
			}
		});
        
   
        confirm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ToastUtil.shortShow(BindingPhoneAcitivity.this, "确定");
			}
		});
	}

	public void initView() {
		describe.setText("更换手机号之后，可直接使用新手机号做为用户名登录，密码不变。");
		for (int i = 0; i < BindingPhoneConstanct.tabs.length; i++)
			   setTab(i);
		
		
		pwd = (ClearEditText) findViewById(BindingPhoneConstanct.tabs[0]).findViewById(R.id.edit_txt);
		
        phone = (ClearEditText) findViewById(BindingPhoneConstanct.tabs[1]).findViewById(R.id.edit_txt);
        
        code = (ClearEditText) findViewById(BindingPhoneConstanct.tabs[2]).findViewById(R.id.edit_txt);
	}

	public void setTab(int i) {
		ViewGroup tab =  (ViewGroup) findViewById(BindingPhoneConstanct.tabs[i]);
		((ImageView)tab.findViewById(R.id.imageView1))
		                .setImageDrawable(ResourceUtils.getDrawable(BindingPhoneConstanct.imgs[i]));
	}
	
}
