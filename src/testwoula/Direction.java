package testwoula;

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;



public class Direction implements KeyListener {

	private joueur joueur;

	public Direction(joueur joueur) {
		this.joueur = joueur;
	}

	@Override
	public void keyReleased(int key, char c) {
		this.joueur.setMoving(false);
	}

	
	
	@Override
	public void setInput(Input input) {

	}

	@Override
	public boolean isAcceptingInput() {
		return true;
	}

	@Override
	public void inputEnded() {

	}

	@Override
	public void inputStarted() {

	}

	@Override
	public void keyPressed(int key, char c) {
		switch (key) {
		case Input.KEY_UP:
			this.joueur.setDirection(0);
			this.joueur.setMoving(true);
			break;
		case Input.KEY_LEFT:
			this.joueur.setDirection(1);
			this.joueur.setMoving(true);
			break;
		case Input.KEY_DOWN:
			this.joueur.setDirection(2);
			this.joueur.setMoving(true);
			break;
		case Input.KEY_RIGHT:
			this.joueur.setDirection(3);
			this.joueur.setMoving(true);
			break;
		}
	}

}
