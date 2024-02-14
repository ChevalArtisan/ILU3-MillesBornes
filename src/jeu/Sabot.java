package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte> {

	private Carte cartes[];
	private int nbCartes;
	public int nombreOperations;
	
	
	public Sabot() {
		cartes= new Carte[110];
	}
	
	public Carte piocher() {
		Iterator<Carte> iter=iterator();
		Carte carte=iter.next();
		iter.remove();
		return carte;
	}
	public boolean estVide() {
		return nbCartes==0;
	}
	
	private void ajouterCarte(Carte carte) {
		if (nbCartes< cartes.length) {
			cartes[nbCartes++]=carte;
		}
		else {
			throw new IndexOutOfBoundsException("Sabot plein");
		}
	}
	
	public void ajouterFamilleCarte(Carte...cartes) {
		for(Carte carte: cartes) {
		for (int i = 0; i < carte.getNombre(); i++) {
			ajouterCarte(carte);
		}
	}
	}
	public void ajouterFamillesCartes() {
		
	}

	@Override
	public Iterator<Carte> iterator() {
		return new Iterateur();
		
		
	}
	private class Iterateur implements Iterator<Carte>{
		private int indiceIterateur=0;
		private int nombreOperationsReference = nombreOperations;
		private boolean nextEffectue = false;
		
		private void verificationConcurrence(){
			 if (nombreOperations != nombreOperationsReference)
			 throw new ConcurrentModificationException();
			 }
		@Override
		public boolean hasNext() {
			return nbCartes>indiceIterateur;
		}

		@Override
		public Carte next() {
			verificationConcurrence();
			if(hasNext()) {
				Carte carte=cartes[indiceIterateur++];
				nextEffectue=true;
				return carte;
			}else {
				throw new NoSuchElementException();
			}
		}
		
		public void remove() {
			verificationConcurrence();
			if (nbCartes < 1 || !nextEffectue) {
				throw new IllegalStateException();
			}
			for (int i = indiceIterateur - 1; i < nbCartes - 1; i++) {
				cartes[i] = cartes[i + 1];
				}
			nextEffectue = false;
			indiceIterateur--; 
			nbCartes--;
			nombreOperations++;
			nombreOperationsReference++; 
		}

	}
}


