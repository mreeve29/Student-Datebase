import BreezySwing.*;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;
@SuppressWarnings("serial")
public class OutputDialog extends GBDialog{

	//class objects/elements
	private JLabel baseLabel = addLabel("",1,1,1,1);
	private JTextArea personArea = addTextArea("",2,1,1,1);
	
	private JButton closeButton = addButton("Close",3,1,1,1);
	
	public void buttonClicked(JButton button) {
		if(button == closeButton) {
			dispose();
		}
	}
	
	//constructor
	public OutputDialog(JFrame parent, ArrayList<Person> list, String label, String title) {
		super(parent);
		
		baseLabel.setText(label);
		
		personArea.setEditable(false);
		fillTextArea(list);
		
		this.setSize(400,400);
		this.setTitle(title);
		this.setVisible(true);
	}
	
	//fills the output area with a given ArrayList
	private void fillTextArea(ArrayList<Person> list) {
		String people = "";
		for(Person p : list) {
			people += p.print() + '\n';
		}
		personArea.setText(people);
		personArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
	}

}
