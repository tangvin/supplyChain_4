package cn.com.edzleft.entity;

import java.util.List;

public class DataTableEntity {
	public DataTableEntity() {
	}

	public DataTableEntity(Integer draw, Integer total, List<?> pageData) {
		this.draw = draw;
		this.total = total;
		this.pageData = pageData;
	}
	public DataTableEntity(Integer draw, Integer pageNumber, Integer total, List<?> pageData) {
		this.draw = draw;
		this.total = total;
		this.pageData = pageData;
		this.pageNumber=pageNumber;
	}

	private Integer draw;//表示请求次数

	private Integer total;//总记录数

	private Integer pageNumber;//当前页数

	private List<?> pageData;//具体的数据对象数组

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<?> getPageData() {
		return pageData;
	}

	public void setPageData(List<?> pageData) {
		this.pageData = pageData;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
}
