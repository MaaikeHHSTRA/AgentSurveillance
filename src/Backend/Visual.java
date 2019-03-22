package Backend;

import static java.lang.Math.*;

public class Visual
{
    double angle;
    double x;
    double y;
    double[] visionBeg;
    double[] visionEnd;

    public Visual(double[] position, double angleFacing, double visualAngle, float[] visualRange){
        angle = visualAngle;
        x = position[0];
        y = position[1];

        if(visualRange[0] == 0) visionBeg = position;
        else {

            visionBeg = new double[]{x + visualRange[0] * cos(Math.toRadians(angleFacing)),
                    y + visualRange[0] * sin(Math.toRadians(angleFacing))};
        }
        visionEnd = new double[]{x + visualRange[1] * cos(Math.toRadians(angleFacing)),
                y + (visualRange[1] * sin(Math.toRadians(angleFacing)))};

    }

    public double[][] getVisualArea(){

        double[] topEndPoint = {x + cos(Math.toRadians(angle/2)) * visionEnd[0],
                                y + sin(Math.toRadians(angle/2)) * visionEnd[1]};
        double[] botEndPoint = {x - cos(Math.toRadians(angle/2)) * visionEnd[0],
                                y - sin(Math.toRadians(angle/2)) * visionEnd[1]};
        double[] topBegPoint = visionBeg;
        double[] botBegPoint = visionBeg;

        //To implement when the agent can't see close to him

        double[][] areaPoints = {topBegPoint, botBegPoint, topEndPoint, botEndPoint};
        return areaPoints;
    }

}
