package cn.caregg.o2o.business.ui.activity;

import android.os.Bundle;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;

import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.ui.base.BaseActivity;

@ContentView(R.layout.carnest_modify_contact_mode)
public class ModityContactActivity extends BaseActivity{
  
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
		
	}
	
}
