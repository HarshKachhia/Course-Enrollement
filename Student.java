import java.util.Vector;

public class Student extends Person
{
  private String id;
  private String name;
  private Vector<Course> courses; // contains all courses the student is registered in

	//constructor will set values based on arguments
	public Student(String stdName, String stdId)
	{
		name = stdName;
		id = stdId;
		this.courses = new Vector<Course>(); //initialise the Vector
	}

	//Getters
	public String getName()
	{
  		return name;
	}
	public String getId()
	{
		return id;
	}

    public String toString()
	{
     // return a string representation of a student using the following format:
     // 100234546 John McDonald
     // Registered courses: ELEE 2110, ELEE 2790, SOFE 2710, SOFE 2800, SOFE 2850
		System.out.println("\n" + this.id + " " + this.name);
		System.out.print("Registered courses: ");
		for(Course course: this.courses)
				System.out.print(course.getCode() + " " + course.getNumber() + ", ");
		return "";
	}

	//Method to add student to course.
	public void registerFor(Course course)
	{
		//checks to see if the student is already in the course
		if (!(courses.contains(course)))
		{
			courses.add(course); //adds course to student's list
		}

	}

	//Method checks if the student is registered in a course(argument)
	public Boolean isRegisteredInCourse(Course course)
	{
		return courses.contains(course); //returns boolean value indicating based on student's courses vector
	}

}
