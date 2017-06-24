public class Employee
{
  
	  private String employee = null; 
	  private int age = 0; 
	  private String position = null; 
	  private Emotions e;
	  private String path = null;
	  private boolean isSelected=false;
	
	private Employee(String employee, int age, String position, Emotions e, String path) {
		
		this.employee = employee;
		this.age = age;
		this.position = position;
		this.e = e;
		this.path = path;
	}

  
  
}