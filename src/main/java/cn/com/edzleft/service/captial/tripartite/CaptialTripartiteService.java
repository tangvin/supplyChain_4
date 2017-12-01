package cn.com.edzleft.service.captial.tripartite;

import cn.com.edzleft.entity.Tripartite;
import cn.com.edzleft.util.page.PageUtil;

/**
 * Created by ASUS on 2017/11/28.
 */
public interface CaptialTripartiteService {

    public PageUtil<Tripartite> getTripartiteSelect(PageUtil<Tripartite> userPage);

}
