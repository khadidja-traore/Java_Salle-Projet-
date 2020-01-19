package pobj.simuagent;
import pobj.simuagent.factory_terrain.*;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
 

public class TestFichier {

	    private static final String filename = "/Users/elioelghoul/Desktop/JProjet/terrain1.trk";
	     
	    public static void main(String[] args) throws IOException {
	        BufferedReader rd = null;
	        try {
	            // ouvrir.
	            rd = new BufferedReader(new FileReader(new File(filename)));
	             
	           //creer le terrain et l'afficher
	            Terrain[][] t = MapFactoryFromFile_Matrix.build (filename);
				Terrain.display(t);
	           
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
	       
	    }
}
	
		
		
		
		
		


