package FrontEnd;

import View.Map;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Builder extends JFrame
{
    private BuilderPanel builderPanel;

    private JButton zoomIn, zoomOut, toggleGrid;

    private JButton continueB, back;

    private JButton structure, target, cover, sentryTower, outerWall;

    private Map map;

    public Builder()
    {
        super(Settings.getTitle());

        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        map = new Map();

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        builderPanel = new BuilderPanel();

        JPanel zoomPanel = new JPanel();

        zoomPanel.setLayout(new GridLayout(1,0,5,5));

        zoomIn = new JButton("Zoom in");
        zoomIn.addActionListener(e ->
        {
            builderPanel.increaseZoomLevel();
        });

        zoomOut = new JButton("Zoom out");
        zoomOut.addActionListener(e ->
        {
            builderPanel.decreaseZoomLevel();
        });

        toggleGrid = new JButton("Toggle grid");
        toggleGrid.addActionListener(e ->
        {
            builderPanel.toggleShowGrid();
        });

        zoomPanel.add(zoomIn);
        zoomPanel.add(zoomOut);
        zoomPanel.add(toggleGrid);

        centerPanel.add(builderPanel, BorderLayout.CENTER);
        centerPanel.add(zoomPanel, BorderLayout.SOUTH);

        JPanel rightPanel = new JPanel();
        rightPanel.setBorder(new TitledBorder("Types"));
        rightPanel.setLayout(new BorderLayout(0,0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5,0,0,5));

        structure = new JButton("Structure");
        structure.addActionListener(e ->
        {

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

        JPanel menuButtonPanel = new JPanel();
        menuButtonPanel.setLayout(new GridLayout(0,1,0,5));

        continueB = new JButton("Continue");
        continueB.addActionListener(e ->
        {
            this.setVisible(false);
            StateManager.setGameState(StateManager.GameState.WORLD);
            StateManager.update();
        });

        back = new JButton("Back");
        back.addActionListener(e -> {
            this.setVisible(false);
            StateManager.setGameState(StateManager.GameState.MENU);
            StateManager.update();
        });

        menuButtonPanel.add(continueB);
        menuButtonPanel.add(back);

        rightPanel.add(buttonPanel, BorderLayout.NORTH);
        rightPanel.add(menuButtonPanel, BorderLayout.SOUTH);

        this.add(centerPanel, BorderLayout.CENTER);
        this.add(rightPanel, BorderLayout.EAST);

        this.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    public Map getMap()
    {
        return map;
    }
}
