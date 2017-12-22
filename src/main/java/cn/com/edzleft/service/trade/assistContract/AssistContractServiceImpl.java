package cn.com.edzleft.service.trade.assistContract;

import cn.com.edzleft.dao.trade.assistContract.AssistContractMapper;
import cn.com.edzleft.entity.AssistContract;
import cn.com.edzleft.entity.Contract;
import cn.com.edzleft.service.trade.contractSigning.ContractSigningService;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ibmtech on 2017/12/18.
 */
@Service
@Transactional
public class AssistContractServiceImpl implements  AssistConotractService {
    @Autowired
    private AssistContractMapper assistContractMapper;
    @Autowired
    private ContractSigningService contractSigningService;


    @Override
    public List<AssistContract> selectAssistContract(Integer id) {
        List<AssistContract> assistContractList = assistContractMapper.selectAssistContractListById(id);
                return assistContractList;
    }

    /**
     * 修改辅合同状态
     * @param id
     * @param flag
     * @return
     */
    @Override
    public Map<String,Object> claimAssistContract(Integer id, Integer flag) {

        //根据辅合同id查询主合同状态
        AssistContract assistContract = assistContractMapper.selectAssistContractById(id);
        Integer contractId = assistContract.getContractId();
        //根据主合同id查询主合同状态
        Contract contract = contractSigningService.queryContractById(contractId);
        Integer contractStatus = contract.getContractStatus();
        //判断主合同状态是否正常
        //非正常状态（2--已终止  4--驳回）
        Map<String, Object> map = new HashMap<String, Object>();
        if (contractStatus==0||contractStatus==1||contractStatus==3) {
            if (flag == 1) {   //待领取--领取合同
                //领取合同（0---1）
                assistContract.setAssistId(id);
                assistContract.setAssistStatus(1);
            } else if (flag == 2) { //待领取--驳回
                //驳回（0--3）
                assistContract.setAssistId(id);
                assistContract.setAssistStatus(3);
            } else if (flag == 3) {  //正常 1 --2终止
                //终止（1--2）
                assistContract.setAssistId(id);
                assistContract.setAssistStatus(2);
            }
            //修改合同状态
            int i = assistContractMapper.claimAssistContract(assistContract);
            map.put("success",true);
            map.put("message","主合同正常，操作成功！");
        }else{
            map.put("success",false);
            map.put("message","主合同异常，或者不在执行期，无法操作！");
        }
            return  map;
    }



}
