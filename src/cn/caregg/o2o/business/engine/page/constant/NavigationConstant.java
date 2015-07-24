package cn.caregg.o2o.business.engine.page.constant;

import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.utils.ResourceUtils;

public interface NavigationConstant {

//  主页底部导航图片
	public int[]  navigationStillTabs = {   R.drawable.carnest_main_still_tab_press,
								            R.drawable.carnest_main_still_newspaper_tab,
								            R.drawable.carnest_main_still_money_tab,
								            R.drawable.carnest_main_still_myself_tab};
	
	// 底部导航效果
	public int[] ngImgPress = { R.drawable.carnest_home_tab_press,
								R.drawable.carnest_order_tab_press,
								R.drawable.carnest_bill_tab_press,
								R.drawable.carnest_myself_tab_press };
	
	// 底部导航Tab
	public int[] ngTabs = {R.id.navigation_tab1,R.id.navigation_tab2,
			               R.id.navigation_tab3,R.id.navigation_tab4};
	   

	
	// 底部导航Img
	public int[] ngImgs = {R.drawable.carnest_home_tab,
			               R.drawable.carnest_order_tab,
			               R.drawable.carnest_bill_tab,
			               R.drawable.carnest_myself_tab};
	
	
	public String[]  fragmentNames = ResourceUtils.getStringArray(R.array.main_fragment);

	   
	public String[] tabtxt = ResourceUtils.getStringArray(R.array.tabTxt);
	   
}
