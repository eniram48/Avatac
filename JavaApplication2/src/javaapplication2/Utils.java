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
import java.util.ArrayList;

/**
 *
 * @author Marine
 */
public class Utils {
    
    // Lecture du fichier
    public ArrayList lectureFichier()
    {
         ArrayList liste = new ArrayList();
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
         double latitude;
         double longitude;
         
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
                        if(num_ligne<nbre_intersections+1)
                        {
                            // On stocke le nombre de rues
                            groupes_ligne = ligne.split(" ");
                            latitude = Double.parseDouble(groupes_ligne[0]);
                            longitude = Double.parseDouble(groupes_ligne[1]);
                            intersection = new Intersection(latitude, longitude);
                            //intersections.add(intersection);
                            liste.add(intersection);

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
                            //rues.add(rue);
                            liste.add(rue);
                        }
                    }
                    num_ligne++;
		}
            } while (ligne != null);
            ficTexte.close();
                            
	} catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
	} catch (IOException e) {
            System.out.println(e.getMessage());
	}
        
        /*for(int i = 0; i<rues.size();i++)
        {
            liste.add(rues.get(i));
        }
        
        for(int j = 0; j<intersections.size();j++)
        {
            liste.add(intersections.get(j));
        }*/
        
        /*liste.addAll(rues);
        liste.addAll(intersections);*/
        
        return liste;
    }
    
    // Méthode de parcourt de la ville
    public void Parcours(ArrayList<Rue> rues, ArrayList<Intersection> intersections, int intersectionDepart)
    {
        int indexIntectionDepart = intersectionDepart;
        int indexIntersectionArrivee = 0;
        int nb_rues = rues.size();
        int nb_ruesParcourues = 0;
        int nb_intersections = intersections.size();
        
        
        /*System.out.println("8");
        
        for(int i = 0;i<7;i++)
        {
            
            System.out.println("1");
            System.out.println("4516");
        }
        System.out.println("4516");*/

        
        for(Rue rue: rues)
        {
            if(rue.getIntDepart() == indexIntectionDepart)
            {
                indexIntersectionArrivee = rue.getIntArrivee();
                System.out.println(indexIntersectionArrivee);
                indexIntectionDepart = indexIntersectionArrivee;
                nb_ruesParcourues++;
                /*if(nb_ruesParcourues == nb_rues)
                    break;*/
            }
        }
    }
    
}
