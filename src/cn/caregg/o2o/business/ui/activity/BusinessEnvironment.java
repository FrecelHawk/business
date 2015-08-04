package cn.caregg.o2o.business.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.page.constant.BusinessEnvironmentConstant;
import cn.caregg.o2o.business.engine.page.control.NavigationControl;
import cn.caregg.o2o.business.engine.page.impl.NoticeNavigationBar;
import cn.caregg.o2o.business.ui.base.BaseActivity;
import cn.caregg.o2o.business.utils.ResourceUtils;
import cn.caregg.o2o.business.utils.ToastUtil;


/**
 * @ClassName: BusinessEnvironment
 * @Description: TODO   商家环境界面
 * @author FH 
 * @date 2015年8月4日 下午4:26:10
 * 
*/

@ContentView(R.layout.carnest_setting_business_envrionment)
public class BusinessEnvironment extends BaseActivity{

	@ViewInject(R.id.navigation)
	private ViewGroup  navigation;
	
	private CheckBox[]  checkBoxs = new CheckBox[7]; 
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
		
		setTitle();
	    initView();
	}


	public void initView() {
		for(int i=0;i<BusinessEnvironmentConstant.tabs.length;i++){
	    	ViewGroup  tab = (ViewGroup) findViewById(BusinessEnvironmentConstant.tabs[i]);
			((ImageView)tab.findViewById(R.id.imageView1)).setImageDrawable(ResourceUtils.getDrawable(BusinessEnvironmentConstant.imgs[i]));
			((TextView)tab.findViewById(R.id.textView1)).setText(BusinessEnvironmentConstant.txts[i]);		
			checkBoxs[i] = (CheckBox) tab.findViewById(R.id.checkBox1);
			
	    }
	}


	public void setTitle() {
		new NavigationControl()
		 .setNavigationInf(new NoticeNavigationBar(navigation, BusinessEnvironment.this))
		 .setTitle("设置营业时间")
		 .noticeNavigationRightTv("保存")
		 .noticeNavigation(new SaveListener());
	}
	
	
	private class SaveListener  implements OnClickListener{

		@Override
		public void onClick(View v) {
			ToastUtil.shortShow(BusinessEnvironment.this, "保存");
			for(int i=0;i<checkBoxs.length;i++){
				ToastUtil.shortShow(BusinessEnvironment.this, checkBoxs[i].isChecked()+"");
			}
		}
		
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		checkBoxs = null;
	}
}
