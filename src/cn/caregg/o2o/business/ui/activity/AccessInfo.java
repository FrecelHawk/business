package cn.caregg.o2o.business.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.page.control.NavigationControl;
import cn.caregg.o2o.business.engine.page.impl.NavigationBar;
import cn.caregg.o2o.business.ui.base.BaseActivity;
import cn.caregg.o2o.business.utils.ActivityStartUtil;
import cn.caregg.o2o.business.utils.DelayedHandler;
import cn.caregg.o2o.business.utils.ResourceUtils;
import cn.caregg.o2o.business.utils.ToastUtil;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

@ContentView(R.layout.carnest_account_number_info)
public class AccessInfo extends BaseActivity {

	
	private int[]  images = {R.drawable.carnest_access_phone,R.drawable.carnest_access_pwd,R.drawable.carnest_access_update};
	
	@ViewInject(R.id.navigation)
	private ViewGroup  navigation;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
		new NavigationControl().setNavigationInf(
				new NavigationBar(navigation, AccessInfo.this))
				.setTitle("用户信息");
		
		initView();
		
	}


	public void initView() {
		ViewGroup tab1 = (ViewGroup) findViewById(R.id.tab1);
		ViewGroup tab2 = (ViewGroup) findViewById(R.id.tab2);
		ViewGroup tab3 = (ViewGroup) findViewById(R.id.tab3);

		((TextView)tab1.findViewById(R.id.textView3)).setText("当前已是最新版本");
		((ImageView)tab1.findViewById(R.id.imageView1)).setImageDrawable(ResourceUtils.getDrawable(images[2]));
		((TextView)tab1.findViewById(R.id.textView1)).setText("版本信息");
		
		((TextView)tab2.findViewById(R.id.textView1)).setText("绑定手机");
		((ImageView)tab2.findViewById(R.id.imageView1)).setImageDrawable(ResourceUtils.getDrawable(images[0]));
		
		((TextView)tab3.findViewById(R.id.textView1)).setText("修改密码");
		((ImageView)tab3.findViewById(R.id.imageView1)).setImageDrawable(ResourceUtils.getDrawable(images[1]));
	}
	
	
	public void outlogin(View view){
		ToastUtil.shortShow(AccessInfo.this, "退出");
		ActivityStartUtil.start(AccessInfo.this, LoginActivity.class);
		DelayedHandler.execute(new Runnable() {
			
			@Override
			public void run() {
                   finish();				
			}
		}, 2000);
	}
}
