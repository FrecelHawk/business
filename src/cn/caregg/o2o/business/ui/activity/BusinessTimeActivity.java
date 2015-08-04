package cn.caregg.o2o.business.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.page.control.NavigationControl;
import cn.caregg.o2o.business.engine.page.impl.NoticeNavigationBar;
import cn.caregg.o2o.business.ui.base.BaseActivity;
import cn.caregg.o2o.business.utils.ToastUtil;

@ContentView(R.layout.carnest_settings_business_time)
public class BusinessTimeActivity extends BaseActivity {

	@ViewInject(R.id.navigation)
	private ViewGroup navigation;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
		setTitle();
	}

	public void setTitle() {
		new NavigationControl()
		 .setNavigationInf(new NoticeNavigationBar(navigation, BusinessTimeActivity.this))
		 .setTitle("设置营业时间")
		 .noticeNavigationRightTv("保存")
		 .noticeNavigation(new SaveListener());
	}
	
	private class SaveListener  implements OnClickListener{

		@Override
		public void onClick(View v) {
			ToastUtil.shortShow(BusinessTimeActivity.this, "保存");
		}
		
	}
}
