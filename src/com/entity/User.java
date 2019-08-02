package com.entity;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String uname;
	private String password;
	private String sex;
	private String score1;
	private String score2;
	private String score3;
	private String score4;
	private String score5;
	private String score6;
	private String score7;
	private String recommend;

	// Constructors

	/** default constructor */
	public User() {
	}

	public User(int uid,String uname,String password,String sex,String score1,String score2,String score3,String score4,String score5,String score6,String score7) {
		this.uid = uid;
		this.uname = uname;
		this.password = password;
		this.sex = sex;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
		this.score4 = score4;
		this.score5 = score5;
		this.score6 = score6;
		this.score7 = score7;
	}
	/** minimal constructor */
	public User(Integer uid) {
		this.uid = uid;
	}

	/** full constructor */
	public User(Integer uid, String uname, String password, String sex,
			String score1, String score2, String score3, String score4,
			String score5, String score6, String score7, String recommend) {
		this.uid = uid;
		this.uname = uname;
		this.password = password;
		this.sex = sex;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
		this.score4 = score4;
		this.score5 = score5;
		this.score6 = score6;
		this.score7 = score7;
		this.recommend = recommend;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getScore1() {
		return this.score1;
	}

	public void setScore1(String score1) {
		this.score1 = score1;
	}

	public String getScore2() {
		return this.score2;
	}

	public void setScore2(String score2) {
		this.score2 = score2;
	}

	public String getScore3() {
		return this.score3;
	}

	public void setScore3(String score3) {
		this.score3 = score3;
	}

	public String getScore4() {
		return this.score4;
	}

	public void setScore4(String score4) {
		this.score4 = score4;
	}

	public String getScore5() {
		return this.score5;
	}

	public void setScore5(String score5) {
		this.score5 = score5;
	}

	public String getScore6() {
		return this.score6;
	}

	public void setScore6(String score6) {
		this.score6 = score6;
	}

	public String getScore7() {
		return this.score7;
	}

	public void setScore7(String score7) {
		this.score7 = score7;
	}

	public String getRecommend() {
		return this.recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

}