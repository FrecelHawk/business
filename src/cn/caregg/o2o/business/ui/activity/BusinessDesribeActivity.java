package cn.caregg.o2o.business.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.page.control.NavigationControl;
import cn.caregg.o2o.business.engine.page.impl.NavigationBar;
import cn.caregg.o2o.business.ui.base.BaseActivity;
import cn.caregg.o2o.business.utils.ToastUtil;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @ClassName: BusinessDesribeActivity
 * @Description: TODO        商家介绍
 * @author FH 
 * @date 2015年8月4日 下午4:28:07
 * 
*/

@ContentView(R.layout.carnest_modify_business_describe)
public class BusinessDesribeActivity extends BaseActivity {

	@ViewInject(R.id.navigation)
	private ViewGroup navigation;
	
	@ViewInject(R.id.button1)
	private Button  save;
	
	@ViewInject(R.id.add_content)
	private EditText content;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
		
		new NavigationControl().setNavigationInf(
				new NavigationBar(navigation, BusinessDesribeActivity.this))
				.setTitle("修改商家介绍");
		
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				  ToastUtil.longShow(BusinessDesribeActivity.this, "保存");
			}
		});
	}
}
