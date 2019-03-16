package thread;

import java.util.concurrent.CyclicBarrier;
/**
 * 一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行或者回调一个线程继续执行其他任务
 * @author 晨
 *
 */
public class CyclicBarrierTest {

	public static void main(String[] args) {
		int barrierNum = 5;
		CyclicBarrier cyclicBarrier = new CyclicBarrier(barrierNum,new Runnable() {
			
			@Override
			public void run() {
				 System.out.println("所有线程已经全部执行完毕，开始我登场了");
			}
		});
		MyBarrierRunnable myBarrierRunnable = new MyBarrierRunnable(cyclicBarrier);
		for(int i = 0 ;i < barrierNum ;i++) {
			new Thread(myBarrierRunnable).start();;
		}
	}

}
class MyBarrierRunnable implements Runnable{
	CyclicBarrier barrier;
	public MyBarrierRunnable(CyclicBarrier barrier) {
		this.barrier = barrier;
	}
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " 正在执行...");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + "|所有线程已经全部执行结束，开始继续执行");
			barrier.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}