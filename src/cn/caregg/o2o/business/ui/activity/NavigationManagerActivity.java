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
import cn.caregg.o2o.business.engine.page.control.FragmentControl;
import cn.caregg.o2o.business.engine.page.control.NavigationControl;
import cn.caregg.o2o.business.engine.page.impl.NavigationBar;
import cn.caregg.o2o.business.ui.base.BaseFragmentActivity;
import cn.caregg.o2o.business.utils.ResourceUtils;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @ClassName: NavigationManagerActivity
 * @Description: TODO  导航管理
 * @author FH 
 * @date 2015年7月14日 下午2:28:27
 * 
*/

@ContentView(R.layout.carnest_navigation_manager)
public class NavigationManagerActivity extends BaseFragmentActivity {

	
   @ViewInject(R.id.top_navigation)
   private ViewGroup  navigation;
   
   private int oldIndex=0;
   
   private NavigationControl navigationControl;
   
   @ViewInject(R.id.bottom_navigation_layout)
   private ViewGroup  bottomNavigationLyaout;
   
   private String[]  fragmentNames = ResourceUtils.getStringArray(R.array.main_fragment);
   
// 底部导航Tab
   private int[] ngTabs = {R.id.navigation_tab1,R.id.navigation_tab2,R.id.navigation_tab3,R.id.navigation_tab4};
   
// 底部导航Img
   private int[] ngImgs = {R.drawable.carnest_home_tab,R.drawable.carnest_order_tab,R.drawable.carnest_bill_tab,R.drawable.carnest_myself_tab};
   
// 底部导航效果
	private int[] ngImgPress = { R.drawable.carnest_home_tab_press,
			R.drawable.carnest_order_tab_press,
			R.drawable.carnest_bill_tab_press,
			R.drawable.carnest_myself_tab_press };
   
   private String[] tabtxt = ResourceUtils.getStringArray(R.array.tabTxt);


   private List<TextView>  tabs = new ArrayList<TextView>();
   
   
   
   @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
		initialTab();
		navigationControl = new NavigationControl()
		     .setNavigationInf(new NavigationBar(navigation,NavigationManagerActivity.this))
		     .setTitle("主页")
		     .hideArrow();
		System.out.println("test");
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
		defaultSet();
	}


	private void defaultSet() {
		defaultInitialFragment();
		touchTab(oldIndex);
	}


	private void defaultInitialFragment() {
		try {
			FragmentControl.showFragment(NavigationManagerActivity.this, Class.forName(fragmentNames[oldIndex]));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	private void setTile(int index) {
		navigationControl.setTitle(tabtxt[index]);
	}
	
	private void switchFragment(int index) {
		try {
			FragmentControl.swtichFragment(NavigationManagerActivity.this, 
					  Class.forName(fragmentNames[oldIndex]), 
					  Class.forName(fragmentNames[index]));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	private class  NavigationListener  implements OnClickListener{

		@Override
		public void onClick(View v) {
			 for(int index=0;index<ngTabs.length;index++){
				  if(v.getId()==ngTabs[index]){
					  setTile(index);
					  switchFragment(index);
					  oldIndex = touchTab(index); 
					  break;
				  }
					   
			 }
		}


		
	};
	
	
	public void setBottomNavigationBackground(int reid){
		bottomNavigationLyaout.setBackgroundResource(reid);
	}
	
}
