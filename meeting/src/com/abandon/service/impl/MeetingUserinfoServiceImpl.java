package com.abandon.service.impl;

import java.util.List;

import com.abandon.domain.MeetingUserinfo;
import com.abandon.mapper.MeetingUserinfoMapper;
import com.abandon.service.MeetingUserinfoService;
import com.abandon.utils.DBFactoryUtils;

public class MeetingUserinfoServiceImpl implements MeetingUserinfoService {

	@Override
	public List<MeetingUserinfo> getAllMeetingUserinfo(String bespeakId) {
		MeetingUserinfoMapper mapper= DBFactoryUtils.getMapper(MeetingUserinfoMapper.class);
		try {
			if(bespeakId!=null&&!"".equals(bespeakId)) {
				return mapper.getAllMeetingUserinfo(bespeakId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	

}
