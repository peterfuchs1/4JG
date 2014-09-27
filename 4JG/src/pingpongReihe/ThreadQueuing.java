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
	 * Let's wait and queue!
	 * @param s a stoppable
	 */
	public void open(Stoppable s);
	/**
	 * We have finished our work
	 * Next one please!
	 */
	public void ready();
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
