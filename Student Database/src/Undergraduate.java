
public class Undergraduate extends Student{
	
	//enum to store grade level
	public enum Grade{
		FRESHMEN("Freshmen"),
		SOPOHMORE("Sopohmore"),
		JUNIOR("Junior"),
		SENIOR("Senior");
		
		//enum objects
		private String description;
		
		public String getDescription() {
			return description;
		}
		
		//enum constructor
		Grade(String d){
			description = d;
		}	
	}
	
	private Grade level;
	
	private String major;
	
	//constructor
	public Undergraduate(String nm, int id, Grade lvl, String m) {
		super(nm,id);
		level = lvl;
		major = m;
	}
	
	public String print() {
		return "Name: "  + getName() + '\n' +
					"Grade Level: " + level.getDescription() + '\n' +
					"Major: " + major + '\n' + 
					"Student ID: " + getID();
	}
	
	public Grade getLevel() {
		return level;
	}
	
	public String getMajor(){
		return major;
	}
	
	public boolean equals(Undergraduate u) {
		if(level == u.getLevel() && major.equalsIgnoreCase(u.getMajor())) {
			return true;
		}else return false;
	}
	
}
