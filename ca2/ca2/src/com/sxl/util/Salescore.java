package com.sxl.util;
//登记积分
public class Salescore {
private String cardNo;//会员卡号
private String terminalId;//终端号
private String saleDeptId;//销售部门
private String billType;//单据来源
private String srcId;//单据号
private double points;//销售积分
private double balancePoints;//当前剩余积分
private double amount;//消费金额
private String remarks;//摘要
private Long scoreId;//登记积分台帐号

public String getCardNo() {
	return cardNo;
}
public void setCardNo(String cardNo) {
	this.cardNo = cardNo;
}
public String getTerminalId() {
	return terminalId;
}
public void setTerminalId(String terminalId) {
	this.terminalId = terminalId;
}
public String getSaleDeptId() {
	return saleDeptId;
}
public void setSaleDeptId(String saleDeptId) {
	this.saleDeptId = saleDeptId;
}
public String getBillType() {
	return billType;
}
public void setBillType(String billType) {
	this.billType = billType;
}
public String getSrcId() {
	return srcId;
}
public void setSrcId(String srcId) {
	this.srcId = srcId;
}
public double getPoints() {
	return points;
}
public void setPoints(double points) {
	this.points = points;
}
public double getBalancePoints() {
	return balancePoints;
}
public void setBalancePoints(double balancePoints) {
	this.balancePoints = balancePoints;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public String getRemarks() {
	return remarks;
}
public void setRemarks(String remarks) {
	this.remarks = remarks;
}
public Long getScoreId() {
	return scoreId;
}
public void setScoreId(Long scoreId) {
	this.scoreId = scoreId;
}

}
