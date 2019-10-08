//@author vidula IT18026962
package com.oop.service;

import java.util.ArrayList;
import java.util.logging.Logger;


import com.oop.model.Teacher;

public interface ITeacherService {
  
  
  public static final Logger log = Logger.getLogger(ITeacherService.class.getName());
  
  public void addTeacher(Teacher teacher);
  
  public Teacher getTeacherByID(String memberID);
  
  public ArrayList<Teacher> getTeacher();
  
  public Teacher updateTeacher(String memberID, Teacher teacher);
  
  public void removeTeacher(String memberID);
  
  

}
