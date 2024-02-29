package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Member;
import com.springmvc.domain.Teacher;

public interface TeacherRepository {
	public void CreateTeacher(Teacher teacher); 
	void UpdateTeacher(Teacher teacher);
	public List<Teacher> AllTeacher();
<<<<<<< HEAD
	public Teacher teacherId(String teacherId);
}

=======
	public Teacher teacherId(String teacherId);	
}
>>>>>>> 6f8e02927c668559c23d378e1cd5decd4cefd5ba
