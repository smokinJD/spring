package com.novellius;

import java.sql.Timestamp;
import java.util.ArrayList;
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
//		Admin admin = new Admin();
//		admin.setNombre("Miriam");
//		admin.setCargo("SubGerente");
//		admin.setFechaCreacion(ts);
		
		try{
			
			List <Admin> admins = new ArrayList <Admin>();
			
			admins.add(new Admin(3, "Julen", "Boss", ts));
			admins.add(new Admin(4, "Roku", "Gerente", ts));
			admins.add(new Admin(5, "Irati", "Programadora", ts));
			
			int[] vueltas = adminDao.saveAll(admins);
			
			for (int i : vueltas){
				System.out.println("Fila Afectadas Correctamente "+ i);
			}
		 
		}catch (CannotGetJdbcConnectionException ex){
			ex.printStackTrace();
		}catch (DataAccessException ex){
			ex.printStackTrace();
		}
		
		((ClassPathXmlApplicationContext)aplicationContext).close();
	}
}
