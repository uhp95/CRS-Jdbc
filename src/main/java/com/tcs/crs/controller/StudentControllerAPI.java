package com.tcs.crs.controller;

/*
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
*/

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.crs.dao.StudentDAOImpl;
import com.tcs.crs.model.Courses;
import com.tcs.crs.model.Grades;
import com.tcs.crs.model.PayFee;
import com.tcs.crs.model.Student;




@Controller
@RestController
public class StudentControllerAPI {

	@Autowired
	private StudentDAOImpl crsdao;
	
	@RequestMapping(value = "/Registration", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON )
	@ResponseBody
	
	/*
	 * Register Student Details
	 * @Param student
	 * @Throws
	 */
	public ResponseEntity  Register(@RequestBody Student students)
	{
		String response = null;
		response =  crsdao.register(students);
		
		if(response.equals("Successful"))
		{
			return new ResponseEntity("Details added Successfully",HttpStatus.OK) ;
		}
		
		else 
			
			return new ResponseEntity("Error",HttpStatus.NOT_FOUND) ;
		
	}
	
	/*
	 * Add Course Details
	 * @Param course
	 * @Throws
	 */
	@RequestMapping(value = "/AddCourse", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON )
	@ResponseBody
	public ResponseEntity  AddCourse(Courses course)
	{
		String response = null;
		response =  crsdao.addcourse(course);
		
		if(response.equals("Successful"))
		{
			return new ResponseEntity("Course Added Successfully",HttpStatus.OK) ;
		}
		
		else 
			
			return new ResponseEntity("Error",HttpStatus.NOT_FOUND) ;
	}

	/*
	 * Delete Course Details
	 * @Param courseId
	 * @Throws
	 */
	@RequestMapping(value = "/DeleteCourse/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON )
	@ResponseBody
	public ResponseEntity  DeleteCourse(@PathVariable("id") int id)
	{
		String response = crsdao.deletecourse(id);
		
		if(response.equals("Successful"))
		{
			return new ResponseEntity("Course Deleted Successfully",HttpStatus.OK) ;
		}
		
		else 
		
			return new ResponseEntity("No Such Course Exists",HttpStatus.NOT_FOUND) ;
	}
	
	/*
	 * View Grade Details
	 * @Param id
	 * @Throws
	 */
	@RequestMapping(value = "/ViewGrades/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON )
	@ResponseBody
	public ResponseEntity  ViewCourse(@PathVariable("id") int id)
	{
		float response = crsdao.viewgrades(id);
		
		if(response == 0)
		{
			return new ResponseEntity("No Grade Set",HttpStatus.NOT_FOUND) ;
		}
		
		else
		{
			return new ResponseEntity("You have scored " + response,HttpStatus.OK) ;
		}
		
	}
	
	/*
	 * Payment Details
	 * @Param fee
	 * @Throws
	 */
	@RequestMapping(value ="/PayFee", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity Fee(PayFee fee)
	{
		String response = null;
		response = crsdao.fees(fee);
		
		if(response.equals("Successful"))
		{
			return new ResponseEntity("Loading...",HttpStatus.OK);
		}
		
		 return new ResponseEntity("Server Busy. Try Again Later",HttpStatus.NOT_FOUND);
	}
	
	
	/*
	 * View Courses
	 * @Param course
	 * @Throws
	 */
	
	@RequestMapping(value = "/ViewCourse", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity ViewCourse(Courses course)
	{
		if(crsdao.viewCourse(course).isEmpty()) 
		{
			return new ResponseEntity("No Active Courses",HttpStatus.NOT_FOUND);
		}
	
		return new ResponseEntity(crsdao.viewCourse(course),HttpStatus.OK);
	}
	

}
