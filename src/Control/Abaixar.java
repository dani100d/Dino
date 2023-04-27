package Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import Model.Sprite;

public class Abaixar extends Thread implements KeyListener {
	Sprite personagem;
	private boolean ativo = true;
	int right;
	int pulo, subida, descida;
	static HashMap<Integer, Boolean> keyPool;

	public Abaixar(Sprite player1) {
		this.personagem = player1;
		keyPool = new HashMap<Integer, Boolean>();
		right = 0;
		pulo = 8;
		subida = 8;
		descida = 12;
		start();
	}

	public void run() {
		ativo = true;
		while (ativo) {
			try {
				if (keyPool.get(KeyEvent.VK_S) != null) {
					personagem.setAbaixando(true);
					abaixar();
				}
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void abaixar() {

		for (int i = 0; i < 6; i++) {
			try {
				sleep(100);
				switch (right) {
				case 0:
					personagem.aparencia = 12;

					break;
				case 1:
					personagem.aparencia = 13;

					break;
				case 2:
					personagem.aparencia = 14;
					sleep(100);

					break;
				case 3:
					personagem.aparencia = 15;
					sleep(100);

					break;
				case 4:
					personagem.aparencia = 16;
					sleep(100);
					break;
				case 5:

					personagem.aparencia = 17;
					sleep(100);
					break;

				}
				
				if (right == 5)
					right = 0;
				else
					right++;

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		personagem.aparencia = 0;
		personagem.setAbaixando(false);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keyPool.put(e.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keyPool.remove(e.getKeyCode());
		personagem.aparencia = 37;

	}

}
