package com.tcs.crs.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.crs.model.Courses;
import com.tcs.crs.model.Grades;
import com.tcs.crs.model.PayFee;
import com.tcs.crs.model.Student;



@Repository
public class StudentDAOImpl implements StudentDAO {
	
	Logger logger = LoggerFactory.getLogger(StudentDAOImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	@Transactional
	/*
	 * Register Student Details
	 * @Param student
	 * @Throws
	 */
	public   String register(Student student) {
		
		String Sql = "insert into Student(first_name,last_name,address,email,mobile,DoB) "
				+ "values(?,?,?,?,?,?)";	
		jdbcTemplate.update(Sql, student.getFirstName(),student.getLastName(),student.getAddress(),student.getEmailId(),student.getMobileNo(),student.getDob());
		logger.debug("Debugging");
		return "Successful";
			
	}

	
	
	
	
	

	
	
	 private static AtomicInteger i = new AtomicInteger(0);
	 private  int a;
	
	private static List<Student> students;
	{
		students = new ArrayList();
	}
	
	private static List<Courses> courses;
	{
		courses = new ArrayList();
	}
	
	private static List<Grades> grades;
	{
		grades = new ArrayList();
	}

	private static List<PayFee> fees;
	{
		fees = new ArrayList();
	}

	

	/*
	 * Add Course Details
	 * @Param course
	 * @Throws
	 */
	
	public String addcourse(Courses course) 
	{
	
		courses.add(course);
		return "Successful";
		
	}
	
	/*
	 * Delete Course Details
	 * @Param courseId
	 * @Throws
	 */

	public String deletecourse(int courseId) 
	{
		
		for(Courses c: courses)
		{
			if(c.getCourseId()== courseId)
			{
				courses.remove(c);
			}
			
			else 
				return "Unsuccessful";
		}
		
		return "Successful";
		
	}
	
	/*
	 * View Grade Details
	 * @Param id
	 * @Throws
	 */

	public float viewgrades(int id) 
	{
		
		for (Grades g: grades)
		{
			if(g.getStudentId()== id)
			{
				return g.getGrade();
			}
			
			
		}
		
		return 0;
	}

	/*
	 * Payment Details
	 * @Param fee
	 * @Throws
	 */

	@Override
	public String fees(PayFee fee)
		{
			fee.setTransactionId(System.currentTimeMillis());
			fees.add(fee);
			return "Successful";
			
		}
		
	


	
	/*
	 * View Courses
	 * @Param course
	 * @Throws
	 */

	public List viewCourse(Courses course) 
	
	{
		
		return null;
		
	}






	

}
