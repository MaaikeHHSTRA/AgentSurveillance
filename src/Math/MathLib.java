package Math;

public class MathLib {
    // Every function should be static. MathLib should NEVER be instantiated.

    public static double[] lineEquationFromTwoPoints(double[] begPos, double[] endPos){
        double a = (endPos[1] - begPos[1])/(endPos[0] - begPos[0]);
        double b = endPos[1] - a*endPos[0];
        double[] eq = {a,b};
        return eq;
    }

    public static double distanceBetweenTwoPoints(double[] begPos, double[] endPos){
        return Math.sqrt(
                (endPos[1]-begPos[1])*(endPos[1]-begPos[1]) +
                        (endPos[0]-begPos[0])*(endPos[0]-begPos[0]));

    }

}
