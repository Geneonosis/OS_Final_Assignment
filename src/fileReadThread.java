import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class fileReadThread implements Runnable{

	private File file;
	String fileName;
	private BufferedReader input;
	
	public fileReadThread(String string) {
		// TODO Auto-generated constructor stub
		fileName = "./src/" + string;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(fileName);
		getFile(fileName);
		readAndPrintFile();
		
	}

	/***
	 * Funciton: readAndPrintFile()
	 * Purpose: to read a file and print its contents into the console
	 * TODO: Break up later?
	 */
	public void readAndPrintFile() {
		// TODO Auto-generated method stub
		try {
			input = new BufferedReader(new FileReader(file));
			String str = "";
			while((str = input.readLine()) != null) {
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/***
	 * Function: getFile
	 * Purpose: to get a file to cache
	 * @param fileName
	 */
	public void getFile(String fileName) {
		// TODO Auto-generated method stub
		file = new File(fileName);
	}
}
