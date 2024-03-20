package cartes;

public class Borne extends Carte {
	private int km;

	public Borne(int nombre, int km) {
		super(nombre);
		this.km = km;
	}
	
	@Override
	public String toString() {
		return getkm()+"bornes";
	}

	public int getkm() {
		return km;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Borne) {
			Borne borne = (Borne) obj;
			return borne.getkm()==this.km;
		}
		return false;
	}
	

}
