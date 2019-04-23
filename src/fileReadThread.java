import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class fileReadThread extends Main implements Runnable{

	private File file;
	String fileName;
	private BufferedReader input;
	//Ready_Q dll2 = null;
	
	public fileReadThread(String string) {
		fileName = "./src/" + string;
	}

	@Override
	public void run() {
		//System.out.println(fileName);
		getFile(fileName);
		readAndPrintFile();
	}

	/***
	 * Funciton: readAndPrintFile()
	 * Purpose: to read a file and print its contents into the console
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
			file_read_done = 1;
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
		Semaphore s1 = semaphore;
		switch(strings[0]) {
		case"proc":
			int firstInt = Integer.parseInt(strings[2]);
			int secondInt = Integer.parseInt(strings[3]);
			Ready_Q.InsertAtTail(Ready_Q.new PCB(firstInt,secondInt,GenerateCPUIOBurstArray(strings,secondInt)));
			/*try {
				s1.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			break;
		case"sleep":
			sleep(strings);
			break;
		case"stop":
			System.out.println("Made it to stop case");
			break;
		default:
			System.out.println("Default in Determine Method");
			break;
		}
	}

	private void sleep(String[] strings) {
		System.out.println("Made it to sleep case");
		System.out.println("Sleep for : " + strings[1] + "ms");
		try {
			Thread.sleep(Integer.parseInt(strings[1]));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/***
	 * takes a string array and converts it into an int array
	 * @param strings
	 * @param length
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
