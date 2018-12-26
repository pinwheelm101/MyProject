package com.abandon.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.abandon.domain.MeetingUserinfo;
import com.abandon.utils.DBFactoryUtils;


public class MeetingUserinfoMapperTest {
	@Test
	public void add() {
		SqlSession session = DBFactoryUtils.getSqlSession();
		MeetingUserinfoMapper mapper = session.getMapper(MeetingUserinfoMapper.class);
		MeetingUserinfo meetingUserinfo = new MeetingUserinfo();
		meetingUserinfo.setBespeakId(11);
		meetingUserinfo.setMeetingrooomUserId(021041);
		meetingUserinfo.setUserId("admin");

		
		try {
			int i = mapper.addMeetingUserinfo(meetingUserinfo);
			if(i>0) {
				session.commit();
				System.out.println("tianjai 成功");
			}else System.out.println("shibai  失败");
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}
	}
	
	@Test
	public void getall() {
		MeetingUserinfoMapper mapper = DBFactoryUtils.getMapper(MeetingUserinfoMapper.class);
		
		List<MeetingUserinfo> list = mapper.getAllMeetingUserinfo("1235");
		
		for(MeetingUserinfo mm: list) {
			System.out.println(mm);
		}
	}
}
