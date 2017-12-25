package game;

import modelephysique.Vecteur;

public class GameObject {
	private Vecteur position;
	private int type, z = 0;
	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	private int sizeX = 10, sizeY = 10, sizeZ = 20;
	
	public GameObject(double x, double y, int type) {
		this(new Vecteur(x, y), type);
	}

	public Vecteur getPosition() {
		return position;
	}

	public void setPosition(Vecteur position) {
		this.position = position;
	}

	public GameObject(Vecteur position, int type) {
		this.position = position;
		this.type = type;
	}

	public GameObject getProjectedFromAngle(double angle) {
		Vecteur vecteur = Vecteur.vecteurAvecAngle(1000, angle);

		Vecteur proj1 = Vecteur.projectionOrthogonale(position, vecteur);

		Vecteur proj1_2 = proj1.rotate(-angle);
		// Vecteur.projectionOrthogonale(proj1,new Vecteur(1000, 0));

		return new GameObject(new Vecteur(proj1_2.getX(), proj1_2.getY()), type);

	}

	public double getX() {
		return position.getX();
	}

	public double getY() {
		return position.getY();
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSizeX() {
		return sizeX;
	}

	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}

	public int getSizeZ() {
		return sizeZ;
	}

	public void setSizeZ(int sizeZ) {
		this.sizeZ = sizeZ;
	}

}
