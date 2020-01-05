import java.util.ArrayList;
import java.util.Random;

public class Database {
	
	//class objects
	private ArrayList<Person> people = new ArrayList<Person>();
	
	//adds a person
	public void addPerson(Person p) {
		if(p instanceof Student){
			Student s = (Student) p;
			if(s.getID() == 0) {
				s.setID(generateID());
			}
			people.add(s);
		}else {
			people.add(p);
		}
	}
	
	//gets a person
	public Person getPerson(int index) {
		return people.get(index);
	}
	
	//generates unique id between 1111 and 9999
	private int generateID() {
		int id = 0;
		boolean exists = false;
		do {
			exists = false;
			Random rand = new Random();
			String num = "";
			for(int i = 1; i <= 4; i++) {
				num += rand.nextInt(9)+1;
			}
			id = Integer.parseInt(num);
			exists = idExists(id);
		}while(exists);
		return id;
	}
	
	//gets all people
	public ArrayList<Person> getPeople(){
		return people;
	}
	
	//gets all students
	public ArrayList<Person> getStudents(){
		ArrayList<Person> students = new ArrayList<Person>();
		for(Person p : people) {
			if(p instanceof Student) {
				students.add(p);
			}
		}
		return students;
	}
	
	//gets all undergrads
	public ArrayList<Person> getUndergrads(){
		ArrayList<Person> undergrads = new ArrayList<Person>();
		for(Person p : people) {
			if(p instanceof Undergraduate) {
				undergrads.add(p);
			}
		}
		return undergrads;
	}
	
	//gets all grads
	public ArrayList<Person> getGraduates(){
		ArrayList<Person> graduates = new ArrayList<Person>();
		for(Person p : people) {
			if(p instanceof GraduateStudent) {
				graduates.add(p);
			}
		}
		return graduates;
	}
	
	//gets undergrads and grads, used in comparison dialog
	public ArrayList<Person> getUndergradsAndGrads(){
		ArrayList<Person> combined = new ArrayList<Person>();
		for(Person p : people) {
			if(p instanceof GraduateStudent || p instanceof Undergraduate) {
				combined.add(p);
			}
		}
		return combined;
	}
	
	//gets amount of people
	public int getSize() {
		return people.size();
	}
	
	//imports new arraylist
	public void importData(ArrayList<Person> p) {
		people.clear();
		people.addAll(p);
	}
	
	//checks if ID already exists
	public boolean idExists(int id) {
		for(Person p : people) {
			if(p instanceof Student) {
				Student s = (Student)p;
				if(s.getID() == id)return true;
			}
		}
		return false;
	}
	
}
