package cn.caregg.o2o.business.ui.activity;

import android.os.Bundle;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;

import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.ui.base.BaseActivity;

/**
 * @ClassName: BusinessDesribeActivity
 * @Description: TODO        商家介绍
 * @author FH 
 * @date 2015年8月4日 下午4:28:07
 * 
*/

@ContentView(R.layout.carnest_modify_business_describe)
public class BusinessDesribeActivity extends BaseActivity {

	  @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
	}
}
