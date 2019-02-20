import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class MenuState extends State
{
    private JButton buildMap;
    private JButton importMap;
    private JButton exit;

    public MenuState()
    {
        super(Settings.getTitle());

        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));

        JLabel label = new JLabel("Agent Surveillance");
        label.setPreferredSize(new Dimension(200,50));
        label.setHorizontalAlignment(JLabel.CENTER);

        JPanel mapPanel =  new JPanel();
        mapPanel.setLayout(new GridLayout(0,1,20,0));

        buildMap = new JButton("Build Map");
        buildMap.addActionListener(e ->
        {
            this.setVisible(false);
            StateManager.setGameState(StateManager.GameState.BUILDERSIZE);
            StateManager.update();
        });

        importMap = new JButton("Import Map");
        importMap.addActionListener(e ->
        {
            JDialog test = new JDialog();
            test.setTitle("test");

            JButton testl = new JButton("wow");

            test.add(testl);

            test.setVisible(true);

            test.pack();
        });

        exit = new JButton("Exit");
        exit.addActionListener(e -> {
            dispose();
        });

        mapPanel.add(buildMap);
        mapPanel.add(importMap);
        mapPanel.add(exit);

        panel.add(label, BorderLayout.NORTH);
        panel.add(mapPanel, BorderLayout.CENTER);

        this.add(panel);

        this.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
}
