package ie.tcd.AESOP.test;

import android.app.Activity;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

public class fall_detection extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i("Deug", "before oncreate");
		super.onCreate(savedInstanceState);
		EventManager mEventManager = EventManager.getInstance();
		SensorManager mSensorManager = (SensorManager) getSystemService(getApplicationContext().SENSOR_SERVICE);
		mEventManager.initMotion(mSensorManager);
		// mSensorManager.registerListener(new Acceleration(),
		// SensorManager.SENSOR_ACCELEROMETER,
		// SensorManager.SENSOR_DELAY_GAME);

		mEventManager.registerMultiEventHandler(new FallDetection());
		Log.i("DEBUG", "before create dummy");
		DummySensor dummy = new DummySensor();
		dummy.go();

		// setContentView(R.layout.main);

	}

}