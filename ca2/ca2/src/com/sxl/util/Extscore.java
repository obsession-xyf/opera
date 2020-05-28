package com.sxl.util;

import java.util.Date;

//会员积分
public class Extscore {
private Long id;//交易流水号
private String cardNo;//会员卡号
private Date date;//交易日期
private String remarks;//描述
private double points;//积分制
private double balancePoints;//剩余积分
private double expense;//积分金额
private String terminalId;//终端号
private String saleDeptId;//销售部门
private String billType;//销售单据类型
private String srcId;//销售单据号
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getCardNo() {
	return cardNo;
}
public void setCardNo(String cardNo) {
	this.cardNo = cardNo;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getRemarks() {
	return remarks;
}
public void setRemarks(String remarks) {
	this.remarks = remarks;
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
public double getExpense() {
	return expense;
}
public void setExpense(double expense) {
	this.expense = expense;
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

}
