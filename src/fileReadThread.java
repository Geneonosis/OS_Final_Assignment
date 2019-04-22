import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class fileReadThread extends Main implements Runnable{

	private File file;
	String fileName;
	private BufferedReader input;
	//Ready_Q dll2 = null;
	
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
				
				DetermineWhatToDoWith(words);
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
	private void DetermineWhatToDoWith(String []strings) {
		switch(strings[0]) {
		case"proc":
			//TODO: create a PCB structure, read other parameters into it
			System.out.println("Made it to proc case");
			System.out.println(strings.length);

			DLL.InsertAtTail(DLL.new PCB(Integer.parseInt(strings[2]),Integer.parseInt(strings[3]),GenerateCPUIOBurstArray(strings,Integer.parseInt(strings[3]))));
			//DLL.head.next = DLL.new PCB(1,7);
			System.out.println("head.next: " + DLL.head.next.toString());
			
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
	 * 
	 * @param strings
	 * @return
	 */
	public int [] GenerateCPUIOBurstArray(String[] strings, int length ) {
		int j = 0;
		int array[] = new int[length];
		for(int i = 4; i < strings.length; i++) {
			array[j] = Integer.parseInt(strings[i]);
			j++;
		}
		return array;	
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
