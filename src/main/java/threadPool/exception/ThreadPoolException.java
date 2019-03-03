package threadPool.exception;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolException {

	public static void main(String[] args) {
		submitThread();
//		System.exit(-1);
	}
	public static void executeThread() {
		Thread.setDefaultUncaughtExceptionHandler(new MyExceptionHandler());
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 2, 1000, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>(), new MyThreadFactory());
		pool.execute(new MyRunable());
		pool.execute(new MyRunable());
		System.out.println("****");
	}
	public static void submitThread(){
		Thread.setDefaultUncaughtExceptionHandler(new MyExceptionHandler());
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 2, 1000, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>(), new MyThreadFactory());
		Future<?> t1 = pool.submit(new MyRunable());
		Future<String> t2 = pool.submit(new MyCall());
		try {
			Object d = t1.get();//当通过future调用时，才能拿到异常和返回值
			System.out.println(d);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}

class MyRunable implements Runnable {

	public void run() {
		System.out.println("MyRunable---------------");
		throw new RuntimeException("线程池抛出异常------");
	}
}
class MyCall implements Callable<String>{
	public String call() throws Exception {
		System.out.println("MyCall---------------");
		return "自定义线程池返回值";
	}
	
}
class MyThreadFactory implements ThreadFactory {

	public Thread newThread(Runnable r) {
		Thread t = new Thread(r, "factory");
		return t;
	}

}