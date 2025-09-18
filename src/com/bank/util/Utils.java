package com.bank.util;

public class Utils {
	  public static boolean codeCompteValide(String code) {
	        return code.matches("CPT-\\d{5}");
	    }

	  
}
