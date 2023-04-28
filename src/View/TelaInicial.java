package View;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaInicial extends JFrame {

	private JLabel label;

	public TelaInicial() {
		setLayout(new FlowLayout());
		setSize(792, 1058);
		//setUndecorated(true);

		//setExtendedState(MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		label = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("inicio.png")));

		label.setBounds(0, 0, 792, 1058);
		//label.setBackground(Color.black);

		

		setVisible(true);

	}
}
