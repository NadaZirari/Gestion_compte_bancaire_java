package com.bank.ui;

import com.bank.model.*;
import com.bank.util.Utils;
import java.util.HashMap;
import java.util.Scanner;

public class ConsoleUI {
    private HashMap<String, Compte> comptes = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    public void demarrer() {
        boolean exit = false;
        while (!exit) {
            afficherMenu();
            int choix = lireEntier("Choix : ");
            switch (choix) {
                case 1: creerCompte(); break;
                case 2: faireVersement(); break;
                case 3: faireRetrait(); break;
                case 4: faireVirement(); break;
                case 5: consulterSolde(); break;
                case 6: consulterOperations(); break;
                case 7: exit = true; System.out.println("Au revoir !"); break;
                default: System.out.println("Choix invalide"); break;
            }
        }
    }

    private void afficherMenu() {
        System.out.println("\n--- Gestion Banque ---");
        System.out.println("1. Créer compte");
        System.out.println("2. Versement");
        System.out.println("3. Retrait");
        System.out.println("4. Virement");
        System.out.println("5. Consulter solde");
        System.out.println("6. Consulter opérations");
        System.out.println("7. Quitter");
    }

    private int lireEntier(String message) {
        System.out.print(message);
        while (!sc.hasNextInt()) {
            System.out.println("Entrée invalide !");
            sc.next();
            System.out.print(message);
        }
        int valeur = sc.nextInt();
        sc.nextLine(); // consommer le retour chariot
        return valeur;
    }

    
    private void creerCompte() { 
    	 System.out.print("Nom du titulaire : ");
    	    String nom = sc.nextLine();
    	    System.out.print("Numéro du compte : ");
    	    String numero = sc.nextLine();
    	    Compte compte = new CompteCourant(numero, 0.0); // ✅
    	    comptes.put(numero, compte);
    	    System.out.println("Compte créé avec succès !");
    }
    private void faireVersement() {
    	 System.out.print("Numéro du compte : ");
    	    String numero = sc.nextLine();

    	    Compte compte = comptes.get(numero);
    	    if (compte == null) {
    	        System.out.println("Compte introuvable !");
    	        return;
    	    }

    	    System.out.print("Montant à verser : ");
    	    double montant = sc.nextDouble();
    	    sc.nextLine();
    	    try {
    	        compte.verser(montant, "Versement espèces");
    	        System.out.println("Versement effectué avec succès !");
    	    } catch (Exception e) {
    	        System.out.println("Erreur : " + e.getMessage());
    	    }
    
    
    }
    
    
    private void faireRetrait() { 
    	
    	 System.out.print("Numéro du compte : ");
    	    String numero = sc.nextLine();

    	    Compte compte = comptes.get(numero);
    	    if (compte == null) {
    	        System.out.println("Compte introuvable !");
    	        return;
    	    }

    	    System.out.print("Montant à retirer : ");
    	    double montant = sc.nextDouble();
    	    sc.nextLine();
    	
    	    try {
    	        compte.retirer(montant);
    	        System.out.println("Retrait effectué avec succès !");
    	    } catch (Exception e) {
    	        System.out.println("Erreur : " + e.getMessage());
    	    }
    }
    private void faireVirement() { /*...*/ }
    private void consulterSolde() { /*...*/ }
    private void consulterOperations() { /*...*/ }
}
