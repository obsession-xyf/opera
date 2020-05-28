package com.sxl.util;

import java.util.Date;

public class Extemoney {
	private String cardNo;// 卡号
	private String emoneyId;// 电子币帐号
	private String cardnoType;
	private String descrip;// 说明
	private String emoneymetaId;// e币类别
	private Date issueDate;// 签发时间
	private double issueAmount;// 签发金额
	private double balance;// 余额
	private Date effectiveDate;// 开始时间
	private Date invalidDate;// 结束时间
	private double shoping;// 消费金额
	private double paying;// 使用额度
	private String promeType;// 活动类型
	private String billType;// 单据类型
	private String couponrangesId;
	private String deptId;// 发币部门
	private String promeid;
	private boolean isLimit;
	private boolean isDiscount;
	
	public String getCardnoType() {
		return cardnoType;
	}
	public void setCardnoType(String cardnoType) {
		this.cardnoType = cardnoType;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getEmoneyId() {
		return emoneyId;
	}
	public void setEmoneyId(String emoneyId) {
		this.emoneyId = emoneyId;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public String getEmoneymetaId() {
		return emoneymetaId;
	}
	public void setEmoneymetaId(String emoneymetaId) {
		this.emoneymetaId = emoneymetaId;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public double getIssueAmount() {
		return issueAmount;
	}
	public void setIssueAmount(double issueAmount) {
		this.issueAmount = issueAmount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public Date getInvalidDate() {
		return invalidDate;
	}
	public void setInvalidDate(Date invalidDate) {
		this.invalidDate = invalidDate;
	}
	public double getShoping() {
		return shoping;
	}
	public void setShoping(double shoping) {
		this.shoping = shoping;
	}
	public double getPaying() {
		return paying;
	}
	public void setPaying(double paying) {
		this.paying = paying;
	}
	public String getPromeType() {
		return promeType;
	}
	public void setPromeType(String promeType) {
		this.promeType = promeType;
	}
	public String getBillType() {
		return billType;
	}
	public void setBillType(String billType) {
		this.billType = billType;
	}
	public String getCouponrangesId() {
		return couponrangesId;
	}
	public void setCouponrangesId(String couponrangesId) {
		this.couponrangesId = couponrangesId;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getPromeid() {
		return promeid;
	}
	public void setPromeid(String promeid) {
		this.promeid = promeid;
	}
	public boolean isLimit() {
		return isLimit;
	}
	public void setLimit(boolean isLimit) {
		this.isLimit = isLimit;
	}
	public boolean isDiscount() {
		return isDiscount;
	}
	public void setDiscount(boolean isDiscount) {
		this.isDiscount = isDiscount;
	}

	
}
