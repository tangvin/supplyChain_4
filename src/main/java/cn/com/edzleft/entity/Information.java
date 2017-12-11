package cn.com.edzleft.entity;

/**基本资料表
 * gyl_information
 */
public class Information {
    /**
     * id
     */
    private Integer id;
    /**
     * 企业身份  0采购方、1贸易方、2资方
     */
    private Integer entIdentity;
    /**
     * 企业名称
     */
    private String entName;
    /**
     * 企业证件类型  0三证合一，1非三证合一
     */
    private Integer entDocumentType;
    /**
     * 社会统一信用代码
     */
    private String entCreditCode;
    /**
     * 工商登记注册号
     */
    private String registrationNumber;
    /**
     * 税务登记号
     */
    private String taxRegistrationNumber;
    /**
     * 组织机构代码
     */
    private String institutionCode;
    /**
     * 法定代表人
     */
    private String representative;
    /**
     * 法定代表人证件类型  0居民身份证、1护照、2港澳居民来往内地通行证、3台湾居民来往大陆通行证
     */
    private Integer representativeType;
    /**
     * 法定代表人证件号码
     */
    private Integer representativeNum;
    /**
     * 注册资本  单位万元
     */
    private Integer registeredCapital;
    /**
     * 主要股东
     */
    private String majorShareholder;
    /**
     * 经营范围  500字符以内
     */
    private String businessScope;
    /**
     * 登记机关
     */
    private String registrationAuthority;
    /**
     * 固定电话  格式：区号-号码-分机号（没有分机号为空）
     */
    private String telephone;
    /**
     * 省/直辖市
     */
    private String municipality;
    /**
     * 市
     */
    private String city;
    /**
     * 区县
     */
    private String county;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 企业联系人
     */
    private String businessContact;
    /**
     * 企业联系人手机
     */
    private String mobilePhone;
    /**
     * 联系人电子邮箱
     */
    private String emailAddress;
    /**
     * 邮编
     */
    private Integer zipCode;
    /**
     * 网址
     */
    private String webSite;
    /**
     * 社会统一信用代码电子档
     */
    private String codeFile;
    /**
     * 工商营业执照副本电子档
     */
    private String businessLicense;
    /**
     * 税务登记证电子档
     */
    private String electronicFile;
    /**
     * 法人身份证电子档
     */
    private String personIdcard;
    /**
     * 税号
     */
    private Integer taxNumber;
    /**
     * 开户许可证电子档
     */
    private String openAccountFile;
    /**
     * 财务报表电子档
     */
    private String financialFile;

    /**
     *组织机构电子档
     */
    private String organizationElectronicFile;

    /**
     * 企业图片
     */
    private String entLogo;
    /**
     * 认证状态
     */
    private Integer certificationStatus;

    /**
     * 创建者
     * @return
     */
    private Integer creatorId;


    public Integer getCertificationStatus() {
        return certificationStatus;
    }

    public void setCertificationStatus(Integer certificationStatus) {
        this.certificationStatus = certificationStatus;
    }

    public String getEntLogo() {
        return entLogo;
    }

    public void setEntLogo(String entLogo) {
        this.entLogo = entLogo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEntIdentity() {
        return entIdentity;
    }

    public void setEntIdentity(Integer entIdentity) {
        this.entIdentity = entIdentity;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName == null ? null : entName.trim();
    }

    public Integer getEntDocumentType() {
        return entDocumentType;
    }

    public void setEntDocumentType(Integer entDocumentType) {
        this.entDocumentType = entDocumentType;
    }

    public String getEntCreditCode() {
        return entCreditCode;
    }

    public void setEntCreditCode(String entCreditCode) {
        this.entCreditCode = entCreditCode == null ? null : entCreditCode.trim();
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber == null ? null : registrationNumber.trim();
    }

    public String getTaxRegistrationNumber() {
        return taxRegistrationNumber;
    }

    public void setTaxRegistrationNumber(String taxRegistrationNumber) {
        this.taxRegistrationNumber = taxRegistrationNumber == null ? null : taxRegistrationNumber.trim();
    }

    public String getInstitutionCode() {
        return institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode == null ? null : institutionCode.trim();
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative == null ? null : representative.trim();
    }

    public Integer getRepresentativeType() {
        return representativeType;
    }

    public void setRepresentativeType(Integer representativeType) {
        this.representativeType = representativeType;
    }

    public Integer getRepresentativeNum() {
        return representativeNum;
    }

    public void setRepresentativeNum(Integer representativeNum) {
        this.representativeNum = representativeNum;
    }

    public Integer getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(Integer registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getMajorShareholder() {
        return majorShareholder;
    }

    public void setMajorShareholder(String majorShareholder) {
        this.majorShareholder = majorShareholder == null ? null : majorShareholder.trim();
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope == null ? null : businessScope.trim();
    }

    public String getRegistrationAuthority() {
        return registrationAuthority;
    }

    public void setRegistrationAuthority(String registrationAuthority) {
        this.registrationAuthority = registrationAuthority == null ? null : registrationAuthority.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality == null ? null : municipality.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getBusinessContact() {
        return businessContact;
    }

    public void setBusinessContact(String businessContact) {
        this.businessContact = businessContact == null ? null : businessContact.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress == null ? null : emailAddress.trim();
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite == null ? null : webSite.trim();
    }

    public String getCodeFile() {
        return codeFile;
    }

    public void setCodeFile(String codeFile) {
        this.codeFile = codeFile == null ? null : codeFile.trim();
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense == null ? null : businessLicense.trim();
    }

    public String getElectronicFile() {
        return electronicFile;
    }

    public void setElectronicFile(String electronicFile) {
        this.electronicFile = electronicFile == null ? null : electronicFile.trim();
    }

    public String getPersonIdcard() {
        return personIdcard;
    }

    public void setPersonIdcard(String personIdcard) {
        this.personIdcard = personIdcard == null ? null : personIdcard.trim();
    }

    public Integer getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(Integer taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getOpenAccountFile() {
        return openAccountFile;
    }

    public void setOpenAccountFile(String openAccountFile) {
        this.openAccountFile = openAccountFile == null ? null : openAccountFile.trim();
    }

    public String getFinancialFile() {
        return financialFile;
    }

    public void setFinancialFile(String financialFile) {
        this.financialFile = financialFile == null ? null : financialFile.trim();
    }

    public String getOrganizationElectronicFile() {
        return organizationElectronicFile;
    }

    public void setOrganizationElectronicFile(String organizationElectronicFile) {
        this.organizationElectronicFile = organizationElectronicFile;
    }
    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Information that = (Information) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (entIdentity != null ? !entIdentity.equals(that.entIdentity) : that.entIdentity != null) return false;
        if (entName != null ? !entName.equals(that.entName) : that.entName != null) return false;
        if (entDocumentType != null ? !entDocumentType.equals(that.entDocumentType) : that.entDocumentType != null)
            return false;
        if (entCreditCode != null ? !entCreditCode.equals(that.entCreditCode) : that.entCreditCode != null)
            return false;
        if (registrationNumber != null ? !registrationNumber.equals(that.registrationNumber) : that.registrationNumber != null)
            return false;
        if (taxRegistrationNumber != null ? !taxRegistrationNumber.equals(that.taxRegistrationNumber) : that.taxRegistrationNumber != null)
            return false;
        if (institutionCode != null ? !institutionCode.equals(that.institutionCode) : that.institutionCode != null)
            return false;
        if (representative != null ? !representative.equals(that.representative) : that.representative != null)
            return false;
        if (representativeType != null ? !representativeType.equals(that.representativeType) : that.representativeType != null)
            return false;
        if (representativeNum != null ? !representativeNum.equals(that.representativeNum) : that.representativeNum != null)
            return false;
        if (registeredCapital != null ? !registeredCapital.equals(that.registeredCapital) : that.registeredCapital != null)
            return false;
        if (majorShareholder != null ? !majorShareholder.equals(that.majorShareholder) : that.majorShareholder != null)
            return false;
        if (businessScope != null ? !businessScope.equals(that.businessScope) : that.businessScope != null)
            return false;
        if (registrationAuthority != null ? !registrationAuthority.equals(that.registrationAuthority) : that.registrationAuthority != null)
            return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;
        if (municipality != null ? !municipality.equals(that.municipality) : that.municipality != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (county != null ? !county.equals(that.county) : that.county != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (businessContact != null ? !businessContact.equals(that.businessContact) : that.businessContact != null)
            return false;
        if (mobilePhone != null ? !mobilePhone.equals(that.mobilePhone) : that.mobilePhone != null) return false;
        if (emailAddress != null ? !emailAddress.equals(that.emailAddress) : that.emailAddress != null) return false;
        if (zipCode != null ? !zipCode.equals(that.zipCode) : that.zipCode != null) return false;
        if (webSite != null ? !webSite.equals(that.webSite) : that.webSite != null) return false;
        if (codeFile != null ? !codeFile.equals(that.codeFile) : that.codeFile != null) return false;
        if (businessLicense != null ? !businessLicense.equals(that.businessLicense) : that.businessLicense != null)
            return false;
        if (electronicFile != null ? !electronicFile.equals(that.electronicFile) : that.electronicFile != null)
            return false;
        if (personIdcard != null ? !personIdcard.equals(that.personIdcard) : that.personIdcard != null) return false;
        if (taxNumber != null ? !taxNumber.equals(that.taxNumber) : that.taxNumber != null) return false;
        if (openAccountFile != null ? !openAccountFile.equals(that.openAccountFile) : that.openAccountFile != null)
            return false;
        if (financialFile != null ? !financialFile.equals(that.financialFile) : that.financialFile != null)
            return false;
        if (organizationElectronicFile != null ? !organizationElectronicFile.equals(that.organizationElectronicFile) : that.organizationElectronicFile != null)
            return false;
        if (entLogo != null ? !entLogo.equals(that.entLogo) : that.entLogo != null) return false;
        if (certificationStatus != null ? !certificationStatus.equals(that.certificationStatus) : that.certificationStatus != null)
            return false;
        return creatorId != null ? creatorId.equals(that.creatorId) : that.creatorId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (entIdentity != null ? entIdentity.hashCode() : 0);
        result = 31 * result + (entName != null ? entName.hashCode() : 0);
        result = 31 * result + (entDocumentType != null ? entDocumentType.hashCode() : 0);
        result = 31 * result + (entCreditCode != null ? entCreditCode.hashCode() : 0);
        result = 31 * result + (registrationNumber != null ? registrationNumber.hashCode() : 0);
        result = 31 * result + (taxRegistrationNumber != null ? taxRegistrationNumber.hashCode() : 0);
        result = 31 * result + (institutionCode != null ? institutionCode.hashCode() : 0);
        result = 31 * result + (representative != null ? representative.hashCode() : 0);
        result = 31 * result + (representativeType != null ? representativeType.hashCode() : 0);
        result = 31 * result + (representativeNum != null ? representativeNum.hashCode() : 0);
        result = 31 * result + (registeredCapital != null ? registeredCapital.hashCode() : 0);
        result = 31 * result + (majorShareholder != null ? majorShareholder.hashCode() : 0);
        result = 31 * result + (businessScope != null ? businessScope.hashCode() : 0);
        result = 31 * result + (registrationAuthority != null ? registrationAuthority.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (municipality != null ? municipality.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (county != null ? county.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (businessContact != null ? businessContact.hashCode() : 0);
        result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (webSite != null ? webSite.hashCode() : 0);
        result = 31 * result + (codeFile != null ? codeFile.hashCode() : 0);
        result = 31 * result + (businessLicense != null ? businessLicense.hashCode() : 0);
        result = 31 * result + (electronicFile != null ? electronicFile.hashCode() : 0);
        result = 31 * result + (personIdcard != null ? personIdcard.hashCode() : 0);
        result = 31 * result + (taxNumber != null ? taxNumber.hashCode() : 0);
        result = 31 * result + (openAccountFile != null ? openAccountFile.hashCode() : 0);
        result = 31 * result + (financialFile != null ? financialFile.hashCode() : 0);
        result = 31 * result + (organizationElectronicFile != null ? organizationElectronicFile.hashCode() : 0);
        result = 31 * result + (entLogo != null ? entLogo.hashCode() : 0);
        result = 31 * result + (certificationStatus != null ? certificationStatus.hashCode() : 0);
        result = 31 * result + (creatorId != null ? creatorId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Information{" +
                "id=" + id +
                ", entIdentity=" + entIdentity +
                ", entName='" + entName + '\'' +
                ", entDocumentType=" + entDocumentType +
                ", entCreditCode='" + entCreditCode + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", taxRegistrationNumber='" + taxRegistrationNumber + '\'' +
                ", institutionCode='" + institutionCode + '\'' +
                ", representative='" + representative + '\'' +
                ", representativeType=" + representativeType +
                ", representativeNum=" + representativeNum +
                ", registeredCapital=" + registeredCapital +
                ", majorShareholder='" + majorShareholder + '\'' +
                ", businessScope='" + businessScope + '\'' +
                ", registrationAuthority='" + registrationAuthority + '\'' +
                ", telephone='" + telephone + '\'' +
                ", municipality='" + municipality + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", address='" + address + '\'' +
                ", businessContact='" + businessContact + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", zipCode=" + zipCode +
                ", webSite='" + webSite + '\'' +
                ", codeFile='" + codeFile + '\'' +
                ", businessLicense='" + businessLicense + '\'' +
                ", electronicFile='" + electronicFile + '\'' +
                ", personIdcard='" + personIdcard + '\'' +
                ", taxNumber=" + taxNumber +
                ", openAccountFile='" + openAccountFile + '\'' +
                ", financialFile='" + financialFile + '\'' +
                ", organizationElectronicFile='" + organizationElectronicFile + '\'' +
                ", entLogo='" + entLogo + '\'' +
                ", certificationStatus=" + certificationStatus +
                ", creatorId=" + creatorId +
                '}';
    }
}