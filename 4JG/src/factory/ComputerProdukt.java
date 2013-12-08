package factory;

public abstract class ComputerProdukt extends Artikel {
	public ComputerProdukt(int nummer,String bezeichnung,double preis,int menge,Einheiten mengenEinheit){
		super(nummer,bezeichnung,preis,menge,mengenEinheit);
		this.kategorie="Computerware";
	}

}
