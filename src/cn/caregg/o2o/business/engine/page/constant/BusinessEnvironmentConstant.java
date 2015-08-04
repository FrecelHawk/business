package cn.caregg.o2o.business.engine.page.constant;

import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.utils.ResourceUtils;

public interface BusinessEnvironmentConstant {

//	 图片
	 public int[] imgs={R.drawable.carnest_business_anteroom,
	            R.drawable.carnest_business_free_drink,
	            R.drawable.carnest_business_free_wifi,
	            R.drawable.carnest_specially_preson_receive,
	            R.drawable.carnest_business_computer_internet,
	            R.drawable.carnest_business_special_stop,
	            R.drawable.carnest_business_airwave};
//	 文本
	 public String[] txts = ResourceUtils.getStringArray(R.array.envrionment_tabTxts);
	 
//	 标签
	 public int[]  tabs = {R.id.tab1,R.id.tab2,R.id.tab3,R.id.tab4,R.id.tab5,R.id.tab6,R.id.tab7};
}
