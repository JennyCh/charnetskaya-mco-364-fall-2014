package charnetskaya.threads;

public class MultithreadingPrintingBusyLoop {
	
	public static void main (String [] args){
		Thread threads [] = new Thread[10000000];
		
		for(int i =0; i <threads.length; i++){
			int current = i;
			threads[i] = new Thread(){
				public void run(){
					System.out.println (current);
				}
			};
			
			threads[i].start();
		}
		
		//this is a busy loop - bad idea
		int alive = threads.length;
		while(alive > 0){
			alive = 0;
			for(int i = 0; i < threads.length; i++){
				if(threads[i].isAlive()){
					alive++;
				}
			}
		}
		
		System.out.println("finished");
	}

}
