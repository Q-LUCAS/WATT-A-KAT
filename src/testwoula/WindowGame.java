package testwoula;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
//import org.newdawn.slick.Music;

public class WindowGame extends BasicGame {

	private GameContainer container;
	private Map map = new Map();
	private joueur joueur = new joueur(map);
	
	public static void main(String[] args) throws SlickException {
		new AppGameContainer(new WindowGame(), 1920, 1080, true).start();
	}

	public WindowGame() {
		super("WATT-A-KAT");
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		this.container = container;
		//Music background = new Music("F:\\eclipse-workspace\\WAT-A-KAT\\src\\main\\ressources\\music\\nyan-cat-original.ogg");
		//background.loop();
		this.map.init();
		this.joueur.init();
		Direction controler = new Direction(this.joueur);
		container.getInput().addKeyListener(controler);
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		this.map.render();
		this.joueur.render(g);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		this.joueur.update(delta);
	}

	@Override
	public void keyReleased(int key, char c) {
		if (Input.KEY_ESCAPE == key) {
			this.container.exit();
		}
		
	}

	@Override
	public void keyPressed(int key, char c) {
	}
	
}