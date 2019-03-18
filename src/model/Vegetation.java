package model;

public class Vegetation extends RectancleFactory {

    private static Vegetation instance = null;

    private Vegetation() {

    }

    public static Vegetation getInstance() {
        if (instance == null) {
            instance = new Vegetation();
        }
    return instance;
    }
}

