package com.abandon.mapper;

import java.util.List;

import com.abandon.domain.UserInfo;
/*
 * 用户信息访问接口
 */
public interface UserInfoMapper {
	/**
	 * 根据条件查询用户信息
	 * @param user	查询条件 账号密码 是否有效
	 * @return	用户信息
	 */
	public UserInfo getUser(UserInfo user);
	/**
	 * 添加用户信息
	 * @param user 
	 * @return 影响行数帮助后续判断
	 */
	public int addUser(UserInfo user);
	/**
	 * 查询多个用户信息
	 * @param user 查询条件 用户信息
	 * @return 返回的多个用户信息
	 */
	public List<UserInfo> selectUser(UserInfo user);
	/**
	 * 根据用户id查询单个用户信息
	 * @param id 查询条件
	 * @return 查询到的用户信息
	 */
	public UserInfo getUserInfo(String id);
	/**
	 * 修改更新用户信息
	 * @param user	需要修改的信息
	 * @return	返回影响行数 作为操作成功的判断
	 */
	public int updateUser(UserInfo user);
	/**
	 *	根据用户id 删除用户信息	如果存在外键则不成功 做假删除
	 * @param userId 	tiaojian
	 * @return	影响行数
	 */
	//public int deleteUser(String userId);
}
