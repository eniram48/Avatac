/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Marine
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String fichier = "doodle.txt";
        String ligne = "";
        BufferedReader clavier = new BufferedReader(new InputStreamReader(
				System.in));
        
        fichier = clavier.readLine();
	BufferedReader ficTexte;
        
        try {
		ficTexte = new BufferedReader(new FileReader(new File(fichier)));
			
		do {
                    ligne = ficTexte.readLine();
                    if (ligne != null) {
			System.out.println(ligne);
                    }
		} while (ficTexte != null);
		ficTexte.close();
		System.out.println("\n");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
                
    }
    
}
