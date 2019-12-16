
public class Undergraduate extends Student{
	
	enum Grade{
		FRESHMAN("Freshman"),
		SOPHMORE("Sophmore"),
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
	
	public String print() {
		return "Name: "  + getName() + '\n' +
					"Grade Level: " + level.getDescription() + '\n' +
					"Major: " + major + '\n' + 
					"Student ID: " + getID();
	}
	
	
}
