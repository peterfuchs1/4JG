/**
 * 
 */
package pingpongReihe;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * ThreadQueue mit festgelegter Reihenfolge
 * 
 * @author Walter Rafeiner-Magor
 * @version 1.1
 *
 */
public class ThreadQueue implements ThreadQueuing {
	private ConcurrentLinkedQueue<Stoppable> q; // the queue
	private Iterator<Stoppable> iter;			// iterator 
	private Stoppable expectedElement;			// expected Thread 

	/*
	 * (non-Javadoc)
	 * 
	 * @see pingpongReihe.ThreadQueuing#open(pingpongReihe.Stoppable)
	 */
	@Override
	public synchronized void isOpen(Stoppable s) {
		// The wrong thread has to wait!
		while (s != expectedElement)
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pingpongReihe.ThreadQueuing#ready()
	 */
	@Override
	public synchronized void finished() {
		// After work go to the next element
		this.expectedElement = nextElement();
		// inform all threads
		this.notifyAll();
	}

	/**
	 * standard construct creates a new queue
	 */
	public ThreadQueue() {
		q = new ConcurrentLinkedQueue<Stoppable>();
	}

	/**
	 * does the queue contain the given stoppable?
	 * 
	 * @param s
	 *            a stoppable
	 * @return true or false
	 */
	private boolean isRegistered(Stoppable s) {
		return q.contains(s);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pingpongReihe.ThreadQueuing#register(pingpongReihe.Stoppable)
	 */
	public void register(Stoppable s) {
		// We should register uniquely
		if (!this.isRegistered(s)) {
			q.add(s);
			resetQueue();
		}
	}
	/**
	 * in case of queue change, reset the queue 
	 */
	private void resetQueue(){
		// create a new iterator
		this.iter = q.iterator();
		// go forward to the next element
		this.expectedElement = nextElement();
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see pingpongReihe.ThreadQueuing#unRegister(pingpongReihe.Stoppable)
	 */
	public void unRegister(Stoppable s) {
		q.remove(s);
		resetQueue();
	}

	/**
	 * who is next? 
	 * if we have reached the tail, 
	 * let us start from the head again!
	 * 
	 * @return the next stoppable or null
	 */
	private Stoppable nextElement() {
		Stoppable ret = null;
		if (!q.isEmpty()) {
			if (!iter.hasNext()) 
				iter = q.iterator();
			ret = iter.next();
		}
		return ret;
	}

}
