package cn.caregg.o2o.business.ui.activity;

import android.os.Bundle;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;

import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.ui.base.BaseActivity;

@ContentView(R.layout.carnest_settings_business_time)
public class BusinessTimeActivity extends BaseActivity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
	}
}
