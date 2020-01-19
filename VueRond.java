package pobj.ihm;

import java.awt.Graphics;
import java.awt.Color;

public class VueRond implements Drawable {
     private double x, y , rayon;
     
     public VueRond( double x, double y, double rayon ) {
    	     this.x = x; 
    	     this.y = y;
    	     this.rayon = rayon;
     
     }
     
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.RED);
		g.drawOval((int) x, (int) y, (int) (2*rayon), (int) (2*rayon));
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return 0;
	}
    
	
	public void move() {
		this.x++;
		this.y++;
		
	}
	public void move2() {
		this.x--;
		this.y--;
		
	}
	
}
