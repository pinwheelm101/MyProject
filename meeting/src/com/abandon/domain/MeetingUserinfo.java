package com.abandon.domain;

public class MeetingUserinfo {
	private String userName;
	
	private String userSex;
	
	private Integer userAge;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column meeting_userinfo.meetingrooom_user_id
	 * @mbg.generated  Mon Dec 17 23:21:18 CST 2018
	 */
	private Integer meetingrooomUserId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column meeting_userinfo.user_id
	 * @mbg.generated  Mon Dec 17 23:21:18 CST 2018
	 */
	private String userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column meeting_userinfo.bespeak_id
	 * @mbg.generated  Mon Dec 17 23:21:18 CST 2018
	 */
	private Integer bespeakId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column meeting_userinfo.meetingrooom_user_id
	 * @return  the value of meeting_userinfo.meetingrooom_user_id
	 * @mbg.generated  Mon Dec 17 23:21:18 CST 2018
	 */
	public Integer getMeetingrooomUserId() {
		return meetingrooomUserId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column meeting_userinfo.meetingrooom_user_id
	 * @param meetingrooomUserId  the value for meeting_userinfo.meetingrooom_user_id
	 * @mbg.generated  Mon Dec 17 23:21:18 CST 2018
	 */
	public void setMeetingrooomUserId(Integer meetingrooomUserId) {
		this.meetingrooomUserId = meetingrooomUserId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column meeting_userinfo.user_id
	 * @return  the value of meeting_userinfo.user_id
	 * @mbg.generated  Mon Dec 17 23:21:18 CST 2018
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column meeting_userinfo.user_id
	 * @param userId  the value for meeting_userinfo.user_id
	 * @mbg.generated  Mon Dec 17 23:21:18 CST 2018
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column meeting_userinfo.bespeak_id
	 * @return  the value of meeting_userinfo.bespeak_id
	 * @mbg.generated  Mon Dec 17 23:21:18 CST 2018
	 */
	public Integer getBespeakId() {
		return bespeakId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column meeting_userinfo.bespeak_id
	 * @param bespeakId  the value for meeting_userinfo.bespeak_id
	 * @mbg.generated  Mon Dec 17 23:21:18 CST 2018
	 */
	public void setBespeakId(Integer bespeakId) {
		this.bespeakId = bespeakId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	@Override
	public String toString() {
		return "MeetingUserinfo [userName=" + userName + ", userSex=" + userSex + ", userAge=" + userAge
				+ ", meetingrooomUserId=" + meetingrooomUserId + ", userId=" + userId + ", bespeakId=" + bespeakId
				+ "]";
	}
	
	
}