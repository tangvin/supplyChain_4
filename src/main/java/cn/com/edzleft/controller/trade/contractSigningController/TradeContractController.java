package cn.com.edzleft.controller.trade.contractSigningController;

import cn.com.edzleft.entity.Contract;
import cn.com.edzleft.service.trade.contractSigning.ContractSigningService;
import cn.com.edzleft.util.page.DataGridJson;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ibmtech on 2017/11/24.
 */
@Controller
@RequestMapping("/contract")
public class TradeContractController {

    @Autowired
    private ContractSigningService contractSigningService;

    /**
     * 合同签约页面展示
     * @param pageNumber
     * @param pageSize
     * @param contractStatus
     * @param creatTime
     * @param endTime
     * @param buyerSigning
     * @return
     */
    @RequestMapping("/queryByPage")
    @ResponseBody
    public DataGridJson queryByPage(Integer pageNumber,Integer pageSize ,String contractStatus,String creatTime,String endTime,String buyerSigning){
        PageUtil<Contract> pageUtil = new PageUtil<>();
        HashMap<String,Object> whereMaps =new HashMap<>();
        whereMaps.put("contractStatus",contractStatus);
        whereMaps.put("creatTime",creatTime);
        whereMaps.put("endTime",endTime);
        whereMaps.put("buyerSigning",buyerSigning);

        DataGridJson dgj = new DataGridJson();
        pageUtil.setCpage(pageNumber);
        pageUtil.setPageSize(pageSize);
        pageUtil.setWhereMap(whereMaps);
        // pageUtil = contractSigningService.queryAllContract(pageUtil);

        dgj.setTotal(pageUtil.getTotalCount());
        dgj.setRows(pageUtil.getList());
        return dgj;
    }

    /**
     * 根据id 查询合同相信信息
     */
    public Contract contractDetail(Integer id){
        Contract contract = contractSigningService.queryContractById(id);
        return contract;
    }

}
