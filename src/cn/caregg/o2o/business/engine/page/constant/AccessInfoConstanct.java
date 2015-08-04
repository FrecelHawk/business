package cn.caregg.o2o.business.engine.page.constant;

import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.utils.ResourceUtils;

public interface AccessInfoConstanct {

	//文本
	public String[]  txts = ResourceUtils.getStringArray(R.array.accessInfo_tabTxts);

    //图片	
	public int[]  images = {R.drawable.carnest_access_phone,R.drawable.carnest_access_pwd,R.drawable.carnest_access_update};

    //标签
	public int[] tabs = {R.id.tab1,R.id.tab2,R.id.tab3};
	
}
