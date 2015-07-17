package cn.caregg.o2o.business.ui.activity;

import java.util.ArrayList;
import java.util.List;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.page.NavigationControl;
import cn.caregg.o2o.business.engine.page.impl.NavigationBar;
import cn.caregg.o2o.business.ui.base.BaseActivity;
import cn.caregg.o2o.business.utils.ResourceUtils;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @ClassName: NavigationManagerActivity
 * @Description: TODO  处理导航
 * @author FH 
 * @date 2015年7月14日 下午2:28:27
 * 
*/

@ContentView(R.layout.carnest_navigation_manager)
public class NavigationManagerActivity extends BaseActivity {

	
   @ViewInject(R.id.top_navigation)
   private ViewGroup  navigation;
   
   private int oldIndex=0;
   
// 底部导航Tab
   private int[] ngTabs = {R.id.navigation_tab1,R.id.navigation_tab2,R.id.navigation_tab3,R.id.navigation_tab4};
   
// 底部导航Img
   private int[] ngImgs = {R.drawable.carnest_order_tab,R.drawable.carnest_bill_tab,R.drawable.carnest_evaluate_tab,R.drawable.carnest_myself_tab};
   
// 底部导航效果
   private int[] ngImgPress = {R.drawable.carnest_order_tab_press,R.drawable.carnest_bill_tab_press,R.drawable.carnest_evaluate_tab_press,R.drawable.carnest_myself_tab_press};

   
   private String[] tabtxt = ResourceUtils.getStringArray(R.array.tabTxt);


   private List<TextView>  tabs = new ArrayList<TextView>();
   
   
   
   @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
		initialTab();
		new NavigationControl()
		     .setNavigationInf(new NavigationBar(navigation, NavigationManagerActivity.this))
		     .setTitle("主页");
	}


	private void initialTab() {
		for(int index=0;index<ngTabs.length;index++){
			 TextView txtView = (TextView) findViewById(ngTabs[index]);
			 txtView.setText(tabtxt[index]);
			 Drawable drawable = ResourceUtils.getDrawable(ngImgs[index]);
			 txtView.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
			 txtView.setOnClickListener(new NavigationListener());
			 tabs.add(txtView);
		}
		
	}
	
	
	private int touchTab(int index){
		 hideOldTab();
		 setTab(tabs.get(index),
				ResourceUtils.getColor(R.color.navigation_font_blue),
				ngImgPress[index]);
		 return index;
	}
   

	private void hideOldTab() {
		setTab(tabs.get(oldIndex),
				ResourceUtils.getColor(R.color.navigation_font_gray),
				ngImgs[oldIndex]);
	}


	private void setTab(TextView tv,int color,int press){
          tv.setTextColor(color); 
		 Drawable drawable = ResourceUtils.getDrawable(press);
		 tv.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
	}
	
	
	private class  NavigationListener  implements OnClickListener{

		@Override
		public void onClick(View v) {
			 for(int index=0;index<ngTabs.length;index++){
				  if(v.getId()==ngTabs[index]){
					  oldIndex = touchTab(index); break;
				  }
					   
			 }
		}
		
	};
}
