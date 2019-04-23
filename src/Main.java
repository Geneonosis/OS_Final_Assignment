public class Main {
	
	static public Ready_Q DLL = null;
	static String algorithm = null;
	static int quantumTime = 0;
	
	public static void main(String[] args) {
		//setup from the arguments
		DLL = new Ready_Q();
		FileReadThread(args);
		
		// starting to build a thread for this
		getRemainingAguments(args[0],args[1]);
		System.out.println(DLL.toString());
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
