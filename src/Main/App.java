package Main;

import javax.swing.JFrame;

import Control.Controle;
import View.Janela;
import View.TelaInicial;

public class App{

	public static void main(String[] args) {
		
		Janela janela = new Janela(1024,544);
		new Controle(janela).run();
		

	}
}
