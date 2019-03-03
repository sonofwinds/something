package consumer;

import java.util.concurrent.LinkedBlockingQueue;

public class ResourceStorge {
private static LinkedBlockingQueue<Resource> quene = new LinkedBlockingQueue<Resource>(10);
public  static void push(Resource resource,Thread thread) {
	synchronized(quene) {
			while(quene.size()==10) {//仓库已满
				try {
					System.out.println(resource.getName()+" ResourceStorge is full and wait cosummer");
					quene.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		quene.add(resource);
		System.out.println("push "+resource.toString());
		quene.notifyAll();
	}
}
public static void pop(Thread thread) {
	synchronized(quene) {
		while(quene.size()==0) {
			System.out.println("ResourceStorge is null and nofity producer");
			try {
				quene.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			Resource resource = quene.poll();
			System.out.println("pop "+resource.toString());
		    quene.notifyAll();
	}
}
}
