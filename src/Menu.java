import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame
{
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

        JButton b1 = new JButton("Build Map");
        JButton b2 = new JButton("Select Map");
        JButton b3 = new JButton("Exit");

        mapPanel.add(b1);
        mapPanel.add(b2);
        mapPanel.add(b3);

        b3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        });

        panel.add(label, BorderLayout.NORTH);
        panel.add(mapPanel, BorderLayout.CENTER);

        this.add(panel);

        this.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
}
