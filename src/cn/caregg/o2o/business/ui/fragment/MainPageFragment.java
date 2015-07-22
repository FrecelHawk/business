package cn.caregg.o2o.business.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.ui.activity.NavigationManagerActivity;
import cn.caregg.o2o.business.ui.base.BaseFragment;
import cn.caregg.o2o.business.utils.ResourceUtils;

import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * @ClassName: HomePageFragment
 * @Description: TODO         主页
 * @author FH 
 * @date 2015年7月20日 上午10:01:52
 * 
*/

@SuppressLint("InflateParams")
public class MainPageFragment extends BaseFragment {

	@ViewInject(R.id.top_navigation)
	private ViewGroup  navigation;
	
	private View view;
	
	
	private int[] imgTabs={R.drawable.carnest_main_income_menoy,
			               R.drawable.carnest_main_income_menoy,
			               R.drawable.carnest_main_check,
			               R.drawable.carnest_main_vehicle_cleaning,
			               R.drawable.carnest_main_cosmetology,
			               R.drawable.carnest_main_maintain};
	
	private int[]  tabs = { R.id.main_tab1,
				            R.id.main_tab2,
				            R.id.main_tab3,
				            R.id.main_tab4,
				            R.id.main_tab5,
				            R.id.main_tab6};
	private ViewGroup head;
	
	private ViewGroup  orderBar;
	
	
//	评论数
	private int  commentNumber=14;

	
	
	private String[] tabTxt =ResourceUtils.getStringArray(R.array.main_tabTxts);
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.carnest_business_main, null);
		
		head = (ViewGroup) view.findViewById(R.id.main_head);
		
		((NavigationManagerActivity)getActivity()).setBottomNavigationBackground(R.color.navigation_bottom_blue);
		
		initialOrderBar();
		
		initinalTab();
		return view;
	}

	private void initialOrderBar() {
		orderBar = (ViewGroup) view.findViewById(R.id.order_bar);
		((TextView)orderBar.findViewById(R.id.textView1)).setText("15");
		ViewGroup left = (ViewGroup) orderBar.findViewById(R.id.left);
		ViewGroup right = (ViewGroup) orderBar.findViewById(R.id.right);
		
		((TextView)left.findViewById(R.id.textView1)).setTextColor(ResourceUtils.getColor(R.color.main_order_font));
		((TextView)left.findViewById(R.id.textView1)).setText("16");
		right.setBackgroundResource(R.drawable.right_circle);
		((TextView)right.findViewById(R.id.textView1)).setText("18");
		((TextView)right.findViewById(R.id.textView2)).setText("今日订单");
	}

	private void initinalTab() {
		for(int i=0;i<tabs.length;i++){
			  ViewGroup viewGroup = (ViewGroup) view.findViewById(tabs[i]);
			  ((ImageView)viewGroup.findViewById(R.id.imageView1)).setImageDrawable(ResourceUtils.getDrawable(imgTabs[i]));
			  ((TextView)viewGroup.findViewById(R.id.textView1)).setText(tabTxt[i]);
			  viewGroup.setOnClickListener(new SeleteListener());
		}
	}
	
	
	
	private class SeleteListener  implements OnClickListener{

		@Override
		public void onClick(View v) {
			
		}
		
	}
	
	
}  
