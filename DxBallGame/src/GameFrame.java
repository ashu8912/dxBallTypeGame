import javax.swing.JFrame;


public class GameFrame extends JFrame implements GameConstants{
	
	public GameFrame()
	{
		setSize(GAME_WIDTH,GAME_HEIGHT);
		setLocationRelativeTo(null);
		Board board=new Board();	
		
		//setFocusable(true);
		
		add(board);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
GameFrame frame=new GameFrame();
	
	}

}
