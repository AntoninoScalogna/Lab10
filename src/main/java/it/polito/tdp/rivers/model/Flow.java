package it.polito.tdp.rivers.model;

import java.time.LocalDate;
import java.util.Date;

public class Flow {
	private Integer id;
	private Date day;
	private double flow;
	private River river;

	
	
	public Flow(Integer id,Date day, double flow, River river) {
		this.day = day;
		this.flow = flow;
		this.river = river;
		this.id=id;
	}
	
	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public double getFlow() {
		return flow;
	}

	public void setFlow(double flow) {
		this.flow = flow;
	}


	@Override
	public String toString() {
		return "Flow [id=" + id + ", day=" + day + ", flow=" + flow + ", river=" + river + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Flow other = (Flow) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
