package view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import game.GameObject;

public class TopView implements GameView {

	@Override
	public void draw(Graphics2D g2d, ArrayList<GameObject> data) {
		g2d.setColor(Color.red);
		for (GameObject object : data) {
			drawObject(g2d, object);
		}

	}

	private void drawObject(Graphics2D g2d, GameObject object) {
		g2d.drawRect((int) object.getX(), (int) object.getY(), object.getSizeX(), object.getSizeY());
	}

}
