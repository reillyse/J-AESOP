package ie.tcd.AESOP.test;

import android.util.Log;

public class FallDetection extends MultiEventHandler {

	EventStream s1;
	EventStream s2;
	EventStream s3;
	EventManager manager = EventManager.getInstance();
	double threshold = 1;
	MathVector upright_accel_vector;
	AccelerationVector acc;
	AccelerationVector acc2;

	public FallDetection() {
		Event e1 = new Event("ACCEL_HIP");
		Event e2 = new Event("ACCEL_ANKLE");
		Event e3 = new Event("ACCEL_WRIST");
		s1 = new EventStream(10, e1.type, this);
		s2 = new EventStream(10, e2.type, this);
		s3 = new EventStream(10, e3.type, this);
		upright_accel_vector = new MathVector(0, -9.8, 0);
		acc = new AccelerationVector(0, 0, 0);
		acc2 = new AccelerationVector(0, 0, 0);

	}

	@Override
	public boolean executionPolicy() {
		/*
		 * if(!s1.isReady()){ return false; } Iterator<Event> acceleration_1 =
		 * s1.getWindow().iterator();
		 * acc.fromString(acceleration_1.next().content); if
		 * (MathVector.angleBetween(new MathVector(acc.x,acc.y,acc.z),
		 * upright_accel_vector) > threshold) { if (acceleration_1.hasNext()){
		 * acc2.fromString(acceleration_1.next().content); if(
		 * MathVector.angleBetween(acc2.toMathVector(),upright_accel_vector) <
		 * threshold) { Log.i("Change in Posture","in EP"); return true; //
		 * posture has changed from vertical to horizontal } } }
		 */

		return false; // no change in posture

	}

	@Override
	public void handler() {
		/*
		 * Iterator<Event> acceleration_1 = s1.getWindow().iterator();
		 * Iterator<Event> acceleration_2 = s2.getWindow().iterator();
		 * Iterator<Event> acceleration_3 = s3.getWindow().iterator();
		 * 
		 * 
		 * while (acceleration_1.hasNext()) { if (vectorMagnitude(new
		 * AccelerationVector(acceleration_1.next().content).toMathVector()) >
		 * 20) { call_ambulance(); return; } } while (acceleration_2.hasNext())
		 * { if (vectorMagnitude(new
		 * AccelerationVector(acceleration_2.next().content).toMathVector()) >
		 * 20) { call_ambulance(); return; } } while (acceleration_3.hasNext())
		 * { if (vectorMagnitude(new
		 * AccelerationVector(acceleration_3.next().content).toMathVector()) >
		 * 20) { call_ambulance(); return; } }
		 */
	}

	private void call_ambulance() {
		Log.i("FALL DETECTION", "CALL AMBULANCE");
	}

	static double vectorMagnitude(MathVector vec) {

		// double result =
		return Math.sqrt(vec.x * vec.x + vec.y * vec.y + vec.z * vec.z);
		// if(result > 20){Log.i("Vector Math", "magnitude of vector is " +
		// result);}
		// return result;

	}

}
