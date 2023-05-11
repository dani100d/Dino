package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;

public class Janela extends JFrame {
	
	private static final long serialVersionUID = -3338597443822445438L;
	private Menu menu;

	private Fase fase;

	public Janela(int largura, int altura) {

		setPreferredSize(new Dimension(largura, altura));
		setLayout(new FlowLayout());

		setSize(largura, altura);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);

		//Image iconeTitulo = Toolkit.getDefaultToolkit().getImage("baseDados\\caverna.png");
		//this.setIconImage(iconeTitulo);
		this.fase = new Fase("ok.png");
		this.menu= new Menu(719, 713);
		add(fase);
		add(menu);
		this.setVisible(true);

	}

	public Fase getFase() {
		return fase;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}
	
}
