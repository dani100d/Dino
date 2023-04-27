package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;

public class Janela extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3338597443822445438L;

	private Fase fase;

	public Janela(int largura, int altura) {

		setPreferredSize(new Dimension(largura, altura));
		setLayout(new FlowLayout());

		setSize(largura, altura);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);

		//Image iconeTitulo = Toolkit.getDefaultToolkit().getImage("baseDados\\caverna.png");
		//this.setIconImage(iconeTitulo);
		this.setVisible(true);

	}

	public Fase getFase() {
		return fase;
	}
}
