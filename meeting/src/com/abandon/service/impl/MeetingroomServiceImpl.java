package com.abandon.service.impl;


/**
 * 会议室信息管理服务方法
 */
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.abandon.domain.EnquipmentInfo;
import com.abandon.domain.MeetingroomInfo;
import com.abandon.mapper.EnquipmentMapper;
import com.abandon.mapper.MeetingroomInfoMapper;
import com.abandon.service.MeetingroomService;
import com.abandon.utils.DBFactoryUtils;

public class MeetingroomServiceImpl implements MeetingroomService {

	@Override
	public List<MeetingroomInfo> getAllMeetingroomInfo(MeetingroomInfo meetingroomInfo) {
		
		MeetingroomInfoMapper mapper = DBFactoryUtils.getMapper(MeetingroomInfoMapper.class);
		
		try {
			if(meetingroomInfo.getMeetingroomName()!=null&&!"".equals(meetingroomInfo.getMeetingroomName())) {
				//设置模糊查询字段 
				meetingroomInfo.setMeetingroomName("%"+meetingroomInfo.getMeetingroomName()+"%");
			}			

			List<MeetingroomInfo> list = mapper.getAllMetingroomInfo(meetingroomInfo);
				
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean AddMetingroomInfo(MeetingroomInfo meetingroomInfo,String enquipmentIds) {
		SqlSession session =DBFactoryUtils.getSqlSession();
		MeetingroomInfoMapper meetingroommapper= session.getMapper(MeetingroomInfoMapper.class);
		EnquipmentMapper enMapper=session.getMapper(EnquipmentMapper.class);
		
		
		try {
			int y=-1;
			int i=-1;
			//先添加会议室信息 （外键不能为空）
			if(meetingroomInfo!=null) {
				 i= meetingroommapper.AddMetingroomInfo(meetingroomInfo);				
			}
			
			if(enquipmentIds!=null&&!"".equals(enquipmentIds)&&meetingroomInfo!=null) {
				//拿出info中meetingid
				Integer meetingroomId = meetingroomInfo.getMeetingroomId();
				//将传过来的字符串还原成id
				String[] enIds=enquipmentIds.split(",");				
				//遍历设置meetroomId并存储 到设备信息中
				for(String enId:enIds) {
					EnquipmentInfo enInfo=new EnquipmentInfo();
					try {
						//放入设备id
						enInfo.setEnquipmentId(Integer.parseInt(enId));
						//放入会议室id
						enInfo.setMeetingroomId(meetingroomId);
						//执行更新操作
						y=enMapper.updateMeetingroomID(enInfo);
					} catch (Exception e) {
						e.printStackTrace();
					}									
					
					if(i>0&&y>0) {
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
	public MeetingroomInfo getMetingroomInfo(String meetingroomId) {
		MeetingroomInfoMapper mapper = DBFactoryUtils.getMapper(MeetingroomInfoMapper.class);
		if(meetingroomId!=null&&!"".equals(meetingroomId)) {
			return mapper.getMetingroomInfo(meetingroomId);
		}else {
			return null;
		}	
	}

	@Override
	public boolean updateMetingroomInfo(MeetingroomInfo meetingroomInfo, String enquipmentIds) {
		SqlSession session =DBFactoryUtils.getSqlSession();
		MeetingroomInfoMapper meetingroommapper= session.getMapper(MeetingroomInfoMapper.class);
		EnquipmentMapper enMapper=session.getMapper(EnquipmentMapper.class);
		
		
		try {
			int y=-1;
			int i=-1;
			//先更新会议室信息 （外键不能为空）
			if(meetingroomInfo!=null) {
				 i= meetingroommapper.updateMetingroomInfo(meetingroomInfo);				
			}
			
			if(enquipmentIds!=null&&!"".equals(enquipmentIds)&&meetingroomInfo!=null) {
				//拿出info中meetingid
				Integer meetingroomId = meetingroomInfo.getMeetingroomId();
				//将传过来的字符串还原成id
				String[] enIds=enquipmentIds.split(",");				
				//遍历设置meetroomId并存储 到设备信息中
				for(String enId:enIds) {
					EnquipmentInfo enInfo=new EnquipmentInfo();
					try {
						//放入设备id
						enInfo.setEnquipmentId(Integer.parseInt(enId));
						//放入会议室id
						enInfo.setMeetingroomId(meetingroomId);
						//执行更新操作
						y=enMapper.updateMeetingroomID(enInfo);
					} catch (Exception e) {
						e.printStackTrace();
					}									
					
					if(i>0&&y>0) {
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
	public boolean deleteMetingroomInfo(String meetingroomId) {
		SqlSession session = DBFactoryUtils.getSqlSession();
		MeetingroomInfoMapper mapper = session.getMapper(MeetingroomInfoMapper.class);
		EnquipmentMapper enMapper=session.getMapper(EnquipmentMapper.class);
		try {
			if(meetingroomId!=null) {
				//删除会议室信息
				MeetingroomInfo meetingroomInfo =mapper.getMetingroomInfo(meetingroomId);
				meetingroomInfo.setMmeetingroomState("0");
				int i= mapper.updateMetingroomInfo(meetingroomInfo);
				//查询会议室所属设备信息
				List<EnquipmentInfo> list=enMapper.getMroomIdEnquipmentInfo(meetingroomId);
				for(EnquipmentInfo eninfo :list) {
					//重置设备信息中的会议室id
					eninfo.setMeetingroomId(null);
					enMapper.updateEnquipmentInfo(eninfo);
				}
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
