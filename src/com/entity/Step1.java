package com.entity;

/**
 * Step1 entity. @author MyEclipse Persistence Tools
 */

public class Step1 implements java.io.Serializable {

	// Fields

	private String step1Key;
	private String step1Value;

	// Constructors

	/** default constructor */
	public Step1() {
	}

	/** minimal constructor */
	public Step1(String step1Key) {
		this.step1Key = step1Key;
	}

	/** full constructor */
	public Step1(String step1Key, String step1Value) {
		this.step1Key = step1Key;
		this.step1Value = step1Value;
	}

	// Property accessors

	public String getStep1Key() {
		return this.step1Key;
	}

	public void setStep1Key(String step1Key) {
		this.step1Key = step1Key;
	}

	public String getStep1Value() {
		return this.step1Value;
	}

	public void setStep1Value(String step1Value) {
		this.step1Value = step1Value;
	}

}