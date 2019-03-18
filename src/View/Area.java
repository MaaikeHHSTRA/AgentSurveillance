package View;

public class Area
{
    protected double[] topLeft, bottomRight;

    public Area(double[] topLeft, double[] bottomRight)
    {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public Area(double left, double top, double right, double bottom)
    {
        this(new double[]{left, top}, new double[]{right, bottom});
    }

    public double[] getTopLeft()
    {
        return topLeft;
    }

    public void setTopLeft(double[] topLeft)
    {
        this.topLeft = topLeft;
    }

    public double[] getBottomRight()
    {
        return bottomRight;
    }

    public void setBottomRight(double[] bottomRight)
    {
        this.bottomRight = bottomRight;
    }

    public boolean inArea(double[] pos)
    {
        if((pos[0] < topLeft[0]) || (pos[0] > bottomRight[0]) ||
                (pos[1] < topLeft[1]) || (pos[1] > bottomRight[1])) return false;
        else return true;
    }

}
