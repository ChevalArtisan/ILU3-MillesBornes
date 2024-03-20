package jeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Probleme.Type;


public class Joueur {
	private String nom;
	private List<Limite> limites;
	private List<Bataille> bataille;
	private Collection<Borne> bornes;
	private Set<Botte> bottes;
	private MainAsListe main;
	
	
	public Joueur(String nom) {
		super();
		this.nom = nom;
		limites=new ArrayList<>();
		bataille=new ArrayList<>();
		bornes =new ArrayList<>();
		bottes=new HashSet<>();
		main=new MainAsListe();
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	public Carte prendreCarte(List<Carte> sabot) {
		if (sabot.isEmpty()){
			return null;
		}else {
			Carte carte=sabot.get(0);
			this.donner(carte);
			return carte;
		}
	}
	
	
	public int hashCode() {
		return 31*nom.hashCode();
		
	}
	
	public int getKM() {
		int total=0;
		for (Borne borne: bornes) {
			total+=borne.getkm();
		}
		return total;
	}
	public boolean estPrio() {
		boolean isPrio = false;
		for (Botte botte: bottes) {
			if (botte.getType()==Type.FEU)
				isPrio=true;
		}
		return isPrio;
	}
	public int getLimite() {
		
		FinLimite fl=new FinLimite(1);
		if(estPrio()||limites.isEmpty()||limites.get(limites.size()-1).equals(fl)) {
			return 200;
		}else {
			return 50;
		}
	}

	

	public boolean estBloque() {
		   boolean prioritaire = estPrio();
				if (bataille.isEmpty() && prioritaire) {
					return false;
				}
				if (!bataille.isEmpty()) {
					Carte sommetCarte = bataille.get(bataille.size()-1);
					Carte feuVert = new Parade(1,Type.FEU);
					Carte feuRouge = new Attaque(1,Type.FEU);
					if (sommetCarte instanceof Parade && sommetCarte.equals(feuVert)) {
						return false;
					}
					if (sommetCarte instanceof Parade && prioritaire) {
						return false;
					}
					if (sommetCarte instanceof Attaque && sommetCarte.equals(feuRouge) && prioritaire) {
						return false;
					}
					if (sommetCarte instanceof Attaque && prioritaire) {
						Attaque carte = (Attaque) sommetCarte;
						for (Botte botte : bottes) {
							if (botte.getType() == carte.getType()) {
								return false;
							}
						}
					}
				}
				return true;
			}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if( obj instanceof Joueur) {
			Joueur joueur=(Joueur)obj;
			return joueur.toString().equals(nom);
			}
					
		else 
			return false;
	}
	
	

	public String toString() {
		return nom;
	}
	
	public Main getMain() {
		return main;
	}

	public Set<Botte> getBottes() {
		return bottes;
	}

	public List<Bataille> getBataille() {
		return bataille;
	}

	public List<Limite> getLimites() {
		return limites;
	}
	
	public Collection<Borne> getBornes(){
		return bornes;
	}
}
