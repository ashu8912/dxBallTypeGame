import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Ball implements GameConstants{
	private int x;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getXspeed() {
		return xspeed;
	}
	public void setXspeed(int xspeed) {
		this.xspeed = xspeed;
	}
	public int getYspeed() {
		return yspeed;
	}
	public void setYspeed(int yspeed) {
		this.yspeed = yspeed;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	private int y;
	private int w;
	private int h;
	private int speed=6;
	private int xspeed;
	private int yspeed;
	public boolean check()
	{
		return y>=GAME_HEIGHT-h;
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
	private Image image;
	public Ball()
	{loadImages();
		this.x=GAME_WIDTH/2;
		this.y=GAME_HEIGHT/2;
		this.w=40;
		this.h=40;
		xspeed=yspeed=speed;
	}
	public void move()
	{
		x+=xspeed;
		y+=yspeed;
	}
	public void changeDirection()
	{
		if(x<=0)
		{
			xspeed=speed;
		}
		if(x>=GAME_WIDTH-2*w)
		{
			xspeed=-speed;
		}
		if(y<=0)
		{
			yspeed=speed;
		}
	}
	public Rectangle getBounds()
	{
		return new Rectangle(x, y, w, h);
	}
	public void loadImages()
	{image=new ImageIcon(Ball.class.getResource("ball.gif")).getImage();
	}
	public void drawBall(Graphics g)
	{
		g.drawImage(image, x, y,w,h,null);
	}

}
