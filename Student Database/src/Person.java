import java.io.Serializable;

public class Person implements Serializable{
	private String name;
	
	public Person(String nm) {
		name = nm;
	}
	
	public Person() {
		name = "";
	}
	
	public void setName(String nm) {
		name = nm;
	}
	
	public String getName() {
		return name;
	}
	
	public String print() {
		return "Name: " + name;
	}
	
}
