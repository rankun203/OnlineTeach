package com.teachMng.onlineTeach.util;

/**
 * 计时器
 * @author mindfine
 */
public class Timer {

	long start;
	long last;
	/**
	 * 构造方法，用当前系统时间初始化一个计时器
	 */
	public Timer(){
		start = System.currentTimeMillis();
		last = start;
	}
	/**
	 * 获取当前时间距上一次调用round()方法以来的时间，如果没有调用过此方法，则获取到当前时间距初始化计时器经过的时间
	 * @return 一个long类型的数，以毫秒计的时间。
	 */
	public long round(){
		long round = System.currentTimeMillis() - last;
		last = System.currentTimeMillis();
		return round;
	}
	/**
	 * 获取到当前时间距初始化计时器经过的时间
	 * @return 一个long类型的数，以毫秒计的时间
	 */
	public long total(){
		return System.currentTimeMillis() - start;
	}
	/**
	 * 用当前时间重置该计时器
	 */
	public void reset(){
		start = System.currentTimeMillis();
		last = start;
	}
}
