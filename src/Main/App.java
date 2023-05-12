package Main;

import Control.Controle;
import View.Janela;

public class App{

	public static void main(String[] args) {
		
		Janela janela = new Janela(1024,544);
		new Controle(janela).run();
		

	}
}
