package cartes;

import java.util.HashMap;
import java.util.Map;

public class Attaque extends Bataille {

	public Attaque(int nombre,Type type) {
		super(nombre, type);
	}
	public Type getType() {
		return type;
	}
	public String toString() {
		Map<Type, String> nomCarte = new HashMap<>();
		nomCarte.put(Type.ACCIDENT, "Accident");
		nomCarte.put(Type.CREVAISON, "Crevaison");
		nomCarte.put(Type.ESSENCE, "Panne d'essence");
		nomCarte.put(Type.FEU, "Feu rouge");
		
		return nomCarte.get(getType());
	}
}
