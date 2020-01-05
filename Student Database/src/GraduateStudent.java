
public class GraduateStudent extends Student{
	
	//class objects
	private String major;
	
	//constructor
	public GraduateStudent(String nm, int id, String m) {
		super(nm,id);
		major = m;
	}
	
	public void setMajor(String m) {
		major = m;
	}
	
	public String getMajor() {
		return major;
	}
	
	public String print() {
		return "Name: "  + getName() + '\n' +
					"Major: " + major + '\n' + 
					"Student ID: " + getID();
	}
	
	public boolean equals(GraduateStudent g) {
		if(major.equalsIgnoreCase(g.getMajor())) {
			return true;
		}else return false;
	}
	
	
}
