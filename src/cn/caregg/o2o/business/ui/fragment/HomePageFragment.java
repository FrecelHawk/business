package cn.caregg.o2o.business.ui.fragment;

import com.lidroid.xutils.view.annotation.ViewInject;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.page.control.NavigationControl;
import cn.caregg.o2o.business.engine.page.impl.NavigationBar;
import cn.caregg.o2o.business.ui.activity.NavigationManagerActivity;
import cn.caregg.o2o.business.ui.base.BaseFragment;

/**
 * @ClassName: HomePageFragment
 * @Description: TODO         主页
 * @author FH 
 * @date 2015年7月20日 上午10:01:52
 * 
*/

public class HomePageFragment extends BaseFragment {

	@ViewInject(R.id.top_navigation)
	private ViewGroup  navigation;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		Toast.makeText(getActivity().getBaseContext(), "主页", Toast.LENGTH_LONG).show();
	}
}
