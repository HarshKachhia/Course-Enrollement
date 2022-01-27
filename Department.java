import java.util.HashSet;
import java.util.Vector;

public class Department {
   private String name; // the name of school Dept of Computing and Info Science
   private String id; // short name for courses SOFE, ELEE, STAT, etc
   private Vector<Course> courseList; // all courses offered by the department
   private Vector<Student> registerList; // all students taking courses in the department.

   //constructor will set values based on arguments
   public Department(String name, String id) {
      this.name = name;
      this.id = id;
      this.courseList = new Vector<Course>(); //initialise the Vector
      this.registerList = new Vector<Student>(); //initialise the Vector
   }

   //Getter Methods
   public String getName() {
      return name;
   }
   public String getId() {
      return id;
   }

   //Formatted Output
   public String toString()
   {
      // returns a string representation of department name, number 
      // of courses offered and number of students registered in the
      // department. Use the format:
      // ECSE: 53 courses, 460 students
      return id + ": " + courseList.size() + " courses, " + registerList.size() + " students";
   }

   //Method adds a course to the courseList
   public void offerCourse(Course course)
   {
      if(!(courseList.contains(course))) //if the courseList doesn't already have this course then
      {
         courseList.add(course); //add
      }
   }

   //Method prints the courses offered in the department
   public String printCoursesOffered()
   {
      for (Course course : courseList) //for all courses in the courseList
      {
         //course.toString();
         System.out.println(course); //done in alternative way
      }
      return "";
   }

   //Method to print all students in the department by name
   public String printStudentsByName()
   {
      for (Student student : registerList) //for all student in registerList
      {
         student.toString(); //print using it's respective .toString() method
      }
      return "";
   }

   //Method to register a student course in the department
   public void registerStudentCourseInDepartment(Student student, Course course)
   {
      if(isStudentRegistered(student) == false) //if the student is not registered, then add
      {
         registerList.add(student);
         offerCourse(course);
      }
   }

   //Method checks if the student is registered in the department
   public boolean isStudentRegistered(Student student)
   {
      return registerList.contains(student); //checks if the list contains the student object
   }


   //-------BONUS--------

   //Method to check the students who are registered in a course using it's specific course number
   public Vector<Student> studentsRegisteredInCourse(int code)
   {
      for (Course course : courseList)
      {
         if (course.getNumber() == code) // if the parameter number matches any course number in courseList
         {
            return course.getClassList(); //get the list of students in the class
         }
      }
      return null;
   }

   //Method to print the students in a course which were found using the studentsRegisteredInCourse() method
   public void printStudentsRegisteredInCourse(int code)
   {
      if (studentsRegisteredInCourse(code).isEmpty()) //0 students
      {
         System.out.println(""); //return null
      }
      for (Student student : studentsRegisteredInCourse(code)) //iterate through the students in the classList of the found course
      {
         System.out.println(student.getId() + ", " + student.getName()); // print the student's info
      }
   }

   //Method to find the largest course in the department
   public Course largestCourse()
   {
      int largestNum = 0;
      Course largestCourse = new Course(); //temp/new course object to hold all the info

      for (Course course : courseList) //iterate over the course in courseList
      {
         if (course.getClassList().size() > largestNum)  //will keep doing this to find the largest class size
         {
            //by default will print the last course found with the largest classSize (if 2 or more courses have the same classSize)

            largestNum = course.getClassList().size(); //stores the largest classSize in the variable
            largestCourse = course; //stores the largest found course inside the new largestCourse object
         }
      }
      return largestCourse; //returns the temp/new course object
   }

}