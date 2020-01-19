package pobj.ihm;

import java.awt.Color;
import java.awt.Graphics;

import pobj.physics.RectanglePhysique;

public class VueMur implements Drawable {
	 private double x, y , large, haut;
	
	public VueMur(RectanglePhysique p) {
		this.x = p.getPosX();
		this.y = p.getPosY();
		this.large = p.getLarg();
		this.haut = p.getHaut();
		
		
	
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.drawRect((int) x, (int) y, (int) large, (int) haut);

	}
	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
