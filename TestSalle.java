package pobj.simuagent;
import pobj.tools.*;
import pobj.physics.*;
import pobj.simuagent.factory_terrain.*;
import java.util.ArrayList;
import pobj.ihm.*;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import pobj.simuagent.*;

public class TestSalle {
	

	 private static final String filename = "/Users/elioelghoul/Desktop/JProjet/terrain1.trk";
     
	    public static void main(String[] args) throws InterruptedException{
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
	        
	        Fenetre mgraph = new Fenetre();
	        MoteurPhysique mphys = new MoteurPhysique();
	        
	    //test constructeur
	    int cote = 10;
        Salle salle1 = new Salle(terrain, cote);
        StrategieSimple str = new StrategieSimple(salle1);
      
        Personne p = new Personne (50,50,str);
        VueParticule vuep = new VueParticule(p);
        p.setRandomDirectionAndVitesse();
        mphys.add(p);
        
        
        System.out.println(p.getRayon());
        
 /*       CerclePhysique particule = new CerclePhysique(50, 50, 4, 1);
        VueParticule vuep = new VueParticule(particule);
        particule.setRandomDirectionAndVitesse();
        mphys.add(particule);
*/

	    //Test affichage de la salle 
	        

			for(int i=0; i<salle1.getHaut(); i++){
	                    for(int j=0; j<salle1.getLarg(); j++){
	                         switch(salle1.get(i, j)){
		                         case Mur:
		                         //System.out.println(i*cote +" "+ j*cote+" "+ cote+" "+ cote);
		                         Mur m = new Mur(i*cote, j*cote, cote, cote);
		                         
		
		                         MurView mv = new MurView(m);
		                         mphys.add(m);
		                         mgraph.add(mv);
    
	                         }
	                    }

			}
			for(int iter = 0; iter<2000; iter++) {
				
		        System.out.println(p.getTraget());

				p.move();
            mgraph.add(vuep);
            mphys.updateMovablePosition();
            // rafraichissement de l'affichage
            mgraph.repaint();      
            // temporisation (sinon, on ne voit rien)
            Thread.sleep(50);
            vuep.move(p,null);

            if(!mphys.isMove()) {
                System.out.println("plus de mouvement => sortie");
                break;
            }
        }
        
			
			
			
			
			
			
			
			
			
			
			
			
			
			
        //test accesseur par des coordonnées
        System.out.println(salle1.get(10,11));
        
        //test accesseur par vecteur
        System.out.println(salle1.get(new Vecteur2D(20,15)));
        
        //test gethaut
        System.out.println(salle1.getHaut());
        
        //test getlarg
        System.out.println(salle1.getLarg());
        
        
        //test add et getlisteCibles
        
        ArrayList <Vecteur2D> liste = salle1.getlisteCibles();
        
        for( int i1 = 0; i1 < liste.size(); i1 ++)
            System.out.println( (liste.get(i1)).toString() );
            
            
        
        salle1.add(new Vecteur2D(50,40));
       
        for( int i = 0; i < liste.size(); i ++)
            System.out.println( (liste.get(i)).toString() );
        
        //test isVisible  
        
        
        
        
	    }
	    
			  
}
        
       
        
