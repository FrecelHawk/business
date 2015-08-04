package cn.caregg.o2o.business.ui.fragment;


import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.config.ConstantValues;
import cn.caregg.o2o.business.engine.page.constant.MyselfFragmentConstant;
import cn.caregg.o2o.business.ui.activity.AccessInfo;
import cn.caregg.o2o.business.ui.activity.BusinessInfoActivity;
import cn.caregg.o2o.business.ui.activity.NoticeActivity;
import cn.caregg.o2o.business.ui.activity.SuggestionFeedbackActivity;
import cn.caregg.o2o.business.ui.activity.UserSearchActivity;
import cn.caregg.o2o.business.ui.base.BaseFragment;
import cn.caregg.o2o.business.utils.ActivityStartUtil;
import cn.caregg.o2o.business.utils.PhoneUtil;
import cn.caregg.o2o.business.utils.ResourceUtils;
import cn.caregg.o2o.business.utils.ToastUtil;
import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @ClassName: MyselfFragment  
 * @Description: TODO   我的界面
 * @author FH 
 * @date 2015年7月20日 上午9:58:23
 * 
*/
@SuppressLint("InflateParams")
public class MyselfFragment extends BaseFragment {

	
	private View view;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		initView(inflater);
		return view;
	}

	public void initView(LayoutInflater inflater) {
		view = inflater.inflate(R.layout.carnest_myself_fragement, null);
		initialBusinessHead();
		initialTabView();
		view.findViewById(R.id.call_custom_service).setOnClickListener(new OnClick());
	}

	@SuppressWarnings("unused")
	private void initialBusinessHead() {
		ViewGroup  viewGroup = (ViewGroup) view.findViewById(R.id.business_head);
		ImageView  imageView = (ImageView) viewGroup.findViewById(R.id.business_head_sculpture); 
		((TextView)viewGroup.findViewById(R.id.textView1)).setText("商家名称");
		((TextView) viewGroup.findViewById(R.id.textView2))
				.setText(ResourceUtils.getStringFormat(
						R.string.business_myself_phone_numer,
						new Object[]{"1333499135"}));
		viewGroup.setOnClickListener(new SelecteListener());
	}

	private void initialTabView() {
		for(int i=0;i<MyselfFragmentConstant.tabs.length;i++){
			ViewGroup  viewGroup = (ViewGroup) view.findViewById(MyselfFragmentConstant.tabs[i]);
			Drawable drawable = ResourceUtils.getDrawable(MyselfFragmentConstant.imags[i]);
			((ImageView)viewGroup.findViewById(R.id.imageView1)).setImageDrawable(drawable);
			((TextView)viewGroup.findViewById(R.id.textView1)).setText(MyselfFragmentConstant.tabTxts[i]);
			viewGroup.setOnClickListener(new SelecteListener());
		}
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	/** 
	 * @author FH
	 * @Description: TODO  打电话给客服
	 * @throws:throws
	*/ 
	
	
	public void callCustomService(){
		ToastUtil.longShow(getActivity(), "打电话");
		PhoneUtil.callPhone(getActivity(), ConstantValues.CUSTOM_SERVICE_PHONE);
	}
	
	
	private class OnClick  implements OnClickListener{

		@Override
		public void onClick(View v) {
            callCustomService();
		}
		
	}
	
	
	private  class  SelecteListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.business_head:
				  ActivityStartUtil.start(getActivity(), BusinessInfoActivity.class);
				break;
			case R.id.select_tab1:
				  ActivityStartUtil.start(getActivity(), NoticeActivity.class);break;
			case R.id.select_tab3:
				  ActivityStartUtil.start(getActivity(),UserSearchActivity.class);break;
			case R.id.select_tab4:
				  ActivityStartUtil.start(getActivity(), SuggestionFeedbackActivity.class);
				   break;
			case R.id.select_tab5:
				  ActivityStartUtil.start(getActivity(), AccessInfo.class);break;
			default:
				break;
			}
		}
		
	}
}
