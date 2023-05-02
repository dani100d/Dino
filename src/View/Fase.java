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
		fundo = new Mapa("fundojogo.jpg", "fundo.txt");
		fundo.montarMapa();

		inimigo = new Inimigo();
		try {
			personagem = new Sprite(img, 0, 4, 12, 50, 408);
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

}
