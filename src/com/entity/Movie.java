package com.entity;

/**
 * Movie entity. @author MyEclipse Persistence Tools
 */

public class Movie implements java.io.Serializable {

	// Fields

	private Integer mid;
	private String mname;
	private Integer audience;

	// Constructors

	/** default constructor */
	public Movie() {
	}

	/** minimal constructor */
	public Movie(Integer mid) {
		this.mid = mid;
	}

	/** full constructor */
	public Movie(Integer mid, String mname, Integer audience) {
		this.mid = mid;
		this.mname = mname;
		this.audience = audience;
	}

	public Movie(Integer mid, String mname) {
		this.mid = mid;
		this.mname = mname;
	}
	// Property accessors

	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public Integer getAudience() {
		return this.audience;
	}

	public void setAudience(Integer audience) {
		this.audience = audience;
	}

}