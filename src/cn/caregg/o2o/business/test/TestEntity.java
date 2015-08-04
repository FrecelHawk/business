package cn.caregg.o2o.business.test;

import java.util.Map;

/**
 * @ClassName: TestEntity
 * @Description: TODO
 * @author FH 
 * @date 2015年7月30日 下午5:48:28
 * 
*/

public class TestEntity<E> {

	private String state;
	
	private String message;
	
	private String data;


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
	
	
}
