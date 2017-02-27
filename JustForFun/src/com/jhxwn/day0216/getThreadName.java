package com.jhxwn.day0216;

/**
 * 获取执行线程的名字
 * @author zhou
 *
 */
public class getThreadName {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		Thread thread = new Thread("现场1");
		System.out.println(thread.getName());
		for (int i = 0; i < 10; i++) {
			new Thread(" "+i){
				public void run(){
					System.out.println("current "+getName()+" is running");
				}
			}.start();
		}
	}
}



