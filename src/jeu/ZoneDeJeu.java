package jeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;

public class ZoneDeJeu {
	private List<Bataille> pileBataille;
	private List<Limite> pileLimite;
	private Collection<Borne> bornes;
	private Set<Botte> bottes;
	
	
	public ZoneDeJeu() {
		this.pileLimite=new ArrayList<>();
		this.pileBataille=new ArrayList<>();
		this.bornes =new ArrayList<>();
		this.bottes=new HashSet<>();
	}
	public List<Bataille> getPileBataille() {
		return pileBataille;
	}
	public void setPileBataille(List<Bataille> pileBataille) {
		this.pileBataille = pileBataille;
	}
	public List<Limite> getPileLimite() {
		return pileLimite;
	}
	public Collection<Borne> getBornes() {
		return bornes;
	}
	public Set<Botte> getBottes() {
		return bottes;
	}

	

}
