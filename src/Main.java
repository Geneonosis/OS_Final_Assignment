import java.util.concurrent.Semaphore;

public class Main {
	
	static public DLL Ready_Q = null;
	static public DLL IO_Q = null;
	static String algorithm = null;
	static int quantumTime = 0;
	Semaphore s1 = new Semaphore(0);
	static int file_read_done = 0;
	
	public static void main(String[] args) {
		//setup from the arguments
		Ready_Q = new DLL();
		IO_Q = new DLL();
		FileReadThread(args);
		
		// starting to build a thread for this
		getRemainingAguments(args[0],args[1]);
		System.out.println(Ready_Q.toString());
		//execution of arguments
	}

	/**
	 * @param args
	 */
	private static void FileReadThread(String[] args) {
		Thread t1 = new Thread(new fileReadThread(args[2]));
		t1.start();
		Thread t2 = new Thread(new CPU_scheduler_thread(args[0]));
		t2.start();
		
		try {
			t1.join();
			t2.join();
			//System.out.println(DLL.head.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/***
	 * Function: getRemainingAguments
	 * Purpose: to obtain the remaining arguments from the command line
	 * @param alg
	 * @param qt
	 */
	private static void getRemainingAguments(String alg, String qt) {
		// TODO Auto-generated method stub
		algorithm = alg;
		quantumTime = Integer.parseInt(qt);
	}
}
