public class Main {
	
	static String algorithm = null;
	static int quantumTime = 0;
	
	public static void main(String[] args) {
		//setup from the arguments
		
		// TODO getting the file and reading from the file
		// need to be in their own thread!!!
		FileReadThread(args);
		
		// starting to build a thread for this
		getRemainingAguments(args[0],args[1]);
		
		//execution of arguments
	}

	/**
	 * @param args
	 */
	private static void FileReadThread(String[] args) {
		Thread t1 = new Thread(new fileReadThread(args[2]));
		t1.start();
		
		try {
			t1.join();
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
