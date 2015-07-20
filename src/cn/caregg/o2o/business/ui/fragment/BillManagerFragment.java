package cn.caregg.o2o.business.ui.fragment;

import android.os.Bundle;
import android.widget.Toast;
import cn.caregg.o2o.business.ui.base.BaseFragment;

/**
 * @ClassName: BillManagerFragment
 * @Description: TODO       账单管理
 * @author FH 
 * @date 2015年7月20日 上午10:03:45
 * 
*/

public class BillManagerFragment extends BaseFragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Toast.makeText(getActivity().getBaseContext(), "账单", Toast.LENGTH_LONG).show();
	}
}
