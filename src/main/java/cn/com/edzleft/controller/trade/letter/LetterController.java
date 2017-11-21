package cn.com.edzleft.controller.trade.letter;

import cn.com.edzleft.entity.Letter;
import cn.com.edzleft.service.trade.letter.LetterService;
import cn.com.edzleft.util.page.DataGridJson;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ibmtech on 2017/11/20.
 */
@Controller
@RequestMapping("/letter")
public class LetterController {

    @Autowired
    private LetterService letterService;


    /**
     * 条件查询+分页显示
     */
    @RequestMapping(value = "/queryByPage" ,method = RequestMethod.POST)
    @ResponseBody
    public DataGridJson getLetterByPage(int page, int rows, PageUtil<Letter> pageUtil){
        DataGridJson dgj = new DataGridJson();
        //分页对象
        pageUtil.setCpage(page);
        pageUtil.setPageSize(rows);
        PageUtil<Letter> letters = letterService.queryAllLetterByPage(pageUtil);
        dgj.setTotal(letters.getTotalCount());
        dgj.setRows(letters.getList());
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
