package com.abandon.service;

import java.util.List;

import com.abandon.domain.MeetingroomInfo;

/**
 * 会议室信息处理业务逻辑接口
 * @author Administrator
 *
 */
public interface MeetingroomService {
	/**
	 * 查询多个会议室信息
	 * @param meetingroomInfo 
	 * @return 多个会议室信息
	 */
	public List<MeetingroomInfo> getAllMeetingroomInfo(MeetingroomInfo meetingroomInfo);
	/**
	 * 添加会议室信息 并在设备信息中更新会议室id
	 * @param meetingroomInfo 会议室信息
	 * @param enquipmentIds		设备信息id
	 * @return	true 成功 false失败
	 */
	public boolean AddMetingroomInfo(MeetingroomInfo meetingroomInfo,String enquipmentIds);
	/**
	 * 查询单个会议室信息
	 * @param meetingroomId 查询条件
	 * @return	会议室信息
	 */
	public MeetingroomInfo getMetingroomInfo(String meetingroomId);
	/**
	 * 更新会议室信息 并在设备信息中更新设备id
	 * @param meetingroomInfo 会议室信息
	 * @param enquipmentIds	设备id
	 * @return	true 成功 false失败
	 */
	public boolean updateMetingroomInfo(MeetingroomInfo meetingroomInfo,String enquipmentIds);
	/**
	 * 根据会议室编号 删除会议室信息（家删除）
	 * @param meetingroomInfo 会议室信息
	 * @return	true 成功 false失败
	 */
	public boolean deleteMetingroomInfo(String meetingroomId);
}
