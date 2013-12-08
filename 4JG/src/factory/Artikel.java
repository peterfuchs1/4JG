package factory;

public abstract class Artikel {

	private int nummer;
	protected String kategorie;
	private String bezeichnung;

	private double preis;

	private double gewicht;

	private int menge;

	private Einheiten mengenEinheit;

	/**
	 * @param nummer
	 * @param bezeichnung
	 * @param preis
	 * @param gewicht
	 * @param mengenEinheit
	 * @param menge
	 */
	public Artikel(int nummer, String bezeichnung, double preis,
			double gewicht, Einheiten mengenEinheit, int menge) {
		this.nummer = nummer;
		this.bezeichnung = bezeichnung;
		this.preis = preis;
		this.gewicht = gewicht;
		this.setMengenEinheit(mengenEinheit);
		this.menge = menge;
		this.kategorie="kein Produkt";
	}

	/**
	 * @param nummer
	 * @param bezeichnung
	 * @param preis
	 * @param gewicht
	 * @param mengenEinheit
	 */
	public Artikel(int nummer, String bezeichnung, double preis,
			double gewicht, Einheiten mengenEinheit) {
		this(nummer,bezeichnung,preis,gewicht,mengenEinheit,1);
	}

	/**
	 * @param nummer
	 * @param bezeichnung
	 * @param preis
	 * @param gewicht
	 */
	public Artikel(int nummer, String bezeichnung, double preis, double gewicht) {
		this(nummer,bezeichnung, preis,gewicht,Einheiten.STK,1);
	}

	/**
	 * @return the mengenEinheit
	 */
	public String getMengenEinheit() {
		return mengenEinheit.getCode();
	}

	/**
	 * @param mengenEinheit the mengenEinheit to set
	 */
	public void setMengenEinheit(Einheiten mengenEinheit) {
		this.mengenEinheit = mengenEinheit;
	}

	/**
	 * @return the nummer
	 */
	public int getNummer() {
		return nummer;
	}

	/**
	 * @param nummer the nummer to set
	 */
	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	/**
	 * @return the bezeichnung
	 */
	public String getBezeichnung() {
		return bezeichnung;
	}

	/**
	 * @param bezeichnung the bezeichnung to set
	 */
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	/**
	 * @return the preis
	 */
	public double getPreis() {
		return preis;
	}

	/**
	 * @param preis the preis to set
	 */
	public void setPreis(double preis) {
		this.preis = preis;
	}

	/**
	 * @return the gewicht
	 */
	public double getGewicht() {
		return gewicht;
	}

	/**
	 * @param gewicht the gewicht to set
	 */
	public void setGewicht(double gewicht) {
		this.gewicht = gewicht;
	}

	/**
	 * @return the menge
	 */
	public int getMenge() {
		return menge;
	}

	/**
	 * @param menge the menge to set
	 */
	public void setMenge(int menge) {
		this.menge = menge;
	}


}
