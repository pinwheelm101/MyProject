package com.abandon.mapper;

import java.util.List;

import org.junit.Test;

import com.abandon.domain.MeetingroomInfo;
import com.abandon.service.MeetingroomService;
import com.abandon.service.impl.MeetingroomServiceImpl;
import com.abandon.utils.DBFactoryUtils;

public class MeetingroomMapperTest {
	
	//@Test
	public void get() {
		MeetingroomInfoMapper mapper = DBFactoryUtils.getMapper(MeetingroomInfoMapper.class);
		MeetingroomInfo info =new MeetingroomInfo();
		info.setMeetingroomName("%一楼%");
		try {
			List<MeetingroomInfo> list = mapper.getAllMetingroomInfo(info);
			
			System.out.println(list);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void trrr() {
		MeetingroomInfo info =new MeetingroomInfo();
		MeetingroomService service = new MeetingroomServiceImpl();
		List<MeetingroomInfo> list = service.getAllMeetingroomInfo(info);
		System.out.println(list);
	}
}
