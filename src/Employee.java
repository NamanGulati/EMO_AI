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
		double [] emos = new double[8]; 
		String [] feelings = {"contempt", "digust","fear","happiness","neutral","sadness","suprise","anger"};
		emos[0]= e.scores.getContempt(); 
	      emos[1]= e.scores.getDisgust(); 
	      emos[2]= e.scores.getFear(); ;
	      emos[3]= e.scores.getHappiness(); ; 
	      emos[4]= e.scores.getNeutral(); ;
	      emos[5]= e.scores.getSadness();
	      emos[6] = e.scores.getSurprise();  
	      emos[7]= e.scores.getAnger();
	      double max = 0; 
	      int index = 0; 
	      for( int t = 0; t < emos.length; t++)
	      {
	        if (emos[t] > max)
	        { 
	          max = emos[t]; 
	          index = t; 
	        }
	        
	      }	
	      return feelings[index];
	}
  
  
}