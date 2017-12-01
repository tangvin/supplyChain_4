package cn.com.edzleft.dao.captial.tripartite;

import cn.com.edzleft.entity.Tripartite;
import cn.com.edzleft.util.page.PageUtil;

import java.util.List;

public interface CaptialTripartiteMapper {
    //查询总条数
    int getTripartiteSelectCount(PageUtil<Tripartite> userPage);
    //查询集合
    List<Tripartite> getTripartiteSelectList(PageUtil<Tripartite> userPage);

}