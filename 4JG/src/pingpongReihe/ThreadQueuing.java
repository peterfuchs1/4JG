/**
 * 
 */
package pingpongReihe;

/**
 * @author Walter Rafeiner-Magor
 * 
 *
 */
public interface ThreadQueuing {
	/**
	 * Are we the active stoppable?
	 * Otherwise let's wait and queue!
	 * @param s a stoppable
	 */
	public void isOpen(Stoppable s);
	/**
	 * We have finished our work
	 * Next one please!
	 */
	public void finished();
	/**
	 * register for queuing
	 * @param s a stoppable
	 */
	public void register(Stoppable s);
	/**
	 * unregister from queuing
	 * @param s a stoppable
	 */
	public void unRegister(Stoppable s);
}
