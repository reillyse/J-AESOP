package ie.tcd.AESOP.test;

import android.hardware.SensorListener;
import android.util.Log;

public class Acceleration implements SensorListener {
	int count;
	EventManager manager;

	Acceleration() {
		count = 0;
		manager = EventManager.getInstance();

	}

	@Override
	public void onAccuracyChanged(int sensor, int accuracy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSensorChanged(int sensor, float[] values) {
		count++;

		Event m = new Event("ACCEL_HIP", new AccelerationVector(values[0],
				values[1], values[2]).toString());
		manager.eventOccured(m);
		Event m2 = new Event("ACCEL_WRIST", new AccelerationVector(values[0],
				values[1], values[2]).toString());
		manager.eventOccured(m2);
		Event m3 = new Event("ACCEL_SHOE", new AccelerationVector(values[0],
				values[1], values[2]).toString());
		manager.eventOccured(m3);
		if (count % 100 == 0) {
			Log.i("eventcount", count + "");
		}
	}

}
