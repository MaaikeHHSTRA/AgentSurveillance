import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class Menu extends JFrame
{
    public Menu(String title)
    {
        super(title);

        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));

        JLabel label = new JLabel("Agent Surveillance");
        label.setPreferredSize(new Dimension(200,50));
        label.setHorizontalAlignment(JLabel.CENTER);

        JPanel mapPanel =  new JPanel();
        mapPanel.setLayout(new GridLayout(3,0,20,0));
        mapPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));

        JButton b1 = new JButton("Build Map");
        JButton b2 = new JButton("Select Map");
        JButton b3 = new JButton("Exit");

        mapPanel.add(b1);
        mapPanel.add(b2);
        mapPanel.add(b3);

        panel.add(label, BorderLayout.NORTH);
        panel.add(mapPanel, BorderLayout.CENTER);

        this.add(panel);

        this.pack();
    }
}
