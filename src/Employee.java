public class Employee
{
  
	  private String name = null; 
	  private String age = null; 
	  private String position = null; 
	  private Emotions e;
	  private String path = null;
	  boolean isSelected=false;
	
	Employee(String name, String age, String position, Emotions e, String path) {
		
		this.name = name;
		this.age = age;
		this.position = position;
		this.e = e;
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setEmployee(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Emotions getE() {
		return e;
	}

	public void setE(Emotions e) {
		this.e = e;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	public String getDominantEmotions(){
		return "abc";
	}
  
  
}