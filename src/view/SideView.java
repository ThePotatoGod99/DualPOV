package view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import game.GameObject;
import modelephysique.Vecteur;

public class SideView implements GameView {
	private double angle;
	private Vecteur origin;

	public SideView(Vecteur origin, double angle) {
		this.angle = angle;
		this.origin = origin;
	}

	@Override
	public void draw(Graphics2D g2d, ArrayList<GameObject> data) {
		// TODO Auto-generated method stub
		g2d.setColor(Color.blue);

		for (GameObject object : data) {
			drawObject(g2d, object);
		}

	}

	private void drawObject(Graphics2D g2d, GameObject object) {
		// g2d.drawRect((int) (object.getX() ), object.getZ(), object.getSizeX(),
		// object.getSizeZ());

		Vecteur BC = Vecteur.vecteurAvecAngle(1000, angle);

		g2d.draw(BC.ligne(origin));

		Vecteur OA = object.getPosition();
		g2d.setColor(Color.red);
		g2d.draw(OA.ligne());

		Vecteur OAOB = OA.soustrait(origin);
		g2d.setColor(Color.cyan);
		g2d.draw(OAOB.ligne(origin));

		Vecteur proj1 = Vecteur.projectionOrthogonale(OAOB, BC);
		g2d.setColor(Color.BLUE);
		g2d.draw(proj1.ligne(origin));

		Vecteur proj1_2 = proj1.rotate(-angle);
		g2d.setColor(Color.GREEN);
		g2d.draw(proj1_2.ligne(new Vecteur(origin.getX(), 0)));

		g2d.drawRect((int) (proj1_2.getX() + origin.getX()), object.getZ(), object.getSizeX(), object.getSizeZ());
	}

}
