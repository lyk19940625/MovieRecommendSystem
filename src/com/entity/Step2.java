package com.entity;

/**
 * Step2 entity. @author MyEclipse Persistence Tools
 */

public class Step2 implements java.io.Serializable {

	// Fields

	private String step2Key;
	private String step2Value;

	// Constructors

	/** default constructor */
	public Step2() {
	}

	/** minimal constructor */
	public Step2(String step2Key) {
		this.step2Key = step2Key;
	}

	/** full constructor */
	public Step2(String step2Key, String step2Value) {
		this.step2Key = step2Key;
		this.step2Value = step2Value;
	}

	// Property accessors

	public String getStep2Key() {
		return this.step2Key;
	}

	public void setStep2Key(String step2Key) {
		this.step2Key = step2Key;
	}

	public String getStep2Value() {
		return this.step2Value;
	}

	public void setStep2Value(String step2Value) {
		this.step2Value = step2Value;
	}

}