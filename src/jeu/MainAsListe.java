package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import cartes.Carte;

public class MainAsListe implements Main{
	private List<Carte> cartes=new ArrayList<>();
	public int nombreOperations;
	@Override
	public void prendre(Carte carte) {
		cartes.add(carte);
	}

	@Override
	public void jouer(Carte carte) {
		cartes.remove(carte);
	}

	@Override
	public Iterator<Carte> iterator() {
		return cartes.iterator();
	}
	

	
	

}
