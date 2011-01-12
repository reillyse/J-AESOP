package ie.tcd.AESOP.test;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import android.util.Log;

public class EventStream {
	private MultiEventHandler parent;
	private final boolean READY = true;
	private final boolean NOT_READY = false;
	private String TAG = "EventStream";
	private LinkedList<Event> list;
	private String motion_name;
	private int max_length;
	private boolean status;

	public EventStream(int length, String event_name, MultiEventHandler parent) {
		this.motion_name = event_name;
		list = new LinkedList<Event>();
		max_length = length;
		status = NOT_READY;
		EventManager m = EventManager.getInstance();
		m
				.registerEventListener(new Event(event_name, ""),
						mEventStreamListener);
		this.parent = parent;
	}

	private final EventListener mEventStreamListener = new EventListener() {
		public void onEvent(Event g) {
			// Log.i(TAG,g.name + " gesture received");
			add(g);
		}
	};

	public boolean add(Event m) {
		if (!m.type.equals(motion_name)) {
			Log.e(TAG, "Wrong type of motion provided to event stream");
			return false;
		}

		list.addFirst(m);
		status = READY;
		if (list.size() > max_length) {
			list.removeLast();
		}
		if (parent.executionPolicy()) {
			parent.handler();
		}
		return true;
	}

	public boolean isReady() {
		return status;
	}

	/*
	 * Only to be called after we know an event stream is ready
	 */
	public Date latestTimestamp() {
		return list.getFirst().timestamp;

	}

	public synchronized Event getLatest() {

		return list.getFirst();

	}

	/*
	 * debugging method
	 */
	public void print() {
		Log.d(TAG, "status = " + status);
		Iterator<Event> i = list.iterator();
		while (i.hasNext()) {
			Log.d(TAG, (i.next()).to_string());
		}
		Log.d(TAG, "print finished");
	}

	public LinkedList<Event> getWindow() {
		return list;
	}

	public void notReady() {
		// TODO Auto-generated method stub
		status = NOT_READY;
	}
}
