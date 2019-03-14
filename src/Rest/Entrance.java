
public class Entrance{

	private static String type;
	private static double[] begPos = null;
	private static double[] endPos = null;
	private static double enteringSoundDistance;
	private static double enteringTime;
	
	public Entrance(String t, double[] begP, double[] endP)
	{
		type = t;
		begPos = begP;
		endPos = endP;
		if(type == "door")
		{
			enteringSoundDistance = 5.0;
			enteringTime = 5.0;
		} else
		{ 
			enteringSoundDistance = 10.0;
			enteringTime = 3.0;
		}	
	}
	
	public void setPosition(double[] begP, double[] endP){
		begPos = begP;
		endPos = endP;
	}
	
	public double[] getBegPosition(){
		return begPos;
	}
	
	public double[] getEndPosition(){
		return endPos;
	}
	
}
