package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Classes;

public interface ClasseService {
	
	public Classes getById(int classNum);
	List<Classes> getAllClassesList(Classes classes);
	void setNewClasses(Classes classes);
	public void setdeleteClasses(int classNum);	
	public void setUpdateClasses(Classes classes);
}
