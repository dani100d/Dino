package View;

import java.io.IOException;

import Model.Inimigo;
import Model.Jogo;
import Model.Mapa;
import Model.Picterodatilo;
import Model.Sprite;

public class Fase extends Jogo {

	private static final long serialVersionUID = 1L;

	private Mapa fundo;
	private Sprite personagem;
	private Camera camera;
	private Inimigo inimigo;

	public Fase(String img) {
		super(img);
		Load(img);

	}

	@Override
	public void Load(String img) {
		fundo = new Mapa("fase1.png", "fundo.txt");
		fundo.montarMapa();

		inimigo = new Inimigo();
		try {
			personagem = new Sprite(img, 0, 4, 12, 50, 440);
		} catch (IOException e) {

		}

		try {
			Picterodatilo pic1 = new Picterodatilo("picRoxo.png", 8, 9, 1, 500, 400);
			Picterodatilo pic2 = new Picterodatilo("picRed.png", 8, 9, 1, 1000, 100);
			inimigo.getPicterodatilos().add(pic1);
			inimigo.getPicterodatilos().add(pic2);

		} catch (IOException e) {

		}
		camera = new Camera(personagem, fundo,inimigo);
		setVisible(true);

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

}
