package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import Model.Inimigo;
import Model.Picterodatilo;
import Model.Sprite;
import Model.Triceraptor;
import View.Fase;
import View.Janela;
import View.Menu;

public class Controle implements KeyListener, ActionListener, Runnable {
	private Janela janela;
	private Movimento mover;
	private Pulo pulo;
	private Abaixar abaixar;
	private Fase fase;
	private int add;
	private Menu menu;

	private Dancar dancar;
	private Sprite personagem;
	private Inimigo inimigo;

	public Controle(Janela janela) {
		this.janela = janela;
		this.fase= janela.getFase();
		this.menu= janela.getMenu();
		this.mover = new Movimento(fase.getPersonagem());
		this.pulo = new Pulo(fase.getPersonagem());
		this.dancar = new Dancar(fase.getPersonagem());
		this.abaixar = new Abaixar(fase.getPersonagem());
		this.personagem = fase.getPersonagem();
		this.inimigo = fase.getInimigo();
		this.add= 0;

		addFase();
	}

	public void addFase() {
		
		janela.setVisible(true);
		fase.addKeyListener(mover);
		fase.addKeyListener(pulo);
		fase.addKeyListener(dancar);
		fase.addKeyListener(abaixar);
		fase.addKeyListener(this);
		fase.requestFocus();
		menu.getJogar().addActionListener(this);
	}

	public void atualizarTela() {

	}

	@Override
	public void run() {
		while (true) {
			try {
				atualizarTela();
				Thread.sleep(100);
				adicionarInimigo();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public Movimento getMover() {
		return mover;
	}

	public void adicionarInimigo() {
		
		try {
			if(personagem.getX()>100 && add ==0){
				Picterodatilo pic1 = new Picterodatilo("picRoxo.png", 8, 9, 1, 500, 400);
				Picterodatilo pic2 = new Picterodatilo("picRed.png", 8, 9, 1, 1000, 100);
				inimigo.getPicterodatilos().add(pic1);
				inimigo.getPicterodatilos().add(pic2);
                add++;
			}
			else if(personagem.getX()> 150 && add==1) {
				Triceraptor tri= new Triceraptor("tri.png",9,2,9,800,408);
				inimigo.getTriceraptores().add(tri);
				add++;
			tri.setControle(1);
				
			}
		} catch (IOException e) {

		}
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==menu.getJogar()) {
			menu.getJogar().setVisible(false);
			janela.setSize(1024,544);
			fase.setVisible(true);
			fase.requestFocus();
		}
		
	}

}
