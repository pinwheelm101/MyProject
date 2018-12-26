package com.abandon.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.abandon.domain.MeetingroomSetting;
import com.abandon.service.BespeakService;
import com.abandon.service.impl.BespeakServiceImpl;

public class ListSetMapTest {
	@Test
	public void Listsss(){
		BespeakService mapper = new BespeakServiceImpl();
		MeetingroomSetting bespeak = new MeetingroomSetting();
		bespeak.setUserId("admin");
		bespeak.setBespeakState("0");
		List<MeetingroomSetting> belist = mapper.getAllMeetingroomSetting(bespeak);
		//去重
		//List<MeetingroomSetting > list = belist.stream().collect(Collectors.toList());
		//Set<MeetingroomSetting> set= new HashSet<MeetingroomSetting>();
		//List<MeetingroomSetting> list= new ArrayList<MeetingroomSetting>();
		//set.addAll(belist);
		//list.addAll(set);
		for(MeetingroomSetting mm:belist) {
			System.out.println(mm);
		}
	}
}
