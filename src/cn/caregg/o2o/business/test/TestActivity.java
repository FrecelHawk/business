package cn.caregg.o2o.business.test;

import android.os.Bundle;
import android.view.View;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.http.callback.RequestCallBackString;
import cn.caregg.o2o.business.engine.http.task.UserTask;
import cn.caregg.o2o.business.ui.activity.LoginActivity;
import cn.caregg.o2o.business.ui.activity.NavigationManagerActivity;
import cn.caregg.o2o.business.ui.base.BaseActivity;
import cn.caregg.o2o.business.utils.ActivityStartUtil;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;

@ContentView(R.layout.test_ativity)
public class TestActivity extends BaseActivity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
	}
	
	
	public void test(View view){
		ActivityStartUtil.start(TestActivity.this, NavigationManagerActivity.class);
	}
}
