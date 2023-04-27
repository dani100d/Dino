package Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import Model.Sprite;

public class Pulo extends Thread implements KeyListener {
	Sprite personagem;
	private boolean ativo = true;
	int right;
	int pulo, subida, descida;
	static HashMap<Integer, Boolean> keyPool;

	public Pulo(Sprite player1) {
		this.personagem = player1;
		keyPool = new HashMap<Integer, Boolean>();
		right = 0;
		pulo = 10;
		subida = 16;
		descida = 20;
		start();

	}

	public void run() {
		ativo = true;
		while (ativo) {
			try {
				if (keyPool.get(KeyEvent.VK_SPACE) != null) {
					personagem.setPulando(true);
					pular();
				}
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void pular() {
		System.out.println(personagem.getY());

		for (int i = 0; i < 11; i++) {
			try {
				sleep(100);
				switch (right) {
				case 0:
					personagem.aparencia = 38;
					break;
				case 1:
					personagem.aparencia = 38;

					break;
				case 2:
					personagem.aparencia = 38;
					break;
				case 3:
					personagem.aparencia = 39;
					personagem.setX(personagem.getX() + pulo);
					personagem.setY(personagem.getY() - subida);
					break;
				case 4:
					personagem.aparencia = 40;
					personagem.setX(personagem.getX() + pulo);
					personagem.setY(personagem.getY() - subida);
					break;
				case 5:
					personagem.aparencia = 41;
					personagem.setX(personagem.getX() + pulo);
					personagem.setY(personagem.getY() - subida);
					break;
				case 6:
					personagem.aparencia = 42;
					personagem.setX(personagem.getX() + pulo);
					personagem.setY(personagem.getY() - subida);
					break;
				case 7:
					personagem.aparencia = 43;
					personagem.setX(personagem.getX() + pulo);
					personagem.setY(personagem.getY() - subida);
					break;
				case 8:
					personagem.aparencia = 44;
					personagem.setX(personagem.getX() + pulo);
					personagem.setY(personagem.getY() + descida);
					break;
				case 9:
					personagem.aparencia = 45;
					personagem.setX(personagem.getX() + pulo);
					personagem.setY(personagem.getY() + descida);
					break;
				case 10:
					personagem.aparencia = 46;
					personagem.setX(personagem.getX() + pulo);
					personagem.setY(personagem.getY() + descida);
					break;
				case 11:
					personagem.aparencia = 47;
					personagem.setX(personagem.getX() + pulo);
					personagem.setY(personagem.getY() + descida);
					break;
				}
				System.out.println(personagem.getY());
				right++;
				if (right == 11)
					right = 0;

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		personagem.setY(personagem.getY() + descida);
		personagem.aparencia = 0;
		personagem.setPulando(false);

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
