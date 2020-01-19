package pobj.simuagent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import pobj.physics.Personne;
import pobj.simuagent.factory_terrain.MapFactoryFromFile_Matrix;

public class TestPersonne {
	
private static final String filename = "/users/Etu9/3800559/Java/2i002_ressources_projet2017/billard-etu/ressources/terrain1.trk";
	
	public static void main (String [] args) {
	
		
		
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
	
		Salle s = new Salle(terrain,10);
		StrategieSimple str = new StrategieSimple(s);
		Personne p = new Personne(25,5,str);
		System.out.println(p.getPos().toString());
		
		System.out.println(str.deplacement(p).toString());
	}
}
