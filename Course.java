/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author jeehyeopkwon
 */
public class Course {
    
	//define valuables
	private Instructor instructor;
    private String course;
    private String courseTitle;
    private String courseLocation;
    private DayOfWeek dayOfWeek;
    private LocalTime coursStartTime;
    private int classSize;
    private Student student;
    static int studentNumberInClass = 0;
    private String prerequisiteCourse = "";
    
    /**
     * constructor of Course class
     */
    public Course(Instructor instructor, String course, String courseTitle, 
                String courseLocation, DayOfWeek dayOfWeek, LocalTime coursStartTime, int classSize) {
        
        this.instructor = instructor;
        validateCourse(course);
        this.courseTitle = courseTitle;
        this.courseLocation = courseLocation;
        this.dayOfWeek = dayOfWeek;
        validateCourseStartTime(coursStartTime);
        this.classSize = classSize;
        
    }
    
    /**
     * constructor of Course class(overloading)
     * this constructor contains the prerequisiteCourse value compared with first constructor
     */
    public Course(Instructor instructor, String course, String courseTitle, 
            String courseLocation, DayOfWeek dayOfWeek, LocalTime coursStartTime, int classSize, String prerequisiteCourse) {
    	
    	this.instructor = instructor;
        validateCourse(course);
        this.courseTitle = courseTitle;
        this.courseLocation = courseLocation;
        this.dayOfWeek = dayOfWeek;
        validateCourseStartTime(coursStartTime);
        this.classSize = classSize;
        this.prerequisiteCourse = prerequisiteCourse;
    }
    
    /**
     * validate if the instructor can teach the course
     * @param the string value
     */
    private void validateCourse(String course) {
    	if(!this.instructor.canTeach(course)) {
        	throw new IllegalArgumentException("Professor Frank Enstein is not qualified to teach COMP9999");
        } else {
        	this.course = course;
        }
    	
    }
    
    /**
     * validate the starting time of course
     * @param the Localtime object
     */
    private void validateCourseStartTime(LocalTime coursStartTime) {
    	
    	//check the starting time and the ending time of course(8:00 - 18:00)
    	if(coursStartTime.isBefore(LocalTime.of(8, 00)) || coursStartTime.isAfter(LocalTime.of(18, 00))) {
        	throw new IllegalArgumentException("Course start time must be between 08:00-18:00");
        } else {
        	this.coursStartTime = coursStartTime;
        }
    	
    }
    
    /**
     * get the Prerequisite course of student
     * @return the string value - the Prerequisite of student
     */
    public String getPrerequisite() {
    	return this.prerequisiteCourse;
    }
    
    /**
     * get the instructor's valiable to connect with instructor class 
     * @return the Instructor valuable 
     */
    public Instructor getInstructor(){
        return this.instructor;
    }
    
    /**
     * get the class room 
     * @return the string value 
     */
    public String getRoom(){
        return this.courseLocation;
    }
    
    /**
     * get the day and time of course 
     * @return the string value 
     */
    public String getCourseDayAndTime(){
        return ( this.dayOfWeek + "'s, starting at " + this.coursStartTime);
    }
    
    /**
     * get the size of class(the number of students)
     * @return the int value 
     */
    public int getClassSize(){
    	
        return this.classSize;
    }
    
    /**
     * show the course and the title of course
     * @return the int value 
     */
    public String showClassList(){
    	return this.student.toString();
    }
    
    /**
     * validate if the averageAge of students are above 25
     * @return the boolean value
     */
    public boolean matureClass(){
    	
    	if(Student.averageAgeOfStudent > 25) {
    		return true;
    	} else {
    		return false;
    	}
    	
    }
    
    /**
     * Add students to the course
     * @param the student object
     * @return the string value
     */
    public String addStudent(Student student){
    	
    	this.student = student;
    	
    	//check if the student is in a good standing
    	if(!student.inGoodStanding()) {
 
    		return ("The Student is not in good standing and cannot join the course.");
    	}
    	
    	//check the size of class
    	if(studentNumberInClass < classSize) {
    		studentNumberInClass++;
    		this.student = student;
    	} else {
    		return "Student was not added because the course is full";
    		
    	}
    	
    	//check if the student completed the prerequisiteCourse
    	if(!student.getCompletedCourses().contains(this.prerequisiteCourse)) {
    		return ("Student has not completed the prerequisite course: COMP1008");
    	} 
    	
    	return "Student was not added because the course is full";
    	
    	
    	
    }
    
    /**
     * set the size of the class
     * @param the int value
     * @return the string value
     */
    public String setClassSize(int classSize){
    	
    	//check if the size of class is above 40
    	if(classSize > 40) {
    		this.classSize = 40;
    		return ("Max class size = 40, it has been set to 40");
    	} else {
    		this.classSize = classSize;
    	}
    	return ("Class size : " + classSize); 
    	
    }
    
    
    @Override
    public String toString(){
        return (this.course + "-" + this.courseTitle);
    
    }
    
}
