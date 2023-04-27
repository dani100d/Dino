package Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import Model.Sprite;

public class Dancar extends Thread implements KeyListener {
	Sprite personagem;
	private boolean ativo = true;
	int right;
	int pulo, subida, descida;
	static HashMap<Integer, Boolean> keyPool;

	public Dancar(Sprite player1) {
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
				if (keyPool.get(KeyEvent.VK_SPACE) == null && keyPool.get(KeyEvent.VK_S) == null) {
						dancar();
					
				}
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void dancar() {

		for (int i = 0; i < 4; i++) {
			try {
				sleep(200);
				switch (right) {
				case 0:
					personagem.aparencia = 0;
					break;
				case 1:
					personagem.aparencia = 1;

					break;
				case 2:
					personagem.aparencia = 2;

					break;
				case 3:
					personagem.aparencia = 3;

				}
				right++;
				if (right == 3)
					right = 0;

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		personagem.aparencia = 0;
		ativo = true;

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

	}

}
