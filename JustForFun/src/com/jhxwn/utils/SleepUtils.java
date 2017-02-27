package com.jhxwn.utils;

import java.util.concurrent.TimeUnit;
/**
 * 线程sleep的方法
 * 注意区分Thread.sleep()函数
 * @author zhou
 *
 */
public class SleepUtils {

	public static final void second(long seconds){
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
