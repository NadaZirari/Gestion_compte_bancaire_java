package com.bank.model;
public class CompteCourant extends Compte {
	
	   private double decouvert;

	    public CompteCourant(String code, double solde, double decouvert) {
	        super(code, solde);
	        this.decouvert = decouvert;
	    }

	    
	    @Override
	    public void retirer(double montant) throws Exception {
	        if (montant <= 0) throw new Exception("Montant doit être positif");
	        if (solde - montant < -decouvert)
	            throw new Exception("Retrait impossible : dépassement du découvert");
	        solde -= montant;
	        listeOperations.add(new Retrait(montant, "Distributeur ATM"));
	    }

	    @Override
	    public double calculerInteret() { return 0; }

	    @Override
	    public void afficherDetails() {
	        System.out.println("Compte courant - Code: " + code + ", Solde: " + solde + ", Découvert: " + decouvert);
	    }
	    
}
