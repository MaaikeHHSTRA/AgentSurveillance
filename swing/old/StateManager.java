public class StateManager
{
    private static String title;
    private static GameState gameState;
    private static MenuState menuState;
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
                if (menuState == null)
                    menuState = new MenuState();
                else
                    menuState.setVisible(true);
                break;
            case BUILDER:
                builder = new Builder();
                break;
            case BUILDERSIZE:
                builderSize = new BuilderSize();
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
        update();
    }
}
