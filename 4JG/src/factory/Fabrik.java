package factory;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class Fabrik {

	private boolean bezahlt;

	private boolean verpackt;

	private boolean verschickt;
	protected String fabArt;
	private List<Artikel> einkaufsWagen;

	/**
	 * Konstruktor
	 */
	public Fabrik() {
		einkaufsWagen=new LinkedList<Artikel>();
		bezahlt=false;
		verpackt=false;
		verschickt=false;
		fabArt="";
	}
	/**
	 * kein Produkt erzeugt
	 * @param produkt
	 * @return
	 */
	public static  Artikel erzeuge(String produkt) {return null;}
	/**
	 * Produkt in den Einkaufswagen
	 * @param produkt
	 */
	public void add(Artikel produkt){
		einkaufsWagen.add(produkt);
	}
	/**
	 * Produkte bezahlt
	 */
	public void bezahlen() {
		bezahlt=true;
	}
	/**
	 * Produkte verpackt
	 */
	public void verpacken() {
		verpackt=true;
	}
	/**
	 * Produkte verschickt
	 */
	public void verschicken() {
		verschickt=true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		int size=einkaufsWagen.size();
		sb.append("Der Einkaufswagen enthaelt ").append(fabArt).append(": ").append(size).append("\n");
		if(size>0){
			Iterator<Artikel> iter=einkaufsWagen.iterator();
			double kosten=0.0;
			while(iter.hasNext()){
				Artikel a=iter.next();
				kosten+=a.getPreis();
				sb.append(a.getKategorie()).append(": ").append(a.getNummer());
				sb.append(", ").append(a.getMenge()).append(a.getMengenEinheit());
				sb.append(" ").append(a.getBezeichnung());
				sb.append(", Preis: ").append(a.getPreis());
				sb.append("\n");
			}
			sb.append("Gesamtkosten: ").append(kosten).append("\n");
			sb.append("Die Produkte wurden ");
			if(!bezahlt)
				sb.append("noch nicht ");
			sb.append("bezahlt.\n");
			sb.append("Die Produkte wurden ");
			if(!verpackt)
				sb.append("noch nicht ");
			sb.append("verpackt.\n");
			sb.append("Die Produkte wurden ");
			if(!verschickt)
				sb.append("noch nicht ");
			sb.append("verschickt.\n");
		}
		return sb.toString();
	}
	
}
