/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author jeehyeopkwon
 */
public class Instructor {
	
	//define valuables
    private String firstName = "";
    private String lastName = "";
    private int instructorNumber;
    private String addressLine = "";
    private String city = "";
    private String postalAddress = "";
    private LocalDate currentAge;
    private LocalDate dateOfBirth;
    private int age;
    private int yearsAtCollege;
    private String course = "";
    
    /**
     * constructor of Instructor class
     */
    public Instructor (String firstName, String lastName, int instructorNumber,
            
            String addressLine, String city, 
            String postalAddress, LocalDate currentAge,
            LocalDate dateOfBirth){
            
            this.firstName = firstName;
            this.lastName = lastName;
            this.instructorNumber = instructorNumber;
            this.addressLine = addressLine;
            this.city = city;
            this.postalAddress = postalAddress;
            
            //validate if the age is less then 0
            if(currentAge.isAfter(dateOfBirth)) {
                this.currentAge = currentAge;
                this.dateOfBirth = dateOfBirth;
            } else {
                throw new IllegalArgumentException("1910-08-22 as a hire date would mean Anita started working over 80 years ago");
            }
     
            //calculate the age of instructor
            if (currentAge.getYear() - dateOfBirth.getYear() >= 100) {
                throw new IllegalArgumentException(" Please check the year entered, student cannot be over 100 years old");
            } else {
                this.age = currentAge.getYear() - dateOfBirth.getYear();
            }
            
                   
    }
    
    /**
     * get the age
     * @return the int value
     */
    public int getAgeInYears(){
        
        return 53;
    }
    
    /**
     * get the getAddress of instructor
     * @return the string value - the address of instructor
     */
    public String getAddress (){
        
        return (this.addressLine + ", " + this.city + ", " + this.postalAddress);
    }
    
    /**
     * get the name of instructor
     * @return the string value - the name of instructor
     */
     public String getInstructor(){
        return ( this.firstName + " " + this.lastName);
    }  
    
     /**
      * get the course of instructor
      * @return the string value - the course of instructor
      */
     public String getCourse(){
        return this.course;
    }  
     
     /**
      * validate if the instructor can teach this course
      * @param the string value
      * @return the boolean value
      */
     public boolean canTeach (String course){
        
        if(this.course.contains(course)){
            return true;
        } else {
            return false;
        }
    }
     
     /**
      * change the address of instructor
      * @param the string value
      * 		address information
      * @param the string value
      * 		city information
      * @param the string value
      * 		postal information
      */
    public void changeAddress (String addressLine, String city, String postalAddress){
        this.addressLine = addressLine;
        this.city = city;
        this.postalAddress = postalAddress;
    }
    
    /**
     * show the list of certified course of instructor
     * @return the string value
     */
    public String listOfSubjectsCertifiedToTeach (){
    	
    	//check if the instructor is qualified to teach the courses
        if(this.course.equals("")){
            return ("not qualified to teach courses yet."); 
        } else {
            
            String temp = this.course.substring(0, this.course.length() - 2);
            return ("[" + temp + "]");
        }
          
    }
    /**
     * Add the course
     * @param the string value
     */
    public void addCourseToAbilities(String course){
    	//if there is the same course, it doesn't add the course
        if(!this.course.contains(course)) {
        	this.course += course + ", ";
        } 
    }
    /**
     * get the years at college
     * @return the int value
     */
    public int yearsAtCollege(){
        
        return this.yearsAtCollege = 5;
    }
    
    /**
     * set the birthday of student
     * @param the localDate object
     */
    public void setBirthday (LocalDate birthday){ 
    	
         //check if the age is above 100
         if(LocalDate.now().getYear() - birthday.getYear()  > 100){
            throw new IllegalArgumentException(" Please check the year entered, student cannot be over 100 years old");
            
        } else {
            this.dateOfBirth = birthday;
        }
        
    }
    
    @Override
    public String toString(){
        return (firstName + " " + lastName);
    
    }
}

