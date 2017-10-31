package cn.com.edzleft.util;

public class PageObj
{
	public int page;

	public int pageSize;

	public int pageCount;

	public int totalCount;
	
	public int startIndex;

	public int getPage()
	{
		return page;
	}

	public void setPage(int page)
	{
		if (page <= 0)
		{
			this.page = 1;
		}else
		{
			this.page = page;
		}
	}

	public int getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	public int getPageCount()
	{
		return pageCount;
	}

	public void setPageCount(int pageCount)
	{
		this.pageCount = pageCount;
	}

	public int getTotalCount()
	{
		return totalCount;
	}

	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
	}

	public int getStartIndex() {
		if(page<2){
			this.startIndex = 0;
		}else{
			this.startIndex=(page-1)*pageSize;
		}
		return startIndex;
	}

	
	
	

}
