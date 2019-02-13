import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Builder extends JFrame
{
    JButton structure;
    JButton target;
    JButton cover;
    JButton sentryTower;
    JButton outerWall;

    JButton zoomIn;
    JButton zoomOut;

    public Builder(String title)
    {
        super(title);

        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel viewPanel = new JPanel();
        viewPanel.setBackground(Color.GREEN);
        viewPanel.setPreferredSize(new Dimension(1000,1000));

        JScrollPane scrollPane = new JScrollPane(viewPanel);
        scrollPane.setPreferredSize(new Dimension(800, 600));

        JPanel rightPanel = new JPanel();
        rightPanel.setBorder(new TitledBorder("Types"));
        rightPanel.setLayout(new BorderLayout(0,0));

        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(5,0,0,5));

        structure = new JButton("Structure");
        structure.addActionListener(e -> {

        });

        target = new JButton("Target");
        target.addActionListener(e -> {

        });

        cover = new JButton("Cover");
        cover.addActionListener(e -> {

        });

        sentryTower = new JButton("Sentry tower");
        sentryTower.addActionListener(e -> {

        });

        outerWall = new JButton("Outer wall");
        outerWall.addActionListener(e -> {

        });

        buttonPanel.add(structure);
        buttonPanel.add(target);
        buttonPanel.add(cover);
        buttonPanel.add(sentryTower);
        buttonPanel.add(outerWall);

        JPanel zoomPanel = new JPanel();

        zoomPanel.setLayout(new GridLayout(2,0,0,5));

        zoomIn = new JButton("Zoom in");
        zoomIn.addActionListener(e -> {

        });

        zoomOut = new JButton("Zoom out");
        zoomOut.addActionListener(e -> {

        });

        zoomPanel.add(zoomIn);
        zoomPanel.add(zoomOut);

        rightPanel.add(buttonPanel, BorderLayout.NORTH);
        rightPanel.add(zoomPanel, BorderLayout.SOUTH);

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(rightPanel, BorderLayout.EAST);

        this.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
}
