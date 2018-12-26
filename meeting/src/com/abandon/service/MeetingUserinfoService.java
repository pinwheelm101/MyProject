package com.abandon.service;

import java.util.List;

import com.abandon.domain.MeetingUserinfo;

public interface MeetingUserinfoService {
	/**
	 * 查询参加会议人员信息
	 * @param bespeakId	插叙条件 会议预约id
	 * @return 多个会议人员信息
	 */
	public List<MeetingUserinfo> getAllMeetingUserinfo(String bespeakId);
	
	
}
