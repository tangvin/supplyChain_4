package cn.com.edzleft.service.trade.contractSigning;

import cn.com.edzleft.dao.trade.contractSigning.ContractSigningMapper;
import cn.com.edzleft.entity.AssistContract;
import cn.com.edzleft.entity.Contract;
import cn.com.edzleft.service.trade.assistContract.AssistConotractService;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by ibmtech on 2017/11/24.
 */
@Service
@Transactional
public class ContractSigningServiceImpl implements ContractSigningService {
    @Autowired
    private ContractSigningMapper contractSigningMapper;
    @Autowired
    private AssistConotractService assistConotractService;

    /**
     * 条件查询主合同+子合同
     * @param pageUtil
     * @return
     */
    @Override
    public PageUtil<Contract> queryAllContract(PageUtil<Contract> pageUtil) {
        //查询所有的满足条件的合同总数
        Integer totalCount = contractSigningMapper.getContractCount(pageUtil);
        //查询所有满足条件的条数
        List<Contract> list = contractSigningMapper.getContractByPage(pageUtil);
        //调用辅合同id查询主合同下的辅合同
        for (Contract contract : list) {
            Integer contractId = contract.getContractId();
            List<AssistContract> assistContracts = assistConotractService.selectAssistContract(contractId);
             //将辅合同集合放到主合同下面
            contract.setAssistContractList(assistContracts);
        }
        pageUtil.setTotalCount(totalCount);
        pageUtil.setList(list);
        return pageUtil;
    }

    /**
     * 根据合同id查合同详情
     * @param id
     * @return
     */
    @Override
    public Contract queryContractById(Integer id) {
        Contract contract = contractSigningMapper.selectContractById(id);
        return contract;
    }

    /**
     * 根据合同编号查看合同详情
     * @param number
     * @return
     */
    @Override
    public Contract queryContractByContractnumber(String number) {
        Contract contract = contractSigningMapper.selectDetailContractByContractNumber(number);
        return contract;
    }

    /**
     * 设置合同状态
     * @param id
     * @param flag
     * @param sessionInfo
     * @return
     */
    @Override
    public int setContractMessage(Integer id, Integer flag, HttpSession sessionInfo) {
         //根据id查询出当前的合同
        Contract contract = contractSigningMapper.selectContractById(id);
        if(flag==0) {   //待确认--领取订单
            //领取合同（0---1）
            contract.setContractId(id);
            contract.setContractStatus(1);
        } else if (flag == 1) { //待确认--驳回
            //驳回（0--3）
            contract.setContractId(id);
            contract.setContractStatus(6);
        }else if(flag==2){  //正常 1 --3终止
            contract.setContractId(id);
            contract.setContractStatus(3);
        }
        int i = contractSigningMapper.updateContract(contract);
        System.out.println("合同状态修改完毕！！！");
        return i;
    }
}
