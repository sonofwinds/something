package consumer;

public class Producer implements Runnable {

	public void run() {
		int index=1;
		while(true) {
//			if(index%5==0) {
//				for(int i=0;i<5;i++) {
//					ResourceStorge.push(resource);
//				}
//			}else {
//			}
			Resource resource = new Resource();
			resource.setName(Thread.currentThread().getName());
			resource.setAge(index);
			ResourceStorge.push(resource,Thread.currentThread());
			index++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
