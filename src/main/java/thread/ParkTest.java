package thread;

import java.util.concurrent.locks.LockSupport;

public class ParkTest {

	public static void main(String[] args) {
         try {
        	 Thread t1 = new Thread(new Runnable() {
        		 @Override
        		 public void run() {
        			 System.out.println("开始阻塞线程");
      			     LockSupport.park();//阻塞线程
        			 System.out.println("阻塞释放");
        		 }
        	 });
        	t1.start();
			Thread.sleep(1000l);
			LockSupport.unpark(t1);//解除通过park阻塞的线程
			//线程打断，线程打断时会解除阻塞（sleep,wait,join,park等),但不会打断运行中的线程，只会添加一个是否打断的标识
			t1.interrupt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
