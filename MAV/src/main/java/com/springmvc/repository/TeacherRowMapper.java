package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Teacher;

public class TeacherRowMapper implements RowMapper<Teacher> {

	@Override
	public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Teacher teacher=new Teacher();
		teacher.setTeacherApprove(rs.getBoolean("teacherApprove"));
		teacher.setTeacherCategory(rs.getString("teacherCategory"));
		teacher.setTeacherId(rs.getString("teacherId"));
	//	teacher.setTeacherImages(rs.get);
		teacher.setTeacherInfomation(rs.getString("teacherInfomation"));
		teacher.setTeacherLicense(rs.getString("teacherLicense"));
		teacher.setTeacherRecode(rs.getString("teacherRecode"));
		return teacher;
	}

}
