package cn.com.edzleft.util;

import cn.com.edzleft.dao.trade.information.TradeInformationMapper;
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
    private TradeInformationMapper informationMapper;

    /**
     * 查询所有的基本信息
     */
    @Test
    public void selectAllInfromation(){
        Information information = informationMapper.selectBaseInformation(2);
        System.out.println(information);
        }

    /**
     * 基本资料修改
     */
    @Test
    public void updateInformation(){
        Information info = new Information();
        info.setId(2);
        //企业身份
        info.setEntIdentity(2);
        //企业名称
        info.setEntName("阿里巴巴");
        //社会统一信用代码
        info.setEntCreditCode("11111111");
        //工商登记注册号
        info.setRegistrationNumber("11111111");
        //税务登记号
        info.setTaxRegistrationNumber("11111111");
        //组织机构代码
        info.setInstitutionCode("1111");
        //法定代表人
        info.setRepresentative("瓦岗寨");
        //法定代表人证件类型
        info.setRepresentativeType(1);
        //组织机构代码
        info.setInstitutionCode("1111");
        //法定代表人证件号码
        info.setRepresentativeNum(11111);
        //固定电话
        info.setTelephone("15911111111");
        //省市区域
        info.setMunicipality("江苏省");
        //详细地址
        info.setAddress("南京市");
        //企业联系人
        info.setBusinessContact("客场");
        //企业联系人手机
        info.setMobilePhone("13512345432");
        //联系人电子邮件
        info.setEmailAddress("11230622133@qq.com");
        //邮编
        info.setZipCode(10091);
        //网址
        info.setWebSite("http://8080、supply");

        /**
         * 高级信息部分
         */
        //注册资本
        info.setRegisteredCapital(11111);
        //主要股东
        info.setMajorShareholder("美创互联");
        //经营范围
        info.setBusinessScope("众美");
        //登记机关
        info.setRegistrationAuthority("北京");

        //电子图片
        //社会统一信用代码电子档
        info.setCodeFile("1111");
        //工商登记注册电子档
        info.setBusinessLicense("1111");
        //税务登记号电子档
        info.setElectronicFile("22222 ");
        //组织机构代码电子档
        info.setOrganizationElectronicFile("222222");
        //法人身份证电子档
        info.setPersonIdcard("222222222");
        //开户许可证电子档
        info.setOpenAccountFile("2222222");
        //用户账号id
        info.setAccountId(222222);
        //企业图片
        info.setEntLogo("123.jpg");
        //认证状态
        info.setCertificationStatus(2);
        //调用修改方法
        informationMapper.updateInformation(info);
        System.out.println("修改成功");
        System.out.println(info);

    }

}
