
public class Person {
	private String name;
	
	public Person(String nm) {
		name = nm;
	}
	
	public void setString(String nm) {
		name = nm;
	}
	
	public String getName() {
		return name;
	}
	
	public String print() {
		return "Name: " + name;
	}
	
}
