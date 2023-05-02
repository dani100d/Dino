package View;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Model.Inimigo;
import Model.Mapa;
import Model.Picterodatilo;
import Model.Sprite;
import Model.Triceraptor;

public class Camera {
	private Sprite personagem;
	private Mapa mapa;

	static int x = 0;
	static int y = 0;
	private BufferedImage tela;
	private Graphics g;
	private Inimigo inimigo;

	public Camera(Sprite personagem, Mapa mapa, Inimigo inimigo) {
		super();
		this.personagem = personagem;
		this.mapa = mapa;
		this.inimigo = inimigo;

		tela = new BufferedImage(mapa.getMapaLargura(), mapa.getMapaAltura(), BufferedImage.TYPE_4BYTE_ABGR);
		g = tela.getGraphics();
		mapa.montarMapa();

	}

	public void renderinzar() {

		g.drawImage(mapa.getMapa(), 0, 0, null);

		for (int i = 0; i < inimigo.getPicterodatilos().size(); i++) {

			Picterodatilo pic = (Picterodatilo) inimigo.getPicterodatilos().get(i);

			g.drawImage(pic.sprites[pic.aparencia], pic.getX(), pic.getY(), null);

		}
		
		for (int i = 0; i < inimigo.getTriceraptores().size(); i++) {

			Triceraptor tri = (Triceraptor) inimigo.getTriceraptores().get(i);

			g.drawImage(tri.sprites[tri.aparencia], tri.getX(), tri.getY(), null);

		}
		
		g.drawImage(personagem.sprites[personagem.aparencia], personagem.getX(), personagem.getY(), null);

	}

	public void draw(Graphics g) {
		if (personagem.getX() > Fase.LARGURA / 2)
			if (personagem.getX() < (mapa.getMapaLargura() - Fase.LARGURA / 2))
				x = personagem.getX() - (Fase.LARGURA / 2);
		if (personagem.getY() > Fase.ALTURA / 2)
			if (personagem.getY() < (mapa.getMapaAltura() - Fase.ALTURA / 2))
				y = personagem.getY() - Fase.ALTURA / 2;

		g.drawImage(tela, -x, -y, null);
	}

	public Inimigo getInimigo() {
		return inimigo;
	}

}
