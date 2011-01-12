package ie.tcd.AESOP.test;

import android.app.Activity;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class gesture extends Activity {

	String TAG = "gesture";
	public TextView text, alert, text3;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.main);
		EventManager mEventManager = EventManager.getInstance();
		SensorManager mSensorManager = (SensorManager) getSystemService(getApplicationContext().SENSOR_SERVICE);
		mEventManager.initMotion(mSensorManager);
		/**
		 * mSensorManager.registerListener(new YesNoMotion(),
		 * SensorManager.SENSOR_ACCELEROMETER, SensorManager.SENSOR_DELAY_GAME);
		 * mSensorManager.registerListener(new InUsersHand(),
		 * SensorManager.SENSOR_ORIENTATION, SensorManager.SENSOR_DELAY_GAME);
		 * //YesOrNoMEH composes the two motions
		 * mEventManager.registerMultiEventHandler(new YesOrNoMEH());
		 * mEventManager.registerEventListener( new
		 * Event(YesOrNoMEH.output_type), handler);
		 **/
	}

	/**
	 * This listener is how the main application gets an event representing a
	 * new motion
	 */
	private final EventListener handler = new EventListener() {
		public void onEvent(Event g) {
			Log.i(TAG, g.getContent());
			// e.print();
		}
	};
}