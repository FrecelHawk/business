package cn.caregg.o2o.business.ui.activity;

import android.os.Bundle;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;

import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.ui.base.BaseActivity;


/**
 * @ClassName: BusinessEnvironment
 * @Description: TODO   商家环境界面
 * @author FH 
 * @date 2015年8月4日 下午4:26:10
 * 
*/

@ContentView(R.layout.carnest_setting_business_envrionment)
public class BusinessEnvironment extends BaseActivity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
	}
}
