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
         Scanner sc = null;
         int i = 0;
         int j = 0;
         int instructions = 0;
         String fichier = "C:\\Users\\Marine\\Desktop\\doodle.txt";
         try{
            //try{
                sc = new Scanner(new File(fichier));
                while(sc.hasNext()) {
                    for (char c :sc.next().toCharArray()) {
                        if(c=='#')
                        {
                            System.out.println("PAINTSQ "+(i-1)+" "+j+" 0");
                            instructions++;
                
                        }
                        j++;
                    }
                    i++;
                    j = 0;
                    
                }
            /*} finally {
                if (sc != null)
                sc.close();
            }*/
                                System.out.println("inst"+instructions);

        } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }

                
    }
    
}
