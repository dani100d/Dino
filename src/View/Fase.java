package View;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;

import Model.Inimigo;
import Model.Jogo;
import Model.Mapa;
import Model.Picterodatilo;
import Model.Sprite;

public class Fase extends Jogo {

	private static final long serialVersionUID = 1L;

	private Mapa fundo, colisao;
	private Sprite personagem;
	private Camera camera;
	private Inimigo inimigo;
	private static ArrayList<Rectangle> retangulosColisao;

	public Fase(String img) {
		super(img);
		Load(img);

	}

	@Override
	public void Load(String img) {
		fundo = new Mapa("fundojogo.jpg", "fundo.txt");
		colisao = new Mapa("fundojogo.jpg", "colisao.txt");
		retangulosColisao= colisao.montarColi();
		fundo.montarMapa();

		inimigo = new Inimigo();
		try {
			personagem = new Sprite(img, 0, 4, 12, 50, 413);
		} catch (IOException e) {

		}

		
		camera = new Camera(personagem, fundo,inimigo);
		setVisible(false);

	}

	@Override
	public void Update() {
		fundo.montarMapa();
		camera.renderinzar();
	}

	@Override
	public void Render() {
		camera.draw(g);
		// g.drawImage(fundo.getMapa(), 0, 0, null);
		// g.drawImage(personagem.sprites[personagem.aparencia], personagem.getX(),
		// personagem.getY(), null);

	}

	public Mapa getFundo() {
		return fundo;
	}

	public Sprite getPersonagem() {
		return personagem;
	}

	public Inimigo getInimigo() {
		return inimigo;
	}

	public static ArrayList<Rectangle> getRetangulosColisao() {
		return retangulosColisao;
	}

	public static void setRetangulosColisao(ArrayList<Rectangle> retangulosColisao) {
		Fase.retangulosColisao = retangulosColisao;
	}

}
