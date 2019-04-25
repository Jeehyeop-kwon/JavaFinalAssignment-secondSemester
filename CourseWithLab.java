package Assignment2;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class CourseWithLab {
	
	//define valuables
	private Instructor instructor;
	private String course;
	private String courseTitle;
	private String courseLocation1;
	private DayOfWeek dayOfWeek1;
	private LocalTime coursStartTime1;
	private int classSize;
	private Instructor labTech;
	private String courseLocation2;
	private DayOfWeek dayOfWeek2;
	private LocalTime labStartTime;
	private String prerequisiteCourse;
	
	/**
     * constructor of CourseWithLab class
     */
	public CourseWithLab(Instructor instructor, String course, String courseTitle, 
            String courseLocation1, DayOfWeek dayOfWeek1, LocalTime coursStartTime1, int classSize, Instructor labTech,
            String courseLocation2, DayOfWeek dayOfWeek2, LocalTime labStartTime) {

		this.instructor = instructor;
	    this.courseTitle = courseTitle;
	    this.courseLocation1 = courseLocation1;
		this.dayOfWeek1 = dayOfWeek1;
		this.classSize = classSize;
		this.labTech = labTech;
	    this.courseLocation2 = courseLocation2;
		this.dayOfWeek2 = dayOfWeek2;
		this.labStartTime = labStartTime;
		validateCourseToTeach(course);
		validateCourseStartTime(coursStartTime1);
		validateLabStartTime(labStartTime);
		
	}
	
	/**
     * constructor of CourseWithLab class(overloading)
     * this constructor contains the prerequisiteCourse value compared with first constructor
     */
	public CourseWithLab(Instructor instructor, String course, String courseTitle, 
            String courseLocation1, DayOfWeek dayOfWeek1, LocalTime coursStartTime1, int classSize, String prerequisiteCourse, Instructor labTech,
            String courseLocation2, DayOfWeek dayOfWeek2, LocalTime labStartTime) {
		
		this.instructor = instructor;
	    this.courseTitle = courseTitle;
	    this.courseLocation1 = courseLocation1;
		this.dayOfWeek1 = dayOfWeek1;
		this.classSize = classSize;
		this.prerequisiteCourse = prerequisiteCourse;
		this.labTech = labTech;
	    this.courseLocation2 = courseLocation2;
		this.dayOfWeek2 = dayOfWeek2;
		this.labStartTime = labStartTime;
		validateCourseToTeach(course);
		validateCourseStartTime(coursStartTime1);
		validateLabStartTime(labStartTime);
		
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
        	this.coursStartTime1 = coursStartTime;
        }
    	
    }
	
	/**
     * validate the starting time of Lab
     * @param the Localtime object
     */
	private void validateLabStartTime(LocalTime labStartTime) {
		
		//check the starting time and the ending time of course(8:00 - 18:00)
    	if(labStartTime.isBefore(LocalTime.of(8, 00)) || labStartTime.isAfter(LocalTime.of(18, 00))) {
        	throw new IllegalArgumentException("The lab start time must be between 08:00-18:00");
        } else {
        	this.coursStartTime1 = labStartTime;
        }
    	
    }

	/**
     * validate if the instructor can teach the course
     * @param the string value
     */
	public void validateCourseToTeach(String course) {
		
		if(!this.instructor.canTeach(course) || !this.labTech.canTeach(course)) {
	    	throw new IllegalArgumentException("Professor Alec Tricity is not qualified to teach COMP2008");
	    } else {
	    	this.course = course;
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
	public Instructor getInstructor() {
		
		return this.instructor;
	}
	/**
     * get the labTech valiable to connect with instructor class 
     * @return the Instructor valuable 
     */
	public Instructor getLabTech() {
		
		return this.labTech;
	}
	
	/**
     * get the lab class and time 
     * @return the string value 
     */
	public String getLabClassAndTime() {
		
		return ("room: " + this.courseLocation2+", " + this.dayOfWeek2 + " starting at " + this.coursStartTime1);
	}
	
	
	@Override
    public String toString(){
        return (this.course + "-" + this.courseTitle + " with lab");
    
    }

	


	
}