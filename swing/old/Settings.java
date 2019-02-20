public class Settings
{
    private static String title;
    private static int worldHeight;
    private static int worldWidth;

    public Settings(String title, int worldHeight, int worldWidth)
    {
        Settings.title = title;
        Settings.worldHeight = worldHeight;
        Settings.worldWidth = worldWidth;
    }

    public Settings(String title)
    {
        this(title, 1000, 1000);
    }

    public static String getTitle()
    {
        return title;
    }

    public static void setTitle(String title)
    {
        Settings.title = title;
    }

    public static int getWorldWidth()
    {
        return worldWidth;
    }

    public static void setWorldWidth(int worldWidth)
    {
        Settings.worldWidth = worldWidth;
    }

    public static int getWorldHeight()
    {
        return worldHeight;
    }

    public static void setWorldHeight(int worldHeight)
    {
        Settings.worldHeight = worldHeight;
    }
}
