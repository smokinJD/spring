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
//		Admin admin = new Admin();
//		admin.setNombre("Miriam");
//		admin.setCargo("SubGerente");
//		admin.setFechaCreacion(ts);
		
		try{
		
			Admin admin = adminDao.findById(1);
			System.out.println("Admin con Id 1= "+ admin);
			
			admin.setNombre("Julen");
			admin.setCargo("Boss");
			
			if (adminDao.update(admin)){
				System.out.println("Actualizado Correctamente: "+ admin);
			}
			
			if (adminDao.delete(admin.getId())){
				System.out.println("Admin "+ admin.getNombre() + " eliminado correctamente");
			}
			
			//Funciones Insert y buscar por.
//		adminDao.save(admin);
//		
//		System.out.println(adminDao.findById(1));
//		System.out.println(adminDao.findById(3));
//		
//		System.out.println(adminDao.findByNombre("r").toString());
		 
		}catch (CannotGetJdbcConnectionException ex){
			ex.printStackTrace();
		}catch (DataAccessException ex){
			ex.printStackTrace();
		}
		
		((ClassPathXmlApplicationContext)aplicationContext).close();
	}
}
