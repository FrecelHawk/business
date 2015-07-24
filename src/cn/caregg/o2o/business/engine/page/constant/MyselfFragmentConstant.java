package cn.caregg.o2o.business.engine.page.constant;

import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.utils.ResourceUtils;

public interface MyselfFragmentConstant {

//	选择条图片
	public int[] imags = { R.drawable.carnest_message,
			R.drawable.carnest_business, R.drawable.carnest_myself,
			R.drawable.carnest_feedback, R.drawable.carnest_logo };	 
	
//	选择条布局
	public int[] tabs = { R.id.select_tab1, R.id.select_tab2,
			               R.id.select_tab3, R.id.select_tab4, 
			               R.id.select_tab5 };
	
//	选择条文本
	public String[]  tabTxts = ResourceUtils.getStringArray(R.array.business_myself_tab);
	
	

}
