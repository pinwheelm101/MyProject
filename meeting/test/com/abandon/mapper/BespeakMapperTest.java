package com.abandon.mapper;




import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.abandon.domain.MeetingroomSetting;
import com.abandon.service.BespeakService;
import com.abandon.service.impl.BespeakServiceImpl;
import com.abandon.utils.DBFactoryUtils;

public class BespeakMapperTest {
	@Test
	public void addBespeak(){
		SqlSession session = DBFactoryUtils.getSqlSession();
		BespeakMapper mapper = session.getMapper(BespeakMapper.class);
		MeetingroomSetting bespeakInfo=new MeetingroomSetting();
		
		bespeakInfo.setBespeakId(02314);
		System.out.println(bespeakInfo.getApplyTime());
		int i= mapper.AddmeetingroomSetting(bespeakInfo);
		if(i>0) {
			System.out.println("添加会议预约信息成功");
		}else {
			System.out.println("添加会议预约信息失败");
		}
	
	}
	@Test
	public void get() {
		SqlSession session = DBFactoryUtils.getSqlSession();
		BespeakMapper mapper = session.getMapper(BespeakMapper.class);
		MeetingroomSetting bespeakInfo=new MeetingroomSetting();
		
		bespeakInfo.setMeetingName("%521%");
		
		List<MeetingroomSetting> li = mapper.getAllMeetingroomSetting(bespeakInfo);
		
		for(MeetingroomSetting jj:li) {
			System.out.println(jj);
		}
	}
	
	@Test
	public void getone() {
		BespeakMapper mapper =DBFactoryUtils.getMapper(BespeakMapper.class);
		
		MeetingroomSetting bespeakInfo=new MeetingroomSetting();
		
	 bespeakInfo = mapper.getMeetingroomSetting("1235");
		
		System.out.println( bespeakInfo);
				
	}
	@Test 
	public void getall() {
		//业务
		BespeakService service = new BespeakServiceImpl();
		//查询未审核信息
		MeetingroomSetting bespeak=new MeetingroomSetting();
		bespeak.setBespeakState("0");
		List<MeetingroomSetting> list = service.getAllMeetingroomSetting(bespeak);
			
		for(MeetingroomSetting mm:list) {
				System.out.println(mm);
		}
	}
}
