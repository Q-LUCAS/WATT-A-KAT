package testwoula;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;


public class joueur {
	
	private float x = 300, y = 300;
	private int direction = 2;
	private boolean moving = false;
	private Animation[] animations = new Animation[8];

	private Map map;

	public joueur(Map map) {
		this.map = map;
	}

	public void init() throws SlickException {
		SpriteSheet chat = new SpriteSheet("F:\\eclipse-workspace\\WAT-A-KAT\\src\\main\\ressources\\sprite\\chat.png", 64, 64);
		this.animations[0] = loadAnimation(chat, 0, 1, 0);
		this.animations[1] = loadAnimation(chat, 0, 1, 1);
		this.animations[2] = loadAnimation(chat, 0, 1, 2);
		this.animations[3] = loadAnimation(chat, 0, 1, 3);
		this.animations[4] = loadAnimation(chat, 1, 9, 0);
		this.animations[5] = loadAnimation(chat, 1, 9, 1);
		this.animations[6] = loadAnimation(chat, 1, 9, 2);
		this.animations[7] = loadAnimation(chat, 1, 9, 3);
	}

	private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
		Animation animation = new Animation();
		for (int x = startX; x < endX; x++) {
			animation.addFrame(spriteSheet.getSprite(x, y), 100);
		}
		return animation;
	}

	public void render(Graphics g) {
		g.setColor(new Color(0, 0, 0, .5f));
		g.fillOval((int) x - 16, (int) y - 8, 32, 16);
		g.drawAnimation(animations[direction + (moving ? 4 : 0)],  x - 32,  y - 50);
	}

	
		
	
	
	public void update(int delta) {
	
		if (this.moving) {
			float futurX = getFuturX(delta);
			float futurY = getFuturY(delta);
			boolean collision = this.map.isCollision(futurX, futurY);
			if (collision) {
				this.moving = false;
			} else {
				this.x = futurX;
				this.y = futurY;
			}
		}
	}

	private float getFuturX(int delta) {
		float futurX = this.x;
		switch (this.direction) {
		case 1:
			futurX = this.x - 1f * delta;
			break;
		case 3:
			futurX = this.x + 1f * delta;
			break;
		}
		return futurX;
	}

	private float getFuturY(int delta) {
		float futurY = this.y;
		switch (this.direction) {
		case 0:
			futurY = this.y - 1f * delta;
			break;
		case 2:
			futurY = this.y + 1f * delta;
			break;
		}
		return futurY;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

}
