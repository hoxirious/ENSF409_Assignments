import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
	
	private ArrayList<Supplier> suppliers;

    
	public ArrayList<Item> readStorage() throws IOException {
	 ArrayList<Item> itemList = new ArrayList<Item>();
	 String filename = "E:\\FormCanada\\UOC\\S2021\\ENSF409\\ENSF409_Assignments\\Lab3\\ex1\\items.txt";
	 
	 FileReader fr;
	try {
		fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		
		String line; 
		
		try {
			while((line = br.readLine())!=null) {
				String[] itemInfo = line.split(";");

				
				int id = Integer.parseInt(itemInfo[0]);
				String name = itemInfo[1];
				int quantity = Integer.parseInt(itemInfo[2]);
				int supID = Integer.parseInt(itemInfo[4]);
				double price = Double.parseDouble(itemInfo[3]);
				
				
				
				Item newItem = new Item(id,name, quantity, price, supID);
				itemList.add(newItem);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		br.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	return itemList;
}

    public ArrayList<Supplier> readSupplier() {
        suppliers = new ArrayList<Supplier>();

        String outputFilename = "E:\\FormCanada\\UOC\\S2021\\ENSF409\\ENSF409_Assignments\\Lab3\\ex1\\suppliers.txt";

        try {
            FileReader fr = new FileReader(outputFilename);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] suppInfo = line.split(";");
                suppliers.add(new Supplier(Integer.parseInt(suppInfo[0]), suppInfo[1], suppInfo[2], suppInfo[3]));
            }
            br.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("Cannot read the outfile location");
        }
        return suppliers;
    }

}
