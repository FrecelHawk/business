package cn.caregg.o2o.business.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.page.control.NavigationControl;
import cn.caregg.o2o.business.engine.page.impl.NavigationBar;
import cn.caregg.o2o.business.ui.base.BaseActivity;
import cn.caregg.o2o.business.utils.ResourceUtils;
import cn.caregg.o2o.business.utils.ValidityUtil;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @ClassName: RestPasswdActivity
 * @Description: TODO   重置密码界面
 * @author FH 
 * @date 2015年7月29日 下午2:11:48
 * 
*/

@ContentView(R.layout.carnest_reset_passwd)
public class RestPasswdActivity extends BaseActivity {

	
	private EditText newPwd;
	
	private EditText oldPwd;

	private EditText confirmPwd;
	
	@ViewInject(R.id.button1)
	private Button confirm;
	
	private Button  check;
	
	@ViewInject(R.id.navigation)
	private ViewGroup  navigation;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
		new NavigationControl().setNavigationInf(
				new NavigationBar(navigation, RestPasswdActivity.this))
				.setTitle("重置密码");
		initialView();
	}


	private void initialView() {
		newPwd = (EditText) ((ViewGroup)findViewById(R.id.tab1)).findViewById(R.id.edit_txt);
		
		oldPwd = (EditText) ((ViewGroup)findViewById(R.id.tab2)).findViewById(R.id.edit_txt);
		
		confirmPwd = (EditText) ((ViewGroup)findViewById(R.id.tab3)).findViewById(R.id.edit_txt);
        
		
		((TextView)findViewById(R.id.textView1)).setText("密码为6-20位字母，数字取特殊字符组件");
		
//		提示文字
		newPwd.setHint(R.string.new_pwd);
		
		oldPwd.setHint(R.string.old_pwd);
		
		confirmPwd.setHint(R.string.confirm_pwd);
		
//		验证
		ValidityUtil.limitInputLength(newPwd, 20);
		ValidityUtil.limitInputLength(oldPwd, 20);
		ValidityUtil.limitInputLength(confirmPwd, 20);
		
		confirm.setText(ResourceUtils.getString(R.string.reset_pwd));
		confirm.setOnClickListener(new OnClick());
	}
	
	
	private class OnClick  implements OnClickListener{

		@Override
		public void onClick(View v) {
			
			
		}
		
	}
}
