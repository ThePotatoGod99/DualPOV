package view;

import java.awt.Graphics2D;
import java.util.ArrayList;

import game.GameObject;

public interface GameView {

	public void draw(Graphics2D g2d, ArrayList<GameObject> data);

}
