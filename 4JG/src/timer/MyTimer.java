/**
 * 
 */
package timer;

import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author uhs374h
 *
 */
public class MyTimer implements IObservable {
	private TimerTask tt;
	private Timer t;
	private long status;
	private ConcurrentLinkedQueue<IObserver> observers;

	/**
	 * 
	 */
	public MyTimer() {
		tt = new MyTimerTask();
		observers = new ConcurrentLinkedQueue<>();
		t = new Timer();
		t.schedule(tt, 1000,1000);

	}

	private void update() {
		notifyObservers(status);
	}

	@Override
	public void addObserver(IObserver s) {
		observers.add(s);

	}

	@Override
	public void removeObserver(IObserver s) {
		Iterator<IObserver> it=observers.iterator();
		while (it.hasNext()){
			IObserver o=it.next();
			if (o == s)
				it.remove();
		}

	}

	@Override
	public void notifyObservers() {
		for (IObserver o : observers)
			o.update(this, null);

	}

	@Override
	public void notifyObservers(Object o) {
		for (IObserver ob : observers)
			ob.update(this, o);

	}

	private class MyTimerTask extends TimerTask {
		@Override
		public void run() {
			status = java.time.LocalTime.now().toSecondOfDay();
			update();

		}

	}
}
