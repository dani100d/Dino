package Model;

import java.util.ArrayList;

public class Inimigo {


	private ArrayList<Picterodatilo> picterodatilos;
	
	public Inimigo() {
		
		this.picterodatilos = new ArrayList<Picterodatilo>();
	}
	

	public ArrayList<Picterodatilo> getPicterodatilos() {
		return picterodatilos;
	}

	public void setPicterodatilos(ArrayList<Picterodatilo> picterodatilos) {
		this.picterodatilos = picterodatilos;
	}


}
