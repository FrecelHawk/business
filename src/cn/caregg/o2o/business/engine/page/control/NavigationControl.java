package cn.caregg.o2o.business.engine.page.control;

import android.view.View.OnClickListener;
import cn.caregg.o2o.business.engine.page.impl.NoticeNavigationBar;
import cn.caregg.o2o.business.engine.page.inf.NavigationInf;

/**
 * @ClassName: NavigationControl
 * @Description: TODO  导航栏控制
 * @author FH 
 * @date 2015年7月16日 下午2:52:31
 * 
*/

public class NavigationControl {

	private NavigationInf  navigationInf;

	public NavigationControl setNavigationInf(NavigationInf navigationInf) {
		this.navigationInf = navigationInf;
		return this;
	}
	
	public NavigationControl setTitle(String title){
		navigationInf.setTitle(title);
		return this;
	}
	
	public NavigationControl  hideNavigation(){
		navigationInf.hide();
		return this;
	}
	
	public NavigationControl showNavigation(){
		navigationInf.show();
		return this;
	}
	
	public NavigationControl showArrow(){
		navigationInf.showArrow();
		return this;
	}
	
	public NavigationControl hideArrow(){
		navigationInf.hideArrow();
		return this;
	}
	
	public NavigationControl  noticeNavigation(OnClickListener listener){
		((NoticeNavigationBar)navigationInf).onClick(listener);
		return this;
	}
	
}
