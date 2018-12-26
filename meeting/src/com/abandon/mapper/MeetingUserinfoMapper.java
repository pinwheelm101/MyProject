package com.abandon.mapper;

import java.util.List;

import com.abandon.domain.MeetingUserinfo;
/**
 * 参加会议人员数据接口
 * @author Administrator
 *
 */

public interface MeetingUserinfoMapper {
	/**
	 * 添加参加会议人员信息
	 * @param meetingUserinfo
	 * @return	影响行数
	 */
	public int addMeetingUserinfo(MeetingUserinfo meetingUserinfo);
	/**
	 * 查询参加会议人员信息
	 * @param bespeakId	插叙条件 会议预约id
	 * @return 多个会议人员信息
	 */
	public List<MeetingUserinfo> getAllMeetingUserinfo(String bespeakId);
	/**
	 * 删除参会议人员信息
	 * @param meetingUserinfo	参加会议人员信息
	 * @return	影响行数
	 */
	public int deleteMeetingUserinfo(MeetingUserinfo meetingUserinfo);
	
}
