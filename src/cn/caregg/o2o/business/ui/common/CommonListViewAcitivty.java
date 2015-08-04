package cn.caregg.o2o.business.ui.common;

import java.util.List;

import me.maxwin.view.XListView.IXListViewListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.caregg.o2o.business.ui.base.BaseActivity;
import cn.caregg.o2o.business.ui.base.BaseListAdapter;
import cn.caregg.o2o.business.ui.view.CommonListView;
import cn.caregg.o2o.business.utils.DateUtils;
import cn.caregg.o2o.business.utils.DelayTask;
import cn.caregg.o2o.business.utils.DelayedHandler;

/**
 * @ClassName: CommonListViewAcitivty
 * @Description: TODO  通用 ListView 
 * @author FH 
 * @date 2015年8月3日 下午2:00:45
 * 
*/

public abstract class CommonListViewAcitivty extends BaseActivity implements IXListViewListener{

	
	private static final String ACTION = "cn.carnest.pull";
	
	private CommonListView listView;
	
    protected volatile int page=1;
	
	protected int  rows=10;
	
	private UpdateDataRecevier  updateData;
	
	protected  BaseListAdapter<?> adapter;
	
	
	protected List<?>  list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	
	protected <E> void loadDataSource(CommonListView listView,BaseListAdapter<E> adapter,List<E> list){
		this.listView = listView;
		this.adapter = adapter;
		this.list = list;
		initiView();
	}
	
	
	
	private void initiView() {
		listView.setPullRefreshEnable(false);
		listView.setPullLoadEnable(true);
		listView.setXListViewListener(this);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new ItemClick());
		registerBroadcast();
		pullData(page);
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
	 * @author FH
	 * @Description: TODO void  注册广播
	 * @throws:throws
	*/ 
	
	public void registerBroadcast() {
		updateData = new UpdateDataRecevier();
		IntentFilter filter = new IntentFilter();
		filter.addAction(ACTION);
		registerReceiver(updateData, filter);
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
			enterDetail(position);
		}
		
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
			pullData(page);
		}

	}, 2000);
	}
	
	
	protected void  stopRefresh(){
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
	 * @Description: TODO   进入详情界面
	 * @param position void 
	 * @throws:throws
	*/ 
	
	protected abstract void enterDetail(int position);

	/** 
	 * @author FH
	 * @Description: TODO  拉取数据
	 * @param page void    当前页数
	 * @throws:throws
	*/ 
	
	protected abstract void pullData(int page);
		
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		unregisterReceiver(updateData);
		updateData = null;
		list = null;
		adapter = null;
	}

}
