import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Bar implements GameConstants{
	private int x;
	private Image image;
	private int y;
	private int w;
	private int h;

	private int xspeed;
	private int yspeed;
	final int speed=10;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	public void loadImage()
	{
		image=new ImageIcon
	(Bar.class.getResource("rectangularBar.png")).getImage();
				
	}
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, w/2, h/2);
	}
	public Rectangle getBounds1()
	{
		return new Rectangle(x+w/2,y,w/2,h/2);
	}
	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public void stop()
	{
		xspeed=0;
		yspeed=0;
	}
	public Bar()
	{h=40;
	w=200;
	loadImage();
		x=GAME_WIDTH/2-w;
		y=GAME_HEIGHT-2*h;
		xspeed=0;
		yspeed=0;
	}
	public void move()
	{
		x+=xspeed;
		y+=yspeed;
	}
	public void moveLeft()
	{
		xspeed=-speed;
	}
	public void moveRight()
	{
		xspeed=speed;
	}
	public void drawBar(Graphics g)
	{//g.setColor(Color.green);
		g.drawImage(image,x, y, w, h,null);
	}

}
