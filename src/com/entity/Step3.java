package com.entity;

/**
 * Step3 entity. @author MyEclipse Persistence Tools
 */

public class Step3 implements java.io.Serializable {

	// Fields

	private String step3Key;
	private String step3Value;

	// Constructors

	/** default constructor */
	public Step3() {
	}

	/** minimal constructor */
	public Step3(String step3Key) {
		this.step3Key = step3Key;
	}

	/** full constructor */
	public Step3(String step3Key, String step3Value) {
		this.step3Key = step3Key;
		this.step3Value = step3Value;
	}

	// Property accessors

	public String getStep3Key() {
		return this.step3Key;
	}

	public void setStep3Key(String step3Key) {
		this.step3Key = step3Key;
	}

	public String getStep3Value() {
		return this.step3Value;
	}

	public void setStep3Value(String step3Value) {
		this.step3Value = step3Value;
	}

}