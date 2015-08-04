package cn.caregg.o2o.business.engine.page.inf;


/**
 * @ClassName: NavigationInf
 * @Description: TODO
 * @author FH 
 * @date 2015年7月14日 下午7:13:43
 * 
*/

public interface NavigationInf {

	public void  show();
	
	public void  hide();
	
	public void setTitle(String title);
	
	public void  hideArrow();
	
	public void  showArrow();
	
}
