package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Classes;
import com.springmvc.domain.Teacher;

public class ClassesRowMapper implements RowMapper<Classes> {

	@Override
	public Classes mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Classes classes=new Classes();
		classes.setteacherId(rs.getString("teacherId"));
		classes.setClassNum(rs.getInt("classNum"));
		classes.setClassName(rs.getString("className"));
		classes.setClassLecturedate(rs.getDate("classLectureDate").toLocalDate());
		classes.setClassLecturetime(rs.getString("classLectureTime"));
		classes.setClassNumberOfStudents(rs.getInt("classNumberOfStudents"));
		classes.setClassCourseContents(rs.getString("classCourseContents"));
		classes.setClassGrade(rs.getString("classGrade"));
		classes.setClassIntroduction(rs.getString("classIntroduction"));
		classes.setClassLocale(rs.getString("classLocale"));
//		classes.setFileName(rs.getString(10)); 
		System.out.println("crmClasses:"+rs.getString("className"));
		
		
		
		return classes;
	}
	
}
