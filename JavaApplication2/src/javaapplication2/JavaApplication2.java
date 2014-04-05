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
import java.util.Scanner;

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
         
        // On lit le fichier
        lectureFichier();
    }
    
    // Lecture du fichier
    public static void lectureFichier()
    {
        Scanner sc = null;
         
         // Les variables utilisées pour le pb
         int nbre_intersections = 11348;
         int nbre_rues = 17958;
         int nbre_secondes = 54000;
         int nbre_véhicules = 8;
         int intersection_depart = 4516;
         
         String fichier = "C:\\Users\\Marine\\Desktop\\paris_54000.txt";
         String ligne = "";
         int num_ligne = 0;

	BufferedReader ficTexte;
	try {
            ficTexte = new BufferedReader(new FileReader(new File(fichier)));
            if (ficTexte == null) {
		throw new FileNotFoundException("Fichier non trouvé: "+ fichier);
            }
            do {
		ligne = ficTexte.readLine();
                if (ligne != null) {
                    //System.out.println(ligne);
                    if(num_ligne!=0)
                    {
                        
                    }
                    num_ligne++;
		}
            } while (ficTexte != null);
            ficTexte.close();
	} catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
	} catch (IOException e) {
            System.out.println(e.getMessage());
	}
    }
    
}
