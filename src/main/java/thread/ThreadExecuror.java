package thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadExecuror {
public static void main(String[] args) {
	testThreadFactory2();	
}
public static void testThreadFactory() {
	CustomThreadFactory threadFactory = new CustomThreadFactory("test");
	MyRunable myRunable = new MyRunable();
	for(int i=0;i<5;i++) {
		Thread t = threadFactory.newThread(myRunable);
		t.start();
	}
	System.out.printf("Give me CustomThreadFactory stats:\n\n" + threadFactory.getStats());
	
}
public static void testThreadFactory2() {
	CustomThreadFactory threadFactory = new CustomThreadFactory("test");
	MyRunable myRunable = new MyRunable();
	ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), threadFactory);
	for(int i=0;i<5;i++) {
		executor.execute(myRunable);
	}
	System.out.printf("Give me CustomThreadFactory stats:\n\n" + threadFactory.getStats());
}
}
class MyRunable implements Runnable{
	
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("`````````");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
