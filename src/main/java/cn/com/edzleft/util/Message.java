package cn.com.edzleft.util;

public class Message implements java.io.Serializable
{
	private static final long serialVersionUID = -412095459773582659L;

	public static final int OP_SUCCESS = 0;
	public static final int OP_FAIL = 1;
	public static final int OP_ERROR = 2;

	protected int result;
	protected String message;
	protected Object data;
	protected PageObj page;

	public Message()
	{
		init();
	}

	public static Message newSuccessMessage(String msg)
	{
		Message message = new Message();
		message.setMessage(msg);
		message.setResult(OP_SUCCESS);
		return message;
	}

	public static Message showMessage(int result,String message ,Object data, PageObj page)
	{
		Message msg = new Message();
		msg.setResult(result);
		if (message != null)
			msg.setMessage(message);
		if (page != null)
			msg.setPage(page);
		if(data!=null)
			msg.setData(data);
		return msg;
	}

	public static Message showSuccessMessage(String message, Object data , PageObj page)
	{
		return showMessage(OP_SUCCESS, message,data , page);
	}

	public static Message showSuccessMessage(Object data)
	{
		return showMessage(OP_SUCCESS, null,data, null);
	}

	public static Message newErrorMessage(String msg)
	{

		Message message = new Message();
		message.setMessage(msg);
		message.setResult(OP_FAIL);
		return message;
	}

	public static Message newErrorMessage1(String msg, Integer errorCode)
	{

		Message message = new Message();
		message.setMessage(msg);
		message.setResult(OP_FAIL);
		return message;
	}

	public static PageObj initPageObj(Long totalCount, int page, int pageSize)
	{
		if (totalCount == null)
			return null;
		int inttotalCount = totalCount.intValue();
		PageObj pageObj = new PageObj();
		if (pageSize <= 0)
			pageSize = -1;
		int pageCount = pageSize == -1 ? 1 : inttotalCount % pageSize == 0 ? inttotalCount / pageSize : inttotalCount / pageSize + 1;
		pageObj.setTotalCount(inttotalCount);
		pageObj.setPageCount(pageCount);
		pageObj.setPageSize(pageSize);
		pageObj.setPage(page);
		return pageObj;
	}

	public void init()
	{
		result = OP_SUCCESS;
		message = "";
		page = null;
	}

	public int getResult()
	{
		return result;
	}

	public void setResult(int result)
	{
		this.result = result;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public Object getData()
	{
		return data;
	}

	public void setData(Object data)
	{
		this.data = data;
	}

	public PageObj getPage() {
		return page;
	}

	public void setPage(PageObj page) {
		this.page = page;
	}

	@Override
	public String toString()
	{
		return "Message [result=" + result + ", message=" + message + ", data="+ data +", page=" + page + "]";
	}

}
