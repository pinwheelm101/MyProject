package com.abandon.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.abandon.domain.EnquipmentInfo;
import com.abandon.mapper.EnquipmentMapper;
import com.abandon.service.EnqiupmentService;
import com.abandon.utils.DBFactoryUtils;
/*
 * 方法区
 */
public class EnqiupmentServiceImpl implements EnqiupmentService {

	@Override
	public boolean addEqiument(EnquipmentInfo enqiupment) {
		SqlSession session = DBFactoryUtils.getSqlSession();
		EnquipmentMapper mapper = session.getMapper(EnquipmentMapper.class);
		try {
			if(enqiupment!=null) {
				int i = mapper.addEnqiument(enqiupment);
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

	@Override
	public List<EnquipmentInfo> getAllEnquipmentInfo(EnquipmentInfo enqiupmentInfo) {
		try {
			EnquipmentMapper mapper = DBFactoryUtils.getMapper(EnquipmentMapper.class);
			
			//设置查询条件 模糊查询
			if(enqiupmentInfo.getEnquipmentName()!=null && ""!=enqiupmentInfo.getEnquipmentName()) {
				String name = enqiupmentInfo.getEnquipmentName();
				enqiupmentInfo.setEnquipmentName("%"+name+"%");
				
			}
			
			return mapper.getAllEnquipmentInfo(enqiupmentInfo);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public EnquipmentInfo getEnquipmentInfo(String enqiupmentInfoId) {
		try {
			EnquipmentMapper mapper = DBFactoryUtils.getMapper(EnquipmentMapper.class);
			if(enqiupmentInfoId!=null && !"".equals(enqiupmentInfoId) ) {
				return mapper.getEnquipmentInfo(enqiupmentInfoId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateEnquipmentInfo(EnquipmentInfo enquipmentInfo) {
		SqlSession session = DBFactoryUtils.getSqlSession();
		EnquipmentMapper mapper = session.getMapper(EnquipmentMapper.class);
		try {
			if (enquipmentInfo!=null) {
				int i = mapper.updateEnquipmentInfo( enquipmentInfo);
				if (i>0) {
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

	@Override
	public boolean dateEnquipmentInfo(String enquipmentInfoId) {
		SqlSession session = DBFactoryUtils.getSqlSession();
		EnquipmentMapper mapper = session.getMapper(EnquipmentMapper.class);
		
		try {
			if(enquipmentInfoId!=null&&!"".equals(enquipmentInfoId)) {
				//转型处理
				int i = mapper.deleteEnquipmentInfo(Integer.parseInt(enquipmentInfoId));
				if(i>0) {
					session.commit();
					
					return true;
				}else {
					return false;
				}
			}
		} catch (NumberFormatException e) {
			session.rollback();
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<EnquipmentInfo> selectALLEnquipmentInfo(EnquipmentInfo enquipmentInfo) {
		try {
			EnquipmentMapper mapper = DBFactoryUtils.getMapper(EnquipmentMapper.class);
			//设置查询条件 模糊
			if(enquipmentInfo.getEnquipmentName()!=null&&!"".equals(enquipmentInfo.getEnquipmentName())) {
				String name = enquipmentInfo.getEnquipmentName();
				enquipmentInfo.setEnquipmentName("%"+name+"%");
							
			}
			
			return mapper.selectEnquipmentInfo(enquipmentInfo);	
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public EnquipmentInfo  gettTwoEnquipmentInfo(String enquipmentInfoId) {
		EnquipmentMapper mapper = DBFactoryUtils.getMapper(EnquipmentMapper.class);
		
		try {
			if( enquipmentInfoId!=null&&!"".equals(enquipmentInfoId)) {
				
				return mapper.gettTwoEnquipmentInfo(enquipmentInfoId);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<EnquipmentInfo> getNotUseEnquipmentInfo() {
		 try{
			EnquipmentMapper mapper = DBFactoryUtils.getMapper(EnquipmentMapper.class);
			
			return mapper.getNotUseEnquipmentInfo();									
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateMeetingroomID(EnquipmentInfo enquipmentInfo) {
		SqlSession session = DBFactoryUtils.getSqlSession();
		EnquipmentMapper mapper = session.getMapper(EnquipmentMapper.class);
		try {
			if (enquipmentInfo!=null) {
				int i = mapper.updateMeetingroomID(enquipmentInfo);
				if (i>0) {
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

	@Override
	public List<EnquipmentInfo> getMroomIdEnquipmentInfo(String meetingroomId) {
		EnquipmentMapper mapper = DBFactoryUtils.getMapper(EnquipmentMapper.class);
		
		if( meetingroomId!=null&&!"".equals(meetingroomId)){
			return mapper.getMroomIdEnquipmentInfo(meetingroomId);
			}
		return null;
	}



	
	
}
