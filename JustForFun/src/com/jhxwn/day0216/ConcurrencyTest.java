package com.jhxwn.day0216;

/**
 * 测试并发和串行的执行时间
 * @author zhou
 *
 */
public class ConcurrencyTest {

	private static final long count = 100000;
	public static void main(String[] args) throws InterruptedException {
		concurrency();
		serial();
	}
	/*
	 * 并发执行两个数累加。
	 */
	private static void concurrency() throws InterruptedException{
		long start = System.currentTimeMillis();
		Thread thread = new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				int a = 0;
				for (long i = 0; i < count; i++) {
					a += 5;
				}
			}
		});
		thread.start();
		int b = 0;
		for (long j = 0;j < count;j++){
			b += 1;
		}
		thread.join();
		long time = System.currentTimeMillis() - start;
		System.out.println("concurrency : " + time + "ms,b="+b);
	}
	/*
	 * 串行执行累加时间
	 */
	private static void serial(){
		long start = System.currentTimeMillis();
		int a = 0;
		for (int i = 0; i < count; i++) {
			a += 5;
		}
		int b = 0;
		for (int i = 0; i < count; i++) {
			b += 1;
		}
		long time = System.currentTimeMillis() - start;
		System.out.println("serial : " + time + "ms,b="+b);
	}
}
