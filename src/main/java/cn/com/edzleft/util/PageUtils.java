package cn.com.edzleft.util;

public class PageUtils {
    public static PageObj getPage(int page,int pageSize){
	PageObj pageObj = new PageObj();
	pageObj.setPage(page);
	pageObj.setPageSize(pageSize);
	return pageObj;
    }
}
