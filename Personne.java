package pobj.physics;
import pobj.tools.*;
import pobj.simuagent.*;

public class Personne extends CerclePhysique {
	
    private int id;
    private static int cpt = 0;
    private Vecteur2D target; 
    private StrategieSimple str;
     
    
    public Personne ( double x, double y, StrategieSimple str) {
    	super(x, y);
    	id = cpt;
    	cpt++;
    	target = null;
    	this.str = str;
    	
    }
	
    public void setDir(Vecteur2D v) {
    	target = v;
    }
    
    
    
    public void move(){
        target = str.deplacement(this); // usage de la strategie sur la personne qui invoque move
        super.setVit(1.); // arbitraire, ça pourra dépendre des personnes... 
                          // En fait, ça pourrait être fait dans la stratégie si on ouvre la redéfinition
    }
    
    public Vecteur2D getTraget() {
    	return target;
    }
    
}
