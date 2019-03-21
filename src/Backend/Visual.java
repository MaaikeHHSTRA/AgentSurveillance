package Backend;

import static java.lang.Math.*;

public class Visual
{
    double angle;
    double x;
    double y;
    double visionBeg;
    double visionEnd;

    public Visual(double[] position, double visualAngle, double[] visualRange){
        angle = visualAngle;
        x = position[0];
        y = position[1];
        visionBeg = visualRange[0];
        visionEnd = visualRange[1];
    }

    public double[][] getVisualArea(){

        double[] topEndPoint = {x + cos(angle/2)*visionEnd, y + sin(angle/2)*visionEnd};
        double[] botEndPoint = {x - cos(angle/2)*visionEnd, y - sin(angle/2)*visionEnd};
        double[] topBegPoint = {x,y};
        double[] botBegPoint = {x,y};

        if(visionBeg != 0){
            //To implement when the agent can't see close to him
        }

        double[][] areaPoints = {topBegPoint, botBegPoint, topEndPoint, botEndPoint};
        return areaPoints;
    }

}
