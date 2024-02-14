package cartes;

import java.util.HashMap;
import java.util.Map;

public class Botte extends Probleme{

	public Botte(int nombre, Type type) {
		super(nombre, type);
	}
	@Override
	public String toString() {
	Map<Type, String> nomCarte = new HashMap<>();
	nomCarte.put(Type.ACCIDENT, "As du volant");
	nomCarte.put(Type.CREVAISON, "Increvable");
	nomCarte.put(Type.ESSENCE, "Citerne");
	nomCarte.put(Type.FEU, "Vehicule prioritaire");
	
	return nomCarte.get(getType());
	}
	private Type getType() {
		return type;
	}
}
