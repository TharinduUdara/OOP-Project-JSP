//@author vidula IT18026962
package com.oop.service;

import java.util.ArrayList;
import java.util.logging.Logger;


import com.oop.model.Student;

public interface IStudentService {
  
  
  public static final Logger log = Logger.getLogger(IStudentService.class.getName());
  
  public void addStudent(Student student);
  
  public Student getStudentByID(String memberID);
  
  

  
  public ArrayList<Student> getStudent();
  
    
  
  public Student updateStudent(String memberID, Student student);
  
  public void removeStudent(String memberID);
  
  

}