package cn.caregg.o2o.business.engine.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: MainPage
 * @Description: TODO  首页
 * @author FH 
 * @date 2015年8月5日 上午9:47:20
 * 
*/

public class MainPage {
//	待处理订单数量
	private String suspendOrderNumber;
	
//	昨日营业收入
	private String yesterdayMoney; 	
	
//	可提款金额
	private String drawingsMoney;
	
//	本周营业收入
	private String thisWeekMoney;
	
//	今日订单
	private String todayOrderNumber;
	
//	未读消息数量
	private String messgeNumber;
	
//	商家服务数量分组统计
	private List<Map<String,String>>  serviceList = new ArrayList<Map<String,String>>();

	public String getSuspendOrderNumber() {
		return suspendOrderNumber;
	}

	public void setSuspendOrderNumber(String suspendOrderNumber) {
		this.suspendOrderNumber = suspendOrderNumber;
	}

	public String getYesterdayMoney() {
		return yesterdayMoney;
	}

	public void setYesterdayMoney(String yesterdayMoney) {
		this.yesterdayMoney = yesterdayMoney;
	}

	public String getDrawingsMoney() {
		return drawingsMoney;
	}

	public void setDrawingsMoney(String drawingsMoney) {
		this.drawingsMoney = drawingsMoney;
	}

	public String getThisWeekMoney() {
		return thisWeekMoney;
	}

	public void setThisWeekMoney(String thisWeekMoney) {
		this.thisWeekMoney = thisWeekMoney;
	}

	public String getTodayOrderNumber() {
		return todayOrderNumber;
	}

	public void setTodayOrderNumber(String todayOrderNumber) {
		this.todayOrderNumber = todayOrderNumber;
	}

	public String getMessgeNumber() {
		return messgeNumber;
	}

	public void setMessgeNumber(String messgeNumber) {
		this.messgeNumber = messgeNumber;
	}

	public List<Map<String, String>> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<Map<String, String>> serviceList) {
		this.serviceList = serviceList;
	}

	@Override
	public String toString() {
		return "MainPage [suspendOrderNumber=" + suspendOrderNumber
				+ ", yesterdayMoney=" + yesterdayMoney + ", drawingsMoney="
				+ drawingsMoney + ", thisWeekMoney=" + thisWeekMoney
				+ ", todayOrderNumber=" + todayOrderNumber + ", messgeNumber="
				+ messgeNumber + ", serviceList=" + serviceList + "]";
	}
	
	
}
