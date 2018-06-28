package com.money.moneytrackerpojo;

import java.util.Date;

public class Expenses {
	private int exp_id;
	private String exp_ac;
	private int userid;
	private  int exp_catid;
	private Double amount;
	private Date tran_date;
	private String payby;
	private String remark;
	public Expenses(int exp_id, String exp_ac, int userid, int exp_catid, Double amount, Date tran_date, String payby,
			String remark) {
		super();
		this.exp_id = exp_id;
		this.exp_ac = exp_ac;
		this.userid = userid;
		this.exp_catid = exp_catid;
		this.amount = amount;
		this.tran_date = tran_date;
		this.payby = payby;
		this.remark = remark;
	}
	public Expenses() {
		super();
	}
	public int getExp_id() {
		return exp_id;
	}
	public void setExp_id(int exp_id) {
		this.exp_id = exp_id;
	}
	public String getExp_ac() {
		return exp_ac;
	}
	public void setExp_ac(String exp_ac) {
		this.exp_ac = exp_ac;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getExp_catid() {
		return exp_catid;
	}
	public void setExp_catid(int exp_catid) {
		this.exp_catid = exp_catid;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getTran_date() {
		return tran_date;
	}
	public void setTran_date(Date tran_date) {
		this.tran_date = tran_date;
	}
	public String getPayby() {
		return payby;
	}
	public void setPayby(String payby) {
		this.payby = payby;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((exp_ac == null) ? 0 : exp_ac.hashCode());
		result = prime * result + exp_catid;
		result = prime * result + exp_id;
		result = prime * result + ((payby == null) ? 0 : payby.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
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
		Expenses other = (Expenses) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (exp_ac == null) {
			if (other.exp_ac != null)
				return false;
		} else if (!exp_ac.equals(other.exp_ac))
			return false;
		if (exp_catid != other.exp_catid)
			return false;
		if (exp_id != other.exp_id)
			return false;
		if (payby == null) {
			if (other.payby != null)
				return false;
		} else if (!payby.equals(other.payby))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
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
		return "Expenses [exp_id=" + exp_id + ", exp_ac=" + exp_ac + ", userid=" + userid + ", exp_catid=" + exp_catid
				+ ", amount=" + amount + ", tran_date=" + tran_date + ", payby=" + payby + ", remark=" + remark + "]";
	}
	
	

}
