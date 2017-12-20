package cn.com.edzleft.service.trade.assistContract;

import cn.com.edzleft.entity.AssistContract;
import cn.com.edzleft.util.page.PageUtil;

import java.util.List;

/**
 * Created by ibmtech on 2017/12/18.
 */
public interface AssistConotractService {


    /*根据主合同id查询子合同*/
    public List<AssistContract> selectAssistContract(Integer id);


}
