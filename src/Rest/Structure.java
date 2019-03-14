import javax.swing.*;
import java.awt.*;

public class Structure extends Area{

	private static String type;
	private static int numberOfDoors;
	private static int numberOfWindows;
	private static double visibility;

	public Structure(String t, double[] topLeft, double[] bottomRight)
	{
		super(topLeft, bottomRight);
		type = t;
		if(type == "tower") visibility = 18.0;
		else visibility = 10.0;
	}

	//If the Positions given are not on the border of the Structure, the entrance is null
	public static Entrance createEntrance(String type, double[] begPosition, double[] endPosition)
	{
		double x1 = begPosition[0];
		double y1 = begPosition[1];
		double x2 = endPosition[0];
		double y2 = endPosition[1];
		Entrance entrance = null;


		//the entrance is going to be vertical
		if((x1 == x2) && (x1 == topLeft[0] || x1 == bottomRight[0]))
		{
			if(	(y1 > topLeft[1]) && (y2 > topLeft[1]) &&
				(y1 < bottomRight[1]) && (y2 < bottomRight[1]))
			{
				entrance = new Entrance(type, begPosition, endPosition);
			}
		}
		else
		//the entrance is going to be horizontal
		if(y1 == y2)
		{
			if(	(x1 > topLeft[0]) && (x2 > topLeft[0]) &&
				(y1 < bottomRight[0]) && (y2 < bottomRight[0]))
			{
				entrance = new Entrance(type, begPosition, endPosition);
			}
		}
		return entrance;

	}


	//To determine if an agent is in a structure
	private static Boolean inStructure(double[] pos)
	{

		if((pos[0] < topLeft[0]) || (pos[0] > bottomRight[0]) ||
			(pos[1] < topLeft[1]) || (pos[1] > bottomRight[1])) return false;
		else return true;

	}

	public String getType()
	{
		return type;
	}

	public double getVisibility(){
		return visibility;
	}

	public int hasDoors()
	{
		return numberOfDoors;
	}

	public  int hasWindows()
	{
		return numberOfWindows;
	}


}
