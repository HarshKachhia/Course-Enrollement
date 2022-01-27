public class Person
{
   private String  name;

   public Person(String initialName) //constructor will set values based on argument
   {
      name = initialName;
   }
   
   public Person()
   {
     //default constructor
   }
   
   public void setName( String fullName)
   {
      name = fullName;
   }

   public String getName() {
      return name;
   }
 
   public String toString()
   {
      return name;
   }
}
