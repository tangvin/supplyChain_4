package cn.com.edzleft.util;

/**
 * <pre>项目名称：ssh-zjui    
 * 类名称：ReturnJson    
 * 类描述：     JSON模型
 *                用户后台向前台返回的JSON对象
 * 创建人：  朱冀京
 * 创建时间：2017年3月20日 上午7:32:30    
 * 修改人： 朱冀京
 * 修改时间：2017年3月20日 上午7:32:30    
 * 修改备注：       
 * @version </pre>
 */
public class ReturnJson implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3249291140713717714L;

	private boolean success = false;

	private String msg = "";

	private Object obj = null;

	private Integer type = 0;


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public ReturnJson(boolean success, String msg, Object obj) {
		super();
		this.success = success;
		this.msg = msg;
		this.obj = obj;
	}

	public ReturnJson() {
		super();
	}

	
}
