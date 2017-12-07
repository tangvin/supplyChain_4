package cn.com.edzleft.service.captial.information;

import cn.com.edzleft.dao.captial.homepage.CaptialHomePageMapper;
import cn.com.edzleft.entity.Information;
import cn.com.edzleft.entity.SessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by ASUS on 2017/11/29.
 */
@Service
public class CaptialInformationServiceImpl implements CaptialInformationService{

    @Autowired
    private CaptialHomePageMapper captialHomePageMapper;


    @Override
    public void updateInformation(Information information, HttpSession session) {
        SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
        sessionInfo.getAdmin().getUserId();
        captialHomePageMapper.updateInformation(information);
    }
}
