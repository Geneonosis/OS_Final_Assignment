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
				System.out.println("broke out");
				break;
			}
			
			switch(ALG) {
				case "FIFO":
					//TODO:res = sem_timedwait(&sem_cpu,/*some time say 1 sec*/);
					System.out.println("got to FIFO");
						
					//Ready_Q.PCB pcb = Ready_Q.remove();
					//System.out.println(Ready_Q.printBackwards());
					System.out.println(Ready_Q.toString());
					//DLL.PCB pcb = Ready_Q.remove();

					System.out.println("Semaphore 1 acquire");
					try {
						s1.acquire();
						System.out.println("Aquire worked");
					} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "SJF":
					break;
				case "RR":
					break;
				case "PR":
					break;
				default:
					System.out.println("bravely");
					break;
			}
		}
	}

}
