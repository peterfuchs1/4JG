/**
 * 
 */
package pingpongReihe;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author uhs374h
 *
 */
public class ThreadQueue implements ThreadQueuing {
	private ConcurrentLinkedQueue<Stoppable> q;
	private Iterator<Stoppable> iter;
	private Stoppable actualElement;

	/*
	 * (non-Javadoc)
	 * 
	 * @see pingpongReihe.ThreadQueuing#open(pingpongReihe.Stoppable)
	 */
	@Override
	public synchronized void isOpen(Stoppable s) {
		while (s != actualElement)
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
		actualElement = nextElement();
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
			iter = q.iterator();
			actualElement = nextElement();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pingpongReihe.ThreadQueuing#unRegister(pingpongReihe.Stoppable)
	 */
	public void unRegister(Stoppable s) {
		q.remove(s);
		iter = q.iterator();
		actualElement = nextElement();
	}

	/**
	 * who is next If we have reached the tail, let us start from the head
	 * again!
	 * 
	 * @return the next stoppable or null
	 */
	private Stoppable nextElement() {
		Stoppable ret = null;
		if (!q.isEmpty()) {
			if (!iter.hasNext()) {
				iter = q.iterator();
			}
			ret = iter.next();
		}
		return ret;
	}

}
