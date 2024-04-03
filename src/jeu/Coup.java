package jeu;

import cartes.Attaque;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.Probleme.Type;

public class Coup {
	private Carte carte;
	private Joueur joueurCible;
	
	
	public Coup(Carte carte, Joueur joueurCible) {
		this.carte = carte;
		this.joueurCible = joueurCible;
	}

	public Carte getCarte() {
		return carte;
	}

	public Joueur getJoueurCible() {
		return joueurCible;
	}
	
	public boolean estValide(Joueur joueur) {
		if((!joueur.equals(joueurCible)&&joueur!=null)&&
				(carte instanceof Attaque)||(carte instanceof DebutLimite)) {
			return true;
		}else if(joueur==null) {
			return true;
		}
		
		return false;
				}
	}

