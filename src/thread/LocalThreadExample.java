package thread;

import java.util.concurrent.atomic.AtomicInteger;

class ThreadLocalDemo implements Runnable {
	private static final AtomicInteger automicVal = new AtomicInteger(0);
	private static final ThreadLocal<Integer> localThread = ThreadLocal.withInitial(() -> automicVal.getAndIncrement());

	@Override
	public void run() {
		System.out.println("Thread :  " + Thread.currentThread().getName() + " Value : " + localThread.get());
	}
}

public class LocalThreadExample {

	public static void main(String[] args) {
		ThreadLocalDemo demo = new ThreadLocalDemo();
		Thread t1 = new Thread(demo, "Thread One");
		Thread t2 = new Thread(demo, "Thread Two");
		Thread t3 = new Thread(demo, "Thread Three");
		t1.start();
		t2.start();
		t3.start();
	}
}
