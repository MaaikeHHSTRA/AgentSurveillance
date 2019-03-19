package View;
import Backend.Agent;
import Backend.Intruder;
import Backend.Surveillance;

import java.util.Random;

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
			Random random = new Random();
			enteringTime = random.nextGaussian()*2 + 12.0; //Normal distribution with std 2 and mean = 12
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


	//to check if can enter the Sentry tower
	public boolean canEnterSentryTower(Agent agent) {
		if (agent instanceof Surveillance) return true;
		return false;
	}
}
