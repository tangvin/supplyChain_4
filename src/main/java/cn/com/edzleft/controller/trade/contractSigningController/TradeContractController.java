package cn.com.edzleft.controller.trade.contractSigningController;

import cn.com.edzleft.entity.*;
import cn.com.edzleft.service.trade.assistContract.AssistConotractService;
import cn.com.edzleft.service.trade.contractSigning.ContractSigningService;
import cn.com.edzleft.service.trade.reject.RejectService;
import cn.com.edzleft.util.page.DataGridJson;
import cn.com.edzleft.util.page.PageUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * Created by ibmtech on 2017/11/24.
 */
@Controller
@RequestMapping(value = "/contract")
public class TradeContractController {

    @Autowired
    private ContractSigningService contractSigningService;
    @Autowired
    private RejectService rejectService;
    @Autowired
    private AssistConotractService assistConotractService;

    /**
     * 合同列表页面展示
     * @param pageNumber
     * @param pageSize
     * @param contractStatus
     * @param creatTime
     * @param endTime
     * @param ProcurementEntName
     * @return
     */
    @RequestMapping(value = "/contractShow" ,method = RequestMethod.POST)
    @ResponseBody
    public DataGridJson queryByPage(HttpServletRequest request, HttpServletResponse response, Integer pageNumber, Integer pageSize , Object obj , String contractStatus, String creatTime, String endTime, String ProcurementEntName, HttpSession session){
        //远程调用
        response.setContentType("text/plain");
        response.setHeader("Pragma", "No-cache");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Access-Control-Allow-Origin", "*");//添加跨域访问
        String jsonpCallback = request.getParameter("jsonpCallback");

        PageUtil<Contract> pageUtil = new PageUtil<>();


        String ds = request.getParameter("obj");
        Map<String,String> map = new HashMap<String,String>();
        if(ds != ""){
            JSONObject array=JSONObject.fromObject(ds);
            Iterator iter = array.keySet().iterator();
            while (iter.hasNext()) {
                String key = (String) iter.next();
                String value = array.getString(key);
                map.put(key, value);
            }
        }
        SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
        Account sessionAccount=sessionInfo.getAdmin();


        HashMap<String,Object> whereMaps =new HashMap<>();
        whereMaps.put("contractStatus",map.get("contractStatus"));
        whereMaps.put("creatTime",map.get("creatTime"));
        whereMaps.put("endTime",map.get("endTime"));
        whereMaps.put("procurementEntName",map.get("procurementEntName"));

        DataGridJson dgj = new DataGridJson();
        pageUtil.setCpage(pageNumber);
        pageUtil.setPageSize(pageSize);
        pageUtil.setWhereMap(whereMaps);

        pageUtil=contractSigningService.queryAllContract(pageUtil);
        dgj.setTotal(pageUtil.getTotalCount());
        dgj.setRows(pageUtil.getList());
        return dgj;
    }

    /**
     * 根据合同编号查看合同详细信息
     * @param contractnumber
     * @param session
     * @return
     */
    @RequestMapping(value = "/contractDetail",method = RequestMethod.POST)
    @ResponseBody
    public DataGridJson ContractDetailMessage(String contractnumber,HttpSession session){
        DataGridJson dgj = new DataGridJson();
        HashMap<Object, Object> hashMap = new HashMap<>();
        Contract contract = contractSigningService.queryContractByContractnumber(contractnumber);
        Integer contractId = contract.getContractId();
        //将查询到的信息翻入map集合
        hashMap.put("contract",contract);
        dgj.setHashMap(hashMap);
        return dgj;
    }



    /**
     * 根据id 查询合同详细信息
     */
    @RequestMapping(value = "/queryByContractId" ,method = RequestMethod.POST)
    @ResponseBody
    public Contract contractDetail(Integer id){
        Contract contract = contractSigningService.queryContractById(id);
        return contract;
    }



    /**
     * 根据合同编号查看合同详细信息
     */
    @RequestMapping(value = "/getDetailByNumber",method = RequestMethod.POST)
    @ResponseBody
    public Contract getContractDetail(String number){
        Contract contract = contractSigningService.queryContractByContractnumber(number);
        return  contract;
    }


    /**
     * (主合同)领取、终止合同
     */
    @RequestMapping(value = "/lqht" ,method = RequestMethod.POST)
    @ResponseBody
    public int claimContract(Integer id,Integer flag, HttpSession session){
        int i = contractSigningService.setContractMessage(id, flag, session);
        return i;
    }


    /**
     * （主合同）驳回合同
     */
    @RequestMapping(value = "/bohuiContract",method = RequestMethod.POST)
    @ResponseBody
    public List<Reject> rejectReason(Integer id, Integer flag, String rejectReason, HttpSession session){
        //查询当前合同
        Contract contract = contractSigningService.queryContractById(id);
        Integer contractId = contract.getContractId();

        //调用驳回记录表业务
        Reject reject = new Reject();
        //将合同id存到驳回表中
        reject.setContractId(contractId);
        //设置驳回业务类型--(1.合同    2.订单)
        reject.setBussinessType(1);
        //收集页面传回的驳回理由
        reject.setRejectReason(rejectReason);
        //确认驳回之前先将驳回理由存到添加驳回记录表
        rejectService.addRejectReason(reject);
        int i = contractSigningService.setContractMessage(id, flag, session);
        contractSigningService.setContractMessage(id, flag, session);
        List<Reject> rejectList = rejectService.queryRejectByContractId(id);
        return rejectList;
    }


    /**
     * (辅合同)领取、终止合同
     */
    @RequestMapping(value = "/lqAssist" ,method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> claimAssistContract(Integer id,Integer flag){
        Map<String, Object> map = assistConotractService.claimAssistContract(id, flag);
        return map;
    }
    /**
     * 辅合同驳回
     * @param id
     * @param flag
     * @param rejectReason
     * @param session
     * @return
     */
    @RequestMapping(value = "/rejectAssist",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> rejectAassistContract(Integer id, Integer flag, String rejectReason, HttpSession session){
        AssistContract assistContract = new AssistContract();
        Integer assistId = assistContract.getAssistId();
        //调用驳回记录表业务
        Reject reject = new Reject();
        //将合同id存到驳回表中
        reject.setAssistId(assistId);
        //设置驳回业务类型--(1.合同    2.订单)
        reject.setBussinessType(1);
        //收集页面传回的驳回理由
        reject.setRejectReason(rejectReason);
        //确认驳回之前先将驳回理由存到添加驳回记录表
        rejectService.addRejectReason(reject);
        //调用业务修改辅合同状态
        Map<String, Object> map = assistConotractService.claimAssistContract(id, flag);
        return map;
    }





}
