import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileManager {

	public boolean output(Database db, File f) {
		try {
			
			//if the file path does not end with ".ser" then it will be appended to it
			String path = f.getAbsolutePath();
			if(!path.endsWith(".ser")) {
				f = new File(path + ".ser");
			}
			
			//open file and object output stream
			FileOutputStream file = new FileOutputStream(f);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			//write the arraylist of serializable person objects to the out stream
			out.writeObject(db.getPeople());
			
			//close out streams
			out.close();
			file.close();
			
			return true;
		} catch (IOException i) {
			return false;
		}
	}

	public boolean importFile(Database db, File f) {
		try {
			//open file and object input stream
			FileInputStream file = new FileInputStream(f);
			ObjectInputStream in = new ObjectInputStream(file);

			//read object from input stream and typecast it to arraylist of person objects
			db.importData((ArrayList<Person>) in.readObject());
			
			//close in streams
			in.close();
			file.close();

			return true;
		} catch (Exception e) {
			return false;
		}

	}
}
