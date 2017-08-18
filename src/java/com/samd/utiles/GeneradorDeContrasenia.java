
package com.samd.utiles;


public class GeneradorDeContrasenia {
    
    public static String NUMEROS = "0123456789";
 
	public static String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 
	public static String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
 
	public static String ESPECIALES = "@#¢&!";
 
        
	public static String getPinNumber() {
		return getPassword(NUMEROS, 4);
	}
 
	public static String getPassword() {
		return getPassword(8);
	}
 
	public static String getPassword(int largo) {
		return getPassword(NUMEROS + MAYUSCULAS + MINUSCULAS, largo);
	}
 
	public static String getPassword(String key, int largo) {
		String contrasenia = "";
 
		for (int i = 0; i < largo; i++) {
			contrasenia+=(key.charAt((int)(Math.random() * key.length())));
		}
 
		return contrasenia;
	}
    
    
}
