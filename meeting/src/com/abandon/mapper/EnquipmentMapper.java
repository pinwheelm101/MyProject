package com.abandon.mapper;

import java.util.List;

import com.abandon.domain.EnquipmentInfo;
/**
 * 设备信息访问接口
 * @author Administrator
 *
 */
public interface EnquipmentMapper {
	/**
	 * 添加设备信息
	 * @param enzheqiupmentInfo 添加信息
	 * @return	影响行数
	 */
	public int addEnqiument(EnquipmentInfo enqiupmentInfo);
	/**
	 * 查询所有设备信息
	 * @param enqiupmentInfo 查询条件
	 * @return	查询信息list
	 */
	public List<EnquipmentInfo> getAllEnquipmentInfo(EnquipmentInfo enqiupmentInfo);
	/**
	 * 根据设备id查询单个设备信息
	 * 
	 * @param enqiupmentInfoId	查询条件
	 * @return	查询出的信息
	 */
	public EnquipmentInfo getEnquipmentInfo(String enquipmentInfoId);
	/**
	 * 更新设备信息
	 * @param enqiupmentInfo 更新内容 (设备名称 设备价格 备注 会议室id)
	 * @return 影响行数 
	 */
	public int  updateEnquipmentInfo(EnquipmentInfo enquipmentInfo);
	/**
	 * 删除设备信息
	 * @param enquipmentInfoId	条件 设备id
	 * 
	 * @return	影响行数
	 */
	public int deleteEnquipmentInfo(Integer enquipmentInfoId);
	/**
	 * 查询设备信息 多表联查
	 * @param enquipmentInfo 查询参数
	 * @return	多个设备信息(会议室名称，用户名在内)
	 */
	public List<EnquipmentInfo> selectEnquipmentInfo(EnquipmentInfo enquipmentInfo);
	/**
	 * 根据id 多表；联查 设备信息
	 * @param enquipmentInfoId 查询条件
	 * @return  单个设备信息(会议室名称，用户名在内)
	 */
	public EnquipmentInfo  gettTwoEnquipmentInfo(String enquipmentInfoId);
	/**
	 * 查询未使用设备信息
	 * @param  无   
	 * @return	多个信息
	 */
	public List<EnquipmentInfo> getNotUseEnquipmentInfo();
	/**
	 * 更新设备表中会议室id
	 * @param enquipmentId 查询条件
	 * @param meetingroomId 修改内容 (包含)
	 * @return	影响行数
	 */
	public int updateMeetingroomID(EnquipmentInfo enquipmentInfo);
	/**
	 * 根据会议室id获取设备信息
	 * @param meetingroomId 会议室id
	 * @return	多个设备信息
	 */
	public  List<EnquipmentInfo> getMroomIdEnquipmentInfo(String meetingroomId);
}
