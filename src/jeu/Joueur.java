package jeu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Probleme.Type;


public class Joueur {
	private String nom;
	private ZoneDeJeu zone;
	private MainAsListe main;
	
	
	public Joueur(String nom) {
		super();
		this.nom = nom;
		this.zone= new ZoneDeJeu();
		main=new MainAsListe();
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	public boolean deposer(Carte c) {
		if(c instanceof Borne) {
			Borne borne=(Borne) c;
			if((!estBloque())&&
			(getKM()<1000)&&
			(borne.getkm()<getLimite())) {
				zone.getBornes().add(borne);
				return true;	
				}else {
					return false;
				}
		}else if (c instanceof Botte) {
			Botte botte = (Botte) c;
			zone.getBottes().add(botte);
			zone.getPileBataille().removeIf());
			return true;
		}else if (c instanceof DebutLimite) {
			
		}else if (c instanceof FinLimite) {
			
		}else if (c instanceof Bataille) {
			
		}else return false;
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
		for (Borne borne: zone.getBornes()) {
			total+=borne.getkm();
		}
		return total;
	}
	public boolean estPrio() {
		boolean isPrio = false;
		for (Botte botte: zone.getBottes()) {
			if (botte.getType()==Type.FEU)
				isPrio=true;
		}
		return isPrio;
	}
	public int getLimite() {
		List<Limite> limites=zone.getPileLimite();
		if(estPrio()||limites.isEmpty()||limites.get(limites.size()-1) instanceof FinLimite) {
			return 200;
		}else {
			return 50;
		}
	}
	
	public ZoneDeJeu getZoneDeJeu() {
		return this.zone;
	}
	

	public boolean estBloque() {
		   boolean prioritaire = estPrio();
		   List<Bataille> bataille=zone.getPileBataille();
		   Set<Botte> bottes = zone.getBottes();
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
	
	public HashSet<Coup> coupsPossible(Set<Joueur> participants){
		HashSet<Coup> res =new HashSet<>();
		Coup coup;
		for (Joueur joueur : participants) {
			Iterator<Carte> it = main.iterator();
			while(it.hasNext()) {
				coup=new Coup(it.next(),joueur);
				if(coup.estValide(this))
					res.add(coup);
			}
		}	
		return res;
	}

	
	public HashSet<Coup> coupsDefausse(){
		HashSet<Coup> res =new HashSet<>();
		Iterator<Carte> it = main.iterator();
		while(it.hasNext()) {
			res.add(new Coup(it.next(),null));
		}
		return res;
		
	}
}