package cn.com.edzleft.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bhcx.entity.SellerEntity;
import com.bhcx.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.alibaba.fastjson.JSONObject;

public abstract class BaseController
{
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	public static final String ERROR_MSG = "errMsg";
	protected HttpServletRequest request;
	protected HttpSession session;
	public static String SHOOT_SESSION = "ShootEntry";
	protected Message showSuccessMessage(Object data, PageObj page)
	{
		return showMessage(Message.OP_SUCCESS, null,data, page);
	}

	protected Message showMessage(int result, String message,Object data, PageObj page)
	{
		Message msg = new Message();
		msg.setResult(result);
		if (message != null)
			msg.setMessage(message);
		if (page != null)
			msg.setPage(page);
		if (data != null)
			msg.setData(data);
		return msg;
	}

	protected Message showMessage(Integer result, String message)
	{
		return showMessage(result, message, null,null);
	}

	protected Message showErrorMessage(String message)
	{
		return showMessage(Message.OP_FAIL, message, null,null);
	}

	protected Message showSuccessMessage(Object data)
	{
		return showMessage(Message.OP_SUCCESS,null, data, null);
	}

	public String getRemoteAddr(HttpServletRequest request)
	{
		String address = request.getHeader("X-Forwarded-For");
		if (address != null && address.length() > 0 && !"unknown".equalsIgnoreCase(address))
		{
			return address;
		}
		address = request.getHeader("Proxy-Client-IP");
		if (address != null && address.length() > 0 && !"unknown".equalsIgnoreCase(address))
		{
			return address;
		}
		address = request.getHeader("WL-Proxy-Client-IP");
		if (address != null && address.length() > 0 && !"unknown".equalsIgnoreCase(address))
		{
			return address;
		}
		return request.getRemoteAddr();
	}
	
	@SuppressWarnings("unchecked")
    public void printRequestParameters(HttpServletRequest request) {
        System.out.println("------print request params------");

        Enumeration<String> paramNames = request.getParameterNames();

        while (paramNames.hasMoreElements()) {
            String pName = paramNames.nextElement();

            String value = request.getParameter(pName);
            System.out.println((pName + "=" + (value != null ? value : "")));
        }
        System.out.println("-----end print----");
    }
	protected PageObj initPageObj(Long totalCount, int page, int pageSize)
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

	protected void initPageInfo(HttpServletRequest request, Long totalcount, int page, int pageSize)
	{
		int pageCount = 1;
		if (pageSize != -1 && page != 0)
			pageCount = totalcount.intValue() % pageSize == 0 ? totalcount.intValue() / pageSize : totalcount.intValue() / pageSize + 1;
		request.setAttribute("pageNow", page);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("totalCount", totalcount);
	}

	protected String encode(String str)
	{
		if (str == null)
			return "";
		try
		{
			return URLEncoder.encode(str, "UTF-8");
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
			return "";
		}

	}

	
	protected void printHeaders()
	{
		Enumeration<String> headers = request.getHeaderNames();
		while (headers.hasMoreElements())
		{
			String header = headers.nextElement();
			Enumeration<String> values = request.getHeaders(header);
			System.out.print(header + ": ");
			while (values.hasMoreElements())
			{
				System.out.print(values.nextElement() + " ");
			}
			System.out.println();

		}
	}

	protected String decode(String str)
	{
		if (str == null)
			return "";
		try
		{
			return URLDecoder.decode(str, "UTF-8");
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
			return "";
		}

	}

	public HttpServletRequest getRequest()
	{
		return request;
	}

	@Resource
	public void setRequest(HttpServletRequest request)
	{
		this.request = request;
	}

	/**
	 * 注意:尽量不要把信息存到session
	 * 
	 * @return
	 */
	public HttpSession getSession()
	{
		return session;
	}

	@Resource
	public void setSession(HttpSession session)
	{
		this.session = session;
	}
	/**
	 * session 对象存储
	 * 
	 * @param request
	 * @param key
	 * @param object
	 */
	public void putObj2Session(HttpServletRequest request, String key, Object object) {
		session = request.getSession();
		session.setAttribute(key, object);
	}

	/**
	 * session 中取对象
	 * 
	 * @param key
	 * @param request
	 */
	public Object getSessionObjByKey(String key, HttpServletRequest request) {
		session = request.getSession();
		return session.getAttribute(key);
	}

	/**
	 * 清空session
	 * 
	 * @param key
	 * @return
	 */
	public void removeSessionKey(String key, HttpServletRequest request) {
		session = request.getSession();
		session.removeAttribute(key);
	}

	/**
	 * 获取项目访问名称
	 * 
	 * @return
	 */
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}
	
	public UserEntity getUserByToken(String token){
		Object json = redisTemplate.opsForValue().get(token);
		if(json==null){
			return null;
		}
		UserEntity userEntity = JSONObject.parseObject(json.toString(), UserEntity.class);
		return 	userEntity;
		
	}

	public SellerEntity getSellerByToken(String token){
		Object json = redisTemplate.opsForValue().get(token);
		if(json==null){
			return null;
		}
		SellerEntity sellerEntity = JSONObject.parseObject(json.toString(), SellerEntity.class);
		return 	sellerEntity;

	}

}
