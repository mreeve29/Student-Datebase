import BreezySwing.*;

import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
public class DatabaseGUI extends GBFrame{
	
	private Database db = new Database();
	
	private JLabel personCountLabel = addLabel("Number of people in database: 0",1,1,1,1);
	private JButton addPersonButton = addButton("Add Person",2,1,1,1);
	private JButton printAllPeopleButton = addButton("Print All People",3,1,1,1);
	private JButton printAllStudentsButton = addButton("Print All Students",4,1,1,1);
	private JButton printAllUndergraduatesButton = addButton("Print All Undergraduates",5,1,1,1);
	private JButton printAllGraduatesButton = addButton("Print All Graduates",6,1,1,1);
	private JButton compareStudentButton = addButton("Compare Students",7,1,1,1);
	private JButton importButton = addButton("Import",8,1,1,1);
	private JButton exportButton = addButton("Export",9,1,1,1);
	private JButton quitButton = addButton("Quit",10,1,1,1);
	
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
			PersonCompareDialog pcd = new PersonCompareDialog(this,db,"Select Students to Compare:","Compare Students");
		}else if(button == importButton){
			FileManager fm = new FileManager();
			String home = System.getProperty("user.home");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Student Database Files", "ser");
			JFileChooser fc = new JFileChooser(home + "/Desktop");
			fc.setFileFilter(filter);
			
			fc.showOpenDialog(this);
			
			File selected = fc.getSelectedFile();
			if(selected == null)return;
			
			if(!selected.getAbsolutePath().endsWith(".ser")) {
				messageBox("Invald file, please select a .ser file");
				return;
			}
			
			int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to import a database? It will overwrite the current database.", "Confirm Import", JOptionPane.YES_NO_OPTION);
			
			if(confirm != 0)return;
			
			if(!fm.importFile(db, selected)) {
				messageBox("Invald file, please select a .ser file");
			}
			
			personCountLabel.setText("Number of people in database: " + db.getSize());
			if(db.getSize() >= 10) {
				addPersonButton.setEnabled(false);
			}
			
		}else if(button == exportButton){
			FileManager fm = new FileManager();
			String home = System.getProperty("user.home");
			JFileChooser fc = new JFileChooser(home + "/Desktop");

			int clicked = fc.showSaveDialog(this);
			
			File selected = fc.getSelectedFile();
			if(selected == null || clicked == JFileChooser.CANCEL_OPTION)return;
			
			if(fm.output(db, selected)) {
				messageBox("File Saved");
			}
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
