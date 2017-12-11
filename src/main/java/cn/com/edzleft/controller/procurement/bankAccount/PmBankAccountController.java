package cn.com.edzleft.controller.procurement.bankAccount;

import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.BankAccount;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.service.procurement.bankAccount.PmBankAccountService;
import cn.com.edzleft.service.trade.account.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ibmtech on 2017/12/6.
 */
@Controller
@RequestMapping(value = "/pmbankAccount")
public class PmBankAccountController {

    @Autowired
    private PmBankAccountService pmbankAccountService;
    
    @Autowired
    private AccountService accountService;

    /**
     * 查询所有银行卡
     * @return
     */
    @RequestMapping(value = "getAllBankAccoun" ,method = RequestMethod.POST)
    @ResponseBody
    public List<BankAccount> getAllBankAccount(HttpServletRequest request, HttpServletResponse response, HttpSession sessionInfo){
        //设置跨域访问
        response.setContentType("text/plain");
        response.setHeader("Pragma", "No-cache");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Access-Control-Allow-Origin", "*");//添加跨域访问
        String jsonpCallback = request.getParameter("jsonpCallback");

       //获取当前用户id
        SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();
        List<BankAccount> bankAccounts = pmbankAccountService.queryBankAccountByUserId(userId);
        return bankAccounts;
    }

    /**
     * 添加银行卡
     * @return
     */
    @RequestMapping(value = "addBankAccount",method = RequestMethod.POST)
    @ResponseBody
    public  int addBankAccount(BankAccount bankAccount,HttpSession session,String userPhone,String bankAccountDepositBank,String bankAccountCreditHolder,String bankAccountNumber){
    	SessionInfo sessions = (SessionInfo) session.getAttribute("sessionInfo");
        Integer userId = sessions.getAdmin().getUserId();
        Account account = accountService.queryAcountById(userId);
        BankAccount bank = new  BankAccount();
        //账号
        bank.setBankAccountNumber(bankAccountNumber);
        //持卡人
        bank.setBankAccountCreditHolder(bankAccountCreditHolder);
        //开户行
        bank.setBankAccountDepositBank(bankAccountDepositBank);
        //创建时间
        bank.setBankAccountCreateTime(new Date());
        //创建人
        bank.setBankAccountCreatePeople(account.getUserName());
        //添加一个默认状态为0，不然设为默认不好使
        bank.setDefaultId(0);
        //用户id
        bank.setUserId(userId);
        int i = pmbankAccountService.addBankAcount(bank, session);
        return i;
    }

    /**
     * 根据id删除银行卡
     * @return
     */
    @RequestMapping(value = "/deleteBankAccount",method = RequestMethod.POST)
    @ResponseBody
    public int deleteBankAccount(Integer id){
        int flag = pmbankAccountService.cutBankAccountById(id);
        return flag;
    }

    /**
     * 设置默认的银行卡
     * @param id
     * @param value
     * @param session
     * @return
     */
    @RequestMapping(value = "/setDefaultBank" ,method = RequestMethod.POST)
    @ResponseBody
    public int setDefaultAccount(Integer id,Integer value,HttpSession session){
        int i = pmbankAccountService.setbankAccount(id, value, session);
        return i;
    }
    

    /**
     * 添加银行卡第三步
     * @return
     */
    @RequestMapping(value = "/bankTwo",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> bankTwo(HttpSession session, BankAccount bankAccount){
        //获取当前用户填写的银行卡类型(开户行)
        String bankAccountDepositBank = bankAccount.getBankAccountDepositBank();
        //获取输入的账号查询银行卡信息（获取手机号）
        String bankAccountNumber = bankAccount.getBankAccountNumber();
        BankAccount ba = pmbankAccountService.queryBankAccountByNumber(bankAccountNumber);
        if(ba!=null){
            Integer userId = ba.getUserId();
            Account account = accountService.queryAcountById(userId);
            String userPhone = account.getUserPhone();
            Map<String,Object> map = new HashMap<>();
            map.put("userPhone",userPhone);
            map.put("bankAccountDepositBank",bankAccountDepositBank);
            return map;
        }else {
            return null;
        }
    }
    
}
