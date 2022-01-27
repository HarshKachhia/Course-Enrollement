// Courses.java
// Harsh Kachhia
// Student#: 100792045

import java.util.Vector;

public class Course{
   private Department dept;
   private String title; // title of the course (e.g. Intro to programming);
   private String code; // course code, e.g. SOFE, ELEE, MANE, etc.
   private int number; // course number, e.g. 1200, 2710, 2800, etc.
   private  Vector <Student>classList; // contains all students registered in this course

    //constructor will set values based on arguments
   public Course(String code, int number, Department dept, String title)
   {
       this.code = code;
       this.number = number;
       this.dept = dept;
       this.title = title;
       this.classList = new Vector<Student>(); //initialise the Vector
   }

   public Course()
   {
	    // TODO Auto-generated constructor stub
       // default
   }

   //Getter Methods
   public String getCode()
   {
       return code;
   }
   public int getNumber()
   {
       return number;
   }
   public Vector getClassList(){ return classList;}

 //Formatted output
  public String toString() {
     // return a string representation of the course with the course code,
     // name, and number of people registered in the course in the following
     // format:
     // SOFE 2710 Object Oriented Programming and Design, Enrollment = 260
      return this.code + " " + this.number + " " + this.title + ", Enrollment = " + this.classList.size();  //Fix

  }

  public void addStudentToCourse(Student student)
  {
       if((classList.contains(student)) == false)
        {
            classList.add(student); //update classList of course to include student
            dept.offerCourse(this); //telling dept to offer this course in order to use printclassesOffered()
        }
  }

}
