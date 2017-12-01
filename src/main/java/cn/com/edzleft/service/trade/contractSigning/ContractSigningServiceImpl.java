package cn.com.edzleft.service.trade.contractSigning;

import cn.com.edzleft.dao.trade.contractSigning.ContractSigningMapper;
import cn.com.edzleft.entity.Contract;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ibmtech on 2017/11/24.
 */
@Service
@Transactional
public class ContractSigningServiceImpl implements ContractSigningService {
    @Autowired
    private ContractSigningMapper contractSigningMapper;

    @Override
    public PageUtil<Contract> queryAllContract(PageUtil<Contract> pageUtil) {
        //查询所有的满足条件的合同总数
        Integer totalCount = contractSigningMapper.selectTotalCount(pageUtil);
        //查询所有满足条件的条数
        List<Contract> list = contractSigningMapper.selectContractByPage(pageUtil);
        pageUtil.setTotalCount(totalCount);
        pageUtil.setList(list);
        return pageUtil;
    }

    @Override
    public Contract queryContractById(Integer id) {
        Contract contract = contractSigningMapper.selectContractById(id);
        return contract;
    }
}
