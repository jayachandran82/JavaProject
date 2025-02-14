package thread;

public class PreventRaceConditions implements Runnable {
	private int inventory = 1;
	long twoSeconds = 3000;

	public static void main(String[] args) {
		PreventRaceConditions prc = new PreventRaceConditions();
		Thread firstThread = new Thread(prc, "First thread");
		Thread secondThread = new Thread(prc, "Second thread");
		firstThread.start();
		secondThread.start();
	}

	public void run() {
	
		if (inventory > 0) {
			try {
				System.out.println(
						"Thread " + Thread.currentThread().getName() + " starting with inventory: " + inventory);
				Thread.sleep(twoSeconds);
			} catch (InterruptedException e) {
				System.out.println(" InterruptedException :::" + e);
			}
			inventory--;
			System.out.println("Thread " + Thread.currentThread().getName() + " leaving with inventory: " + inventory);
		} else {
			System.out.println("Need to backorder! Thread " + Thread.currentThread().getName()
					+ " found inventory with: " + inventory);
		}
	}
}