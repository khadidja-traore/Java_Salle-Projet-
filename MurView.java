package pobj.simuagent;

import java.awt.Color;
import java.awt.Graphics;

import pobj.ihm.Drawable;

public class MurView implements Drawable{
	
	private Mur m;
	
	public MurView(Mur m) {this.m = m;}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.drawRect((int)m.getPosX(), (int)m.getPosY(),(int)m.getLarg(), (int)m.getHaut());
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 0;
	}

}
