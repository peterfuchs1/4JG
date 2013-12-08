package factory;

public class SpezialFabrik extends Fabrik {
	public SpezialFabrik(){
		this.fabArt="Alle Produkte";
	}
	public static Artikel erzeuge(String produkt) {
		Artikel ret=null;
		try {
					
			Class<?> cls=Class.forName("factory."+produkt);
			ret=(Artikel)cls.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			
			e.printStackTrace();
		}
		return ret;
	}

}
