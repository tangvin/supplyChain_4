package cn.com.edzleft.service.procurement.receivingaddress;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.edzleft.dao.procurement.receivingaddress.PmReceivingAddressMapper;
import cn.com.edzleft.entity.ReceivingAddress;
import cn.com.edzleft.entity.SessionInfo;
@Service
public class PmReceivingAddressServiceImpl implements PmReceivingAddressService{
	@Autowired
	private PmReceivingAddressMapper pmReceivingAddressMapper;
	@Override
	public int deleteByPrimaryKey(Integer rAddressId) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 *添加收货地址
	 */
	@Override
	public int insert(ReceivingAddress ra,HttpSession session) {
		SessionInfo sessions = (SessionInfo) session.getAttribute("sessionInfo");
		Integer userId = sessions.getAdmin().getUserId();
		List<ReceivingAddress> list = pmReceivingAddressMapper.selectByPrimaryKey(userId);
        if(ra.getrAddressDefault()==0){
        	for(ReceivingAddress r : list){
        		ra.setrAddressDefault(1);
        		pmReceivingAddressMapper.updAddress(r);
        	}
        }
		ra.setUnionID(userId);;
		int i = pmReceivingAddressMapper.insert(ra);
		return i;
	}

	/**
	 * 回显收货地址
	 */
	@Override
	public ReceivingAddress queryReceivingAddress(Integer addressId) {
		return pmReceivingAddressMapper.queryReceivingAddress(addressId);
	}

	@Override
	public ReceivingAddress selectByPrimaryKey(String cId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(ReceivingAddress record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(ReceivingAddress record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(ReceivingAddress record) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*根据用户ID查询地址*/
	@Override
	public List<ReceivingAddress> selectByPrimaryKey(Integer userId) {
		// TODO Auto-generated method stub
		return pmReceivingAddressMapper.selectByPrimaryKey(userId);
	}

	/**
	 * 设为默认地址
	 */
	@Override
	public int setDefaultAddress(Integer id, HttpSession session, Integer value) {
		 SessionInfo sessions = (SessionInfo) session.getAttribute("sessionInfo");
	     Integer userId = sessions.getAdmin().getUserId();
	     List<ReceivingAddress> list = pmReceivingAddressMapper.selectByPrimaryKey(userId);
	     if(value==0){
	    	 for(ReceivingAddress r : list){
	    		 if(r.getrAddressDefault()==0){
	    			 r.setrAddressDefault(1);
	    			 pmReceivingAddressMapper.updAddress(r);
	    		 }
	    	 }
	     }
	     ReceivingAddress ra = new ReceivingAddress();
	     ra.setrAddressId(id);
	     ra.setrAddressDefault(value);
	     pmReceivingAddressMapper.updAddress(ra);
		return 1;
		 
	}

	/**
	 * 删除收货地址
	 */
	@Override
	public int deleteAddress(Integer id) {
		return pmReceivingAddressMapper.deleteByPrimaryKey(id);
	}

}
