package cn.caregg.o2o.business.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.page.control.NavigationControl;
import cn.caregg.o2o.business.engine.page.impl.NavigationBar;
import cn.caregg.o2o.business.ui.base.BaseActivity;
import cn.caregg.o2o.business.ui.view.ClearEditText;
import cn.caregg.o2o.business.utils.ResourceUtils;
import cn.caregg.o2o.business.utils.ToastUtil;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

@ContentView(R.layout.carnest_modify_contact_mode)
public class ModityContactActivity extends BaseActivity{
  
	
	@ViewInject(R.id.navigation)
	private ViewGroup  navigation;
	
	@ViewInject(R.id.button1)
	private Button  save;
	
//	联系人
	private ClearEditText contact;
//	手机号
	private ClearEditText phone;
//	联系人电话
	private ClearEditText contactTel;
	
	private int[] imgs = {R.drawable.carnest_modify_contact,R.drawable.carnest_modify_contact_phone,R.drawable.carnest_modify_phone};
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
		
		new NavigationControl().setNavigationInf(
				new NavigationBar(navigation, ModityContactActivity.this))
				.setTitle("修改联系方式");
		
		initView();
		
		setListener();
	}


	public void initView() {
		ViewGroup tab1 = (ViewGroup) findViewById(R.id.tab1);
		contact = (ClearEditText) tab1.findViewById(R.id.edit_txt);
		
		ViewGroup tab2 = (ViewGroup) findViewById(R.id.tab2);
		((ImageView)tab2.findViewById(R.id.imageView1)).setImageDrawable(ResourceUtils.getDrawable(imgs[2]));
		((TextView)tab2.findViewById(R.id.textView1)).setText("手机号");
		phone = (ClearEditText) tab2.findViewById(R.id.edit_txt);
		
		 ViewGroup tab3 = (ViewGroup) findViewById(R.id.tab3);
		((ImageView)tab3.findViewById(R.id.imageView1)).setImageDrawable(ResourceUtils.getDrawable(imgs[1]));
		((TextView)tab3.findViewById(R.id.textView1)).setText("联系电话");
		contactTel = (ClearEditText) tab3.findViewById(R.id.edit_txt);
	}


	public void setListener() {
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				  ToastUtil.shortShow(ModityContactActivity.this, "保存");
			}
		});
	}
	
}
