package cn.com.edzleft.service.captial.homepage;

import cn.com.edzleft.dao.captial.homepage.CaptialHomePageMapper;
import cn.com.edzleft.entity.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ASUS on 2017/11/2.
 */
@Service
public class CaptialHomePageServiceImpl implements CaptialHomePageService {

    @Autowired
    private CaptialHomePageMapper homePageMapper;


    @Override
    public Information homePageSelect(Integer userId) {
        return homePageMapper.homePageSelect(userId);
    }
}
