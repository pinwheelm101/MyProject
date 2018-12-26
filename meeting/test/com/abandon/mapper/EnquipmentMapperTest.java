package com.abandon.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import com.abandon.domain.EnquipmentInfo;
import com.abandon.utils.DBFactoryUtils;

public class EnquipmentMapperTest {
	//@Test
	public void addEqiument() {
		SqlSession session = DBFactoryUtils.getSqlSession();
		EnquipmentMapper mapper = session.getMapper(EnquipmentMapper.class);
		EnquipmentInfo enqiupment=new EnquipmentInfo();
		 enqiupment.setEnquipmentId(101);
		 enqiupment.setEnquipmentName("投影仪");
		 enqiupment.setEnquipmentPrice((double)2645);
		 enqiupment.setEnquipmentRemerk("测试");
		
		 
		 
		
		
		try {
			if(enqiupment!=null) {
				int i = mapper.addEnqiument(enqiupment);
				if(i>0) {
					session.commit();
					System.out.println("修改成功");
				}else {
					System.out.println("修改失败");
				}
			}
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}
		
		
	}
	
	//@Test
	public void queys() {
		EnquipmentMapper mapper = DBFactoryUtils.getMapper(EnquipmentMapper.class);
		EnquipmentInfo enquipment=new EnquipmentInfo();
	
		List<EnquipmentInfo>  list = mapper.getAllEnquipmentInfo(null);
		for(EnquipmentInfo info:list) {
			System.out.println(info);
		}
		
		
	}
	//@Test
	public void delete() {
		SqlSession  session = DBFactoryUtils.getSqlSession();
		EnquipmentMapper mapper = session.getMapper(EnquipmentMapper.class);
		
		EnquipmentInfo enqiupment=new EnquipmentInfo();
		 enqiupment.setEnquipmentId(101);
		 try {
				if(enqiupment!=null) {
					int i = mapper.deleteEnquipmentInfo(105);
					if(i>0) {
						session.commit();
						System.out.println("删除成功");
					}else {
						System.out.println("删除失败");
					}
				}
			} catch (Exception e) {
				session.rollback();
				e.printStackTrace();
			}
	}
	
	//@Test
	public void geten() {
		EnquipmentMapper mapper = DBFactoryUtils.getMapper(EnquipmentMapper.class);
		EnquipmentInfo enqiupment= mapper.getEnquipmentInfo("102");
		System.out.println(enqiupment);
	}
	
	@Test
	public void update() {
		SqlSession session = DBFactoryUtils.getSqlSession();
		EnquipmentMapper mapper=session.getMapper(EnquipmentMapper.class);
		EnquipmentInfo enqiupment=new EnquipmentInfo();
//		enqiupment.setEnquipmentName("测试用例");
//		enqiupment.setEnquipmentPrice((double)62340);
//		enqiupment.setEnquipmentRemerk("ceshi 测试");
		enqiupment.setEnquipmentId(105);
		enqiupment.setMeetingroomId(null);
		
		try {
			
				int i = mapper.updateEnquipmentInfo(enqiupment);
				if(i>0) {
					session.commit();
					System.out.println("修改成功");
				}else {
					System.out.println("修改失败");
				}
												
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}
	}
	
	//@Test
	public void selectall() {
		EnquipmentMapper mapper = DBFactoryUtils.getMapper(EnquipmentMapper.class);
		EnquipmentInfo enquipment=new EnquipmentInfo();
	
		List<EnquipmentInfo>  list = mapper.selectEnquipmentInfo(null);
		for(EnquipmentInfo info:list) {
			System.out.println(info);
		}
}

}