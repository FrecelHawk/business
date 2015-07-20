package cn.caregg.o2o.business.engine.page.inf;

import cn.caregg.o2o.business.ui.base.BaseFragment;
import cn.caregg.o2o.business.ui.base.BaseFragmentActivity;

public interface SwtichFragment {

	public void swtichFragment(BaseFragmentActivity activity,Class<?> before,Class<?> alter);
	
	public void addFragment(BaseFragment baseFragment);
	
	public void showFragment(BaseFragmentActivity activity,Class<?> clazz);
	
	public void removeFragment(BaseFragment baseFragment);
}
