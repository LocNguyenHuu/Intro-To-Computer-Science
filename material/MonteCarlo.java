import java.lang.Math;

public class MonteCarlo
{
	public static void main(String[] args)
	{
		double numberOfHits = 0;
		long numberOfTrials = 0;

		// for(int t = 0; t < numberOfTrials; t++)
		while(true)
		{
			double x = Math.random()*2 - 1;
			double y = Math.random()*2 - 1;

			double ns = x*x + y*y;

			if(ns <= 1)
			{
				numberOfHits++;
			}

			numberOfTrials++;

			if(numberOfTrials % 100 == 0)
			{
				double approxPI = 4.0 * numberOfHits / numberOfTrials;
				System.out.println("approx pi " + approxPI + "\treal PI " + Math.PI);
			}
		}
	}
}



