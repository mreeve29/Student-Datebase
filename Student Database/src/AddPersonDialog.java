import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import BreezySwing.*;

public class AddPersonDialog extends GBDialog {

	//elements
	private JLabel addLabel = addLabel("Add Person:",1,1,4,1);
	
	private ButtonGroup studentTypeBG = new ButtonGroup();
	private JRadioButton personButton = addRadioButton("Person",2,1,1,1);
	private JRadioButton studentButton = addRadioButton("Student",2,2,1,1);
	private JRadioButton undergradButton = addRadioButton("Undergraduate",2,3,1,1);
	private JRadioButton graduateButton = addRadioButton("Graduate",2,4,1,1);
	
	private JLabel nameLabel = addLabel("Name:",3,1,2,1);
	private JTextField nameField = addTextField("",3,3,2,1);
	
	private JLabel idLabel = addLabel("Student ID(0 for autogenerated):",4,1,2,1);
	private IntegerField idField = addIntegerField(0,4,3,2,1);
	
	private JLabel majorLabel = addLabel("Major:",5,1,2,1);
	private JTextField majorField = addTextField("",5,3,2,1);
	
	private JLabel levelLabel = addLabel("Level:",6,1,2,1);
	private JComboBox<String> comboLevel = addComboBox(6,3,2,1);
	
	private JButton addPersonButton = addButton("Add Undergraduate",7,3,2,1);
	private JButton cancelButton = addButton("Cancel",7,1,1,1);
	
	//class objects
	private Database db;
	
	public void buttonClicked(JButton button) {
		if(button == addPersonButton) {
			
			//check if name is blank
			String name = nameField.getText();
			if(name.isEmpty() || isBlank(name)) {
				messageBox("Empty name");
				return;
			}
			
			//check if major is blank
			String major = majorField.getText();
			if(undergradButton.isSelected() || graduateButton.isSelected()) {	
				if(major.isEmpty() || isBlank(major)) {
					messageBox("Empty major");
					return;
				}
			}
			
			//check id
			if(!idField.isValidNumber()) {
				messageBox("Invalid ID");
				return;
			}
			
			int id = idField.getNumber();
			
			if(id < 0) {
				messageBox("Can't have negative ID");
				return;
			}
			
			if(db.idExists(id)) {
				messageBox("ID " + id + " already exists");
				return;
			}
			
			if(undergradButton.isSelected()) {
				//undergrad
				Undergraduate.Grade level = Undergraduate.Grade.valueOf(comboLevel.getSelectedItem().toString().toUpperCase());
				db.addPerson(new Undergraduate(name, id, level, major));
				
			}else if(graduateButton.isSelected()){
				//grad
				db.addPerson(new GraduateStudent(name, id, major));
			}else if(personButton.isSelected()){
				//person
				db.addPerson(new Person(name));
			}else if(studentButton.isSelected()) {
				//student
				db.addPerson(new Student(name,id));
			}
			
			setDlgCloseIndicator("ADDED");
			dispose();
		}else if(button == cancelButton) {
			dispose();
		}
	}
	
	//error checking helper method
	private boolean isBlank(String s) {
		for(int i = 0; i < s.length(); i++) {
			if(!Character.isWhitespace(s.charAt(i))) return false;
		}
		return true;
	}
	
	//event listener that changes what fields are visible depending on the type of person selected
	private ChangeListener cl = new ChangeListener() {
		
		@Override
		public void stateChanged(ChangeEvent e) {
			JRadioButton source = (JRadioButton) e.getSource();
			
			if(source == undergradButton && undergradButton.isSelected()) {
				//undergrad --> show level field
				idField.setVisible(true);
				idLabel.setVisible(true);
				majorField.setVisible(true);
				majorLabel.setVisible(true);
				comboLevel.setVisible(true);
				levelLabel.setVisible(true);
				addPersonButton.setText("Add Undergraduate Student");
			}else if(source == graduateButton && graduateButton.isSelected()){
				//grad --> hide level field
				idField.setVisible(true);
				idLabel.setVisible(true);
				majorField.setVisible(true);
				majorLabel.setVisible(true);
				comboLevel.setVisible(false);
				levelLabel.setVisible(false);
				addPersonButton.setText("Add Graduate Student");
			}else if(source == studentButton && studentButton.isSelected()) {
				//student --> hide level and major fields
				idField.setVisible(true);
				idLabel.setVisible(true);
				majorField.setVisible(false);
				majorLabel.setVisible(false);
				comboLevel.setVisible(false);
				levelLabel.setVisible(false);
				addPersonButton.setText("Add Student");
			}else if(source == personButton && personButton.isSelected()) {
				//person --> hide everything but name
				idField.setVisible(false);
				idLabel.setVisible(false);
				majorField.setVisible(false);
				majorLabel.setVisible(false);
				comboLevel.setVisible(false);
				levelLabel.setVisible(false);
				addPersonButton.setText("Add Person");
			}
			
		}
	};
	
	//constructor
	public AddPersonDialog(JFrame parent, Database d) {
		super(parent);
		studentTypeBG.add(graduateButton);
		studentTypeBG.add(undergradButton);
		studentTypeBG.add(personButton);
		studentTypeBG.add(studentButton);
		comboLevel.addItem("Freshmen");
		comboLevel.addItem("Sopohmore");
		comboLevel.addItem("Junior");
		comboLevel.addItem("Senior");
		comboLevel.setSelectedIndex(0);
		
		graduateButton.addChangeListener(cl);
		undergradButton.addChangeListener(cl);
		personButton.addChangeListener(cl);
		studentButton.addChangeListener(cl);
		
		undergradButton.setSelected(true);
		
		db = d;
		
		this.setSize(550,400);
		this.setTitle("Add Person");
		this.setVisible(true);
		
	}

}
