package Model;

import java.util.ArrayList;

public class Inimigo {


	private ArrayList<Picterodatilo> picterodatilos;
	private ArrayList<Triceraptor> triceraptores;
	
	public Inimigo() {
		
		this.picterodatilos = new ArrayList<Picterodatilo>();
		this.triceraptores = new ArrayList<Triceraptor>();
	}
	

	public ArrayList<Picterodatilo> getPicterodatilos() {
		return picterodatilos;
	}

	public void setPicterodatilos(ArrayList<Picterodatilo> picterodatilos) {
		this.picterodatilos = picterodatilos;
	}


	public ArrayList<Triceraptor> getTriceraptores() {
		return triceraptores;
	}


	public void setTriceraptores(ArrayList<Triceraptor> triceraptores) {
		this.triceraptores = triceraptores;
	}


}
