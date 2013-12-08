package observer_ticketshop;

public class Konzert implements Comparable<Konzert>{
	private String name;
	private int anzahl;
	private int frei;
	/**
	 * @param name
	 * @param anzahl
	 * @param frei
	 */
	public Konzert(String name, int anzahl, int frei) {
		this.name = name;
		this.anzahl = anzahl;
		this.frei = frei;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the anzahl
	 */
	public int getAnzahl() {
		return anzahl;
	}
	/**
	 * @param anzahl the anzahl to set
	 */
	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}
	/**
	 * @return the frei
	 */
	public int getFrei() {
		return frei;
	}
	/**
	 * @param frei the frei to set
	 */
	public void setFrei(int frei) {
		this.frei = frei;
	}
	@Override
	public int compareTo(Konzert k) {
		return (this.name.compareTo(k.getName()));
	}
	
}
