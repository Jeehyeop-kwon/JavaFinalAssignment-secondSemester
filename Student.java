/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author jeehyeopkwon
 */

public class Student {
	
	//define valuables
	private Course course1;
    private String firstName;
    private String lastName;
    private String addressLine;
    private String city;
    private String postalAddress;
    private String course;
    private int studentNumber;
    private LocalDate currentAge;
    private LocalDate dateOfBirth;
    private int age;
    private int getYearEnrolled = 2000;
    private boolean studentStatus = true;
    private String compeletedCourse = "";
    //private Course compeletedCourse;
    private int grade;
    static int averageAgeOfStudent = 0;
    static int sumOfStudentAge = 0;
    static int numberOfStudent = 0;

    
    /**
     * constructor of student class
     */
    public Student (String firstName, String lastName, String addressLine, String city, 
            String postalAddress, String course, int studentNumber, LocalDate currentAge,
            LocalDate dateOfBirth){
            
            this.firstName = firstName;
            this.lastName = lastName;
            this.addressLine = addressLine;
            this.city = city;
            this.postalAddress = postalAddress;
            this.course = course;
            this.studentNumber = studentNumber;
            this.currentAge = currentAge;
            this.dateOfBirth = dateOfBirth;
            numberOfStudent++;
            validateAge(dateOfBirth);
            AverageAgeOfStudent();
            
                   
    }
    /**
     * calculate the average of age of students
     */
    
    private void AverageAgeOfStudent(){
    	
    	sumOfStudentAge = sumOfStudentAge + this.age;
    	averageAgeOfStudent = sumOfStudentAge / numberOfStudent;
        
    }
    /**
     * validate the age of students( student's age < 100)
     * @param the LocalDate value - student's date of birth
     */
    private void validateAge(LocalDate dateOfBirth){
        if(((LocalDate.now().getYear() - 1) - dateOfBirth.getYear()) > 100){
            throw new IllegalArgumentException(": Please check the year entered, student cannot be over 100 years old");
            
        } else {
            this.age = (LocalDate.now().getYear() - 1) - dateOfBirth.getYear();
        }
        
    }
    /**
     * get the age of student
     * @return the int value - the age of student
     */    
    public int getAge(){
        return this.age;
    }
    
    /**
     * get the getAddress of student
     * @return the string value - the address of student
     */
    public String getAddress(){
        
        return (this.addressLine +" "+ this.city +" "+ this.postalAddress);
    }
    
    /**
     * this function uses to connect with course class
     * @return the course value
     */
    public Course getCourse(){
        
        return this.course1;
    }
    
    /**
     * get the birthday of student
     * @return the localdate value - the birthday of student
     */
    public LocalDate getBirthday(){
        
        return this.dateOfBirth;
        
    }
    /**
     * get the year of student enrolled
     * @return the int value 
     */
     public int getYearEnrolled(){
        
        return this.getYearEnrolled;
        
    }
     /**
      * get the student number
      * @return the int value
      */
     public int getStudentNumber(){
         
         return this.studentNumber;
         
     }
     /**
      * get the completed course of student
      * @return the string value
      */
     public String getCompletedCourses(){
    	 
    	 String temp = this.compeletedCourse.toString();
    	 temp += (" grade=" + this.grade);
         return "[" + temp +"]";
         
     }
     
     
     /**
      * Add the completed course
      * @param the course value
      * @param the int value
      */
     public void addCompletedCourse(Course completedCourse, int grade){
         
         //validate the range of the grade of student(0<= grade <= 100)
         if(!(grade >= 0 && grade <= 100)) {
        	 throw new IllegalArgumentException("grade must be 0-100 inclusive");
         } else {
        	 this.grade = grade;
         }
         
         //passing course => grade(60), failing course < grade(60)
         if(grade >= 60) {
        	 this.compeletedCourse = "" + completedCourse;
         } else {
        	 this.compeletedCourse = "";
        	 
         }
         
     }
     
     /**
      * set the birthday of student
      * @param the LocalDate object
      */
     public void setBirthday (LocalDate dateOfBirth){

         this.dateOfBirth = dateOfBirth;
    	 sumOfStudentAge = sumOfStudentAge - this.age;
    	 averageAgeOfStudent = (sumOfStudentAge + ((LocalDate.now().getYear() - 1) - dateOfBirth.getYear())) / numberOfStudent;
     }

     /**
      * change the address of student
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
     * check the student's status
     * @return the boolean value
     */
    public boolean inGoodStanding() {
    
        return this.studentStatus;
    }
    /**
     * check the student's status
     * @return the boolean value
     */
    public boolean suspendStudent() {
    
        return this.studentStatus = false;
    }
    /**
     * check the student's status
     * @return the boolean value
     */
    public boolean reinstateStudent() {
    
        return this.studentStatus = false;
    }
    /**
     * check whether the student completed course
     * @param the string value
     * @return the boolean value
     */
    public boolean hasCompleted(String string) {
    	if(this.compeletedCourse.contains(string)) {
    		return true;
    	} else {
    		return false;
    	}
	}
    /**
     * Override toString function
     */
    @Override
    public String toString(){
        return (firstName + " " + lastName+ ", student number: " + this.studentNumber);
    
    }

	
}
