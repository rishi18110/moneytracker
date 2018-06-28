package com.money.moneytrackerpojo;

import java.util.Date;

public class CashBook {
	private int acid ;
	private String account;
	private Date tran_date;
	private Double amount;
	private int userid;
	private String operation;
	public CashBook(int acid, String account, Date tran_date, Double amount, int userid, String operation) {
		super();
		this.acid = acid;
		this.account = account;
		this.tran_date = tran_date;
		this.amount = amount;
		this.userid = userid;
		this.operation = operation;
	}
	public CashBook() {
		super();
	}
	public int getAcid() {
		return acid;
	}
	public void setAcid(int acid) {
		this.acid = acid;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Date getTran_date() {
		return tran_date;
	}
	public void setTran_date(Date tran_date) {
		this.tran_date = tran_date;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + acid;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((operation == null) ? 0 : operation.hashCode());
		result = prime * result + ((tran_date == null) ? 0 : tran_date.hashCode());
		result = prime * result + userid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CashBook other = (CashBook) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (acid != other.acid)
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (operation == null) {
			if (other.operation != null)
				return false;
		} else if (!operation.equals(other.operation))
			return false;
		if (tran_date == null) {
			if (other.tran_date != null)
				return false;
		} else if (!tran_date.equals(other.tran_date))
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CashBook [acid=" + acid + ", account=" + account + ", tran_date=" + tran_date + ", amount=" + amount
				+ ", userid=" + userid + ", operation=" + operation + "]";
	}
	
	
}
