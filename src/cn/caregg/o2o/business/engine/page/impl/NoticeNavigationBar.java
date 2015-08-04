package cn.caregg.o2o.business.engine.page.impl;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.page.inf.NavigationInf;

/**
 * @ClassName: NoticeNavigationBar
 * @Description: TODO  通知导航 ,后面在做。
 * @author FH 
 * @date 2015年7月31日 下午3:10:46
 * 
*/

public class NoticeNavigationBar implements NavigationInf {

	private TextView  rightTV;
	
	private ImageView  leftarrow;
	
	private TextView  tilte;
	
	private ViewGroup viewGroup;
	
	private Activity  activity;
	
	
	public NoticeNavigationBar(ViewGroup viewGroup,Activity activity){
		this.viewGroup = viewGroup;
		this.activity = activity;
		initView();
	}
	
	
	public void initView(){
		this.leftarrow = (ImageView) viewGroup.findViewById(R.id.imageView);
		this.tilte = (TextView) viewGroup.findViewById(R.id.textView);
		this.rightTV = (TextView) viewGroup.findViewById(R.id.falg);
		this.leftarrow.setOnClickListener(new BackListener());
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
        this.tilte.setText(title);
	}

	@Override
	public void hideArrow() {
        this.leftarrow.setVisibility(View.GONE);
	}

	@Override
	public void showArrow() {
         this.leftarrow.setVisibility(View.VISIBLE);
	}
	
	private class  BackListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			   activity.finish();
     		}
		
	}

	public void onClick(OnClickListener clickListener) {
		 rightTV.setOnClickListener(clickListener);
	}

}
