import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class Menu extends JFrame
{
    private JButton buildMap;
    private JButton selectMap;
    private JButton exit;

    public Menu(String title)
    {
        super(title);

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
        mapPanel.setLayout(new GridLayout(3,0,20,0));
        mapPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));

        buildMap = new JButton("Build Map");
        buildMap.addActionListener(e ->
        {
            dispose();
            Builder builder = new Builder(title);
        });

        selectMap = new JButton("Select Map");
        selectMap.addActionListener(e ->
        {

        });

        exit = new JButton("Exit");
        exit.addActionListener(e -> {
            dispose();
        });

        mapPanel.add(buildMap);
        mapPanel.add(selectMap);
        mapPanel.add(exit);

        panel.add(label, BorderLayout.NORTH);
        panel.add(mapPanel, BorderLayout.CENTER);

        this.add(panel);

        this.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
}
