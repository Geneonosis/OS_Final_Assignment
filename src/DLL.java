
public class DLL {
	PCB head;
	/* Doubly Linked list Node*/
	class PCB {
		/* class variables */
		int PR;
		int numCPUBurst, numIOBurst;
		
		/* to create dynamic arrays to store cpu and io burst times */
		int []CPUBurst;
		int []IOBurst; 
		
		/* indexes */
		int cpuindex, ioindex;

		/* "pointers" to the next and previous dll PCB node */
	    PCB prev; 
	    PCB next; 
	  
	    /***
	     * PCB is a process control block structure that acts as a node in the DLL
	     * @param priority priority defined in the input file
	     * @param num_CPU_IO_Burst the second number defined in the input.txt file identifies the remaining integers representing the CPU burst and IO burst times
	     * @param PCB_CPU_IO_Array 
	     */
	    PCB(int priority, int num_CPU_IO_Burst, int[] PCB_CPU_IO_Array) { 
	    	PR = priority;
	    	numCPUBurst = (num_CPU_IO_Burst / 2) + 1; 
	    	numIOBurst = num_CPU_IO_Burst / 2;
	    	CPUBurst = new int[numCPUBurst];
	    	IOBurst = new int[numIOBurst];
	    	FillInIOandCPUBurstArrays(PCB_CPU_IO_Array);
	    	cpuindex = 0;
	    	ioindex = 0;
	    }

	    /***
	     * Function: FillInIOandCPUBurstArrays
	     * Purpose: fills in the IO and CPU burst array from the contents of the file
	     * @param PCB_CPU_IO_Array
	     */
		private void FillInIOandCPUBurstArrays(int[] PCB_CPU_IO_Array) {
			int j = 0;
	    	int k = 0;
	    	for(int i = 0; i < PCB_CPU_IO_Array.length; i++) {
	    		if(i % 2 == 0) {
	    			CPUBurst[j] = PCB_CPU_IO_Array[i];
	    		    j++;
	    		}else {
	    			IOBurst[k] = PCB_CPU_IO_Array[i];
	    			k++;
	    		}
	    	}
		}
		
	    public String toString() {
			String str = "\n";
			str += String.format("%-15s %1d\n", "Priority:", PR);
			str += String.format("%-15s %1d\n", "numCPUBurst:", numCPUBurst);
			str += String.format("%-15s %1d\n", "numIOBurst:", numIOBurst);
			str += String.format("%-15s %1d\n", "cpuindex:", cpuindex);
			str += String.format("%-15s %1d\n", "ioindex:", ioindex);
			str += String.format("%-16s", "CPUBurst Array:");
			int i = 0;
			for(i = 0; i < CPUBurst.length; i++) {
				str += i + ": [" + CPUBurst[i] + "] "; 
			}
			str += "\n";
			str += String.format("%-16s", "IOBurst Array:");
			for(i = 0; i < IOBurst.length; i++) {
				str += i + ": [" + IOBurst[i] + "] ";
			}
			str += "\n";
 	    	return str;
	    }
	}

	/***
	 * InsertAtTail(PCB pcb)
	 * Purpose: Insert A pcb at the end of the ready_Q
	 * @param pcb
	 */
	public void InsertAtTail(PCB pcb) {
		if(head == null) {
			head = pcb;
			head.next = head;
			head.prev = head;
		}else{
			pcb.prev = head.prev;
			head.prev = pcb;
			if(head.next == head) {
				head.next = pcb;
			}
			pcb.next = head;
		}
	}
	
	public PCB remove() {
		System.out.println("remove me");
		if(head == null) {
			return null;
		}
		PCB temp = null;
		temp = head;
		if(temp == null) {
			System.out.println("temp is null");
		}else {
			System.out.println("temp is not null");
		}
		
		if(head.next != head) {
			System.out.println("here");
			head = head.next;
			if(temp.prev == null) {
				System.out.println("woops");
			}
			head.prev = temp.prev;
			if(head.next == temp) {
				head.next = head;
			}
			temp.next = null;
			temp.prev = null;
		}else if(head.next == head){
			temp.next = null;
			temp.prev = null;
		}else{
			temp = null;
		}
		return temp;
	}
	
	public String toString() {
		int count = 1;
		String str = "";
		PCB crawl;
		for(crawl = head; crawl.next != head; crawl = crawl.next) {
			str += "<-- ";
			str += "NODE: " + count;
			str += crawl.toString();
			str += "-->\n";
			count++;
		}
		str += "<--";
		str += "NODE: " + count;
		str += crawl.toString();
		str += "--> points back to head\n";
		return str;
	}
	
	/***
	 * The exact same as toString except it prints it in the reverse order
	 * @return String
	 */
	public String printBackwards() {
		int count = 1;
		String str = "";
		PCB crawl;
		if(head.prev == head) {
			System.out.println("im fucked up");
		}
		for(crawl = head; crawl.prev != head; crawl = crawl.prev) {
			str += "<-- ";
			str += "NODE: " + count;
			str += crawl.toString();
			str += "-->\n";
			count++;
		}
		str += "<--";
		str += "NODE: " + count;
		str += crawl.toString();
		str += "--> points back to head\n";
		return str;
	}

	public boolean emptyCheck() {
		// TODO Auto-generated method stub
		if(head == null) {
			return true;
		}
		return false;
	}
}
