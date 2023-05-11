package Model;

import java.util.ArrayList;

public class Inimigo {


	private ArrayList<Picterodatilo> picterodatilos;
	private ArrayList<Triceraptor> triceraptores;
	private ArrayList<Caveira> caveiras;
	
	public Inimigo() {
		
		this.picterodatilos = new ArrayList<Picterodatilo>();
		this.triceraptores = new ArrayList<Triceraptor>();
		this.caveiras = new ArrayList<Caveira>();
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


	public ArrayList<Caveira> getCaveiras() {
		return caveiras;
	}

}
