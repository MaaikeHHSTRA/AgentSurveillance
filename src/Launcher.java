import States.StateManager;

public class Launcher
{
    private static StateManager stateManager;
    private static String title;

    public static void main(String args[])
    {
        title = "Agent Surveillance";
        stateManager = new StateManager(title);
    }
}
