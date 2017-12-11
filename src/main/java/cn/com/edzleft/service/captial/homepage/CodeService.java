package cn.com.edzleft.service.captial.homepage;

import cn.com.edzleft.entity.Code;

/**
 * Created by ASUS on 2017/11/29.
 */
public interface CodeService {

    void insertCode(Code code);

    Code selectCode(Integer userId);

	Code selectCodePhone(String userPhone);

}
