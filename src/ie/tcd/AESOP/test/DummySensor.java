package ie.tcd.AESOP.test;

import android.util.Log;

public class DummySensor implements Runnable {

	EventManager manager;

	public DummySensor() {
		manager = EventManager.getInstance();

	}

	@Override
	public void run() {
		int count = 0;
		Event m = new Event("ACCEL_HIP", new AccelerationVector(10, 1, -9)
				.toString());
		Event m2 = new Event("ACCEL_WRIST", new AccelerationVector(-1, 10, -3)
				.toString());
		Event m3 = new Event("ACCEL_ANKLE", new AccelerationVector(-4, 8, 2)
				.toString());
		while (true) {

			manager.eventOccured(m);

			manager.eventOccured(m2);

			manager.eventOccured(m3);
			count++;
			if (count % 10 == 0) {
				Log.i("eventcount", count + "");
			}
			try {
				Thread.sleep(100, 0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Log.i("shit", "Thread interrupted");
				e.printStackTrace();
			}

		}
	}

	void go() {
		Log.i("GO", "goooooo");
		Thread thread = new Thread(this);
		thread.start();
	}
}
