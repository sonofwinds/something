package threadPool.exception;

import java.lang.Thread.UncaughtExceptionHandler;

public class MyExceptionHandler implements UncaughtExceptionHandler {

	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("exception happends "+t.getName()+"自定义异常发生");

	}

}
