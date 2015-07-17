package cn.caregg.o2o.business.engine.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ResponseInfo
 * @Description: TODO
 * @author FH 
 * @date 2015年7月17日 上午11:58:34
 * 
*/

public class ResponseInfo {

	public ResponseInfo() {
	}
	
	private int state;
	private String message;
	private List<Map<Object,Object>> data = new ArrayList<Map<Object,Object>>();
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Map<Object, Object>> getData() {
		return data;
	}
	public void setData(List<Map<Object, Object>> data) {
		this.data = data;
	}
	
	
}
