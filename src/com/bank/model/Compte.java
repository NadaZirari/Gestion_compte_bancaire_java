package com.bank.model;

import java.util.ArrayList;

public abstract class Compte {
	 protected String code;
	    protected double solde;
	    protected ArrayList<Operation> listeOperations;

	    public Compte(String code, double solde) {
	        this.code = code;
	        this.solde = solde;
	        this.listeOperations = new ArrayList<>();
	    }

	    public abstract void retirer(double montant) throws Exception;
	    public abstract double calculerInteret();
	    public abstract void afficherDetails();

	    public void verser(double montant, String source) throws Exception {
	        if (montant <= 0) throw new Exception("Montant doit être positif");
	        solde += montant;
	        listeOperations.add(new Versement(montant, source));
	    }
	    public String getCode() { return code; }
	    public double getSolde() { return solde; }
	    public ArrayList<Operation> getListeOperations() { return listeOperations; }


}
