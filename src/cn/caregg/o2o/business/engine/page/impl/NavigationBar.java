package cn.caregg.o2o.business.engine.page.impl;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.page.inf.NavigationInf;

/**
 * @ClassName: NavigationBar
 * @Description: TODO
 * @author FH 
 * @date 2015年7月17日 下午1:43:11
 * 
*/

public class NavigationBar implements NavigationInf {

 
	private ImageView  leftarrow;
	
	private TextView  tv;
	
	private ViewGroup viewGroup;
	
	private Activity  activity;
	
	public ImageView getLeftarrow() {
		return leftarrow;
	}

	public void setLeftarrow(ImageView leftarrow) {
		this.leftarrow = leftarrow;
	}

	public TextView getTv() {
		return tv;
	}

	public void setTv(TextView tv) {
		this.tv = tv;
	}

	public ViewGroup getViewGroup() {
		return viewGroup;
	}

	public void setViewGroup(ViewGroup viewGroup) {
		this.viewGroup = viewGroup;
	}

	
    public NavigationBar(ViewGroup viewGroup,Activity activity) {
    	this.viewGroup = viewGroup;
    	this.activity = activity;
    	initalView();
	}
	
    protected void initalView(){
    	leftarrow = (ImageView)viewGroup.findViewById(R.id.imageView);
    	tv = (TextView) viewGroup.findViewById(R.id.textView);
    	leftarrow.setOnClickListener(new BackListener());
    }
	
	@Override
	public void show() {
		viewGroup.setVisibility(View.VISIBLE);
	}

	@Override
	public void hide() {
        viewGroup.setVisibility(View.GONE);
	}

	@Override
	public void setTitle(String title) {
         tv.setText(title);
	}
	
	private class  BackListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			    //activity.sendBroadcast(new Intent(activity.getFinishId()));
			   // BusinessApplication.cleanAll();
			   activity.finish();
     		}
		
	};

}
