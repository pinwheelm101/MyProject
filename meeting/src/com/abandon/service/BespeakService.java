package com.abandon.service;

import java.util.List;

import com.abandon.domain.MeetingroomSetting;


/**
 * 会议室预约信息业务处理接口
 * @author Administrator
 *
 */
public interface BespeakService {
	/**
	 *	添加会议室预约信息
	 * @param bespeak	预约信息
	 * @param userIds	参加会议用户id
	 * @return	true 成功 false 失败
	 */
	public boolean AddBespeakInfo(MeetingroomSetting bespeak,String userIds);
	/**
	 * 获取会议室预约信息
	 * @param bespeakInfo 查询条件
	 * @return	多个会议室预约信息
	 */
	public List<MeetingroomSetting> getAllMeetingroomSetting(MeetingroomSetting bespeakInfo);
	/**
	 * 根据id查询会议室预约信息 （包括对应的会议室名称）
	 * @param id	查询条件
	 * @return	单个会议预约信息
	 */
	public MeetingroomSetting  getMeetingroomSetting(String id);
	/**
	 * 更新会议预约信息
	 * @param bespeak	更新内容 
	 * @param userIds	参加会议人员ids
	 * @return	true 成功 false 失败
	 */
	public boolean updatemeetingroomSetting(MeetingroomSetting bespeak,String userIds);
	/**
	 * 更新会议预约信息
	 * @param bespeak 会议预约信息 （）
	 * @return true 成功 false 失败
	 */
	public boolean  updateBespeakAuditing(MeetingroomSetting bespeak);
}
