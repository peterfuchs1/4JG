package factory;

public abstract class TiefkuehlProdukt extends Artikel {
	public TiefkuehlProdukt(int nummer,String bezeichnung,double preis,int menge,Einheiten mengenEinheit){
		super(nummer,bezeichnung,preis,menge,mengenEinheit);
		this.kategorie="Tiefkuehlware";
	}

}
