package cn.caregg.o2o.business.ui.adapter;


import java.util.List;

import cn.caregg.o2o.business.R;
import cn.caregg.o2o.business.engine.vo.UserInfo;
import cn.caregg.o2o.business.ui.base.BaseListAdapter;
import cn.caregg.o2o.business.ui.view.RoundImageView;
import cn.caregg.o2o.business.utils.DateUtils;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class UserAdapter extends BaseListAdapter<UserInfo>{

	public UserAdapter(Context context, List<UserInfo> list) {
		super(context, list);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View infalterView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if(convertView==null){
			convertView = View.inflate(context, R.layout.carnest_user_info_itme, null);
			viewHolder = new ViewHolder();
			viewHolder.headSculpture=(RoundImageView) convertView.findViewById(R.id.roundImageView1);
			viewHolder.carId = (TextView) convertView.findViewById(R.id.textView1);
			viewHolder.time = (TextView) convertView.findViewById(R.id.textView4);
			viewHolder.name = (TextView) convertView.findViewById(R.id.textView3);
			viewHolder.phone = (TextView) convertView.findViewById(R.id.textView2);
			convertView.setTag(viewHolder);
		}else{
			viewHolder  = (ViewHolder) convertView.getTag();
		}
		
		initItem(position, viewHolder);
		
		return convertView;
	}

	public void initItem(int position, ViewHolder viewHolder) {
		Long  time = items.get(position).getLastLoginTime();
		viewHolder.carId.setText(items.get(position).getCarId());
		viewHolder.time.setText(time!=null?DateUtils.setTimeDateMinute(items.get(position).getLastLoginTime()):"");
		viewHolder.phone.setText(items.get(position).getOwnerTel());
		viewHolder.name.setText(items.get(position).getOwnerNickName());
	}

	
	private  static class ViewHolder{
		RoundImageView  headSculpture;
		
		TextView  carId;
		
		TextView  time;
		
		TextView  name;
		
		TextView  phone;
	}

}
