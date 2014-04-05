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
   ArrayList<Rue> ruesMain;
   ArrayList<Intersection> intersectionsMain; 
   
    public static void main(String[] args) throws IOException {
        
        ArrayList liste = new ArrayList();
        ArrayList<Rue> rues = new ArrayList<Rue>();
        ArrayList<Intersection> intersections = new ArrayList<Intersection>();
        
        int nbre_intersections = 11348;
        int nbre_rues = 17958;
        int nbre_secondes = 54000;
        int nbre_véhicules = 8;
        int intersection_depart = 4516;

        // On lit le fichier
        Utils utils = new Utils();
        liste = utils.lectureFichier();

        for(int i = 0; i<nbre_intersections;i++)
        {
            intersections.add((Intersection)liste.get(i));
            System.out.println(intersections.get(i));
        }
        
        for(int j = nbre_intersections+1; j<liste.size();j++)
        {
            rues.add((Rue)liste.get(j));
        }
    }
    
    
}
