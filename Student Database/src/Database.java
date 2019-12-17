import java.util.ArrayList;
import java.util.Random;

public class Database {
	private ArrayList<Person> people = new ArrayList<Person>();
	private ArrayList<Integer> studentIDs = new ArrayList<Integer>();
	
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
	
	public Person getPerson(int index) {
		return people.get(index);
	}
	
	private int generateID() {
		int id = 0;
		boolean exists = false;
		do {
			Random rand = new Random();
			String num = "";
			for(int i = 1; i <= 4; i++) {
				num += rand.nextInt(9)+1;
			}
			id = Integer.parseInt(num);
			for(Integer i : studentIDs) {
				if(i == id)exists = true;
			}
		}while(exists);
		return id;
	}
	
	public ArrayList<Person> getPeople(){
		return people;
	}
	
	public ArrayList<Person> getStudents(){
		ArrayList<Person> students = new ArrayList<Person>();
		for(Person p : people) {
			if(p instanceof Student) {
				students.add(p);
			}
		}
		return students;
	}
	
	public ArrayList<Person> getUndergrads(){
		ArrayList<Person> undergrads = new ArrayList<Person>();
		for(Person p : people) {
			if(p instanceof Undergraduate) {
				undergrads.add(p);
			}
		}
		return undergrads;
	}
	
	public ArrayList<Person> getGraduates(){
		ArrayList<Person> graduates = new ArrayList<Person>();
		for(Person p : people) {
			if(p instanceof GraduateStudent) {
				graduates.add(p);
			}
		}
		return graduates;
	}
	
	
	public int getSize() {
		return people.size();
	}
	
	
}
