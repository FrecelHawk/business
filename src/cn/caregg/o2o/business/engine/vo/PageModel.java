package cn.caregg.o2o.business.engine.vo;

import java.util.List;

/**
 * @ClassName: Paging
 * @Description: TODO  分页	
 * @author FH 
 * @date 2015年7月30日 下午5:23:45
 * 
*/

public class PageModel<E> {

//	结果集
	private List<E> dataList;

//	当前页面
	private String pageId;
	
//	页面条数
	private String pageSize;

	public List<E> getDataList() {
		return dataList;
	}

	public void setDataList(List<E> dataList) {
		this.dataList = dataList;
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "PageModel [dataList=" + dataList + ", pageId=" + pageId
				+ ", pageSize=" + pageSize + "]";
	}
	
	
	
	
}
