package test;

public class Test {

    public static void main(String args[])
    {
        double v = 6.0;
        double a = 10.0;
        double[] p = {25.0, 34.0};
        double deltaX = v*Math.cos(Math.toRadians(a));
        double deltaY = v*Math.sin(Math.toRadians(a));
        double[] newPos = {p[0] + deltaX, p[1] + deltaY};
        System.out.print(newPos[0] + " " + newPos[1]);
    }
}
