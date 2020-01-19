package pobj.simuagent;

import java.awt.Color;
import java.awt.Graphics;

import pobj.ihm.Drawable;
import pobj.physics.CerclePhysique;
import pobj.physics.Personne;
import pobj.physics.RectanglePhysique;

public class PersonneView implements Drawable {
	private Personne p;
	private double x,y,rayon, masse;

	
	public PersonneView(Personne p) {
		
		this.x = p.getPosX();
		this.y = p.getPosY();
		this.rayon = p.getRayon();
		this.masse = p.getMasse();
			
		}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawOval((int) p.getPosX(), (int) p.getPosX(), (int) (2*p.getRayon()), (int) (2*p.getRayon()));
		
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void move(Personne p, RectanglePhysique mur) {
		
		this.x = p.getPosX();
		this.y = p.getPosY();		
			
	}
	

}
