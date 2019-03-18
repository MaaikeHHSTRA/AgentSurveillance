package model;

public class SentryTower extends RectancleFactory {

    private static SentryTower instance = null;

    private SentryTower() {

    }

    public static SentryTower getInstance() {
        if (instance == null) {
            instance = new SentryTower();
        }
        return instance;

    }
}
