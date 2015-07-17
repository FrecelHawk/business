package cn.caregg.o2o.business.ui.base;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import cn.caregg.o2o.business.app.BusinessApplication;
import cn.caregg.o2o.business.engine.page.inf.ReleaseActivity;

public class BaseActivity extends Activity implements ReleaseActivity{

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

	 
	 protected void finishActivity(String action){
		 this.sendBroadcast(new Intent(action));
	 }
}
