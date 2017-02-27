package com.jhxwn.day0216;

/**
 * 死锁代码演示
 * @author zhou
 *
 */
public class DeadLockedDemo {

	private static String A = "A";
	private static String B = "B";
	public static void main(String[] args) {
		new DeadLockedDemo().deadLock();
	}
	private void deadLock(){
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				synchronized (A) {
					try {
						Thread.currentThread().sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (B) {
						System.out.println("1");
					}
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				synchronized (B) {
					synchronized (A) {
						System.out.println("2");
					}
				}
			}
		});
		t1.start();
		t2.start();
	}
}
