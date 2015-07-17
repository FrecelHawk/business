package cn.caregg.o2o.business.engine.page.impl;

import java.util.List;
import java.util.Vector;

import android.database.Observable;

public class ResponseEvent<T> extends Observable<T>{

	private List<T> container = new Vector<T>();
	
	private boolean  changed = false;
	
	public void addEvnet(T event){
		if(null==event){
			throw new NullPointerException();
		}
	    if(container.contains(event))
				container.add(event);	
	}
	
	
	public void delEvent(T event){
	   container.remove(event);	
	}
	
	
	public void setChanged(){
	      changed = true;	
	}
	
	
	public boolean hasChanged(){
		return changed;
	}
}
