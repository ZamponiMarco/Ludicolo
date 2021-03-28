package sample;

import java.util.Date;

public class AccountingPeriod {
	
	private Date startDate;
	private Date endDate;
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "AccountingPeriod [startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	
	
	
}
