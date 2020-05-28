package com.sxl.util;

import java.util.Date;
//会员帐户
public class Extmember {
private String cardNo;//卡号
private String descrip;//会员描述（会员卡）
private Date issueDate;//开户时间
private String memberankId;//会员级别（003）
private String memberank;//会员级别名称
private Date brankDate;//会员级别考核日期
private String name;//姓名
private String address;//地址
private String tel;//固定电话
private String mobile;//手机
private String postalCode;//邮编
private String email;//邮箱
private String sex;//性别
private Date birthDay;//生日
private String idcardNo;//身份证号
private String cashierId;//操作人
private Date expiryDate;//有效期
private double points;//会员累计积分
private double expense;//会员累计消费金额
private double balancePoints;//会员剩余可用积分
private int node;//会员卡状态，-1作废，0正常，1挂停
public String getCardNo() {
	return cardNo;
}
public void setCardNo(String cardNo) {
	this.cardNo = cardNo;
}
public String getDescrip() {
	return descrip;
}
public void setDescrip(String descrip) {
	this.descrip = descrip;
}
public Date getIssueDate() {
	return issueDate;
}
public void setIssueDate(Date issueDate) {
	this.issueDate = issueDate;
}
public String getMemberankId() {
	return memberankId;
}
public void setMemberankId(String memberankId) {
	this.memberankId = memberankId;
}
public String getMemberank() {
	return memberank;
}
public void setMemberank(String memberank) {
	this.memberank = memberank;
}
public Date getBrankDate() {
	return brankDate;
}
public void setBrankDate(Date brankDate) {
	this.brankDate = brankDate;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getPostalCode() {
	return postalCode;
}
public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}

public Date getBirthDay() {
	return birthDay;
}
public void setBirthDay(Date birthDay) {
	this.birthDay = birthDay;
}
public String getIdcardNo() {
	return idcardNo;
}
public void setIdcardNo(String idcardNo) {
	this.idcardNo = idcardNo;
}
public String getCashierId() {
	return cashierId;
}
public void setCashierId(String cashierId) {
	this.cashierId = cashierId;
}
public Date getExpiryDate() {
	return expiryDate;
}
public void setExpiryDate(Date expiryDate) {
	this.expiryDate = expiryDate;
}
public double getPoints() {
	return points;
}
public void setPoints(double points) {
	this.points = points;
}
public double getExpense() {
	return expense;
}
public void setExpense(double expense) {
	this.expense = expense;
}
public double getBalancePoints() {
	return balancePoints;
}
public void setBalancePoints(double balancePoints) {
	this.balancePoints = balancePoints;
}
public int getNode() {
	return node;
}
public void setNode(int node) {
	this.node = node;
}

}
