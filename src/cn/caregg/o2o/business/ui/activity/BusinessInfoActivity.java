package cn.caregg.o2o.business.ui.activity;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.page.constant.BusinessInfoConstant;
import cn.caregg.o2o.business.engine.page.control.NavigationControl;
import cn.caregg.o2o.business.engine.page.impl.NavigationBar;
import cn.caregg.o2o.business.ui.base.BaseActivity;
import cn.caregg.o2o.business.utils.ActivityStartUtil;
import cn.caregg.o2o.business.utils.ResourceUtils;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @ClassName: BusinessInfo
 * @Description: TODO      商家信息
 * @author FH 
 * @date 2015年7月20日 上午10:00:12
 * 
*/
@ContentView(R.layout.carnest_business_info)
public class BusinessInfoActivity extends BaseActivity {

	@ViewInject(R.id.top_navigation)
	private ViewGroup  navigation;
	  

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
		new NavigationControl().setNavigationInf(
				new NavigationBar(navigation, BusinessInfoActivity.this))
				.setTitle("商家信息");
		
		initialTab();
	}


	private void initialTab() {
		for(int i=0;i<BusinessInfoConstant.tabs.length;i++){
			
			 ViewGroup  viewGroup = (ViewGroup) findViewById(BusinessInfoConstant.tabs[i]);
			((ImageView) (viewGroup)
					.findViewById(R.id.imageView1))
					.setImageDrawable(ResourceUtils.getDrawable(BusinessInfoConstant.imags[i]));
			
			((TextView) (viewGroup)
					.findViewById(R.id.textView1))
					.setText(BusinessInfoConstant.tabTxts[i]);
			
			viewGroup.setOnClickListener(new SeleteListener());
		}
	}
	
	
	private class  SeleteListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.tab1:break;
			case R.id.tab2:
				  ActivityStartUtil.start(BusinessInfoActivity.this, ModityContactActivity.class);
				break;
			case R.id.tab3:
				  ActivityStartUtil.start(BusinessInfoActivity.this, BusinessTimeActivity.class);
				break;
			case R.id.tab4:
				  ActivityStartUtil.start(BusinessInfoActivity.this, BusinessEnvironment.class);
				break;
			case R.id.tab5:
				  ActivityStartUtil.start(BusinessInfoActivity.this, BusinessDesribeActivity.class);
				break;
			case R.id.tab6:break;
			default:
				break;
			}
		}
		
	}
	
	
	
}
