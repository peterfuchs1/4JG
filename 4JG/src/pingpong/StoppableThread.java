/**
 * 
 */
package pingpong;

/**
 * @author uhs374h
 *
 */
public abstract class StoppableThread extends Thread implements Stoppable,Comparable<StoppableThread> {
	private long dauer;
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(StoppableThread o) {
		return (int)(this.dauer-o.getDauer());
	}
	
	/**
	 * @return the dauer
	 */
	public long getDauer() {
		return dauer;
	}

	/**
	 * @param dauer the dauer to set
	 */
	public void setDauer(long dauer) {
		this.dauer = dauer;
	}

	/**
	 * @param dauer
	 */
	public StoppableThread(long dauer) {
		this.dauer = dauer;
	}
	

}
