
public class Ready_Q {
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
	  
	    // Constructor to create a new node 
	    // next and prev is by default initialized as null
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
	     * 
	     * @param PCB_CPU_IO_Array
	     */
		private void FillInIOandCPUBurstArrays(int[] PCB_CPU_IO_Array) {
			int j = 0;
	    	int k = 0;
	    	for(int i = 0; i < PCB_CPU_IO_Array.length; i++) {
	    		if(i % 2 == 0) {
	    			CPUBurst[j] = PCB_CPU_IO_Array[i];
	    			//System.out.print(CPUBurst[j] + " ");
	    		    j++;
	    		}else {
	    			IOBurst[k] = PCB_CPU_IO_Array[i];
	    			k++;
	    		}
	    	}
		}
	    public String toString() {
			String str = "";
			str += "Report: \n";
			str += "Priority: " + PR + "\n";
			str += "numCPUBurst: " + numCPUBurst + "\n";
			str += "numIOBurst: " + numIOBurst + "\n";
			str += "cpuindex: " + cpuindex + "\n";
			str += "ioindex: " + ioindex + "\n";
			str += "CPUBurst Array: ";
			int i = 0;
			for(i = 0; i < CPUBurst.length; i++) {
				str += i + ": [" + CPUBurst[i] + "] "; 
			}
			str += "\n";
			str += "IOBurst Array: ";
			for(i = 0; i < IOBurst.length; i++) {
				str += i + ": [" + IOBurst[i] + "] ";
			}
			str += "\n";
 	    	return str;
	    }
	}

	public void InsertAtTail(PCB pcb) {
		//for if there is only one pcb
		//System.out.println(pcb.toString());
		if(head == null) {
			head = pcb;
			System.out.println(head.toString());
			head.next = head;
			head.prev = head;
		}else{
			if(head.next == head) {
				head.next = pcb;
			}
			head.prev.next = pcb;
			pcb.next = head;
			pcb.prev = head.prev;
			head.prev = pcb;
		}
	}
}
