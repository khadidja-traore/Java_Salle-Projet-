package pobj.ihm;

import java.awt.Color;
import java.awt.Graphics;

import pobj.physics.CerclePhysique;
import pobj.physics.RectanglePhysique;

public class VueParticule implements Drawable{
		private double x,y,rayon, masse;
		
		public VueParticule(CerclePhysique c) {
			this.x = c.getPosX();
			this.y = c.getPosY();
			this.rayon = c.getRayon();
			this.masse = c.getMasse();
			
		}

		@Override
		public void draw(Graphics g) {
			g.setColor(Color.MAGENTA);
			g.drawOval((int) x, (int) y, (int) (2*rayon), (int) (2*rayon));
		}

		@Override
		public int getPriority() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		public double getx() {return x;}
		public void move(CerclePhysique c, RectanglePhysique mur) {
			
			this.x = c.getPosX();
			this.y = c.getPosY();		
				
		}
		
}
