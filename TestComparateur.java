package pobj.simuagent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import pobj.physics.Personne;
import pobj.simuagent.factory_terrain.MapFactoryFromFile_Matrix;
import pobj.tools.Vecteur2D;

public class TestComparateur {

	 private static final String filename = "/Users/elioelghoul/Desktop/JProjet/terrain1.trk";
	 
	public static void main(String[] args) {
		
		Strategy str = null;

		//creer le terrain
		 BufferedReader rd = null;
	        
		 Terrain [][] terrain = null; 
	        try {
	            // ouvrir.
	            rd = new BufferedReader(new FileReader(new File(filename)));
	             
	           //creer le terrain et l'afficher
	            Terrain[][] t = MapFactoryFromFile_Matrix.build (filename);
				terrain = t;
				
				/*String inputLine = null;
	            while((inputLine = rd.readLine()) != null)
	                System.out.println(inputLine);*/
	           
	        }
	       
	        catch(IOException ex) {
	        	System.out.println(System.getProperty("user.dir"));
	            System.err.println("An IOException was caught!");
	            ex.printStackTrace();
	        }
	        finally {
	            // fermer.
	            try {
	                rd.close();
	            }
	            catch (IOException ex) {
	                System.err.println("An IOException was caught!");
	                ex.printStackTrace();
	            }
	        }
		
		
		
		//ici
		Salle salle = new Salle(terrain, 10);
		ArrayList<Vecteur2D> liste = salle.getlisteCibles();
		System.out.println("liste"+liste);
		
		Personne p = new Personne(40,10,str);
		Personne p2 = new Personne(30,20,str);

		
		Vecteur2D cibleOpt = Collections.min(salle.getlisteCibles(), new ComparateurPosition(salle, p.getPos()));
		Vecteur2D cibleOpt2 = Collections.min(salle.getlisteCibles(), new ComparateurPosition(salle, p2.getPos()));

		System.out.println("cible "+cibleOpt);
		System.out.println("cible "+cibleOpt2);

		
		/*System.out.println(p.getPosX());
		System.out.println(p.getPosY());

		
		System.out.println(p.getRayon());
		System.out.println(salle.getlisteCibles());*/

		
		
		
		
		
	}

}