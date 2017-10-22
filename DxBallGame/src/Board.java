import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements GameConstants{
private Timer timer;
Bar bar=new Bar();
int brickHeight=50;
int brickWidth=70;
private boolean isGameOver;
Ball ball=new Ball();
static GameUtils g=new GameUtils(20);
private int row=10;
private int column=3;
Tiles[][] tiles=new Tiles[row][column];
public void prepareTiles()
{for(int i=0;i<row;i++)
{for(int j=0;j<column;j++)
{Tiles tile=new Tiles((i+1)*brickWidth,(j+1)*brickHeight,brickWidth,brickHeight);
	tiles[i][j]=tile;}
}
}
	public void drawGameOver(Graphics g)
	{String val="GameOver";
	isGameOver=true;
		for(int i=0;i<row;i++)
			{for(int j=0;j<column;j++)
			{if(tiles[i][j].isVisible())
			{isGameOver=false;
				break;
			
			}
			}
			
			
			}
		if(isGameOver)
		{g.setColor(Color.RED);
			g.setFont(new Font("Arial",Font.BOLD,46));
			g.drawString(val, GAME_WIDTH/2, GAME_HEIGHT/2);
		timer.stop();
		}
			}
		
	
	

public void bindEvent()
{
	this.addKeyListener(new KeyAdapter() {
		public void keyReleased(KeyEvent e)
		{bar.stop();
		}
		public void keyPressed(KeyEvent e)
		{
			if(e.getKeyCode()==KeyEvent.VK_RIGHT)
			{
			if( bar.getX()<GAME_WIDTH-bar.getW()-10)
			bar.moveRight();
			else
				{bar.stop();
				}
			}
			if(e.getKeyCode()==KeyEvent.VK_LEFT)
				{
				if(bar.getX()>0)
				
				{bar.moveLeft();
				}
				else
					{bar.stop();
					}
					}
		}
				
		
	});
}
public Board()
{setSize(GAME_WIDTH,GAME_HEIGHT);
setBackground(Color.black);
prepareTiles();
gameLoop();
setFocusable(true);
bindEvent();
	
}
public void gameLoop()
{timer=new Timer(GAME_SPEED,(e)->{
	repaint();
	ball.changeDirection();
	ball.move();
	if(ball.getBounds().intersects(bar.getBounds()))
	{
		ball.setXspeed(-g.getRandomNumber());
		ball.setYspeed(-g.getRandomNumber());
	}
	if(ball.getBounds().intersects(bar.getBounds1()))
	{
		ball.setXspeed(g.getRandomNumber());
		ball.setYspeed(-g.getRandomNumber());
	}
	for(int i=0;i<row;i++)
	{for(int j=0;j<column;j++)
	if(ball.getBounds().intersects(tiles[i][j].getBounds()))
	{
	tiles[i][j].setVisible(false);	
	}
	}

	
});
timer.start();
	
}
public void paintComponent(Graphics g)
{super.paintComponent(g);
bar.move();
bar.drawBar(g);
for(int i=0;i<row;i++)
{for(int j=0;j<column;j++)
	if(!isGameOver)
	{
	if(tiles[i][j].isVisible())
		{tiles[i][j].drawTiles(g);
		}
		}
}
drawGameOver(g);
if(ball.check())
{String val1="You Lose";
g.setColor(Color.RED);
	g.setFont(new Font("Arial",Font.BOLD,46));
g.drawString(val1, GAME_WIDTH/2, GAME_HEIGHT/2);
	timer.stop();
}

ball.drawBall(g);
}
}

