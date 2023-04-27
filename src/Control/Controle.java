package Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Model.Inimigo;
import Model.Sprite;
import View.Fase;
import View.Janela;

public class Controle implements KeyListener, Runnable {
	private Janela janela;
	private Movimento mover;
	private Pulo pulo;
	private Abaixar abaixar;
	private Fase fase;

	private Dancar dancar;
	private Sprite personagem;
	private Inimigo inimigo;

	public Controle(Janela janela) {
		this.janela = janela;
		this.fase = new Fase("ok.png");
		this.mover = new Movimento(fase.getPersonagem());
		this.pulo = new Pulo(fase.getPersonagem());
		this.dancar = new Dancar(fase.getPersonagem());
		this.abaixar = new Abaixar(fase.getPersonagem());
		this.personagem = fase.getPersonagem();
		this.inimigo = fase.getInimigo();

		addFase();
	}

	public void addFase() {
		janela.add(fase);
		janela.setVisible(true);
		fase.addKeyListener(mover);
		fase.addKeyListener(pulo);
		fase.addKeyListener(dancar);
		fase.addKeyListener(abaixar);
		fase.addKeyListener(this);
		fase.requestFocus();
	}

	public void atualizarTela() {

	}

	@Override
	public void run() {
		while (true) {
			try {
				atualizarTela();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public Movimento getMover() {
		return mover;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	public Sprite getPersonagem() {
		return personagem;
	}

	public Inimigo getInimigo() {
		return inimigo;
	}

}
