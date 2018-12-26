package com.abandon.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import com.abandon.domain.UserInfo;
import com.abandon.utils.DBFactoryUtils;

public class UserInfoMapperTset {
	@Test
	public void selectUser() {
		UserInfoMapper mapper=DBFactoryUtils.getMapper(UserInfoMapper.class);
		
		UserInfo user=new UserInfo();
		
			user.setUserName("%李%");
			user.setUserSex("男");
		
		List<UserInfo> list=mapper.selectUser(user);
		
		for(UserInfo userInfo:list ) {
			System.out.println(userInfo);
		}
		
	}
	@Test
	public void getUserInfo() {
		UserInfoMapper mapper= DBFactoryUtils.getMapper(UserInfoMapper.class);
		
		UserInfo user= new UserInfo();
			user.setUserId("admin");
			UserInfo userResult=mapper.getUserInfo("admin");
			System.out.println(userResult);
		
	}
	@Test
	public void updateuser() {
		//UserInfoMapper mapper=DBFactoryUtils.getMapper(UserInfoMapper.class);
		//htttp协议 session
		SqlSession session=DBFactoryUtils.getSqlSession();
		
		try {
			UserInfoMapper mapper=session.getMapper(UserInfoMapper.class);
			UserInfo user=new UserInfo();
			user.setUserId("1523");
			user.setUserName("你好");
			int i=mapper.updateUser(user);
			if(i>0) {
				session.commit();
				System.out.println("修改成功");				
			}else {
				System.out.println("修改成功");
			}
		} catch (Exception e) {
			//回滚事物
			session.rollback();
			e.printStackTrace();
		}
		
		
	}
	
	
	@Test
	public void deleteUser() {
		SqlSession  session=DBFactoryUtils.getSqlSession();

		try {
			UserInfoMapper mapper=session.getMapper(UserInfoMapper.class);
			UserInfo user=new UserInfo();
			user.setUserId("1523");
			user.setUserName("你好");
			int i=mapper.updateUser(user);
			if(i>0) {
				session.commit();
				System.out.println("删除成功");				
			}else {
				System.out.println("删除失败");
			}
		} catch (Exception e) {
			//回滚事物
			session.rollback();
			e.printStackTrace();
		}
		
	}
}
