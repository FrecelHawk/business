package cn.caregg.o2o.business.ui.base;


import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * @ClassName: BaseListAdapter
 * @Description: TODO  
 * @author FH 
 * @date 2015年7月30日 下午3:37:14
 * 
 * @param <E>
*/

public abstract class  BaseListAdapter<E> extends BaseAdapter {


	protected final Context context;
	protected LayoutInflater layoutInflater;
	protected final List<E> items;
	
	public BaseListAdapter(Context context,List<E> list) {
		this.context = context;
		this.items = list;
	}
	
	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return  getItem(position).hashCode();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return infalterView(position, convertView, parent);
	}

	public abstract View infalterView(int position,View convertView,ViewGroup parent);
}
