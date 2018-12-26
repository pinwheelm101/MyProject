package com.abandon.mapper;

import java.util.List;

import com.abandon.domain.MeetingroomInfo;

/**
 * 会议室数据访问接口
 * @author Administrator
 *
 */
public interface MeetingroomInfoMapper {
	/**
	 * 查询多个会议室
	 * @param meetingroomInfo 查询条件
	 * @return	返回多个有效会议室
	 */
	public List<MeetingroomInfo> getAllMetingroomInfo(MeetingroomInfo meetingroomInfo);
	/**
	 * 添加会议室信息
	 * @param meetingroomInfo 添加的信息
	 * @return	 影响行数 
	 */
	public int AddMetingroomInfo(MeetingroomInfo meetingroomInfo);
	/**
	 * 根据id查询单个会议信息
	 * @param meetingroomId 查询条件
	 * @return	会议室信息
	 */
	public MeetingroomInfo getMetingroomInfo(String meetingroomId);
	/**
	 * 更新会议室信息
	 * @param meetingroomInfo 更新信息
	 * @return	 影响行数
	 */
	public int updateMetingroomInfo(MeetingroomInfo meetingroomInfo);
}
