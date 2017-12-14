package cn.com.edzleft.service.procurement.oder;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import cn.com.edzleft.dao.procurement.oder.PmOrderMapper;
import cn.com.edzleft.entity.Information;
import cn.com.edzleft.entity.Letter;
import cn.com.edzleft.entity.Order;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class PmOrderServiceImpl implements PmOrderService{

	@Autowired
	private PmOrderMapper pmOrderMapper;

	@Override
	public PageUtil<Order> getOrderEntityList(PageUtil<Order> userPage) {
		//查询总条数
        int totalCount = pmOrderMapper.getCrownEntityCounts(userPage);
        //根据月份进行判断
       /* if(userPage.getWhereMap().get("aa")=="1"){  //月份为一个月
        	userPage.getWhereMap().put("aa","month");
        } else if(userPage.getWhereMap().get("aa")=="2"){ //月份为一年
        	userPage.getWhereMap().put("aa","month");
        }*/
       //查询集合
        List<Order> userList = pmOrderMapper.getCrownEntityList(userPage);
        userPage.setTotalCount(totalCount);
        userPage.setList(userList);
        return userPage;
	}

	@Override
	public String insetOrder(Integer userId) {
		return pmOrderMapper.insetOrder(userId);
	}

	@Override
	public String insetOrder2(Integer userId) {
		return pmOrderMapper.insetOrder2(userId);
	}

	/*添加订单*/
	@Override
	public int insertSelective(Order o,HttpSession sessionInfo) {
		SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();
		String in=String.valueOf(userId);
        List<String> list=Arrays.asList(in.split(""));
        Collections.shuffle(list);
        /*获取随机数*/
        String out=new String();
        Random r=new Random();
        int i = r.nextInt(10);
        System.out.println(i);
        /*获取当前时间戳*/
        long currentTimeMillis = System.currentTimeMillis();
        String orderNumber= "";
        orderNumber = "O"+i+currentTimeMillis;
        o.setOrderNumber(orderNumber);
        for(String s:list){
            out+=s;
        }
        
        System.out.println("================="+out);
		return pmOrderMapper.insertSelective(o);
	}

	@Override
	public String insetOrder3(Integer userId) {
		// TODO Auto-generated method stub
		return pmOrderMapper.insetOrder3(userId);
	}

	@Override
	public String insetOrder4(Integer userId) {
		// TODO Auto-generated method stub
		return pmOrderMapper.insetOrder4(userId);
	}
	
	/**
	 * 修改订单状态
	 * @param id
	 * @return 
	 */
	@Override
	public int updOrderStatus(Integer id, Integer flag) {
		Order order =new Order();
		if(flag==1){//取消按钮，0-->5
			order.setOrderStatus(5);
			order.setOrderId(id);
			order.setOrderConfirmationTime(new Date());
		}else if(flag==2){//编辑按钮
			order.setOrderStatus(0);
			order.setOrderId(id);
		}else if(flag==3){//取消
			order.setOrderStatus(5);
			order.setOrderId(id);
			order.setOrderConfirmationTime(new Date());
		}else if(flag==4){//编辑
			order.setOrderStatus(1);
			order.setOrderId(id);
		}else if(flag==5){//申请用信
			order.setOrderStatus(1);
			order.setOrderId(id);
			order.setOrderConfirmationTime(new Date());
		}else if(flag==6){//提醒发货
			order.setOrderStatus(2);
			order.setOrderId(id);
		}else if(flag==7){//确认收货3-->4
			order.setOrderStatus(4);
			order.setOrderConfirmationTime(new Date());
			order.setOrderId(id);
		}else if(flag==8){//取消
			order.setOrderStatus(0);
			order.setOrderId(id);
			order.setOrderConfirmationTime(new Date());
		}else if(flag==9){//编辑
			order.setOrderId(id);
			order.setOrderStatus(5);
		}else if(flag==10){//取消
			order.setOrderStatus(5);
			order.setOrderId(id);
			order.setOrderConfirmationTime(new Date());
		}else if(flag==11){//编辑
			order.setOrderStatus(0);
			order.setOrderId(id);
		}
		pmOrderMapper.updOrderStatus(order);
		return flag;
	}

	/**
	 *回显申请用信表单
	 */
	@Override
	public Order getSelectOrder(Integer id) {
		return pmOrderMapper.selectByPrimaryKey(id);
	}

	/**
	 * 提交申请用信
	 */
	@Override
	public int commitSqyx(Integer id, Integer flag,String applicationletter) {
		Order order = new Order();
		order.setLetterStatus(0);
		order.setOrderId(id);
		order.setApplicationletter(applicationletter);
		pmOrderMapper.updOrderStatus(order);
		return flag;
		
	}

	@Override
	public Integer insetOrder5(Integer userId) {
		// TODO Auto-generated method stub
		return pmOrderMapper.insetOrder5(userId);
	}

	/**
	 * 编辑时回写订单
	 */
	@Override
	public Order ddbj(Integer orderId) {
		return pmOrderMapper.ddbj(orderId);
	}

	/***
	 * 编辑订单
	 */
	@Override
	public int updataOreder(Order order) {
		int i = pmOrderMapper.updataOreder(order);
		return i;
	}
	/**
	 * 接口用信查询
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selectOrderLetter() {
		return pmOrderMapper.selectOrderLetter();
	}

}
