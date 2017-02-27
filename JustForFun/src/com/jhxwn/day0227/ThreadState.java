package com.jhxwn.day0227;

import java.util.concurrent.TimeUnit;

/**
 * 线程状态查看
 * @author zhou
 *
 */
public class ThreadState {

	public static void main(String[] args) {
		new Thread(new TimeWaiting(),"TimeWaitingThread").start();
		new Thread(new Waiting(),"WaitingThread ").start();
		// 使用两个Blocked线程，一个获取锁成功，一个被阻塞
		new Thread(new Blocked(),"BlockedThread-1 ").start();
		new Thread(new Blocked(),"BlockedThread-2 ").start();
	}
	// 该线程不断的进行睡眠
	public static class TimeWaiting implements Runnable {

		public void run() {
			// TODO Auto-generated method stub
			while(true){
				try {
					TimeUnit.SECONDS.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	// 该线程在Waiting.class实例上等待
	public static class Waiting implements Runnable {
		public void run(){
			while(true){
				synchronized (Waiting.class) {
					try {
						Waiting.class.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	// 该线程在Blocked.class实例上加锁后，不会释放该锁
	public static class Blocked implements Runnable {
		public void run(){
			while(true){
				synchronized (Blocked.class) {
					//SleepUtils.second((long)100);
					try {
						TimeUnit.SECONDS.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
