package com.abandon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.abandon.domain.MeetingUserinfo;
import com.abandon.domain.MeetingroomSetting;
import com.abandon.mapper.BespeakMapper;
import com.abandon.mapper.MeetingUserinfoMapper;
import com.abandon.service.BespeakService;
import com.abandon.utils.DBFactoryUtils;

/*
 * fangfa
 */
public class BespeakServiceImpl  implements BespeakService {

	@Override
	public boolean AddBespeakInfo(MeetingroomSetting bespeak, String userIds) {
		SqlSession session = DBFactoryUtils.getSqlSession();
		BespeakMapper beMapper = session.getMapper(BespeakMapper.class);
		MeetingUserinfoMapper meMapper = session.getMapper(MeetingUserinfoMapper.class);
		//先添加会议室预约信息
		
		try {
				int i= beMapper.AddmeetingroomSetting(bespeak);
				int j=-1;
			if(userIds!=null&&!"".equals(userIds)) {
				String[] userId= userIds.split(",");
				for(String id:userId) {					
					MeetingUserinfo meetingUserinfo =  new MeetingUserinfo();
					meetingUserinfo.setUserId(id);
					meetingUserinfo.setBespeakId(bespeak.getBespeakId());
					j=meMapper.addMeetingUserinfo(meetingUserinfo);
					if(j==0) break;
				}
			}
			if(i>0&&j>0) {
				session.commit();
				return true;
			}else if(i>0&&j==0) {
				session.commit();
				return true;
			}else return false;
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<MeetingroomSetting> getAllMeetingroomSetting(MeetingroomSetting bespeakInfo) {
		try {
			BespeakMapper mapper= DBFactoryUtils.getMapper(BespeakMapper.class);
			if(bespeakInfo!=null&&bespeakInfo.getMeetingName()!=null&&!"".equals(bespeakInfo.getMeetingName())) {
				//设置模糊查询
				bespeakInfo.setMeetingName("%"+bespeakInfo.getMeetingName()+"%");
			}
			
			
			
			return mapper.getAllMeetingroomSetting(bespeakInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public MeetingroomSetting getMeetingroomSetting(String id) {
		BespeakMapper mapper = DBFactoryUtils.getMapper(BespeakMapper.class);
		
		
			try {
				if(id!=null&&!"".equals(id)) {
					return mapper.getMeetingroomSetting(id);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}	
	
		
		return null;
	}

	@Override
	public boolean updatemeetingroomSetting(MeetingroomSetting bespeak, String userIds) {
		//拿到mapper
		SqlSession session = DBFactoryUtils.getSqlSession();
		BespeakMapper beMapper = session.getMapper(BespeakMapper.class);
		MeetingUserinfoMapper meMapper = session.getMapper(MeetingUserinfoMapper.class);
		
		try {
			int i= beMapper.updatemeetingroomSetting(bespeak);
			int j=-1;
			int k=-1;
			
			if(userIds!=null&&!"".equals(userIds)) {
				//修改后的会议人员
				String[] userId2=userIds.split(",");
				
				//修改前的会议人员
				List<String> userId1 = new ArrayList<String>();
				//拿到会议预约id
				String bespeakid = bespeak.getBespeakId().toString();
				//查询未修改前会议参加人员
				List<MeetingUserinfo> mulist = meMapper.getAllMeetingUserinfo(bespeakid);
				
				for(MeetingUserinfo mu:mulist) {
					 userId1.add((mu.getUserId()).toString());
				}
				if(userId1!=null) {
					//删除修改前的会议人员
					for(String id1 :userId1 ) {
						MeetingUserinfo meeu=new MeetingUserinfo();
						meeu.setUserId(id1);
						j=meMapper.deleteMeetingUserinfo(meeu);	
						if(j==0) break;
					}
				}								
				//添加修改后的参加会议人员
				for(String id2:userId2) {
					MeetingUserinfo meetingUserinfo = new MeetingUserinfo();
					meetingUserinfo.setUserId(id2);
					meetingUserinfo.setBespeakId(bespeak.getBespeakId());
					k=meMapper.addMeetingUserinfo(meetingUserinfo);
					if(k==0) break;
				}
				
			}
			
			if(i>0&&j>0&&k>0) {
				session.commit();
				return true;
			}else if(i>0&&j<0&&k<0) {
				session.commit();
				return true;
			}else {
				return false;
			}

		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}
		
		
		
		return false;
	}

	@Override
	public boolean updateBespeakAuditing(MeetingroomSetting bespeak) {
		SqlSession session = DBFactoryUtils.getSqlSession();
		BespeakMapper mapper = session.getMapper(BespeakMapper.class);
		try {
			int i= -1;
			if(bespeak!=null) {
				i=mapper.updateBespeakAuditing(bespeak);
			}
			if(i>0) {
				session.commit();
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}
		return false;
	}
	
}
