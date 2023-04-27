package Main;

import Control.Controle;
import View.Janela;

public class App {

	public static void main(String[] args) {
		
		Janela janela = new Janela(1200, 618);
		new Controle(janela).run();
		

	}

}
