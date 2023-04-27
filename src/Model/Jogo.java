package Model;


import javax.swing.JPanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Jogo extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;

	//dimensões
		public static final int  LARGURA=1200;
		public static final int  ALTURA=618;
	
	private Thread thread;
	private boolean running;
	
	private BufferedImage image;
	protected Graphics2D g;
	private int FPS = 1;

	@SuppressWarnings("unused")
	private Double averageFPS;

	public Jogo(String img) {
		super();
		setPreferredSize(new Dimension(LARGURA,ALTURA));
		setFocusable(true);
		requestFocus();
		Load(img);
		setVisible(true);
	}
	
	public abstract void Load(String img);
	
	 public void terminate() {
		 
	     running=false;
	    }
	 public void addNotify() {
			super.addNotify();

			if (thread == null) {
				thread = new Thread(this);
				thread.start();
			}
		}

	// Funçoes
	public void run() throws java.lang.NullPointerException {
		running = true;

		image = new BufferedImage(LARGURA,ALTURA, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();

		long startTime;
		long URDTimeMillis;
		long waitTime;
		long totalTime = 0;

		int frameCount = 0;
		int maxFrameCount = 30;

		long tragetTime = 100 / FPS;

		// Looping do Jogo
		while (running) {
			startTime = System.nanoTime();
			try {
			

				Update();
				Render();
				gameDraw();

				URDTimeMillis = (System.nanoTime() - startTime) / 1000000;
				waitTime = tragetTime - URDTimeMillis;
				Thread.sleep(waitTime);
				
			} catch (java.lang.NullPointerException e ) {
				
			} catch (java.lang.IllegalArgumentException v ) {
				
			}  catch (InterruptedException e) {
		
			}
			
			totalTime += System.nanoTime() - startTime;
			frameCount++;

			if (frameCount == maxFrameCount) {
				averageFPS = 1000.0 / ((totalTime / frameCount) / 1000000);
				frameCount = 0;
				totalTime = 0;
			}
		}
		
		gameDraw();
	}

	public abstract void Update();
	
	public abstract void Render();

	private void gameDraw() {
		Graphics2D g2 = (Graphics2D) this.getGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();
	}
	public void setRunning(boolean running) {
		this.running = running;
	}
	public boolean isRunning() {
		return running;
	}

}
