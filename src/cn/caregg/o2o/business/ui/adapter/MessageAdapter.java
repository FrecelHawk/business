package cn.caregg.o2o.business.ui.adapter;

import java.util.List;

import android.content.Context;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.vo.NoticeInfo;
import cn.caregg.o2o.business.ui.base.BaseListAdapter;
import cn.caregg.o2o.business.utils.DateUtils;
import cn.caregg.o2o.business.utils.StringUtils;

public class MessageAdapter extends BaseListAdapter<NoticeInfo> {

	
	
	public MessageAdapter(Context context, List<NoticeInfo> list) {
		super(context, list);
	}

	@Override
	public View infalterView(int position, View convertView, ViewGroup parent) {
		ViewHolder  holder= null;
		if(convertView == null){
			convertView = View.inflate(context, R.layout.carnest_news_item, null);
			holder = new ViewHolder();
//			setLayoutMargin(convertView);
			initView(convertView,holder);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.title.setText(StringUtils.imitStringLength(items.get(position)
				.getNoticeInfoTitle(), 10, "..."));
		
		holder.time.setText(DateUtils.setTimeDateMinute(items.get(position)
				.getNoticeInfoTime()));
		
		holder.context.setText(StringUtils.imitStringLength(items.get(position)
				.getNoticeInfoContent2(), 15, "..."));
		
		if(items.get(position).getNoticeInfoStatus().equals("1"))
			holder.falg.setVisibility(View.GONE);
		
		 return convertView;
	}
	
	



	/** 
	 * @author FH
	 * @Description: TODO 动态设置布局
	 * @throws  布局设置有问题
	*/ 
	
	public void setLayoutMargin(View convertView) {
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
				LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(0, 10, 0, 0);
		convertView.setLayoutParams(layoutParams);
	}

	public void initView(View convertView,ViewHolder holder) {
		holder.context = (TextView) convertView.findViewById(R.id.context);
		holder.time = (TextView) convertView.findViewById(R.id.textView2);
		holder.title = (TextView) convertView.findViewById(R.id.textView1);
		holder.icon = (ImageView) convertView.findViewById(R.id.imageView);
		holder.falg = convertView.findViewById(R.id.red_circle);
	}

	private class ViewHolder{
		TextView context;
		TextView title;
		TextView time;
		ImageView icon;
		View      falg;
	}
	
//	跟椐分类设置ICON
	enum  NoticeType{
		NOTICE(1),MESSAGE(2);
		
		private int  state;
		
		NoticeType(int state){
            this.state = state;			
		}
		
		
		public int getState(){
			return state;
		}
		
		
		public void switchIcon(int state){
			 switch(state){
			    case 1:break;
			    case 2:break;
			    default:;
			 }
		}
		
		
	}
	
	
	
}
