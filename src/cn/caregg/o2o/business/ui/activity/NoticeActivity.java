package cn.caregg.o2o.business.ui.activity;

import java.util.ArrayList;
import java.util.List;

import me.maxwin.view.XListView.IXListViewListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.app.BusinessApplication;
import cn.caregg.o2o.business.engine.http.callback.RequestCallBackString;
import cn.caregg.o2o.business.engine.http.task.NoticeTask;
import cn.caregg.o2o.business.engine.page.control.NavigationControl;
import cn.caregg.o2o.business.engine.page.impl.NoticeNavigationBar;
import cn.caregg.o2o.business.engine.parse.ResultPaser;
import cn.caregg.o2o.business.engine.vo.NoticeInfo;
import cn.caregg.o2o.business.engine.vo.NoticePage;
import cn.caregg.o2o.business.ui.adapter.MessageAdapter;
import cn.caregg.o2o.business.ui.base.BaseActivity;
import cn.caregg.o2o.business.ui.view.CommonListView;
import cn.caregg.o2o.business.utils.ActivityStartUtil;
import cn.caregg.o2o.business.utils.DateUtils;
import cn.caregg.o2o.business.utils.DelayTask;
import cn.caregg.o2o.business.utils.DelayedHandler;
import cn.caregg.o2o.business.utils.StringUtils;
import cn.caregg.o2o.business.utils.ToastUtil;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.util.LogUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @ClassName: NoticeActivity
 * @Description: TODO  消息通知界面
 * @author FH 
 * @date 2015年7月31日 下午3:07:22
 * 
*/

@ContentView(R.layout.carnest_news_notice_activity)
public class NoticeActivity extends BaseActivity implements IXListViewListener{

	private static final String ACTION = "cn.carnest.findnotice";

	@ViewInject(R.id.navigation)
	private ViewGroup  navigation;
	
	@ViewInject(R.id.listView)
	private CommonListView listView;
	
	
	private List<NoticeInfo>  list = new ArrayList<NoticeInfo>();
	
	private volatile int page=1;
	
	private int  rows=10;
	
	private UpdateDataRecevier  pullData;
	
	private MessageAdapter  adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
//		NoticePage page = ResultPaser.paserObject(list, NoticePage.class);
		
		new NavigationControl()
		 .setNavigationInf(new NoticeNavigationBar(navigation, NoticeActivity.this))
		 .setTitle("消息通知")
		 .noticeNavigation(new HereReadOnClick());
		initView();
	}



	public void initView() {
		listView.setPullRefreshEnable(false);
		listView.setPullLoadEnable(true);
		listView.setXListViewListener(this);
		adapter = new MessageAdapter(NoticeActivity.this, list);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new ItemClick());
		registerBroadcast();
		findNotice(page);
	}



	public void registerBroadcast() {
		pullData = new UpdateDataRecevier();
		IntentFilter filter = new IntentFilter();
		filter.addAction(ACTION);
		registerReceiver(pullData, filter);
	}


	
	public void findNotice(int page){
		BusinessApplication.business.setServiceOrgSeq("1");
		new NoticeTask().pullPage(page+"", rows+"", BusinessApplication.business.getServiceOrgSeq(), new RequestCallBackString() {
			
			@Override
			public void onSuccess(String data) {
				if(!StringUtils.isEmpty(data)){
					NoticePage pageModel = ResultPaser.paserObject(data, NoticePage.class);
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
				// TODO Auto-generated method stub
				LogUtils.i(failureMsg);
			}
		});
	}

	
	public void  stopRefresh(){
		listView.stopLoadMore();
		listView.setPullLoadEnable(false);
	}

	/** 
	 * @author FH
	 * @Description: TODO void  上拉刷新 暂时不用
	 * @throws:throws
	*/ 
	
	@Deprecated
	@Override
	public void onRefresh() {
		DelayTask.startDelayedTask(2000, new Runnable() {
			@Override
			public void run() {
				listView.setRefreshTime(DateUtils.getCurrentDate());				
			}
		});
	}


	/** 
	 * @author FH
	 * @Description: TODO  加载更新事件
	 * @throws:throws
	*/ 
	
	@Override
	public void onLoadMore() {
	   DelayedHandler.execute(new Runnable() {
		
		@Override
		public void run() {
			page++;
			findNotice(page);
		}
	}, 2000);
	}
	
	
	/** 
	 * @author FH
	 * @Description: TODO void   发送广播更新数据
	 * @throws:throws
	*/ 
	
	public void sendBroadcast(){
		Intent i = new Intent(ACTION);
		sendBroadcast(i);
	}
	
	/**
	 * @ClassName: UpdateDataRecevier
	 * @Description: TODO   更新数据处理
	 * @author FH 
	 * @date 2015年8月1日 下午5:01:41
	 * 
	*/
	
	private class UpdateDataRecevier  extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			  adapter.notifyDataSetChanged();
			  listView.stopLoadMore();
		}
		
	}
	
	
	private class HereReadOnClick  implements OnClickListener{

		@Override
		public void onClick(View v) {
			badgeReader();
			
		}
		
	}
	
	
	/**
	 * @ClassName: ItemClick
	 * @Description: TODO  ListViwe 选择项
	 * @author FH 
	 * @date 2015年8月3日 上午9:51:27
	 * 
	*/
	
	private class ItemClick implements  OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			readMessage(position);
		}

		
		
	}
	
	
	/** 
	 * @author FH
	 * @Description: TODO  读取消息
	 * @param position void 
	 * @throws:throws
	*/ 
	
	public void readMessage(int position) {
		final NoticeInfo info = list.get(position-1);
	    new NoticeTask().singleArticle(BusinessApplication.business.getServiceOrgSeq(), info.getNoticeInfoSeq(), new RequestCallBackString() {
			
			@Override
			public void onSuccess(String data) {
				ActivityStartUtil.startActivityWithParcelable(NoticeActivity.this, NoticeDetailActivity.class, info);
			}
			
			@Override
			public void filterFailureMsg(String failureMsg) {
				 ToastUtil.shortShow(NoticeActivity.this, failureMsg);
			}
		});
	}
	
	
	
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		unregisterReceiver(pullData);
		pullData = null;
		list = null;
		adapter = null;
	}



	/** 
	 * @author FH
	 * @Description: TODO  标记全部已读
	 * @throws:throws
	*/ 
	
	public void badgeReader() {
		new NoticeTask().allArticle(BusinessApplication.business.getServiceOrgSeq(),new RequestCallBackString() {
			
			@Override
			public void onSuccess(String data) {
				 findNotice(0);
			}
			
			@Override
			public void filterFailureMsg(String failureMsg) {
				ToastUtil.shortShow(NoticeActivity.this, failureMsg);
			}
		});
	}
	
}
