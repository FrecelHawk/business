package cn.caregg.o2o.business.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.app.BusinessApplication;
import cn.caregg.o2o.business.engine.page.constant.AccessInfoConstanct;
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
		for(int i=0;i<AccessInfoConstanct.tabs.length;i++)
			           setTab(i);
		
		((TextView)findViewById(R.id.tab1)
				  .findViewById(R.id.textView3)).setText("当前已是最新版本");
	}


	public void setTab(int i) {
		ViewGroup tab = (ViewGroup) findViewById(AccessInfoConstanct.tabs[i]);
		((ImageView)tab.findViewById(R.id.imageView1)).setImageDrawable(ResourceUtils.getDrawable(AccessInfoConstanct.images[i]));
		((TextView)tab.findViewById(R.id.textView1)).setText(AccessInfoConstanct.txts[i]);
		tab.setOnClickListener(new SeleteListener());
	}
	
	
	public void outlogin(View view){
		ToastUtil.shortShow(AccessInfo.this, "退出");
		DelayedHandler.execute(new Runnable() {
			@Override
			public void run() {
				ActivityStartUtil.start(AccessInfo.this, LoginActivity.class);
                   
			}
		}, 2000);
	}
	
	
	private class SeleteListener  implements OnClickListener{

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.tab1:
				 update();
				break;
			case R.id.tab2:
				 bindingPhone();
				break;
			case R.id.tab3:
				 modifyPwd();
				break;
			default:
				break;
			}
		}
		
	}
	
	public void update(){
		ToastUtil.shortShow(AccessInfo.this, "更新");
	}
	
	public void bindingPhone(){
		ActivityStartUtil.start(AccessInfo.this, BindingPhoneAcitivity.class);
	}
	
	public void modifyPwd(){
		ActivityStartUtil.start(AccessInfo.this, RestPasswdActivity.class);
	}
}
