package com.bank.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public abstract class Operation {

	
	protected String numero;
    protected LocalDateTime date;
    protected double montant;

    public Operation(double montant) {
        this.numero = UUID.randomUUID().toString();
        this.date = LocalDateTime.now();
        this.montant = montant;
    }

    public String getNumero() { return numero; }
    public LocalDateTime getDate() { return date; }
    public double getMontant() { return montant; }
    
    
    public abstract String getType();

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(fmt) + " - " + getType() + " : " + montant + " €";
    }
}
    

