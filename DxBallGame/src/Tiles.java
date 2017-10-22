import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Tiles implements GameConstants {
	private int x;
	private int y;
	private int w;
	private int h;
	private Color color;
	private boolean isVisible;
	public Tiles(int x,int y,int w,int h)
	{isVisible=true;
		this.h=h;
	this.w=w;
		this.x=x;
		this.y=y;
	}
	public boolean isVisible() {
		return isVisible;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	public Rectangle getBounds()
	{return new Rectangle(x,y,w,h);
		
	}
public void drawTiles(Graphics g)
{
	g.setColor(Color.WHITE);
	g.fillRect(x,y, w, h);
g.setColor(color.black);
g.drawRect(x, y, w, h);
}
}
