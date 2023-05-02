package Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import Model.Sprite;

public class Movimento extends Thread implements KeyListener {

	Sprite personagem;
	int up, down, left, right;
	static HashMap<Integer, Boolean> keyPool;
	private int pulo = 4;
	private boolean ativo = true;

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Movimento(Sprite player1) {
		this.personagem = player1;
		keyPool = new HashMap<Integer, Boolean>();
		start();

	}

	public void keyPressed(KeyEvent e) {
		
		keyPool.put(e.getKeyCode(), true);
		
	}
	public void keyReleased(KeyEvent e) {

		keyPool.remove(e.getKeyCode());

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			personagem.aparencia = 0;
		}
		
	}

	public void keyTyped(KeyEvent e) {
	}

	public void run() {
		ativo = true;
		while (ativo) {

			try {
				if(!personagem.getAbaixando() && !personagem.getPulando()) {
					mover();
				}
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void mover() {

		
		if (keyPool.get(KeyEvent.VK_RIGHT) != null) {

			personagem.setX(personagem.getX() + pulo);

			switch (right) {
			case 0:
				personagem.aparencia = 24;
				break;
			case 1:
				personagem.aparencia = 25;
				break;
			case 2:
				personagem.aparencia = 26;
				break;
			case 3:
				personagem.aparencia = 27;
				break;
			case 4:
				personagem.aparencia = 28;
				break;
			case 5:
				personagem.aparencia = 29;
				break;
			case 6:
				personagem.aparencia = 30;
				break;
			case 7:
				personagem.aparencia = 31;
				break;
			case 8:
				personagem.aparencia = 32;
				break;
			}
			if (right == 8)
				right = 0;
			else
				right++;
		}

	}
}
