package factory;

public abstract class GemueseProdukt extends Artikel {
	public GemueseProdukt(int nummer,String bezeichnung,double preis,int menge,Einheiten mengenEinheit){
		super(nummer,bezeichnung,preis,menge,mengenEinheit);
		this.kategorie="Gemuese";
	}

}
