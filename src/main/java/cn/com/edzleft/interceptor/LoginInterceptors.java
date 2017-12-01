package cn.com.edzleft.interceptor;

import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.util.ConfigUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class LoginInterceptors implements HandlerInterceptor{
	
	private List<String> excludeUrls;
	
	/**
	 * 预处理
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("-=================preHandle执行-==============");
		//web项目访问路径
		String xiangmuUrl = request.getContextPath();
		//前台请求的url路径
		String URI = request.getRequestURI();
		//将项目的访问路径去除截掉
		String substring = URI.substring(xiangmuUrl.length());
		SessionInfo session = (SessionInfo) request.getSession().getAttribute(ConfigUtil.getSessionInfoName());
		if(session!=null && session.getAdmin()!=null){
			return true;
		}else if (request.getRequestURI()!=null && excludeUrls.contains(substring)) { // excludeUrls.contains() 判断集合是否包含该元素
			return true;
		}else {
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			return false;
		}
	}
	
	/**
	 * 后处理 
	 * 但是渲染modelAndView视图之前执行！！！
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("-=================postHandle()执行-==============");
		
	}

	/**
	 * 请求处理完毕之后执行
	 * 但是只有当 preHandle()返回true才会执行 afterCompletion()该方法
	 * 当 preHandle()返回false  不不不  执行 afterCompletion()该方法
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("-=================afterCompletion()执行-==============");
		
	}

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

}
