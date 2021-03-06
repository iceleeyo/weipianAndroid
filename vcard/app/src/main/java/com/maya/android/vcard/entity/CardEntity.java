package com.maya.android.vcard.entity;

import com.google.gson.annotations.SerializedName;

/**
 * 名片信息
 * @author ZuoZiJi-Y.J
 * @version v1.0
 * @since 2014-2-18
 *
 */
public class CardEntity {
//	/**
//	 * 序号_id
//	 */
//	private static final long serialVersionUID = 100L;
	
	/**
	 * 名片ID
	 */
	@SerializedName("id")
	private Long id;
	/**
	 *  名片数量
	 */
	@SerializedName("cardCount")
	private int cardCount;
	/**
	 * 名片名称
	 */
	@SerializedName("cardName")
	private String cardName;
	/**
	 * 名片主体正面图片
	 */
	@SerializedName("cardImgA")
	private String cardImgA;
	/**
	 * 名片主体背面图片
	 */
	@SerializedName("cardImgB")
	private String cardImgB;
	/**
	 * 正面名片类别（0预留、1为扫描、2为模板、3为本地上传）
	 */
	@SerializedName("cardAType")
	private int cardAType;
	/**
	 * 背面名片类别（0预留、1为扫描、2为模板、3为本地上传）
	 */
	@SerializedName("cardBType")
	private int cardBType;
	/**
	 * 正面名片类型（0为不确定类型、1为90*54、2为90*45、3为90*94 ）
	 */
	@SerializedName("cardAForm")
	private int cardAForm;
	/**
	 * 背面名片类型（0为不确定类型、1为90*54、2为90*45、3为90*94 ）
	 */
	@SerializedName("cardBForm")
	private int cardBForm;
	/**
	 * 正面名片方向（0为横向、1为竖向）
	 */
	@SerializedName("cardAOrientation")
	private int cardAOrientation;
	/**
	 * 背面名片方向（0为横向、1为竖向）
	 */
	@SerializedName("cardBOrientation")
	private int cardBOrientation;
	/**
	 * 认证标准
	 */
	@SerializedName("enterpriseApproval")
	private int enterpriseApproval;
	/**
	 * 公司名称    格式：中文公司1（英文公司）#中文公司2#中文公司3
	 */
	@SerializedName("companyName")
	private String companyName;
	/**
	 * 职位
	 */
	@SerializedName("job")
	private String job;
	/**
	 * 手机号
	 */
	@SerializedName("mobileTelphone")
	private String mobileTelphone;
	/**
	 * 固话
	 */
	@SerializedName("lineTelphone")
	private String lineTelphone;
	/**
	 * 传真
	 */
	@SerializedName("fax")
	private String fax;
	/**
	 * 工作地址
	 */
	@SerializedName("workAddress")
	private String workAddress;
	/**
	 * 邮编
	 */
	@SerializedName("postcode")
	private String postcode;
	/**
	 * 电子邮箱
	 */
	@SerializedName("email")
	private String email;
	/**
	 * 行业
	 */
	@SerializedName("business")
	private int business = -1;
	/**
	 * 备注
	 */
	@SerializedName("description")
	private String remark;
	/**
	 * 公司简介
	 */
	@SerializedName("companyAbout")
	private String companyAbout; 
	/**
	 * QQ(弃用，改用imArrayJson字段) 
	 */
	@SerializedName("qq")
	private String qq;
	/**
	 * 微博(弃用，改用imArrayJson字段)
	 */
	@SerializedName("microblog")
	private String microblog; 
	/**
	 * 省份
	 */
	@SerializedName("province")
	private String province; 
	/**
	 * 国籍
	 */
	@SerializedName("country")
	private String country;
	/**
	 * 公司主页
	 */
	@SerializedName("companyHome")
	private String companyHome; 
	/**
	 * 名片模板ID
	 */
	@SerializedName("templateId")
	private long cardTemplateId;
	/**
	 * 二维码
	 */
	@SerializedName("qrCardPath")
	private String qrCardPath;

	/**
	 * 即时通讯json
	 */
	@SerializedName("imInfo")
	private String imJson;
	
//	/** 即时通讯列表 **/
//	@SerializedName("imInfoList")
//	private ArrayList<ImEntity> imList;
	
	/** 其他中文公司名称列表  **/
	@SerializedName("companyNameList")
	protected String otherCompanyNameList;
	
	/** 英文单位  **/
	@SerializedName("enCompanyName")
	private String enCompanyName;
	/**企业logo*/
	@SerializedName("companyLogo")
	private String companyLogo;
//	public long get_id() {
//		return _id;
//	}
//	public void set_id(long _id) {
//		this._id = _id;
//	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getCardCount() {
		return cardCount;
	}
	public void setCardCount(int cardCount) {
		this.cardCount = cardCount;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getCardImgA() {
		return cardImgA;
	}
	public void setCardImgA(String cardImgA) {
		this.cardImgA = cardImgA;
	}
	public String getCardImgB() {
		return cardImgB;
	}
	public void setCardImgB(String cardImgB) {
		this.cardImgB = cardImgB;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getMobileTelphone() {
		return mobileTelphone;
	}
	public void setMobileTelphone(String mobileTelphone) {
		this.mobileTelphone = mobileTelphone;
	}
	public String getLineTelphone() {
		return lineTelphone;
	}
	public void setLineTelphone(String lineTelphone) {
		this.lineTelphone = lineTelphone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getWorkAddress() {
		return workAddress;
	}
	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBusiness() {
		return business;
	}
	public void setBusiness(int business) {
		this.business = business;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCompanyAbout() {
		return companyAbout;
	}
	public void setCompanyAbout(String companyAbout) {
		this.companyAbout = companyAbout;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qQ) {
		qq = qQ;
	}
	public String getMicroblog() {
		return microblog;
	}
	public void setMicroblog(String microblog) {
		this.microblog = microblog;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCompanyHome() {
		return companyHome;
	}
	public void setCompanyHome(String pageHome) {
		this.companyHome = pageHome;
	}
	public long getCardTemplateId() {
		return cardTemplateId;
	}
	public void setCardTemplateId(long cardTemplateId) {
		this.cardTemplateId = cardTemplateId;
	}
	
	public String getQrCardPath() {
		return qrCardPath;
	}
	public void setQrCardPath(String qrCardPath) {
		this.qrCardPath = qrCardPath;
	}
	public int getCardAType() {
		return cardAType;
	}
	public void setCardAType(int cardAType) {
		this.cardAType = cardAType;
	}
	public int getCardBType() {
		return cardBType;
	}
	public void setCardBType(int cardBType) {
		this.cardBType = cardBType;
	}
	public int getCardAForm() {
		return cardAForm;
	}
	public void setCardAForm(int cardAForm) {
		this.cardAForm = cardAForm;
	}
	public int getCardBForm() {
		return cardBForm;
	}
	public void setCardBForm(int cardBForm) {
		this.cardBForm = cardBForm;
	}
	public int getCardAOrientation() {
		return cardAOrientation;
	}
	public void setCardAOrientation(int cardAOrientation) {
		this.cardAOrientation = cardAOrientation;
	}
	public int getCardBOrientation() {
		return cardBOrientation;
	}
	public void setCardBOrientation(int cardBOrientation) {
		this.cardBOrientation = cardBOrientation;
	}
	public int getEnterpriseApproval() {
		return enterpriseApproval;
	}
	public void setEnterpriseApproval(int enterpriseApproval) {
		this.enterpriseApproval = enterpriseApproval;
	}
	/**
	 * 复制对象的基础类型
	 */
	public CardEntity clone() {
		CardEntity newCard= null;
		try {
			newCard = (CardEntity) super.clone();
		} catch (CloneNotSupportedException e) {
		   e.printStackTrace();
		}
		return newCard;
	}

	public String getImJson() {
		return imJson;
	}

	public void setImJson(String imJson) {
		this.imJson = imJson;
	}
	
	public String getEnCompanyName() {
		return enCompanyName;
	}
	public void setEnCompanyName(String enCompanyName) {
		this.enCompanyName = enCompanyName;
	}
	public String getOtherCompanyNameList() {
		return otherCompanyNameList;
	}
	public void setOtherCompanyNameList(String otherCompanyNameList) {
		this.otherCompanyNameList = otherCompanyNameList;
	}
	public String getCompanyLogo() {
		return companyLogo;
	}
	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}
}
