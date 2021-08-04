import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * The Class FileManager.
 */
public class FileManager {
	
	/**
	 * Read input.
	 *
	 * @param inputLocation the input location
	 * @return the array list of Data
	 * @throws FileNotFoundException the file not found exception
	 */
	public ArrayList <Data> readInput (String inputLocation) throws FileNotFoundException {
		ArrayList<Data>studentInfoList = new ArrayList <Data>();
		
		FileReader fr;

		fr = new FileReader(inputLocation);
		BufferedReader br = new BufferedReader(fr);
		
		String line;
		try {
			while ((line = br.readLine()) != null ) {
				String [] misc = line.stripLeading().split("\\s+");
				Data newStudent = new Data (misc[0],misc[1],misc[2],misc[3]);
				studentInfoList.add(newStudent);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentInfoList; 
	}
}
