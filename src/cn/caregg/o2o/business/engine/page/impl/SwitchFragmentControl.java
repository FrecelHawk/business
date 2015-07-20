package cn.caregg.o2o.business.engine.page.impl;

import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.page.inf.SwtichFragment;
import cn.caregg.o2o.business.ui.base.BaseFragment;
import cn.caregg.o2o.business.ui.base.BaseFragmentActivity;
import cn.caregg.o2o.business.utils.ResourceUtils;

/**
 * @ClassName: SwitchFragmentControl
 * @Description: TODO
 * @author FH 
 * @date 2015年7月20日 下午12:52:30
 * 
*/

public class SwitchFragmentControl {

	private static SwtichFragment fragment;
	
	static {
		fragment = new SwtichFragmentHandler();
		try {
			generateFragment();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void generateFragment() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		String[] classNames = ResourceUtils.getStringArray(R.array.main_fragment);
		for(int i=0;i<classNames.length;i++){
			 fragment.addFragment((BaseFragment)Class.forName(classNames[i]).newInstance());
		}
	}
	
	public static void remove(BaseFragment baseFragment){
		fragment.removeFragment(baseFragment);
	}
	
	
	public static void swtichFragment(BaseFragmentActivity activity,Class<?> before,Class<?> alter){
		 fragment.swtichFragment(activity,before, alter);
	}
}
