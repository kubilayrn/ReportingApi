package com.spring.https.api.form;



public class Report  {

	public Report() {
		super();
		
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public int getMerchant() {
		return merchant;
	}
	public void setMerchant(int merchant) {
		this.merchant = merchant;
	}
	public int getAcquirer() {
		return acquirer;
	}
	public void setAcquirer(int acquirer) {
		this.acquirer = acquirer;
	}
	public String fromDate;
	public String toDate;
	public int merchant;
	public int acquirer;
	
	
	
}
