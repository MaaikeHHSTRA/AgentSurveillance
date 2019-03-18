package model;


public class BuildingStructure extends RectancleFactory {
    private static BuildingStructure instance = null;

    private BuildingStructure() {
    }

    public static BuildingStructure getInstance() {
        if (instance == null) {
            instance = new BuildingStructure();
        }

        return instance;
    }

    public void checkOverlay(){

        //checks whether this Object has intersection with another object, if yes then cancel the
    }
}
