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
			
			String path = f.getAbsolutePath();
			if(!path.endsWith(".ser")) {
				f = new File(path + ".ser");
			}
			
			FileOutputStream file = new FileOutputStream(f);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(db.getPeople());
			out.close();
			file.close();
			return true;
		} catch (IOException i) {
			return false;
		}
	}

	public boolean importFile(Database db, File f) {
		try {
			FileInputStream file = new FileInputStream(f);
			ObjectInputStream in = new ObjectInputStream(file);

			db.importData((ArrayList<Person>) in.readObject());
			in.close();
			file.close();

			return true;
		} catch (Exception e) {
			return false;
		}

	}
}
