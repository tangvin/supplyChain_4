package cn.com.edzleft.dao.trade.contractSigning;

import cn.com.edzleft.entity.Contract;
import cn.com.edzleft.util.page.PageUtil;

import java.util.List;

/**
 * Created by ibmtech on 2017/11/24.
 */
public interface ContractSigningMapper {


    /**
     * 表关联条件查询+分页显示
     */
    public Integer getContractCount(PageUtil pageUtil);
    public List<Contract> getContractByPage(PageUtil pageUtil);



    /**
     *  查询总条数
     */
    public Integer selectTotalCount(PageUtil pageUtil);


    /**
     * 分页显示合同信息
     * @param pageUtil
     * @return
     */
    public List<Contract> selectContractByPage(PageUtil pageUtil);


    /**
     *根据id查看合同详细信息
     */
    public Contract selectContractById(Integer id);

    /**
     * 根据主合同编号查看合同详细信息
     */
    public Contract selectDetailContractByContractNumber(String number);

    /**
     * 修改合同信息
     */
    public int updateContract(Contract contract);

}
