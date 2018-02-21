public class GameLife {
	public static void main(String[] args) throws InterruptedException
	{
		int n = 10;
		//False is dead
		boolean[][] alive = new boolean[n][n];

		randomFill(alive);
		print(alive);

		while(true)
		{
			System.out.print("\033[H\033[2J");
			System.out.flush();

			step(alive);
			print(alive);

			Thread.sleep(100);
		}
	}

	public static void step(boolean[][] alive)
	{
		boolean[][] newAlive = new boolean[alive.length][alive[0].length];

		///rules
		for (int row = 0; row < alive.length; row++) {
			for (int column = 0; column < alive[row].length; column++) {
				boolean isCellAlive = alive[row][column];
				int aliveNeighs = aliveNeighbours(alive, row, column);

				if(isCellAlive)
				{
					if(aliveNeighs < 2)
						newAlive[row][column] = false;
					else if(aliveNeighs == 2 || aliveNeighs == 3)
						newAlive[row][column] = true;
					else
						newAlive[row][column] = false;
				}
				else
				{
					if(aliveNeighs == 3)
						newAlive[row][column] = true;
				}
			}
		}

		for (int row = 0; row < alive.length; row++) {
			for (int column = 0; column < alive[row].length; column++) {
				alive[row][column] = newAlive[row][column];
			}
		}
	}

	public static int aliveNeighbours(boolean[][] alive, int i, int j)
	{
		int res = 0;

		int n = alive.length;

		//TODO consider the world to be infinite
		int startI = Math.max(i-1, 0);
		int startJ = Math.max(j-1, 0);

		int endI = Math.min(i+1, n-1);
		int endJ = Math.min(j+1, n-1);

		for (int row = startI; row <= endI; row++) {
			for (int column = startJ; column <= endJ; column++) {
				if(row == i && column == j)
					continue;

				if(alive[row][column])
				{
					res++;
				}
			}
		}

		return res;
	}

	public static void print(boolean[][] alive)
	{
		for (int row = 0; row < alive.length; row++) {
			for (int column = 0; column < alive[row].length; column++) {
				boolean isCellAlive = alive[row][column];

				String toPrint;

				if(isCellAlive)
				{
					toPrint = '\u2B1B' +"";
				}
				else
				{
					toPrint = "  ";
				}

				System.out.print(toPrint);
			}

			System.out.print("\n");
		}
		System.out.print("\n");
	}

	public static void randomFill(boolean[][] alive)
	{
		for (int row = 0; row < alive.length; row++) {
			for (int column = 0; column < alive[row].length; column++) {
				boolean value = Math.random() > 0.8;
				alive[row][column] = value;
			}
		}
	}
}