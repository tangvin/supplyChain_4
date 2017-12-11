package cn.com.edzleft.dao.captial.homepage;

import cn.com.edzleft.entity.Code;

public interface CodeMapper {


    int insertCode(Code code);

    Code selectCode(Integer userId);

	Code selectCodePhone(String userPhone);


}