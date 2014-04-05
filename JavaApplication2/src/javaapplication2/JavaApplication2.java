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
import java.util.ArrayList;
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
         
         // Les variables utilisées pour le pb
         int nbre_intersections = 11348;
         int nbre_rues = 17958;
         int nbre_secondes = 54000;
         int nbre_véhicules = 8;
         int intersection_depart = 4516;
         
         // Liste de rue
         ArrayList<Rue> rues = new ArrayList<Rue>();
         
         // Liste d'intersections
         ArrayList<Intersection> intersections = new ArrayList<>();
         
         String fichier = "C:\\Users\\Marine\\Desktop\\paris_54000.txt";
         String ligne = "";
         int num_ligne = 0;
         
         String[] groupes_ligne;
         
         Rue rue;
         long latitude;
         long longitude;
         
         Intersection intersection;
         int intDepart;
         int intArrivee;
         int sens;
         int cout;
         int longueur;
         
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
                        if(num_ligne<nbre_intersections)
                        {
                            // On stocke le nombre de rues
                            groupes_ligne = ligne.split(" ");
                            latitude = Long.parseLong(groupes_ligne[0]);
                            longitude = Long.parseLong(groupes_ligne[1]);
                            intersection = new Intersection(latitude, longitude);
                            intersections.add(intersection);
                        }
                        else
                        {
                            // On stocke le nombre d'intersections
                            groupes_ligne = ligne.split(" ");
                            intDepart = Integer.parseInt(groupes_ligne[0]);
                            intArrivee = Integer.parseInt(groupes_ligne[1]);
                            sens = Integer.parseInt(groupes_ligne[2]);
                            cout = Integer.parseInt(groupes_ligne[3]);
                            longueur = Integer.parseInt(groupes_ligne[4]);
                            rue = new Rue(intDepart, intArrivee, sens, cout, longueur);
                            rues.add(rue);
                        }
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
