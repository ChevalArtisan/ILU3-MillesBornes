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
	
	public boolean equals(Object obj) {
		if( obj instanceof Probleme) {
			Probleme probleme=(Probleme)obj;
			return probleme.getType().equals(type) && probleme.getClass().equals(getClass());
			}
					
		else 
			return false;

	}
}
