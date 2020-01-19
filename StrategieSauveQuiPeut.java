package pobj.simuagent;

import java.util.ArrayList;
import java.util.Collections;

import pobj.physics.Personne;
import pobj.tools.Vecteur2D;

public class StrategieSauveQuiPeut implements Strategy {
	
	private Salle s;
	
	public StrategieSauveQuiPeut(Salle s){
		this.s = s;
	}

	@Override
	public Vecteur2D deplacement(Personne p) {
	
		Vecteur2D cibleOpt = Collections.min(s.getlisteCibles(), new ComparateurPosition(s, p.getPos()));
		p.setDir(cibleOpt);

		return cibleOpt;
	
		}

}