package com.abandon.mapper;

import java.util.List;

import com.abandon.domain.MeetingroomSetting;

/**
 * 预约信息数据访问接口
 * @author Administrator
 *
 */
public interface BespeakMapper {
	/**
	 * 添加会议室信息
	 * @param bespeakInfo 添加信息 (未审核状态)
	 * @return	影响行数
	 */
	public int AddmeetingroomSetting(MeetingroomSetting bespeakInfo);
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
	 * 更新会议室预约信息（id）
	 * @param bespeakInfo 更新内容机条件（id）
	 * @return	影响行数
	 */
	public int updatemeetingroomSetting(MeetingroomSetting bespeakInfo);
	/**
	 * 更新会议预约审核状态
	 * @param bespeak 更新信息
	 * @return 影响行数 
	 */
	public int updateBespeakAuditing(MeetingroomSetting bespeak);
}
