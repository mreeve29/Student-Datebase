import BreezySwing.*;
import javax.swing.*;
public class DatabaseGUI extends GBFrame{
	
	private Database db = new Database();
	
	private JLabel personCountLabel = addLabel("Number of people in database: 0",1,1,1,1);
	private JButton addPersonButton = addButton("Add Person",2,1,1,1);
	private JButton printAllPeopleButton = addButton("Print All People",3,1,1,1);
	private JButton printAllStudentsButton = addButton("Print All Students",4,1,1,1);
	private JButton printAllUndergraduatesButton = addButton("Print All Undergraduates",5,1,1,1);
	private JButton printAllGraduatesButton = addButton("Print All Graduates",6,1,1,1);
	private JButton compareStudentButton = addButton("Compare Students",7,1,1,1);
	private JButton quitButton = addButton("Quit",8,1,1,1);
	
	public void buttonClicked(JButton button) {
		if(button == addPersonButton) {
			AddPersonDialog apd = new AddPersonDialog(this,db);
			if(apd.getDlgCloseIndicator().equals("ADDED")) {
				personCountLabel.setText("Number of people in database: " + db.getSize());
				if(db.getSize() >= 10) {
					addPersonButton.setEnabled(false);
				}
			}
		}else if(button == printAllPeopleButton) {
			OutputDialog od = new OutputDialog(this, db.getPeople(), "All People:", "All People in Database");
			
		}else if(button == printAllStudentsButton) {
			OutputDialog od = new OutputDialog(this, db.getStudents(), "All Students:", "All Students in Database");
			
		}else if(button == printAllUndergraduatesButton) {
			OutputDialog od = new OutputDialog(this, db.getUndergrads(), "All Undergrads:", "All Undergrads in Database");
			
		}else if(button == printAllGraduatesButton) {
			OutputDialog od = new OutputDialog(this, db.getGraduates(), "All Graduates:", "All Graduates in Database");
			
		}else if(button == compareStudentButton) {
			//TODO: add compare dialog
		}else if(button == quitButton) {
			System.exit(1);
		}
	}
	
	
	public static void main(String[] args) {
		DatabaseGUI frm = new DatabaseGUI();
	}
	
	public DatabaseGUI() {
		this.setSize(400,400);
		this.setTitle("Student Database");
		this.setVisible(true);
	}
}
