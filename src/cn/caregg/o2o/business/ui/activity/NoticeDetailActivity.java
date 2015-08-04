package cn.caregg.o2o.business.ui.activity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.page.control.NavigationControl;
import cn.caregg.o2o.business.engine.page.impl.NavigationBar;
import cn.caregg.o2o.business.engine.vo.NoticeInfo;
import cn.caregg.o2o.business.ui.base.BaseActivity;
import cn.caregg.o2o.business.utils.DateUtils;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @ClassName: NoticeDetailActivity
 * @Description: TODO
 * @author FH 
 * @date 2015年8月3日 上午9:25:29
 * 
*/

@ContentView(R.layout.carnest_news_detail)
public class NoticeDetailActivity extends BaseActivity {

	@ViewInject(R.id.textView1)
	private TextView  title;
	
	@ViewInject(R.id.textView3)
	private TextView  time;
	
	@ViewInject(R.id.editText1)
	private TextView  context;
	
	@ViewInject(R.id.navigation)
	private ViewGroup  navigation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
		
		new NavigationControl()
		    .setNavigationInf(new NavigationBar(navigation,NoticeDetailActivity.this))
		    .setTitle("消息详情");
		if(null!=getIntent()&&null!=getIntent().getParcelableExtra("Parcelable")){
		    NoticeInfo  info = getIntent().getParcelableExtra("Parcelable");
		    title.setText(info.getNoticeInfoTitle());
		    time.setText(DateUtils.setTimeDateMinute(info.getNoticeInfoTime()));
		    context.setText(info.getNoticeInfoContent2());
		}
		
	}
}
