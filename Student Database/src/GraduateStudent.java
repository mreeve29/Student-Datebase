
public class GraduateStudent extends Student{
	
	private String major;
	
	public GraduateStudent(String nm, int id, String m) {
		super(nm,id);
		major = m;
	}
	
	public GraduateStudent() {
		super("",-1);
		major = "";
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
		if(major.equals(g.getMajor())) {
			return true;
		}else return false;
	}
	
	
}
