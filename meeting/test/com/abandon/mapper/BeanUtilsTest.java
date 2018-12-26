package com.abandon.mapper;
/*
 * beanUntils 注册类型转化实例
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.junit.Test;



public class BeanUtilsTest {
	@Test
	public void testCopy(){
		//生成类型转化并注册
		ConvertUtils.register(new Converter(){
			 
			@Override
			public Date convert(Class  type, Object value) {	
					if(value==null||(!(value instanceof String)))
					{
						return null;
					}
					String st=(String)value;
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					try {
						return sdf.parse(st);
					} catch (ParseException e) {
						e.printStackTrace();
						throw new RuntimeException(e);
					}
			}
			
		}, Date.class);

	}
	}

