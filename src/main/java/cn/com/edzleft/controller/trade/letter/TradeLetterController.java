package cn.com.edzleft.controller.trade.letter;

import cn.com.edzleft.entity.Letter;
import cn.com.edzleft.service.trade.letter.TradeLetterService;
import cn.com.edzleft.util.page.DataGridJson;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * 用信管理
 * Created by ibmtech on 2017/11/20.
 */
@Controller
@RequestMapping("/letter")
public class TradeLetterController {

    @Autowired
    private TradeLetterService letterService;


    /**
     *用信管理
     * @param pageNumber 开始页数
     * @param pageSize  每页显示条数
     * @param letterNumber 用信编号
     * @param belongCredit 所属授信
     * @param letterStatus 用信状态
     * @param applicant 申请人
     * @return
     */
    @RequestMapping(value = "/queryAllLetter" ,method = RequestMethod.POST)
    @ResponseBody
    public DataGridJson getLetterByPage(Integer pageNumber,Integer pageSize ,String letterNumber,String belongCredit,String letterStatus,String applicant){
        PageUtil<Letter> pageUtil = new PageUtil<Letter>();

        HashMap<String,Object> whereMaps =new HashMap<>();
        whereMaps.put("letterNumber",letterNumber);
        whereMaps.put("belongCredit",belongCredit);
        whereMaps.put("letterStatus",letterStatus);
        whereMaps.put("applicant",applicant);

        DataGridJson dgj = new DataGridJson();
        pageUtil.setCpage(pageNumber);
        pageUtil.setPageSize(pageSize);
        pageUtil.setWhereMap(whereMaps);

        pageUtil = letterService.queryAllLetterByPage(pageUtil);
        dgj.setTotal(pageUtil.getTotalCount());
        dgj.setRows(pageUtil.getList());
        return dgj;
    }

    /**
     * 根据id查询用信详情
     */
    @RequestMapping("/queryLetterById")
    @ResponseBody
    public Letter getDetailLetter(Integer id){
        Letter letter = letterService.selectLetterById(id);
        return letter;
    }

}
