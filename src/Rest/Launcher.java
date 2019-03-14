public class Launcher
{
    private static StateManager stateManager;

    public static void main(String args[])
    {
        Settings settings = new Settings("Agent Surveillance");
        stateManager = new StateManager();
    }
}
