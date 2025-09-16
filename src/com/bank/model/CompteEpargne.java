package com.bank.model;

public class CompteEpargne extends Compte {
    private double tauxInteret;

    public CompteEpargne(String code, double solde, double tauxInteret) {
        super(code, solde);
        this.tauxInteret = tauxInteret;
    }

    @Override
    public void retirer(double montant) throws Exception {
        if (montant <= 0) throw new Exception("Montant doit être positif");
        if (solde < montant)
            throw new Exception("Retrait impossible : solde insuffisant");
        solde -= montant;
        listeOperations.add(new Retrait(montant, "Virement sortant"));
    }

    @Override
    public double calculerInteret() {
        return solde * tauxInteret / 100;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Compte épargne - Code: " + code + ", Solde: " + solde + ", Taux: " + tauxInteret + "%");
    }
}
