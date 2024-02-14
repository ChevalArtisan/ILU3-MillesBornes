package cartes;

import java.util.HashMap;
import java.util.Map;

public class Parade extends Bataille {

	public Parade(int nombre,Type type) {
		super(nombre, type);
		
	}
	
	@Override
	public String toString() {
		Map<Type, String> nomCarte = new HashMap<>();
		nomCarte.put(Type.ACCIDENT, "Reparations");
		nomCarte.put(Type.CREVAISON, "Roue de secours");
		nomCarte.put(Type.ESSENCE, "Essence");
		nomCarte.put(Type.FEU, "Feu vert");
		
		return nomCarte.get(getType());
	}

	private Type getType() {
		return type;
	}
}
