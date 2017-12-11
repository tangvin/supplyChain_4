package cn.com.edzleft.dao.procurement.invoice;

import java.util.List;

import cn.com.edzleft.entity.InvoiceRecord;
import cn.com.edzleft.util.page.PageUtil;

public interface ProInvoiceMapper {
	/**InvoiceRecord
	 * 根据Map<String,Object>对象查询符合条件的总数据数
	 * @param userPage
	 * @return
	 */
	int getInvoiceRecordEntityCountsByConditions(PageUtil<InvoiceRecord> userPage);
	/**InvoiceRecord
	 * 根据Map<String,Object>分页查询
	 * @param userPage
	 * @return
	 */
	List<InvoiceRecord> getInvoiceRecordEntityListByConditions(PageUtil<InvoiceRecord> userPage);
	//根据userId查询条数
	//int getCounts(Integer userId);
	//根据userId查询ukey
	//List<InvoiceRecord> getByUserId(Integer userId);
	InvoiceRecord getById(Integer id);
}
