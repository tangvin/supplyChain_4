package cn.com.edzleft.service.captial.homepage;

import cn.com.edzleft.dao.captial.homepage.CodeMapper;
import cn.com.edzleft.entity.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ASUS on 2017/11/29.
 */
@Service
public class CodeServiceImpl implements CodeService{

    @Autowired
    private CodeMapper codeMapper;

    /**
     * 存储验证码信息
     * @param code
     */
    @Override
    public void insertCode(Code code) {
        codeMapper.insertCode(code);
    }

    /**
     * 根据当前用户id查询用户信息
     * @param userId
     * @return
     */
    @Override
    public Code selectCode(Integer userId) {
        return codeMapper.selectCode(userId);
    }
}
