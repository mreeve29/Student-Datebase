import BreezySwing.*;

import java.awt.Font;

import javax.swing.*;
@SuppressWarnings("serial")
public class PersonCompareDialog extends GBDialog{

	//class objects
	private Database db;
	
	private JLabel label = addLabel("",1,1,1,1);
	private JList<String> peopleList = addList(2,1,1,1);
	private JTextArea peopleDetails = addTextArea("",2,2,1,1);
	
	private JButton closeButton = addButton("Close",3,2,1,1);
	
	
	public void buttonClicked(JButton button) {
		if(button == closeButton) {
			dispose();
		}
	}
	
	//constructor
	public PersonCompareDialog(JFrame parent, Database d, String dialogTitle, String labelText) {
		super(parent);
		
		db = d;
		
		peopleDetails.setEditable(false);
		peopleDetails.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		label.setText(labelText);
		
		populateList();
		
		this.setTitle(dialogTitle);
		this.setSize(600,400);
		this.setVisible(true);
	}

	//adds people to list
	private void populateList() {
		if(db.getUndergradsAndGrads().size() == 0)return;
		for(Person p : db.getUndergradsAndGrads()) {
			addItemToList(p.getName());
		}
	}

	//helper method to add single String to list
	private void addItemToList(String add) {
		DefaultListModel<String> model = (DefaultListModel<String>)peopleList.getModel();
        model.addElement(add);
	}
	
	//list event listeners
	public void listItemSelected(JList<String> list) {
		compare();
	}
	
	public void listDoubleClicked(JList<String> list, String itemClicked) {
		compare();
	}
	
	private void compare() {
		Person selected = db.getUndergradsAndGrads().get(peopleList.getSelectedIndex());
		String result = "";
		for(Person p : db.getPeople()) {
			if(p instanceof GraduateStudent) {
				GraduateStudent inList = (GraduateStudent)p;
				if(selected instanceof GraduateStudent) {
					GraduateStudent s = (GraduateStudent)selected;
					if(inList == selected)continue;
					if(s.equals(inList)) {
						result += inList.print() + "\n\n";
					}
				}
			}else {
				Undergraduate inList = (Undergraduate)p;
				if(selected instanceof Undergraduate) {
					Undergraduate s = (Undergraduate)selected;
					if(inList == selected)continue;
					if(s.equals(inList)) {
						result += inList.print() + "\n\n";
					}
				}
			}
		}
		if(result.isEmpty()) {
			peopleDetails.setText("There are no students who compare to " + selected.getName());
		}else {
			peopleDetails.setText("Students that compare to " + selected.getName() + ":\n" + result);
		}
		revalidate();
	}

}