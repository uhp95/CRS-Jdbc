/**
 * 
 */
package com.tcs.crs.dao;



import java.util.List;

import com.tcs.crs.model.Courses;
import com.tcs.crs.model.PayFee;
import com.tcs.crs.model.Student;

/**
 * @author springuser05
 *
 */
public interface StudentDAO {
	
	
	public String register(Student student);	
	public String addcourse(Courses course); 
	public String deletecourse(int courseId);
	public float viewgrades(int id);
	public String fees(PayFee fee);
	public List viewCourse(Courses course); 
	
}
