package com.entity;

/**
 * Step4 entity. @author MyEclipse Persistence Tools
 */

public class Step4 implements java.io.Serializable {

	// Fields

	private String step4Key;
	private String step4Value;

	// Constructors

	/** default constructor */
	public Step4() {
	}

	/** minimal constructor */
	public Step4(String step4Key) {
		this.step4Key = step4Key;
	}

	/** full constructor */
	public Step4(String step4Key, String step4Value) {
		this.step4Key = step4Key;
		this.step4Value = step4Value;
	}

	// Property accessors

	public String getStep4Key() {
		return this.step4Key;
	}

	public void setStep4Key(String step4Key) {
		this.step4Key = step4Key;
	}

	public String getStep4Value() {
		return this.step4Value;
	}

	public void setStep4Value(String step4Value) {
		this.step4Value = step4Value;
	}

}