package View;

public class Entrance{

	private String type;
	private double[] begPos = null;
	private double[] endPos = null;
	private double enteringSoundDistance;
	private double enteringTime;

	public Entrance(String t, double[] begP, double[] endP)
	{
		type = t;
		begPos = begP;
		endPos = endP;
		if(type == "door")
		{
			enteringSoundDistance = 5.0;
			enteringTime = 5.0;
		}
		else
		{
			enteringSoundDistance = 10.0;
			enteringTime = 3.0;
		}
	}

	public void enterWithoutSound()
	{
		if(type == "door")
		{
			enteringSoundDistance = 0.0;
			enteringTime = 12.0; //TO ADD THE STD DEV FUNCTION FROM MATH FILE (NORMAL DSTRB WITH STD 2)
		}
	}

	public void changePosition(double[] begP, double[] endP){
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
