package charnetskaya.threads;

import java.util.concurrent.CountDownLatch;

public class MultithreadingPrintingBusyLoop {
	
	public static void main (String [] args) throws InterruptedException{
		Thread threads [] = new Thread[5];
		
		CountDownLatch latch = new CountDownLatch(5);
		
		for(int i =0; i <threads.length; i++){
			int current = i;
			threads[i] = new Thread(){
				public void run(){
					System.out.println (current);
					latch.countDown();
				}
			};
			
			threads[i].start();
		}
		
		latch.await();
/*		
		//this is a busy loop - bad idea
		int alive = threads.length;
		while(alive > 0){
			alive = 0;
			for(int i = 0; i < threads.length; i++){
				if(threads[i].isAlive()){
					alive++;
				}
			}
		}*/
		
		System.out.println("finished");
	}

}
