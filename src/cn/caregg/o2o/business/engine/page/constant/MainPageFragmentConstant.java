package cn.caregg.o2o.business.engine.page.constant;

import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.utils.ResourceUtils;

public interface MainPageFragmentConstant {

//	标签图片
	public int[] imgTabs={R.drawable.carnest_main_income_menoy,
				            R.drawable.carnest_main_income_menoy,
				            R.drawable.carnest_main_check,
				            R.drawable.carnest_main_vehicle_cleaning,
				            R.drawable.carnest_main_cosmetology,
				            R.drawable.carnest_main_maintain};
//	标签
	public int[]  tabs = { R.id.main_tab1,
				            R.id.main_tab2,
				            R.id.main_tab3,
				            R.id.main_tab4,
				            R.id.main_tab5,
				            R.id.main_tab6};
//	标签文本
	public String[] tabTxt =ResourceUtils.getStringArray(R.array.main_tabTxts);
}
