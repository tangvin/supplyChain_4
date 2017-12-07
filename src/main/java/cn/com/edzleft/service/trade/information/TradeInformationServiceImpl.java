package cn.com.edzleft.service.trade.information;

import cn.com.edzleft.dao.trade.information.TradeInformationMapper;
import cn.com.edzleft.entity.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ibmtech on 2017/11/21.
 */
@Service
@Transactional
public class TradeInformationServiceImpl implements TradeInformationService {

    @Autowired
    private TradeInformationMapper informationMapper;

    /**
     * 查询基本信息
     * @return
     */
    @Override
    public Information queryBaseInformation(Integer id) {
        Information baseinfo = informationMapper.selectBaseInformation(id);
        return baseinfo;
    }


    /**
     * 修改基本信息
     */
    @Override
    public int modifyInformation(Information f) {
        Information info = new Information();

        //获取id
        info.setId(f.getId());
        //企业身份
        info.setEntIdentity(f.getEntIdentity());
        //企业名称
        info.setEntName(f.getEntName());
        //社会统一信用代码
        info.setEntCreditCode(f.getEntCreditCode());
        //工商登记注册号
        info.setRegistrationNumber(f.getRegistrationNumber());
        //税务登记号
        info.setTaxRegistrationNumber(f.getTaxRegistrationNumber());
        //组织机构代码
        info.setInstitutionCode(f.getInstitutionCode());
        //法定代表人
        info.setRepresentative(f.getRepresentative());
        //法定代表人证件类型
        info.setRepresentativeType(f.getRepresentativeType());
        //组织机构代码
        info.setInstitutionCode(f.getInstitutionCode());
        //法定代表人证件号码
        info.setRepresentativeNum(f.getRepresentativeNum());
        //固定电话
        info.setTelephone(f.getTelephone());
        //省市区域
        info.setMunicipality(f.getMunicipality());
        //详细地址
        info.setAddress(f.getAddress());
        //企业联系人
        info.setBusinessContact(f.getBusinessContact());
        //企业联系人手机
        info.setMobilePhone(f.getMobilePhone());
        //联系人电子邮件
        info.setEmailAddress(f.getEmailAddress());
        //邮编
        info.setZipCode(f.getZipCode());
        //网址
        info.setWebSite(f.getWebSite());

        /**
         * 高级信息部分
         */
        //注册资本
        info.setRegisteredCapital(f.getRegisteredCapital());
        //主要股东
        info.setMajorShareholder(f.getMajorShareholder());
        //经营范围
        info.setBusinessScope(f.getBusinessScope());
        //登记机关
        info.setRegistrationAuthority(f.getRegistrationAuthority());

         //电子图片
        //社会统一信用代码电子档
        info.setCodeFile(f.getCodeFile());
        //工商登记注册电子档
        info.setBusinessLicense(f.getBusinessLicense());
        //税务登记号电子档
        info.setElectronicFile(f.getElectronicFile());
        //组织机构代码电子档
        info.setOrganizationElectronicFile(f.getOrganizationElectronicFile());
        //法人身份证电子档
        info.setPersonIdcard(f.getPersonIdcard());
        //开户许可证电子档
        info.setOpenAccountFile(f.getOpenAccountFile());
        //企业图片
        info.setEntLogo(f.getEntLogo());
        //认证状态
        info.setCertificationStatus(f.getCertificationStatus());

        int flag = informationMapper.updateInformation(info);
        return flag;
    }

}
