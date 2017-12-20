package cn.com.edzleft.service.trade.assistContract;

import cn.com.edzleft.dao.trade.assistContract.AssistContractMapper;
import cn.com.edzleft.entity.AssistContract;
import cn.com.edzleft.entity.Contract;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by ibmtech on 2017/12/18.
 */
@Service
@Transactional
public class AssistContractServiceImpl implements  AssistConotractService {
    @Autowired
    private AssistContractMapper assistContractMapper;


    @Override
    public List<AssistContract> selectAssistContract(Integer id) {
        List<AssistContract> assistContractList = assistContractMapper.selectAssistContractListById(id);
                return assistContractList;
    }

/**
 *
 */


}
