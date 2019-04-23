
public class CPU_scheduler_thread extends Main implements Runnable{
	String ALG = null;
	
	CPU_scheduler_thread(String arg1){
		ALG = arg1;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			//IF READY_Q is empty and IO_Q is empty and file_read_done is 1, then break
			if(Ready_Q.emptyCheck() && IO_Q.emptyCheck() && file_read_done == 1) {
				break;
			}
			
			switch(ALG) {
				case "FIFO":
					//TODO:res = sem_timedwait(&sem_cpu,/*some time say 1 sec*/);
					
					break;
				case "SJF":
					break;
				case "RR":
					break;
				case "PR":
					break;
				default:
					System.out.println("bravely");			
			}
		}
	}

}
