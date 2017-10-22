

import java.util.Random;

public class GameUtils {
	Random r=new Random();
	int range;
	public GameUtils(int range)
	{this.range=range;
	r=new Random(range);
	}
	public int getRandomNumber()
	{
		return r.nextInt(this.range);
	}

}
