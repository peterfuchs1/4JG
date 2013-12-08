package factory;

public class Spinat extends GemueseProdukt {

	public Spinat(int nummer, String bezeichnung, double preis) {
		super(nummer,bezeichnung,preis,250,Einheiten.G);
	}
	public Spinat(int nummer, String bezeichnung, double preis,int menge) {
		super(nummer,bezeichnung,preis,menge,Einheiten.G);
	}
	public Spinat(int nummer, String bezeichnung, double preis,int menge, Einheiten mengenEinheit) {
		super(nummer,bezeichnung,preis,menge,mengenEinheit);
	}
}
