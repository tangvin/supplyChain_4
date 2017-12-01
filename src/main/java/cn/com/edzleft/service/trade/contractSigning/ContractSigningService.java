package cn.com.edzleft.service.trade.contractSigning;

import cn.com.edzleft.entity.Contract;
import cn.com.edzleft.util.page.PageUtil;

import java.util.List;

/**
 * Created by ibmtech on 2017/11/24.
 */
public interface ContractSigningService {

    /**
     * 分页显示+条件查询
     */
    public PageUtil<Contract> queryAllContract(PageUtil<Contract> pageUtil);


    /**
     * 根据id查询合同详细信息
     */
    public Contract queryContractById(Integer id);
}
