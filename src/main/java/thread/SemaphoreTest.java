package thread;

import java.util.concurrent.Semaphore;
/**
 * Semaphore其实和锁有点类似，它一般用于控制对某组资源的访问权限
 * @author 晨
 *
 */
public class SemaphoreTest {

	public static void main(String[] args) {
		int N = 8;
		Semaphore semaphore = new Semaphore(5);
		MySemaphoreRunnable mySemaphoreRunnable = new MySemaphoreRunnable(semaphore);
		for (int i = 0; i < N; i++) {
			new Thread(mySemaphoreRunnable).start();
		}

	}
}
class MySemaphoreRunnable implements Runnable {
	Semaphore semaphore;
	
	public MySemaphoreRunnable(Semaphore semaphore) {
		this.semaphore = semaphore;
	}
	
	@Override
	public void run() {
		try {
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName() + "拿到许可，正在执行...");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + "|执行结束，释放许可");
			semaphore.release();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}