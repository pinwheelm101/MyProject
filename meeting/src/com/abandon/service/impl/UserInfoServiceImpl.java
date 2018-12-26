package com.abandon.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.abandon.domain.UserInfo;
import com.abandon.mapper.UserInfoMapper;
import com.abandon.service.UserInfoService;
import com.abandon.utils.DBFactoryUtils;

public class UserInfoServiceImpl implements UserInfoService {
	
	@Override
	public UserInfo isLogin(String userId, String passWord) {
		//拿到接口 创建 数据访问对象
		UserInfoMapper mapper=DBFactoryUtils.getMapper(UserInfoMapper.class);
		try {
			//判断账号密码是否为空
			if(userId!=null&&passWord!=null) {
				UserInfo user=new UserInfo();
				user.setUserId(userId);
				user.setUserPw(passWord);
				//映射访问数据库
				return mapper.getUser(user);
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
//	public static void main(String[] args) {
//		UserInfoServiceImpl userService=new UserInfoServiceImpl();
//		UserInfo user=userService.isLogin("admin", "123");
//		System.out.println(user);
		
//	}
	@Override
	public boolean add(UserInfo userInfo) {
		SqlSession session=DBFactoryUtils.getSqlSession();
		UserInfoMapper mapper=session.getMapper(UserInfoMapper.class);
		//判断	
		try {
			if(userInfo!=null&&userInfo.getUserId()!=null&&userInfo.getUserPw()!=null) {
					int i =mapper.addUser(userInfo);
					//提交事务
					session.commit();
					if(i>0) {
						return true;
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
			//回滚事务
			session.rollback();
		}finally {
			//关闭
			session.close();
		}

		return false;
	}

	@Override
	public List<UserInfo> selectUser(UserInfo user) {
		try {
			UserInfoMapper mapper=DBFactoryUtils.getMapper(UserInfoMapper.class);
			//做判断有这些信息做姓名模糊查询
			if(user!=null&&user.getUserName()!=null&&!"".equals(user.getUserName())) {
				//生成模糊查询字段
				user.setUserName("%"+user.getUserName()+"%");
			}	
			
				List<UserInfo> list=mapper.selectUser(user);		
				return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public UserInfo getUser(String userId) {
				
		if(userId!=null&&!"".equals(userId)) {
			//拿到mapper
			UserInfoMapper mapper=DBFactoryUtils.getMapper(UserInfoMapper.class);
			//映射执行查询并返回结果
			return mapper.getUserInfo(userId);					
		}
			return null;
	}

	@Override
	public boolean updateUser(UserInfo user) {
		//拿到数据库访问session
		SqlSession session=DBFactoryUtils.getSqlSession();
		try {
			//拿到mapper
			UserInfoMapper mapper=session.getMapper(UserInfoMapper.class);
			
			//先做Id查询获取信息
			UserInfo userInfo=mapper.getUserInfo(user.getUserId());
			//将修改信息存入pojo中
			if(user!=null) {
				userInfo.setUserName(user.getUserName());
				userInfo.setUserPw(user.getUserPw());
				userInfo.setUserAge(user.getUserAge());
				userInfo.setUserPhone(user.getUserPhone());
				userInfo.setUserSex(user.getUserSex());
				if(user.getUserUrl()!=null) {
					userInfo.setUserUrl(user.getUserUrl());
				}	
				userInfo.setUserBeizhu(user.getUserBeizhu());
				//执行修改操作 并获取影响行数
				int i=mapper.updateUser(userInfo);
				if(i>0) {
					//提交session
					session.commit();
					
					return true;
				}else {
					return false;
				}
			}
												
		} catch (Exception e) {
			//回滚session
			session.rollback();
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public boolean deleteUser(String id) {
		SqlSession session=DBFactoryUtils.getSqlSession();
		try {
			UserInfoMapper mapper=session.getMapper(UserInfoMapper.class);
			if(id!=null) {
				//
				UserInfo user=mapper.getUserInfo(id);
				if(user!=null) {
					//设置为无效用户
					user.setIsUser("0");
					//更新信息
					int i = mapper.updateUser(user);
					//判断
					if(i>0) {
						session.commit();
						
						return true;
					}else {
						return false;
					}			
				}												
			}
		} catch (Exception e) {
			session.rollback();
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean changeAnthority(UserInfo user) {
		SqlSession session = DBFactoryUtils.getSqlSession();
		try {
			UserInfoMapper mapper=session.getMapper(UserInfoMapper.class);
			
			UserInfo userInfo = mapper.getUserInfo(user.getUserId());
			if(user!= null) {
				userInfo.setUserAnthority(user.getUserAnthority());
				int i=mapper.updateUser(userInfo);
				if(i>0) {
					session.commit();
					return true;
				}else {
					return false;
				}
			}
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}
		return false;
	}

	
}
