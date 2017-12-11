package cn.com.edzleft.service.captial.information;

import cn.com.edzleft.dao.captial.homepage.CaptialHomePageMapper;
import cn.com.edzleft.entity.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ASUS on 2017/11/29.
 */
@Service
public class CaptialInformationServiceImpl implements CaptialInformationService{

    @Autowired
    private CaptialHomePageMapper captialHomePageMapper;


    @Override
    public int updateInformation(Information information) {
        int i = captialHomePageMapper.updateInformation(information);
        return i;
    }

    @Override
    public int insertInformation(Information information) {
        int i = captialHomePageMapper.insertInformation(information);
        if(i > 0){
//            Information information1 = captialHomePageMapper.selectInformation();
        }
        return i;
    }
}
