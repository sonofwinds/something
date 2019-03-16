package threadlocal;

import pojo.User;

public class TestThreadLocal {
private static ThreadLocal<User> context = new ThreadLocal<User>();
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				User u = new User();
				u.setAge(1);
				context.set(u);
				
			}
		}).start();;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   new Thread(new Runnable() {
			
			@Override
			public void run() {
				User u = new User();
				u.setAge(1);
				context.set(u);
				
			}
		}).start();;
	}

}
