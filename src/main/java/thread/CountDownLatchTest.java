package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/**
 * 适用于一个任务需要等待另外一个或者另外一组任务执行完成之后才能继续执行的场景
 * @author 晨
 *
 */
public class CountDownLatchTest {

	public static void main(String[] args) {
		int waitTaskNum = 5;
		CountDownLatch latch = new CountDownLatch(waitTaskNum);
		MyRunnable myRunnable = new MyRunnable(latch);
		for(int i=0;i<waitTaskNum;i++) {
			new Thread(myRunnable).start();
		}
		try {
			System.out.println("等待其他任务结束");
			boolean flag = latch.await(5,TimeUnit.SECONDS);//用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
			System.out.println("其他任务结束,开始干活" + flag);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
class MyRunnable implements Runnable{
	CountDownLatch latch;
	public MyRunnable(CountDownLatch latch) {
		this.latch = latch;
	}
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " 正在执行...");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + "|执行完成，正等待其他线程执行完毕.....");
			latch.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
