package States;

import States.Builder;
import States.Menu;
import States.World;

public class StateManager
{
    private static String title;
    private static GameState gameState;
    private static Menu menu;
    private static Builder builder;
    private static World world;

    public StateManager(String title)
    {
        this.title = title;
        gameState = GameState.MENU;
        update();
    }

    public enum GameState
    {
        MENU, BUILDER, WORLD
    }

    public static void update()
    {
        switch (gameState)
        {
            case MENU:
                menu = new Menu(title);
                break;
            case BUILDER:
                builder = new Builder(title);
                break;
            case WORLD:
                world = new World(title);
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
