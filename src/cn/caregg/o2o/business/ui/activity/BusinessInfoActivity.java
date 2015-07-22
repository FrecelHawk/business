package cn.caregg.o2o.business.ui.activity;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.page.control.NavigationControl;
import cn.caregg.o2o.business.engine.page.impl.NavigationBar;
import cn.caregg.o2o.business.ui.base.BaseActivity;
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
	
//	标签图片
	private int[] imags = { R.drawable.carnest_position,
			R.drawable.carnest_contact_pattern,
			R.drawable.carnest_business_date,
			R.drawable.carenest_business_envrionment,
			R.drawable.carnest_business_describe,
			R.drawable.carnest_business_withdraw_deposit };
//	标签文本
	private String[] tabTxts = ResourceUtils.getStringArray(R.array.business_info_tab);
	
	
	
	
	private int[] tabs = {R.id.tab1,R.id.tab2,R.id.tab3,R.id.tab4,R.id.tab5,R.id.tab6};
	
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
		for(int i=0;i<tabs.length;i++){
			
			 ViewGroup  viewGroup = (ViewGroup) findViewById(tabs[i]);
			((ImageView) (viewGroup)
					.findViewById(R.id.imageView1))
					.setImageDrawable(ResourceUtils.getDrawable(imags[i]));
			
			((TextView) (viewGroup)
					.findViewById(R.id.textView1))
					.setText(tabTxts[i]);
			
			viewGroup.setOnClickListener(new SeleteListener());
		}
	}
	
	
	private class  SeleteListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			
		}
		
	}
	
	
	
}
