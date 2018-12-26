package com.abandon.service;

import java.util.List;


import com.abandon.domain.UserInfo;

/**
  * 用户信息业务逻辑接口
  * @author Administrator
  *
  */
public interface UserInfoService {
	/**
	 * 判断用户账号密码
	 * @param userId	账号
	 * @param passWord	密码
	 * @return	用户信息
	 */
	public UserInfo isLogin(String userId,String passWord);
	/**
	 * 添加用户信息
	 * @param userInfo 添加信息
	 * @return	操作成功与否判断
	 */
	public boolean add(UserInfo userInfo);
	/**
	 * 根据条件查询有效用户信息  其余可为空 支持模糊 
	 * @param user	查询条件	（name，sex）
	 * @return	多个用户信息
	 */
	public List<UserInfo> selectUser(UserInfo user);
	/**
	 * 根据id查询单个用户
	 * @param userId 账号
	 * @return	单个用户信息
	 */
	public UserInfo getUser(String userId);
	/**
	 * 更新用户信息
	 * @param user 查询条件
	 * @return	操作成功与否判断true 成功
	 */
	public boolean updateUser(UserInfo user);
	/**
	 * 删除用户信息（假删除为修改isuse）
	 * @param id 删除条件
	 * 
	 * @return 判断是 true 成功
	 */
	public boolean deleteUser(String id);
	/**
	 * 变更用户权限
	 * @param user  变更信息
	 * @return true 成功
	 */
	public boolean changeAnthority(UserInfo user);
	
	

}
