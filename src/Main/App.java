package Main;

import javax.swing.JFrame;

import Control.Controle;
import View.Janela;
import View.TelaInicial;

public class App{

	public static void main(String[] args) {
		
		Janela janela = new Janela(700,700);
		new Controle(janela).run();
		

	}
}
