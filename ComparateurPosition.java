package pobj.simuagent;

import java.util.Comparator;

import pobj.physics.Personne;
import pobj.tools.Vecteur2D;


public class ComparateurPosition implements Comparator<Vecteur2D>{

	private Vecteur2D pos;
	private Salle s;
	private Personne p;
	
	public ComparateurPosition(Salle s, Vecteur2D pos) {
		this.pos = pos;
		this.s = s;
		
	}

	public int compare(Vecteur2D c1, Vecteur2D c2) {
		//score
		int score1 =0;
		int score2=0;
		
		//Security 

		if (Terrain.level(s.get(c1)) > Terrain.level(s.get(c2))) {
			score1 ++;	
		}
		if (Terrain.level(s.get(c1)) < Terrain.level(s.get(c2))) {
			score2 ++;	
		}
		
		//Distance
		double d1 = Math.sqrt((p.getPosY() - c1.getY()) * (p.getPosY() - c1.getY()) + (p.getPosX() - c1.getX()) * (p.getPosX() - c1.getX()));
		double d2 = Math.sqrt((p.getPosY() - c2.getY()) * (p.getPosY() - c2.getY()) + (p.getPosX() - c2.getX()) * (p.getPosX() - c2.getX()));
		
		
		if (d1 > d2) {
			score1++;
		}
		if (d1 < d2) {
			score2++;
		}
		
		//Visibility
		if (s.isVisible(p.getPos(),c1) == true) {
			score1++;	
		}
		
		if (s.isVisible(p.getPos(),c2) == true) {
			score2++;	
		}
		
		if (score1 > score2) {
			return 1;
		}
		if(score1 < score2) {
			return -1;
		}
		return 0;
		
	} 
	
	
}
