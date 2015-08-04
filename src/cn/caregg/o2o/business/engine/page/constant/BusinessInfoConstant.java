package cn.caregg.o2o.business.engine.page.constant;

import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.utils.ResourceUtils;

public interface BusinessInfoConstant {

//	标签图片
	public int[] imags = { R.drawable.carnest_position,
			R.drawable.carnest_contact_pattern,
			R.drawable.carnest_business_date,
			R.drawable.carnest_business_envrionment,
			R.drawable.carnest_business_describe,
			R.drawable.carnest_business_withdraw_deposit };
	

//	标签文本
	public String[] tabTxts = ResourceUtils.getStringArray(R.array.business_info_tab);
	
//	标签 
	public int[] tabs = {R.id.tab1,R.id.tab2,R.id.tab3,R.id.tab4,R.id.tab5,R.id.tab6};
	
}
