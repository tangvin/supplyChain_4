package cn.com.edzleft.controller.captial.letter;

import cn.com.edzleft.entity.CreditTable;
import cn.com.edzleft.entity.Letter;
import cn.com.edzleft.service.captial.letter.CaptialLetterService;
import cn.com.edzleft.util.page.DataGridJson;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ASUS on 2017/11/2.
 */
@Controller
@RequestMapping(value="/letter")
public class CaptialLetterController {

    @Autowired
    private CaptialLetterService letterService;


    /**
     * 用信管理
     * @param pageNumber 开始页数
     * @param pageSize 每页条数
     * @param letterNumber 用信编号
     * @param belongCredit 所属授信
     * @param letterStatus 状态
     * @param applicant 申请人
     * @return
     */
    @RequestMapping(value = "/letterSelect",method = RequestMethod.POST)
    @ResponseBody
    public DataGridJson letterSelect(Integer pageNumber,Integer pageSize ,String letterNumber,String belongCredit,String letterStatus,String applicant,
    HttpServletRequest request, HttpServletResponse response){

        response.setContentType("text/plain");
        response.setHeader("Pragma", "No-cache");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Access-Control-Allow-Origin", "*");//添加跨域访问
        String jsonpCallback = request.getParameter("jsonpCallback");

        PageUtil<Letter> userPage = new PageUtil<>();
        HashMap<String,Object> whereMaps =new HashMap<>();
        whereMaps.put("letterNumber",letterNumber);
        whereMaps.put("belongCredit",belongCredit);
        whereMaps.put("letterStatus",letterStatus);
        whereMaps.put("applicant",applicant);
        DataGridJson dgj = new DataGridJson();
        userPage.setCpage(pageNumber);
        userPage.setPageSize(pageSize);
        userPage.setWhereMap(whereMaps);
        userPage = letterService.getOrderEntityListByConditions(userPage);
        dgj.setTotal(userPage.getTotalCount());
        dgj.setRows(userPage.getList());
        return dgj;
    }

    /**
     * 用信管理
     * @param pageNumber 开始页数
     * @param pageSize 每页条数
     * @param letterNumber 用信编号
     * @param belongCredit 所属授信
     * @param letterStatus 状态
     * @param applicant 申请人
     * @return
     */
    @RequestMapping(value = "/newLetterSelect",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> newLetterSelect(Integer pageNumber, Integer pageSize , String letterNumber, String belongCredit, String letterStatus, String applicant,
                                              HttpServletRequest request, HttpServletResponse response){

        response.setContentType("text/plain");
        response.setHeader("Pragma", "No-cache");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Access-Control-Allow-Origin", "*");//添加跨域访问
        String jsonpCallback = request.getParameter("jsonpCallback");

        PageUtil<Letter> userPage = new PageUtil<>();
        HashMap<String,Object> whereMaps =new HashMap<>();
        whereMaps.put("letterNumber",letterNumber);
        whereMaps.put("belongCredit",belongCredit);
        whereMaps.put("letterStatus",letterStatus);
        whereMaps.put("applicant",applicant);
        DataGridJson dgj = new DataGridJson();
        userPage.setCpage(pageNumber);
        userPage.setPageSize(pageSize);
        userPage.setWhereMap(whereMaps);
        userPage = letterService.getOrderEntityListByConditions(userPage);
//        dgj.setTotal(userPage.getTotalCount());
//        dgj.setRows(userPage.getList());
        HashMap<String,Object> map =new HashMap<>();
        map.put("total",userPage.getTotalCount());
        map.put("rows",userPage.getList());

        return map;
    }

    /**
     * 授信管理
     * @param pageNumber 开始页数
     * @param pageSize 每页条数
     * @param creditNumber 授信编号
     * @param creditGrantor 授信方
     * @param creditStatus 状态
     * @param applicant 申请人
     * @return
     */
    @RequestMapping(value = "/crownSelect",method = RequestMethod.POST)
    @ResponseBody
    public DataGridJson crownSelect(Integer pageNumber,Integer pageSize ,String creditNumber,String creditGrantor,String creditStatus,String applicant){
        PageUtil<CreditTable> userPage = new PageUtil<>();
        HashMap<String,Object> whereMaps =new HashMap<>();
        whereMaps.put("creditNumber",creditNumber);
        whereMaps.put("creditGrantor",creditGrantor);
        whereMaps.put("creditStatus",creditStatus);
        whereMaps.put("applicant",applicant);
        DataGridJson dgj = new DataGridJson();
        userPage.setCpage(pageNumber);
        userPage.setPageSize(pageSize);
        userPage.setWhereMap(whereMaps);
        userPage = letterService.getCrownEntityListByConditions(userPage);
        dgj.setTotal(userPage.getTotalCount());
        dgj.setRows(userPage.getList());
        return dgj;
    }



}
