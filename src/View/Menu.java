package View;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel{

	private JLabel fundo;
	private JButton jogar;
	private ImageIcon imagem;

	public Menu(int largura, int altura) {

		setPreferredSize(new Dimension(largura, altura));
		setLayout(null);
		jogar = new JButton();
		jogar.setContentAreaFilled(false);
		jogar.setBorder(null);
		jogar.setBounds(160, 448, 125, 63);
		jogar.setIcon(new ImageIcon(getClass().getResource("/jogar.png")));
		fundo = new JLabel(new ImageIcon(getClass().getResource("/menu.jpg")));
		fundo.setBounds(0, 0, 800, 600);
		add(jogar);
		add(fundo);
		
		setVisible(true);
	}
	
	public JLabel getFundo() {
		return fundo;
	}

	public void setFundo(JLabel fundo) {
		this.fundo = fundo;
	}

	public JButton getJogar() {
		return jogar;
	}

	public void setJogar(JButton jogar) {
		this.jogar = jogar;
	}

	public ImageIcon getImagem() {
		return imagem;
	}

	public void setImagem(ImageIcon imagem) {
		this.imagem = imagem;
	}

}
