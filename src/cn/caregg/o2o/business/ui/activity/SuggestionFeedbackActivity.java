package cn.caregg.o2o.business.ui.activity;

import javax.swing.text.html.InlineView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.app.BusinessApplication;
import cn.caregg.o2o.business.engine.http.callback.RequestCallBackString;
import cn.caregg.o2o.business.engine.http.task.UserTask;
import cn.caregg.o2o.business.engine.page.control.NavigationControl;
import cn.caregg.o2o.business.engine.page.impl.NavigationBar;
import cn.caregg.o2o.business.ui.base.BaseActivity;
import cn.caregg.o2o.business.utils.ToastUtil;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

@ContentView(R.layout.carnest_suggestion_feedback)
public class SuggestionFeedbackActivity extends BaseActivity {

	
	@ViewInject(R.id.navigation)
	private ViewGroup navigation;
	
	@ViewInject(R.id.add_content)
	private EditText  content;
	
	@ViewInject(R.id.button1)
	private Button  commit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
		new NavigationControl().setNavigationInf(
				new NavigationBar(navigation, SuggestionFeedbackActivity.this))
				.setTitle("意见反馈");
		
		
	}
	
	
	public void commoit(View view){
		new UserTask().feedback(BusinessApplication.business.getServiceOrgSeq(), content.getText().toString(), "1", new RequestCallBackString() {
			
			@Override
			public void onSuccess(String data) {
				 finish();
			}
			
			@Override
			public void filterFailureMsg(String failureMsg) {
				ToastUtil.shortShow(SuggestionFeedbackActivity.this, failureMsg );
			}
		});
	}
}
