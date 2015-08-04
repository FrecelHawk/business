package cn.caregg.o2o.business.ui.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.app.BusinessApplication;
import cn.caregg.o2o.business.engine.http.callback.RequestCallBackString;
import cn.caregg.o2o.business.engine.http.task.UserTask;
import cn.caregg.o2o.business.engine.page.control.NavigationControl;
import cn.caregg.o2o.business.engine.page.impl.NavigationBar;
import cn.caregg.o2o.business.engine.parse.ResultPaser;
import cn.caregg.o2o.business.engine.vo.UserInfo;
import cn.caregg.o2o.business.engine.vo.UserPage;
import cn.caregg.o2o.business.ui.adapter.UserAdapter;
import cn.caregg.o2o.business.ui.common.CommonListViewAcitivty;
import cn.caregg.o2o.business.ui.view.ClearEditText;
import cn.caregg.o2o.business.ui.view.CommonListView;
import cn.caregg.o2o.business.utils.ActivityStartUtil;
import cn.caregg.o2o.business.utils.StringUtils;
import cn.caregg.o2o.business.utils.ToastUtil;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @ClassName: UserSearchActivity
 * @Description: TODO  用户搜索界面
 * @author FH 
 * @date 2015年8月3日 上午10:43:39
 * 
*/

@ContentView(R.layout.carnest_user_info)
public class UserSearchActivity extends CommonListViewAcitivty{

	@ViewInject(R.id.navigation)
	private ViewGroup  navigation;
	
	@ViewInject(R.id.clearEditText1)
	private ClearEditText  et;
	
	@ViewInject(R.id.listView)
	private  CommonListView  listView;
	
	@ViewInject(R.id.search)
	private TextView   search;
	
	private UserAdapter  adapter;
	
	private List<UserInfo> list = new ArrayList<UserInfo>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
		new NavigationControl().setNavigationInf(
				new NavigationBar(navigation, UserSearchActivity.this))
				.setTitle("用户信息");
		et.setText("136");
		adapter = new UserAdapter(UserSearchActivity.this, list);
		search.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
		    	loadDataSource(listView, adapter, list);
			}
		});
	}


	@Override
	protected void enterDetail(int position) {
		final UserInfo  user = list.get(position);
		if(null==user)  return;
		
		new UserTask().findCarOwnerBySeq(user.getCarOwnerSeq(),
				BusinessApplication.business.getServiceOrgSeq(),
				new RequestCallBackString() {
			
			@Override
			public void onSuccess(String data) {
				if(!StringUtils.isEmpty(data)){
					UserInfo  info = ResultPaser.paserObject(data, UserInfo.class);
//					ActivityStartUtil.startActivityWithParcelable(UserSearchActivity.this, UserDetailActivity.class, info);
				}
			}
			
			@Override
			public void filterFailureMsg(String failureMsg) {
				ToastUtil.shortShow(UserSearchActivity.this, failureMsg);
			}
		});
	}

	@Override
	protected void pullData(int page) {
		BusinessApplication.business.setServiceOrgSeq("1");
		new UserTask().findCarOwner(page + "", rows + "",
				BusinessApplication.business.getServiceOrgSeq(),
				StringUtils.trim(et.getText().toString()),
				new RequestCallBackString() {
			
			@Override
			public void onSuccess(String data) {
				if(!StringUtils.isEmpty(data)){
					UserPage pageModel = ResultPaser.paserObject(data, UserPage.class);
					if(pageModel.getDataList().size()>0){
						list.addAll(pageModel.getDataList());
						sendBroadcast();
						return;
					}
					stopRefresh();
					
				}else{
					listView.setPullRefreshEnable(false);
				}
			}
			
			@Override
			public void filterFailureMsg(String failureMsg) {
				ToastUtil.shortShow(UserSearchActivity.this, failureMsg);
			}
		});
	}

	public void search(View view){
		ToastUtil.shortShow(UserSearchActivity.this, "测试");
	}
	
}
