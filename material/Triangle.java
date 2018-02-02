import java.util.Scanner;
import java.lang.Math;

public class Triangle
{
	public static void main(String[] args)
	{
		double v1x, v1y;
		double v2x, v2y;
		double v3x, v3y;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter the coordinates of the " +
			"vertices of the Triangle");

		v1x = scanner.nextDouble();
		v1y = scanner.nextDouble();

		v2x = scanner.nextDouble();
		v2y = scanner.nextDouble();

		v3x = scanner.nextDouble();
		v3y = scanner.nextDouble();

		System.out.printf("v1=(%f,%f)\nv2=(%f,%f)\nv3=(%f,%f)\n",
			v1x, v1y, v2x, v2y, v3x, v3y);

		double e1x = v2x - v1x;
		double e1y = v2y - v1y;

		double e2x = v3x - v1x;
		double e2y = v3y - v1y;

		double e3x = v3x - v2x;
		double e3y = v3y - v2y;

		double A = (e1x*e2y - e1y*e2x)/2.0;
		A = Math.abs(A);

		if(A < 1e-10)
		{
			System.out.println("This is not a triangle");
		}

		if(Math.abs(A-0.5) < 1e-10)
		{
			System.out.println("This is an easy triangle");
		}

		System.out.println("The area is " + A);

		double a = Math.sqrt(e3x*e3x + e3y*e3y);
		double b = Math.sqrt(e2x*e2x + e2y*e2y);
		double c = Math.sqrt(e1x*e1x + e1y*e1y);

		double angleA = Math.acos((a*a - b*b - c*c)/(-2 * b * c));

		System.out.println("The angle A is " + angleA);
	}
}



