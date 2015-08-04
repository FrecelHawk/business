package cn.caregg.o2o.business.ui.base;

import cn.caregg.o2o.business.app.BusinessApplication;
import cn.caregg.o2o.business.engine.page.inf.ReleaseActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * @ClassName: BaseFragmentActivity
 * @Description: TODO
 * @author FH 
 * @date 2015年7月20日 上午10:50:23
 * 
*/

public class BaseFragmentActivity extends FragmentActivity implements ReleaseActivity{

	private FinishReceiver finishReceiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		BusinessApplication.releaseList.add(getFinishId());
		finishReceiver = new FinishReceiver();
		finishReceiver();
	}
	
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		BusinessApplication.releaseList.remove(getFinishId());
		unregisterReceiver(finishReceiver);
	}
	
	
	public String getFinishId(){
		return this.getClass().getSimpleName();
	};
	
	
	
	@Override
	public void finishReceiver() {
		IntentFilter filter = new IntentFilter(getFinishId());
		filter.setPriority(Integer.MAX_VALUE);
		registerReceiver(finishReceiver, filter);
	}
	
	
	 protected  class FinishReceiver extends BroadcastReceiver{

			@Override
			public void onReceive(Context context, Intent intent) {
				if (getFinishId().
						equals(intent.getAction()))
					      finish();
			}
	    	
	  }

	 
	 protected void finishFragmentActivity(String action){
		 this.sendBroadcast(new Intent(action));
	 }
	
}
