package pobj.physics;

import pobj.simuagent.StrategieSimple;
import pobj.simuagent.Strategy;
import pobj.tools.Vecteur2D;


public class Personne extends CerclePhysique implements Strategy {

	  private int id;
	  private static int cpt = 0;
	  private Vecteur2D target; 
	  private StrategieSimple str;

	


	public Personne(double x, double y, StrategieSimple str){
		super(x,y,10.,1.);
		id = cpt;
		cpt++;
		this.target = new Vecteur2D (x,y);
		this.str = str;
	
	}


/*	public void setDir(Vecteur2D v) {
    	target = v;
    	
    }
*/
	public void move(){

		target = new Vecteur2D(6,11);
		this.setDir(target);
		//target = str.deplacement(this); // usage de la strategie sur la personne qui invoque move
        //super.setVit(1.); // arbitraire, ça pourra dépendre des personnes... 
                          // En fait, ça pourrait être fait dans la stratégie si on ouvre la redéfinition
    }
  
    public Vecteur2D getTraget() {
    	return target;
    }
 

	@Override
	public Vecteur2D deplacement(Personne p) {
		// TODO Auto-generated method stub
		return null;
	}





	



	


	







}
