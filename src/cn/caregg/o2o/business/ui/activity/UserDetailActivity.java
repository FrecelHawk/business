package cn.caregg.o2o.business.ui.activity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.page.control.NavigationControl;
import cn.caregg.o2o.business.engine.page.impl.NavigationBar;
import cn.caregg.o2o.business.engine.vo.UserInfo;
import cn.caregg.o2o.business.ui.base.BaseActivity;
import cn.caregg.o2o.business.ui.view.RoundImageView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @ClassName: UserDetailActivity
 * @Description: TODO  用户详情 
 * @author FH 
 * @date 2015年8月3日 下午4:53:46
 * 
*/

@ContentView(R.layout.carnest_user_detail)
public class UserDetailActivity extends BaseActivity{


	private RoundImageView  headSculpture;
	
	private UserInfo  user;
	
	@ViewInject(R.id.navigation)
	private ViewGroup navigation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
		
		new NavigationControl().setNavigationInf(
				new NavigationBar(navigation, UserDetailActivity.this))
				.setTitle("用户信息");
		
		if(null!=getIntent()&&null!=getIntent().getParcelableExtra("Parcelable")){
			user = getIntent().getParcelableExtra("Parcelable");
			initView(user);
		}
	

	}

	public void initView(UserInfo user) {
		//		 用户信息
				setUserInfo(user);
				
		//		车牌
//				setCarInfo(user);

				
		//	            订单
//				setOrderInfo(user);

		
		//		时间
//				setTime(user);
	}

	public void setTime(UserInfo user) {
		
		Long  registerTime = user.getOwnerCreateTime();
		Long  lastTime = user.getLastLoginTime();
		
		((TextView)findViewById(R.id.time).findViewById(R.id.tab1).findViewById(R.id.textView1)).setText("注册时间：");
//		((TextView)findViewById(R.id.time).findViewById(R.id.tab1).findViewById(R.id.textView1)).setText(null!=registerTime?DateUtils.setTimeDateMinute(registerTime):"");
		((TextView)findViewById(R.id.time).findViewById(R.id.tab2).findViewById(R.id.textView1)).setText("上次登录时间：");
//		((TextView)findViewById(R.id.time).findViewById(R.id.tab2).findViewById(R.id.textView1)).setText(null!=lastTime?DateUtils.setTimeDateMinute(lastTime):"");
	}

	public void setOrderInfo(UserInfo user) {
		((TextView)findViewById(R.id.order).findViewById(R.id.tab1).findViewById(R.id.textView1)).setText("订单数量：");
		((TextView)findViewById(R.id.order).findViewById(R.id.tab1).findViewById(R.id.textView2)).setText(user.getCountOder());
		((TextView)findViewById(R.id.order).findViewById(R.id.tab2).findViewById(R.id.textView1)).setText("消费金额：");
		((TextView)findViewById(R.id.order).findViewById(R.id.tab2).findViewById(R.id.textView2)).setText(user.getSumPrice());
	}

	public void setCarInfo(UserInfo user) {
		((TextView)findViewById(R.id.car).findViewById(R.id.tab1).findViewById(R.id.textView1)).setText("车  牌  号：");
		((TextView)findViewById(R.id.car).findViewById(R.id.tab1).findViewById(R.id.textView2)).setText(user.getCarId());
		((TextView)findViewById(R.id.car).findViewById(R.id.tab2).findViewById(R.id.textView1)).setText("汽车型号：");
		((TextView)findViewById(R.id.car).findViewById(R.id.tab2).findViewById(R.id.textView2)).setText(user.getCarMakerName());
	}

	public void setUserInfo(UserInfo user) {
		((TextView)findViewById(R.id.tab1).findViewById(R.id.textView1)).setText("手  机  号：");
		((TextView)findViewById(R.id.tab1).findViewById(R.id.textView2)).setText(user.getOwnerTel());
		((TextView)findViewById(R.id.tab2).findViewById(R.id.textView1)).setText("用户昵称：");
		((TextView)findViewById(R.id.tab2).findViewById(R.id.textView2)).setText(user.getOwnerNickName());
		((TextView)findViewById(R.id.tab3).findViewById(R.id.textView1)).setText("真实姓名：");
		((TextView)findViewById(R.id.tab3).findViewById(R.id.textView2)).setText(user.getOwnerName());

		headSculpture = (RoundImageView) findViewById(R.id.roundImageView1);
	}
	
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		user = null;
	}
	
}
