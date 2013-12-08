package factory;

public class Maronireis extends TiefkuehlProdukt {

	public Maronireis(int nummer, String bezeichnung, double preis) {
		super(nummer,bezeichnung,preis,250,Einheiten.G);
	}
	public Maronireis(int nummer, String bezeichnung, double preis,int menge) {
		super(nummer,bezeichnung,preis,menge,Einheiten.G);
	}
	public Maronireis(int nummer, String bezeichnung, double preis,int menge, Einheiten mengenEinheit) {
		super(nummer,bezeichnung,preis,menge,mengenEinheit);
	}
	public Maronireis(){
		this(123, "Maronireis", 0.99,250,Einheiten.G);
	}
}
