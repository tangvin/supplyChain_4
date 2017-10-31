package cn.com.edzleft.util;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 分页
 * @author DIY
 *
 */
public class Pagination extends SimplePage implements Serializable {
    private static final long serialVersionUID = 1L;
	/**
	 * 分页内容
	 */
    private List<?> data;
    /**
     * 分页查询对象的类型
     */
    private Map<String,Object> condition;
    /**
     * 分页
     */
    public Pagination() {}
    /**
     * 传入当前页码 和 每页显示的行数
     * @param pageIndex
     * @param pageSize
     */
    public Pagination(Integer pageIndex, Integer pageSize) {
        if(pageIndex>0){
            pageIndex-=1;
        }
        this.startIndex=pageIndex*pageSize;
        this.pageSize=pageSize;
    }
    /**
     * 构建一个总数和list的构造函数
     * @param totals 
     * @param data 
     */
    public Pagination(Integer totals, List<?> data) {
        this.setRecordsTotal(totals);
        this.data = data;
    }

    /**
     * 
     * 构建一个空的<code>Pagination.java</code>
     * @param draw 
     * @param pageSize 每页条数
     * @param total 总页数
     * @param data 
     * @param startIndex 
     */
    public Pagination(int startIndex, int pageSize, int draw, int total, List<?> data) {
        super(startIndex, pageSize, draw, total);
        this.data = data;
    }

    /**
     * 获取分页内容
     * @return data
     */
    public List<?> getData() {
        return data;
    }

    /**
     * 设置分页内容
     * @param data  分页内容
     */
    public void setData(List<?> data) {
        this.data = data;
    }

    /**
     * 获得分页查询的对象类型
     * @return condition
     */
    public Map<String,Object> getCondition() {
        return condition;
    }

    /**
     * 设置分页查询的对象类型
     * @param condition 
     */
    public void setCondition(Map<String,Object> condition) {
        this.condition = condition;
    }

    /**
     * 重写toString 输出参数
     * @return
     * @see Object#toString()
     */
    public String toString() {
        if (condition != null) {
            return condition.toString();
        }
        return null;
    }
}
