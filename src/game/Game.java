package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import modelephysique.Vecteur;
import view.GameView;
import view.SideView;
import view.TopView;

public class Game extends JPanel implements Runnable {

	public void run() {
		while (animating) {
			if (!paused) {
				angle += 0.01;
				repaint();

			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("Processus interrompu!");
			}
		}
	}

	public double angle = Math.PI / 12;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<GameObject> data = new ArrayList<GameObject>();
	private int xd = 1;

	private GameObject object;

	private int x = 200, y = 200;
	private boolean animating = false, paused = false;

	public Game() {
		this.setBackground(Color.black);
		object = new GameObject(x, y, 2);
		data.add(new GameObject(350, 200, 2));
		data.add(object);

		Thread thread = new Thread(this);
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				if (xd == -1) {
					// angle += Math.PI / 6;
				}
				xd *= -1;
				if (!animating) {
					animating = true;
					thread.start();
					paused = false;
				} else if (!paused) {
					paused = true;
				} else {
					paused = false;
				}
				repaint();
			}

		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(0, getHeight() - 1);
		g2d.scale(1, -1);

		/* Grid */

		/*
		 * g2d.setColor(Color.yellow);
		 * 
		 * Vecteur BC = Vecteur.vecteurAvecAngle(1000, angle); Vecteur OB = new
		 * Vecteur(getWidth()/2, getHeight()/2);
		 * 
		 * g2d.draw(BC.ligne(OB));
		 * 
		 * Vecteur OA = new Vecteur(x, y); g2d.setColor(Color.red);
		 * g2d.draw(OA.ligne());
		 * 
		 * Vecteur OAOB = OA.soustrait(OB); g2d.setColor(Color.cyan);
		 * g2d.draw(OAOB.ligne(OB));
		 * 
		 * Vecteur proj1 = Vecteur.projectionOrthogonale(OAOB, BC);
		 * g2d.setColor(Color.BLUE); g2d.draw(proj1.ligne(OB));
		 * 
		 * Vecteur proj1_2 = proj1.rotate(-angle);
		 * 
		 * g2d.setColor(Color.GREEN); g2d.draw(proj1_2.ligne(new Vecteur(getWidth()/2,
		 * 0))); System.out.println(proj1_2.toString());
		 */
		GameView gameview = new TopView();

		// gameview.draw(g2d, data);
		 GameView side = new SideView(new Vecteur(getWidth()/2, getHeight()/2), angle);
		 side.draw(g2d, data);

	}

}
