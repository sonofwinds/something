package consumer;

import java.util.logging.Level;
import java.util.logging.Logger;
	 
	/**
	 * Java程序演示如何在Java和Java中使用notify和notifyAll方法
	  *如何通知和notifyAll方法通知线程，哪个线程被唤醒等。
	 */
	public class NotificationTest {
	 
	    private volatile boolean go = false;
	 
	    public static void main(String args[]) throws InterruptedException {
	        final NotificationTest test = new NotificationTest();
	      
	        Runnable waitTask = new Runnable(){
	      
	            @Override
	            public void run(){
	                try {
	                    test.shouldGo();
	                } catch (InterruptedException ex) {
	                    Logger.getLogger(NotificationTest.class.getName()).
	                           log(Level.SEVERE, null, ex);
	                }
	                System.out.println(Thread.currentThread() + " finished Execution");
	            }
	        };
	      
	        Runnable notifyTask = new Runnable(){
	      
	            @Override
	            public void run(){
	                test.go();
	                System.out.println(Thread.currentThread() + " finished Execution");
	            }
	        };
	      
	        Thread t1 = new Thread(waitTask, "WT1"); //will wait
	        Thread t2 = new Thread(waitTask, "WT2"); //will wait
	        Thread t3 = new Thread(waitTask, "WT3"); //will wait
	        Thread t4 = new Thread(notifyTask,"NT1"); //will notify
	      
	        //starting all waiting thread
	        t1.start();
	        t2.start();
	        t3.start();
	      
	        //pause to ensure all waiting thread started successfully
	        Thread.sleep(200);
	      
	        //starting notifying thread
	        t4.start();
	      
	    }
	    /*
	     * wait and notify can only be called from synchronized method or bock
	     */
	    private synchronized void shouldGo() throws InterruptedException {
	        while(go != true){
	            System.out.println(Thread.currentThread()
	                         + " is going to wait on this object");
	            wait(); //release lock and reacquires on wakeup
	            System.out.println(Thread.currentThread() + " is woken up");
	        }
	            
	        go = false; //resetting condition
	        Thread.sleep(5000);
	    }
	  
	    /*
	     * both shouldGo() and go() are locked on current object referenced by "this" keyword
	     */
	    private synchronized void go() {
	        while (go == false){//因为生产者没有通知消费者，所以导致消费者不断的循环拉去消息	
	            System.out.println(Thread.currentThread()
	            + " is going to notify all or one thread waiting on this object");
	 
	            go = true; //making condition true for waiting thread
	            //notify(); // only one out of three waiting thread WT1, WT2,WT3 will woke up
	            notifyAll(); // all waiting thread  WT1, WT2,WT3 will woke up
	        }
	      
	    }
	  
	}
