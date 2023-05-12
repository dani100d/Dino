package Model;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import View.Fase;

public class Sprite extends Thread {

	private int x, y;
	private int altura, largura;
	private int rows, columns;
	public int aparencia;
	public BufferedImage[] sprites;
	private BufferedImage spriteSheet;
	private Boolean pulando, abaixando;
	private Point ponto = new Point(128, 320);

	public Sprite(String url, int aparencia, int columns, int rows, int posX, int posY) throws IOException {
		spriteSheet = ImageIO.read(getClass().getClassLoader().getResource(url));
		this.aparencia = aparencia;
		this.pulando = false;
		this.abaixando = false;

		this.largura = spriteSheet.getWidth() / columns;
		this.altura = spriteSheet.getHeight() / rows;

		this.setRows(columns);
		this.setColumns(rows);
		this.x = posX;
		this.y = posY;

		sprites = new BufferedImage[columns * rows];
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				sprites[(i * rows) + j] = spriteSheet.getSubimage(i * largura, j * altura, largura, altura);
			}
		}
	}

	public boolean colisao(ArrayList<Rectangle> tmp, int x, int y) {
		Rectangle personagem = new Rectangle(getX() + x, getY() + y, getLargura(), getAltura());
		for (Rectangle rectangle : tmp) {
			if (rectangle.intersects(personagem)) {
				System.out.println("colidiu");
				return true;
			}
		}
		return false;

	}

	public void setX(int posX) {
		// if (!colisao(Fase.getRetangulosColisao(), posX - this.x, 0)) {
		this.x = posX;
		// }
	}

	public void setY(int posY) {
		// if (!colisao(Fase.getRetangulosColisao(), 0, posY - this.y)) {
		this.y = posY;
		//}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}

	public int getAltura() {
		return altura;
	}

	public int getLargura() {
		return largura;
	}

	public Point getPonto() {
		return ponto;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public Boolean getPulando() {
		return pulando;
	}

	public void setPulando(Boolean pulando) {
		this.pulando = pulando;
	}

	public Boolean getAbaixando() {
		return abaixando;
	}

	public void setAbaixando(Boolean abaixando) {
		this.abaixando = abaixando;
	}

}
