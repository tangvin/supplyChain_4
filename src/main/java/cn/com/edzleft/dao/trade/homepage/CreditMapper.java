package cn.com.edzleft.dao.trade.homepage;

import cn.com.edzleft.entity.CreditTable;
import cn.com.edzleft.util.page.PageUtil;

import java.util.List;

/**
 * Created by ibmtech on 2017/11/20.
 */
public interface CreditMapper {

    /**
     * 条件查询
     * param: creditNumber(授信编号)
     *        creditGrantor(授信方)
     *        crdeitStatus(授信状态)
     *        applicant(申请人)
     */
   // public CreditTable selectAllCredit(String creditNumber,String creditGrantor,Integer creditStatus,String applicant);


    /**
     * 根据Map<String,Object>对象查询符合条件的总数据数
     * @param  pageUtil
     * @return
     */
    public Integer getCrdeitAllCount(PageUtil<CreditTable> pageUtil);

    /**
     * 分页
     * @param pageUtil
     * @return
     */
    public List<CreditTable> selectAllCreditByPage(PageUtil<CreditTable> pageUtil);


    /**
     * 根据授信id查询详细信息
     * param:creditId(授信id)
     */
    public CreditTable selectCreditById(Integer id);


}
