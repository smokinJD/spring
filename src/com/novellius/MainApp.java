package com.novellius;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.novellius.dao.AdminDao;
import com.novellius.pojo.Admin;

public class MainApp {
	public static void main(String[] args){
		ApplicationContext aplicationContext = new ClassPathXmlApplicationContext("spring_config.xml");
		
		AdminDao adminDao= (AdminDao)aplicationContext.getBean("adminDao");
		
		Timestamp ts = new Timestamp(new Date().getTime());
		Admin admin = new Admin();
		admin.setNombre("Pepe");
		admin.setCargo("Analista");
		admin.setFechaCreacion(ts);
		
		try{
		adminDao.save(admin);
		
		List<Admin> admins = adminDao.findAll();
		 for (Admin admin2:admins){
			 System.out.println(admin2);
		 }
		 
		}catch (CannotGetJdbcConnectionException ex){
			ex.printStackTrace();
		}catch (DataAccessException ex){
			ex.printStackTrace();
		}
		
		((ClassPathXmlApplicationContext)aplicationContext).close();
	}
}
