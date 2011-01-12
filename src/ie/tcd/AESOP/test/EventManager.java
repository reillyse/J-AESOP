package ie.tcd.AESOP.test;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.util.Log;

/*
 *  How to use this class
 *  
 *  Implement SensorListener in the style of CastOut.java which creates a new Event when something happens on the sensors
 *  use the addOrientationListener style helper methods to add this to the sensor manager
 *  
 *  
 *  EventManager uses the singleton pattern to make sure only one instance of the class is present at any one time
 *  don't call a constructor use. This is important as we always want to be registering and sending Event events to the one
 *  class.
 *  
 *  EventManager.getInstance()
 *  
 *  EventManager uses Events
 *  whenever we want to tell the EventManager about a Event we call 
 *  
 *  mEventManager.EventOccured(m);
 * 	
 * We register Events with the EventManager using the registerEvent method
 * Whenever a Event which matches the type occurs we call the handler for that Event 
 * 
 * Whenever we want to register a MultiEventHandler we call the registerMultiEventHandler method
 * 
 */

public class EventManager {

	private static EventManager instance;

	String TAG = "EventManager";
	Hashtable<String, Vector<EventListener>> hashtable;
	Vector<MultiEventHandler> mehList;

	private EventManager() {
		hashtable = new Hashtable<String, Vector<EventListener>>();
		mehList = new Vector<MultiEventHandler>();
	}

	public static EventManager getInstance() {
		if (instance != null) {
			return instance;
		} else
			instance = new EventManager();
		return instance;
	}

	public boolean registerMultiEventHandler(MultiEventHandler meh) {
		if (mehList.add(meh)) {
			Log.d(TAG, "Multi Event Handler Registered");
			return true;
		} else {
			Log.e(TAG, "Could not register multi event handler");
			return false;
		}
	}

	public boolean registerEventListener(Event m, EventListener listener) {
		Vector<EventListener> list;
		list = hashtable.get(m.type);
		/*
		 * If we have no entry in our hash table for the Event in question add
		 * a new one
		 */
		if (list == null) {
			list = new Vector<EventListener>();
			hashtable.put(m.type, list);
		}

		if (list.add(listener)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean initEvent(SensorManager mSensorManager) {
		/**
		 * mSensorManager.registerListener(new StockOrientation(),
		 * SensorManager.SENSOR_ORIENTATION, SensorManager.SENSOR_DELAY_GAME);
		 * mSensorManager.registerListener(new StockAccel(),
		 * SensorManager.SENSOR_ACCELEROMETER, SensorManager.SENSOR_DELAY_GAME);
		 * mSensorManager.registerListener(new CastOut(),
		 * SensorManager.SENSOR_ACCELEROMETER, SensorManager.SENSOR_DELAY_GAME);
		 **/

		return true;
	}

	public boolean addListener(SensorManager mSensorManager,
			SensorListener listener, int sensor_type, int delay_rate) {
		return mSensorManager.registerListener(listener, sensor_type,
				delay_rate);
	}

	public boolean addOrientationListener(SensorManager mSensorManager,
			SensorListener listener, Event m) {
		EventManager Event_manager = EventManager.getInstance();
		return addListener(mSensorManager, listener,
				SensorManager.SENSOR_ORIENTATION,
				SensorManager.SENSOR_DELAY_GAME);

	}

	public boolean addAccelerometerListener(SensorManager mSensorManager,
			SensorListener listener, Event m) {
		EventManager Event_manager = EventManager.getInstance();
		return addListener(mSensorManager, listener,
				SensorManager.SENSOR_ACCELEROMETER,
				SensorManager.SENSOR_DELAY_GAME);

	}

	public void removeListener(SensorManager mSensorManager,
			SensorListener listener) {
		mSensorManager.unregisterListener(listener);
	}

	public boolean unRegisterEventListener(Event m, EventListener listener) {

		Vector<EventListener> list = hashtable
				.get(m.type);
		if (list == null) {
			Log.e(TAG, "No such listener registered");
			return false;
		}
		Iterator<EventListener> i = list.iterator();
		while (i.hasNext()) {
			if (i.next() == listener) {
				if (list.remove(listener)) {
					Log.d(TAG, "listener removed");
					// if(list.size() == 0){ //no listeners registered kill off
					// everything
					// Log.d(TAG,"listener removed");
					// instance = null;
					// }
					return true;
				} else {
					Log.e(TAG, "Could not remove listener");
					return false;
				}
			}
		}
		return false;

	}

	/*
	 * The Sensor Listener knows what Event it is firing. The developer has
	 * already registered their listener with the EventManager. Therefore as
	 * soon as the sensors know a Event has occurred they trigger the
	 * EventManager to call all the callbacks for that Event.
	 */

	/*
	 * Store the vectors in a hash table with the type of the event as the key
	 */
	public void eventOccured(Event m) {
		Vector<EventListener> list = hashtable
				.get(m.type);
		if (list != null) {
			Iterator<EventListener> i = list.iterator();
			while (i.hasNext()) {
				(i.next()).onEvent(m);
			}
		}
		/*
		 * if(mehList != null){ Iterator<MultiEventHandler> i =
		 * mehList.iterator(); while(i.hasNext()){ MultiEventHandler meh =
		 * (MultiEventHandler)i.next(); if((meh.has_Event(m) &&
		 * meh.executionPolicy())){ meh.handler(); } }
		 * 
		 * 
		 * }
		 */
	}

}
