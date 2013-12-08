package factory;

public class TKSpinat extends TiefkuehlProdukt {

	public TKSpinat(int nummer, String bezeichnung, double preis) {
		super(nummer,bezeichnung,preis,250,Einheiten.G);
	}
	public TKSpinat(int nummer, String bezeichnung, double preis,int menge) {
		super(nummer,bezeichnung,preis,menge,Einheiten.G);
	}
	public TKSpinat(int nummer, String bezeichnung, double preis,int menge, Einheiten mengenEinheit) {
		super(nummer,bezeichnung,preis,menge,mengenEinheit);
	}
}
