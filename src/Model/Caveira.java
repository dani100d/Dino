package Model;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Caveira extends Thread {
	private int x, y;
	private int altura, largura;
	private int rows, columns;
	public int aparencia;
	public BufferedImage[] sprites;
	private BufferedImage spriteSheet;
	private Boolean pulando, abaixando;
	private Boolean ativo;
	private int pulo, left;
	private Point ponto = new Point(655,515);

	public Caveira(String url, int aparencia, int columns, int rows, int posX, int posY) throws IOException {
		spriteSheet = ImageIO.read(getClass().getClassLoader().getResource(url));
		this.aparencia = aparencia;
		this.pulando = false;
		this.abaixando = false;
		this.ativo = true;
		this.pulo = 4;
		this.left = 0;
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
		start();
	}

	public boolean colisao(ArrayList<Rectangle> tmp, int x, int y) {
		Rectangle personagem = new Rectangle(getX() + x, getY() + y, getLargura(), getAltura());
		for (Rectangle rectangle : tmp) {
			if (rectangle.intersects(personagem)) {
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
		// }
	}

	@Override
	public void run() {
		while (ativo) {
			try {
				animar();
				sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void animar() {
		for(int i=0;i<6;i++) {
			try {
				sleep(10);
				//this.setX(this.getX() - pulo);
				switch (left) {
				case 0:
					this.aparencia = 0;
					break;
				case 1:
					this.aparencia = 3;
					break;
				case 2:
					this.aparencia = 1;
					break;
				case 3:
					this.aparencia = 4;
					break;
				case 4:
					this.aparencia = 2;
					break;
				case 5:
					this.aparencia = 5;
					break;
				
				}
				if (left == 5)
					left = 0;
				else
					left++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
