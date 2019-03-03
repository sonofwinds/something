package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Excutors {

	public static void main(String[] args) {
		testCacheThreadPool();
	}
	public static void testCacheThreadPool() {
		ExecutorService threadService = Executors.newCachedThreadPool();
		threadService.execute(new MyRunable());
		threadService.execute(new MyRunable());
		threadService.execute(new MyRunable());
		threadService.execute(new MyRunable());
	}
	public static void testFixedThreadPool() {
		ExecutorService threadService = Executors.newFixedThreadPool(1);
		threadService.execute(new MyRunable());
		threadService.execute(new MyRunable());
		threadService.execute(new MyRunable());
		threadService.execute(new MyRunable());
	}

}
class MyRunable implements Runnable{
	
	public void run() {
			System.out.println(Thread.currentThread().getName()+"start********");
	}
}