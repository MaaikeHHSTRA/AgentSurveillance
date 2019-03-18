package View;
import java.util.ArrayList;

public class Map
{
    private ArrayList<Area> areaList;

    public Map()
    {

    }

    public void addArea(Area area)
    {
        areaList.add(area);
    }

    public ArrayList<Area> getAreaList()
    {
        return areaList;
    }
}
