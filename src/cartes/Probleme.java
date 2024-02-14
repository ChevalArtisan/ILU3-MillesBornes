package cartes;


public abstract class Probleme extends Carte {
	
	public enum Type{
		FEU,ESSENCE,CREVAISON,ACCIDENT
	}
	
	public  Type type;
	
	public Type getType() {
		return type;
	}

	protected Probleme(int nombre,Type type) {
		super(nombre);
		this.type=type;
	}

}
