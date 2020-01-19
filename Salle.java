package pobj.simuagent;

import java.util.ArrayList;

import pobj.physics.RectanglePhysique;
import pobj.simuagent.factory_terrain.MapFactoryFromFile_Matrix;
import pobj.tools.Vecteur2D;
import pobj.ihm.*;
public class Salle {
	

	private ArrayList <Vecteur2D> listeCibles;
	private  Terrain[][] terr;
	private final int cote;
	
	public Salle(Terrain[][] terr, int cote) {
		
		this.terr = terr;
		this.cote = cote;
		listeCibles = new ArrayList<Vecteur2D>();
		// Terrain[][] t = MapFactoryFromFile_Matrix.build ("terrain1.trk");
		// terr = t;
		for(int i=0; i<terr.length; i++){
            for(int j=0; j<terr[0].length; j++) {
            	//RectanglePhysique p = new RectanglePhysique(i,j,cote,cote);
            	//System.out.println(p);
            	if ((terr[i][j]) != Terrain.Mur || ( terr[i][j] != Terrain.Scene) || (terr[i][j] != Terrain.Vide)){
            		Vecteur2D v = new Vecteur2D(i,j);
            		listeCibles.add(v);
            	}
            	
            }
		}  	
		
	}
	
	
	
	public void add(Vecteur2D v) {
		listeCibles.add(v);
	}
	
	public ArrayList <Vecteur2D> getlisteCibles(){
		return listeCibles;
	}
	
	
	public Terrain get(int x,int y) {
		return terr[x][y];
	}
	
	public Terrain get(Vecteur2D v) {
		int x,y;
		x = ((int) v.getX())/cote;
		y = ((int) v.getY())/cote;
		return terr[x][y];
	}
	
	public boolean isVisible(Vecteur2D source, Vecteur2D target){
        Vecteur2D dir = target.minus(source);
        dir.normalize();
        while(get(source) != Terrain.Mur){
            source = source.add(dir);
            if(source.distance(target) < 2)
                return true;
        }
        return false;
    }

	public int getHaut(){
		   int hauteur = 0;
		   for(int i=0; i<terr.length; i++){
				hauteur ++;
			}
			
		return hauteur;
		}

		public int getLarg() {
		int larg = 0;
	    for(int i=0; i<terr[0].length; i++){
				larg ++;
			}
		return larg;
		}
		
		
}
