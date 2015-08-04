package cn.caregg.o2o.business.engine.page.impl;

import java.util.HashMap;
import java.util.Map;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.page.inf.SwtichFragment;
import cn.caregg.o2o.business.ui.base.BaseFragment;
import cn.caregg.o2o.business.ui.base.BaseFragmentActivity;

/**
 * @ClassName: SwtichFragmentHandler
 * @Description: TODO
 * @author FH 
 * @date 2015年7月20日 上午10:52:16
 * 
*/

public class SwtichFragmentHandler implements SwtichFragment {

    
    private static final int TAB_CONTENT = R.id.tab_content;
    
    
	 volatile Map<String,BaseFragment>  fragments = new HashMap<String, BaseFragment>();
    
     public void addFragment(BaseFragment baseFragment){
    	 if(null==baseFragment){
 			throw new NullPointerException();
 		}
    	 fragments.put(baseFragment.getClass().getSimpleName(),baseFragment);
     }
     
     
     public void removeFragment(BaseFragment baseFragment){
    	 if(null==baseFragment){
  			throw new NullPointerException();
  		}
    	 fragments.remove(baseFragment);
     }
     
     
     
    /**
     * 每次使用Replace的时候，Fragment都会重新实例化，重新加载一边数据
     * */
    public void showFragment(BaseFragmentActivity activity,Class<?> fragment){
      	FragmentTransaction transaction = getTransaction(activity);
		transaction.replace(TAB_CONTENT,
				fragments.get(fragment.getSimpleName())).commitAllowingStateLoss();
    	
    } 
     
	
	public void swtichFragment(BaseFragmentActivity activity,Class<?> before,Class<?> alter){
		swtich(activity, fragments.get(before.getSimpleName()),
				fragments.get(alter.getSimpleName()));
	   
	}
	
	/**
	 * Fragment 页面切换
	 *  使用Fragment切换 调用add()与hide()，就不用重新实例化从而消耗性能
	 * */
	public void swtich(BaseFragmentActivity  activity,BaseFragment before,BaseFragment alter) {
		if(null==before||null==alter||before.equals(alter)) return ;
		FragmentManager manager = activity.getSupportFragmentManager();
		FragmentTransaction transaction = getTransaction(manager);
		transaction.hide(before);
		if(!alter.isAdded())
			  transaction.add(TAB_CONTENT, alter,alter.getClass().getSimpleName());
		   else
		  	  transaction.show(alter);
		transaction.commitAllowingStateLoss();
	}


	private FragmentTransaction getTransaction(BaseFragmentActivity activity) {
		FragmentManager fragmentManager = activity.getSupportFragmentManager();
		return getTransaction(fragmentManager);
	}


	public FragmentTransaction getTransaction(FragmentManager fragmentManager) {
		FragmentTransaction transaction = fragmentManager.beginTransaction().setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
		return transaction;
	}
	
	
	
	

    
}
