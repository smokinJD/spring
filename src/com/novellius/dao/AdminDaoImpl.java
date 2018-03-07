package com.novellius.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.novellius.pojo.Admin;

@Component("adminDao")
public class AdminDaoImpl implements AdminDao{

	private NamedParameterJdbcTemplate JdbcTemplate;
	
	@Autowired
	private void setDataSource(DataSource dataSource){
		this.JdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	@Override
	public boolean save(Admin admin) {
		// TODO Auto-generated method stub
//		MapSqlParameterSource paramMap = new MapSqlParameterSource();
//		paramMap.addValue("Nombre", admin.getNombre());
//		paramMap.addValue("Cargo", admin.getCargo());
//		paramMap.addValue("FechaCreacion", admin.getFechaCreacion());
		
		//Pasa los parametros sin necesidad de Get, siempre y cuando tengan el mismo nombre que en la base de datos
		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(admin);
		return JdbcTemplate.update("Insert into Admin (Nombre, Cargo, FechaCreacion) values (:Nombre, :Cargo, :FechaCreacion)", paramMap) == 1;
	}
	@Override
	public List<Admin> findAll() {
		return JdbcTemplate.query("Select * FROM Admin", new RowMapper<Admin>() {

			@Override
			public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
				Admin admin = new Admin();
				
				admin.setId(rs.getInt("id"));
				admin.setNombre(rs.getString("Nombre"));
				admin.setCargo(rs.getString("Cargo"));
				admin.setFechaCreacion(rs.getTimestamp("FechaCreacion"));
				return admin;
			}
			
		});
	}

}
