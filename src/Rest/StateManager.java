public class StateManager
{
    private static String title;
    private static GameState gameState;
    private static Menu menu;
    private static Builder builder;
    private static BuilderSize builderSize;
    private static World world;

    public StateManager()
    {
        gameState = GameState.MENU;
        update();
    }

    public enum GameState
    {
        MENU, BUILDER, BUILDERSIZE, WORLD
    }

    public static void update()
    {
        switch (gameState)
        {
            case MENU:
                if (menu == null)
                    menu = new Menu();
                else
                    menu.setVisible(true);
                break;
            case BUILDER:
                builder = new Builder();
                break;
            case BUILDERSIZE:
                if (builderSize == null)
                    builderSize = new BuilderSize();
                else
                    builderSize.setVisible(true);
                break;
            case WORLD:
                world = new World();
                break;
        }
    }

    public static GameState getGameState()
    {
        return gameState;
    }

    public static void setGameState(GameState state)
    {
        gameState = state;
    }
}
