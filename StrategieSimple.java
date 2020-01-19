package pobj.simuagent;

import java.util.ArrayList;

import pobj.physics.Personne;
import pobj.tools.Vecteur2D;

public class StrategieSimple implements Strategy {
	private Salle s;
	
	public StrategieSimple(Salle s){
		this.s = s;
	}
	
	public Vecteur2D deplacement(Personne p){
		Vecteur2D v = new Vecteur2D(11,20);
		p.setDir(v);
		
		// creation d une droite y = ax+b
		//creation de la pente a
		double a = (p.getPosY()-v.getY())/((p.getPosY()-v.getY()));
		
		//creation de b
		double b = v.getY() - (a*v.getX());
		
		//creation d un vecteur 
		ArrayList<Vecteur2D> tabv = new ArrayList<Vecteur2D>();
		
		double xt = p.getPosX();
		double yt = p.getPosY();

		Vecteur2D vt =new Vecteur2D(xt,yt);
		
		
		for (int i=0; i<tabv.size(); i++ ) {
			if (vt.getX() <= p.getTraget().getX()) {
				
				yt = a*xt + b;
				Vecteur2D vnew = new Vecteur2D (xt,yt);
				tabv.add(vnew);
				

				xt++;
				
			}
			
		}
		
		
		return v;
		
	}

}
