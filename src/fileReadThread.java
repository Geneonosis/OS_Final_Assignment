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
		try {
			input = new BufferedReader(new FileReader(file));
			String str = "";
			while((str = input.readLine()) != null) {
				//split the words across a space, and stores that split words
				String words[] = str.split(" ");
				//System.out.println(words[0]);
				
				DetermineWhatToDoWith(words[0]);
			}
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException " + e + " in readAndPrintFile()");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException " + e + " in readAndPrintFile()");
			e.printStackTrace();
		}
	}

	/***
	 * Function: DetermineWhatToDoWith(String string)
	 * Purpose: to control the flow of execution for the program based on words[0]
	 * @param string
	 */
	private void DetermineWhatToDoWith(String string) {
		switch(string) {
		case"proc":
			//TODO: create a PCB structure, read other parameters into it
			System.out.println("Made it to proc case");
			break;
		case"sleep":
			System.out.println("Made it to sleep case");
			break;
		case"stop":
			System.out.println("Made it to stop case");
			break;
		case"default":
			System.out.println("Default in Determine Method");
			break;
		}
	}

	/***
	 * Function: getFile
	 * Purpose: to get a file to cache
	 * @param fileName
	 */
	public void getFile(String fileName) {
		file = new File(fileName);
	}
}
