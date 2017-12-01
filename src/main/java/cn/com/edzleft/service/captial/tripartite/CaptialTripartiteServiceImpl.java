package cn.com.edzleft.service.captial.tripartite;

import cn.com.edzleft.dao.captial.tripartite.CaptialTripartiteMapper;
import cn.com.edzleft.entity.Tripartite;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ASUS on 2017/11/28.
 */
@Service
public class CaptialTripartiteServiceImpl implements CaptialTripartiteService{

    @Autowired
    private CaptialTripartiteMapper captialTripartiteMapper;

    @Override
    public PageUtil<Tripartite> getTripartiteSelect(PageUtil<Tripartite> userPage) {
        //查询总条数
        int totalCount = captialTripartiteMapper.getTripartiteSelectCount(userPage);
        //查询集合
        List<Tripartite> userList = captialTripartiteMapper.getTripartiteSelectList(userPage);
        userPage.setTotalCount(totalCount);
        userPage.setList(userList);
        return userPage;
    }
}
