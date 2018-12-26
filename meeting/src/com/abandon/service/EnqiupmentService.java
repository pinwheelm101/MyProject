package com.abandon.service;

import java.util.List;

import com.abandon.domain.EnquipmentInfo;
/**
 * 设备信息管理接口
 * @author Administrator
 *
 */
public interface EnqiupmentService {
	/**
	 * 添加设备信息
	 * @param enzheqiupment 信息
	 * @return	true 成功 false 失败
	 */
	public boolean addEqiument(EnquipmentInfo enquipment);
	/**
	 * 查询设备信息 支持模糊查询
	 * @param enqiupmentInfo 查询条件
	 * @return	结果list
	 */
	public List<EnquipmentInfo> getAllEnquipmentInfo(EnquipmentInfo enquipmentInfo);
	/**
	 * 根据设备id查询单个设备信息
	 * @param enqiupmentInfoId 设备id 条件
	 * @return	单个设备信息
	 */
	public  EnquipmentInfo getEnquipmentInfo(String enquipmentInfoId);
	/**
	 * 更新用户信息 
	 * @param enqiupmentInfo 跟新内容 （id为条件）
	 * @return	true 成功 false 失败
	 */
	public boolean updateEnquipmentInfo(EnquipmentInfo enquipmentInfo);
	/**
	 * 根据设备id 删除单个设备信息
	 * @param enqiupmentInfoId 设备id
	 * @return 	true 成功 false 失败
	 */
	public boolean dateEnquipmentInfo(String enquipmentInfoId);
	/**
	 * 查询所有设备信息
	 * @param enquipmentInfo	查询条件
	 * @return 返回多个查询信息 （会议室名称和用户姓名）
	 */
	public List<EnquipmentInfo> selectALLEnquipmentInfo(EnquipmentInfo enquipmentInfo);
	/**
	 * 根据设备id多表联查
	 * @param enquipmentInfoId 查询条件
	 * @return	单个用户信息 
	 */
	public EnquipmentInfo  gettTwoEnquipmentInfo(String enquipmentInfoId);
	/**
	 * 查询未使用设备信息  会议室id为空
	 * @param enquipmentInfo  
	 * @return	多个信息
	 */
	public List<EnquipmentInfo> getNotUseEnquipmentInfo();	
	/**
	 * 更新设备表中会议室id
	 * @param enquipmentId 查询条件
	 * @param meetingroomId 修改内容
	 * @return	影响行数
	 */
	public boolean  updateMeetingroomID(EnquipmentInfo enquipmentInfo);
	
	/**
	 * 根据会议室id获取设备信息
	 * @param meetingroomId 会议室id
	 * @return	多个设备信息
	 */
	public  List<EnquipmentInfo> getMroomIdEnquipmentInfo(String meetingroomId);
}
