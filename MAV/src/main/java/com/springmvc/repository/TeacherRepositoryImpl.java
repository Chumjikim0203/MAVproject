package com.springmvc.repository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Member;
import com.springmvc.domain.Teacher;
import com.springmvc.exception.MemberIdException;

@Repository
public class TeacherRepositoryImpl implements TeacherRepository {


   private JdbcTemplate template;
   @Autowired
   public void setJdbctemplate(DataSource dataSoure) {
      this.template=new JdbcTemplate(dataSoure);
   }
   List<Teacher> teacherlist=new ArrayList();
   @Override
   public void CreateTeacher(Teacher teacher) {
      // TODO Auto-generated method stub
   //강사 등록   
      teacher.setTeacherApprove(true);
      String SQL="INSERT INTO Teacher (teacherId,teacherImages,teacherCategory,teacherRecode,teacherLicense,teacherInfomation,teacherApprove)"
      +"values(?,?,?,?,?,?,?)";
      template.update(SQL,
            teacher.getTeacherId(),
            teacher.getTeacherImages(),
            teacher.getTeacherCategory(),
            teacher.getTeacherRecode(),
            teacher.getTeacherLicense(),
            teacher.getTeacherInfomation(),
            teacher.isTeacherApprove()
            );
   
   }
// 강사정보 수정
   @Override
   public void UpdateTeacher(Teacher teacher) {
      // TODO Auto-generated method stub
      String SQL="update teacher set teacherCategory=?,teacherRecode=?,teacherInfomation=? where teacherId=?";
      template.update(SQL,teacher.getTeacherCategory(),teacher.getTeacherRecode(),teacher.getTeacherInfomation());
      
   }
//전체 출력
   @Override
   public List<Teacher> AllTeacher() {
      // TODO Auto-generated method stub
      String SQL="SELECT * FROM Teacher";
      List<Teacher> teacherlist=template.query(SQL, new TeacherRowMapper());
      return teacherlist;
   }
//단일출력
   @Override
   public Teacher teacherId(String teacherId) {
      // TODO Auto-generated method stub
      Teacher teacherInfo=null;
      String SQL="SELECT COUNT(*) from TEACHER WHERE TEACHERId=?";
      int rowCount =template.queryForObject(SQL, Integer.class,teacherId);
      if(rowCount!=0)
      {
         SQL = "SELECT * FROM Teacher where teacherId=?";
         teacherInfo = template.queryForObject(SQL, new Object[] {teacherId}, new TeacherRowMapper());
      }
      for(int i=0; i<teacherlist.size(); i++)
      {
         Teacher teacher=teacherlist.get(i);
         if(teacher!=null && teacher.getTeacherId()!= null && teacher.getTeacherId().equals(teacherId))
         {
            teacherInfo=teacher;
            break;
         }
      }
      if(teacherInfo==null)
      {
         throw new MemberIdException(teacherId);
      }
      return teacherInfo;
   }
}