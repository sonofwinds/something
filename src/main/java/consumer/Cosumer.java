package consumer;

public class Cosumer implements Runnable {

	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ResourceStorge.pop(Thread.currentThread());
		}

	}

}
