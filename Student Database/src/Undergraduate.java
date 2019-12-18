
public class Undergraduate extends Student{
	
	public enum Grade{
		FRESHMAN("Freshman"),
		SOPOHMORE("Sopohmore"),
		JUNIOR("Junior"),
		SENIOR("Senior");
		
		private String description;
		
		public String getDescription() {
			return description;
		}
		
		Grade(String d){
			description = d;
		}
		
		
	}
	
	private Grade level;
	
	private String major;
	
	public Undergraduate(String nm, int id, Grade lvl, String m) {
		super(nm,id);
		level = lvl;
		major = m;
	}
	
	public Undergraduate() {
		super("",-1);
		level = null;
		major = "";
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
		if(level == u.getLevel() && major.equals(u.getMajor())) {
			return true;
		}else return false;
	}
	
}
