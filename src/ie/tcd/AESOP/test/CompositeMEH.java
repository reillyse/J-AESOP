package ie.tcd.AESOP.test;

import java.util.Date;

public class CompositeMEH extends MultiEventHandler {

	/*
	 * two streams Stream one is occurring before stream 2
	 */
	EventStream s1;
	EventStream s2;
	String TAG = "CompositeMEH";
	EventManager mmanager = EventManager.getInstance();

	public CompositeMEH() {
		Event m1 = new Event("VERTICAL", "");
		Event m2 = new Event("STILL", "");
		s1 = new EventStream(10, m1.type, this);
		s2 = new EventStream(10, m2.type, this);
	}

	@Override
	public boolean executionPolicy() {
		if (s1.isReady() && s2.isReady()
				&& s1.latestTimestamp().before(s2.latestTimestamp())) {
			return true;
		}
		return false;
	}

	@Override
	public void handler() {
		// Log.d(TAG,"Handler fired");
		Date motion1 = s1.getLatest().timestamp;
		Date motion2 = s2.getLatest().timestamp;
		s1.notReady();
		s2.notReady();
		// Log.d(TAG, "motion1 = " + motion1);
		// Log.d(TAG, "motion2 = " + motion2);
		if ((Math.abs(motion1.getSeconds() - motion2.getSeconds()) < 1)) {
			Event m = new Event("PHONE_VERTICAL_STILL",
					"Created by combining two motions");
			// Log.i(TAG,"Composite Event Occurred ");
			mmanager.eventOccured(m);
		}
	}

}
