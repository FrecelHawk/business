package cn.caregg.o2o.business.test;

import java.util.Map;

/**
 * @ClassName: TestEntity
 * @Description: TODO
 * @author FH 
 * @date 2015年7月30日 下午5:48:28
 * 
*/

public class TestEntity {

	private String state;
	
	private String message;
	
	private Map<String,Object> data;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	
	
}
