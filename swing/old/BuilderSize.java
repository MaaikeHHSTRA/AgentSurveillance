import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class BuilderSize extends JFrame
{
    JTextField worldWidth, worldHeight;
    JLabel topLabel, worldWidthL, worldHeightL, errorL;

    JButton continueB;

    public BuilderSize()
    {
        super(Settings.getTitle());

        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));

        topLabel = new JLabel("Set world size.");
        topLabel.setPreferredSize(new Dimension(200, 50));
        topLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0,2,0,5));

        worldWidth = new JTextField("200",5);
        worldHeight = new JTextField("200",5);
        worldWidthL = new JLabel("Width:");
        worldHeightL = new JLabel("Height:");

        buttonPanel.add(worldWidthL);
        buttonPanel.add(worldWidth);
        buttonPanel.add(worldHeightL);
        buttonPanel.add(worldHeight);

        errorL = new JLabel();

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        centerPanel.add(topLabel, BorderLayout.NORTH);
        centerPanel.add(buttonPanel, BorderLayout.CENTER);
        centerPanel.add(errorL, BorderLayout.SOUTH);

        continueB = new JButton("Continue");
        continueB.addActionListener(e ->
        {
            int width = Integer.parseInt(worldWidth.getText());
            int height = Integer.parseInt(worldHeight.getText());

            if(width < 200)
            {
                errorL.setText("Width has to be at least 200.");
                errorL.setForeground(Color.RED);
                this.pack();
            }
            else if (height < 200)
            {
                errorL.setText("Height has to be at least 200.");
                errorL.setForeground(Color.RED);
                this.pack();
            }
            else
            {
                Settings.setWorldWidth(width);
                Settings.setWorldHeight(height);
                this.dispose();
                StateManager.setGameState(StateManager.GameState.BUILDER);
            }
        });

        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(continueB, BorderLayout.SOUTH);

        this.add(panel);

        this.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
}
