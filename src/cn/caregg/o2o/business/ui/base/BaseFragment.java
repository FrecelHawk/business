package cn.caregg.o2o.business.ui.base;

import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.page.inf.SwtichFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


/**
 * @ClassName: BaseFragment
 * @Description: TODO
 * @author FH 
 * @date 2015年7月13日 上午11:19:24
 * 
*/

public class BaseFragment extends Fragment  {

	
	
//	/**
//	 * Fragment 页面切换
//	 * */
//	public void swtich(BaseFragmentActivity  activity,BaseFragment fragment) {
//	    if(!fragment.equals(this)) return;
//	
//		FragmentManager fragmentManager = activity.getSupportFragmentManager();
//		FragmentTransaction transaction = fragmentManager.beginTransaction().setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
//		transaction.replace(R.id.tab_content, this, fragment.getClass().getSimpleName());
//		if(!fragment.isAdded())
//			  transaction.hide(this).add(R.id.tab_content, fragment).commit();
//		   else
//		  	  transaction.hide(this).show(fragment).commit();
//		
//	}

}
