package cn.com.edzleft.util;

import cn.com.edzleft.dao.trade.information.InformationMapper;
import cn.com.edzleft.entity.Information;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ibmtech on 2017/11/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:config/applicationContext.xml")
public class InformationTest {

    @Autowired
    private InformationMapper informationMapper;

    /**
     * 查询所有的基本信息
     */
    @Test
    public void selectAllInfromation(){
        Information information = informationMapper.selectBaseInformation();
        System.out.println(information);
        }

    /**
     * 基本资料修改
     */
    @Test
    public void updateInformation(){
        Information info = new Information();
        info.setId(1);
        //企业身份
        info.setEntIdentity(1);
        //企业名称
        info.setEntName("zhonggongyidong");
        //社会统一信用代码
        info.setEntCreditCode("1234");
        //工商登记注册号
        info.setRegistrationNumber("12345");
        //税务登记号
        info.setTaxRegistrationNumber("412");
        //组织机构代码
        info.setInstitutionCode("1111");
        //法定代表人
        info.setRepresentative("wangwu");
        //法定代表人证件类型
        info.setRepresentativeType(1);
        //组织机构代码
        info.setInstitutionCode("321");
        //法定代表人证件号码
        info.setRepresentativeNum(123);
        //固定电话
        info.setTelephone("15901234567");
        //省市区域
        info.setMunicipality("江苏省");
        //详细地址
        info.setAddress("南京市");
        //企业联系人
        info.setBusinessContact("lisi");
        //企业联系人手机
        info.setMobilePhone("13512345432");
        //联系人电子邮件
        info.setEmailAddress("11230!@qq.com");
        //邮编
        info.setZipCode(123098);
        //网址
        info.setWebSite("http://8080");

        /**
         * 高级信息部分
         */
        //注册资本
        info.setRegisteredCapital(1234);
        //主要股东
        info.setMajorShareholder("zhonuoyid");
        //经营范围
        info.setBusinessScope("gunag");
        //登记机关
        info.setRegistrationAuthority("youzhnegju");

        //电子图片
        //社会统一信用代码电子档
        info.setCodeFile("wang");
        //工商登记注册电子档
        info.setBusinessLicense("zhao");
        //税务登记号电子档
        info.setElectronicFile("qian ");
        //组织机构代码电子档
        info.setOrganizationElectronicFile("sun");
        //法人身份证电子档
        info.setPersonIdcard("idcard");
        //开户许可证电子档
        info.setOpenAccountFile("zhangsi");

        informationMapper.updateInformation(info);
        System.out.println("修改成功");

    }

}
