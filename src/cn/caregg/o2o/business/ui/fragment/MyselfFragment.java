package cn.caregg.o2o.business.ui.fragment;


import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.page.control.NavigationControl;
import cn.caregg.o2o.business.engine.page.impl.NavigationBar;
import cn.caregg.o2o.business.ui.activity.BusinessInfoActivity;
import cn.caregg.o2o.business.ui.activity.NavigationManagerActivity;
import cn.caregg.o2o.business.ui.base.BaseFragment;
import cn.caregg.o2o.business.utils.ActivityStartUtil;
import cn.caregg.o2o.business.utils.ResourceUtils;
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
	
//	选择条图片
	private int[] imags = { R.drawable.carnest_message,
			R.drawable.carnest_business, R.drawable.carnest_myself,
			R.drawable.carnest_feedback, R.drawable.carnest_logo };	 
	
//	选择条文本
	private String[]  tabTxts = ResourceUtils.getStringArray(R.array.business_myself_tab);
	
//	选择条布局
	private int[] tabs = { R.id.select_tab1, R.id.select_tab2,
			               R.id.select_tab3, R.id.select_tab4, 
			               R.id.select_tab5 };
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.carnest_myself_fragement, null);
		initialBusinessHead();
		initialTabView();
		System.out.println("test");
		return view;
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
		for(int i=0;i<tabs.length;i++){
			ViewGroup  viewGroup = (ViewGroup) view.findViewById(tabs[i]);
			Drawable drawable = ResourceUtils.getDrawable(imags[i]);
			((ImageView)viewGroup.findViewById(R.id.imageView1)).setImageDrawable(drawable);
			((TextView)viewGroup.findViewById(R.id.textView1)).setText(tabTxts[i]);
			viewGroup.setOnClickListener(new SelecteListener());
		}
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Toast.makeText(getActivity().getBaseContext(), "我的", Toast.LENGTH_SHORT).show();
	}
	
	
	private  class  SelecteListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.business_head:
				  ActivityStartUtil.start(getActivity(), BusinessInfoActivity.class);
				break;

			default:
				break;
			}
		}
		
	}
}
