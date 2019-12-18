import BreezySwing.*;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;
@SuppressWarnings("serial")
public class PersonCompareDialog extends GBDialog{

	//class objects
	private ArrayList<Person> people;
	
	private JLabel label = addLabel("",1,1,1,1);
	private JList<String> bookList = addList(2,1,1,1);
	private JTextArea bookDetails = addTextArea("",2,2,1,1);
	
	private JButton closeButton = addButton("Close",3,2,1,1);
	
	
	public void buttonClicked(JButton button) {
		if(button == closeButton) {
			dispose();
		}
	}
	
	//constructor
	public PersonCompareDialog(JFrame parent, ArrayList<Person> list, String dialogTitle, String labelText) {
		super(parent);
		
		people = list;
		
		bookDetails.setEditable(false);
		bookDetails.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		label.setText(labelText);
		
		populateList();
		
		this.setTitle(dialogTitle);
		this.setSize(400,400);
		this.setVisible(true);
	}

	//adds books to list
	private void populateList() {
		if(people.size() == 0)return;
		for(Person p : people) {
			addItemToList(p.getName());
		}
	}

	//helper method to add single String to list
	private void addItemToList(String add) {
		DefaultListModel<String> model = (DefaultListModel<String>)bookList.getModel();
        model.addElement(add);
	}
	
	//list event listeners
	public void listItemSelected(JList<String> list) {
		//compare
		revalidate();
	}
	
	public void listDoubleClicked(JList<String> list, String itemClicked) {
		//compare
		revalidate();
	}

}