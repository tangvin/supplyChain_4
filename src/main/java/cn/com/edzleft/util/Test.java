package cn.com.edzleft.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/wechat")
public class Test {
	//@Autowired
	//RedisService redisClient;
	@RequestMapping(value="/share",method=RequestMethod.GET)
	public ModelAndView get(HttpServletRequest request){
		ModelAndView mv=new ModelAndView("/wechat");
		JSONObject jsonObject=PastUtil.getParam("wx0b3333c0434fdf2d",request);
		mv.addObject("timestamp", jsonObject.get("timestamp"));
		mv.addObject("appid", jsonObject.get("appid"));
		mv.addObject("nonceStr", jsonObject.get("nonceStr"));
		mv.addObject("jsapi_ticket", jsonObject.get("jsapi_ticket"));
		mv.addObject("signature", jsonObject.get("signature"));
		mv.addObject("url", jsonObject.get("url"));
		return mv;
	}
}
