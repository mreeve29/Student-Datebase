
public class Student extends Person{

	private int studentID;
	
	public Student(String nm, int id) {
		super(nm);
		studentID = id;
	}
	
	public void setID(int id) {
		studentID = id;
	}
	
	public int getID() {
		return studentID;
	}
	
	public String print() {
		return "Name: " + getName() + '\n'+
					"Student ID: " + studentID + '\n';
	}
	
	
}
