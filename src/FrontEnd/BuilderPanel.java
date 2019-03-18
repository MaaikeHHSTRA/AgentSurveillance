package FrontEnd;

import View.Map;
import View.Area;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class BuilderPanel extends JPanel
{
    private final int PANELRATIO, VIEWWIDTH, VIEWHEIGHT;
    private final double ZOOMINCREMENT, MAXZOOM;
    private int worldWidth, worldHeight, panelWidth, panelHeight, xPosition, yPosition;
    private double zoomLevel;
    private boolean showGrid;

    public BuilderPanel()
    {
        worldWidth = Settings.getWorldWidth();
        worldHeight = Settings.getWorldHeight();

        PANELRATIO = 100;
        VIEWHEIGHT = 800;
//        VIEWWIDTH = VIEWHEIGHT/worldHeight*worldWidth;
        VIEWWIDTH = 800;
        ZOOMINCREMENT = 1.5;
        MAXZOOM = 4;

        panelWidth = PANELRATIO * worldWidth;
        panelHeight = PANELRATIO * worldHeight;
        xPosition = panelWidth / 2;
        yPosition = panelHeight / 2;

        zoomLevel = Math.min((double)VIEWHEIGHT/panelHeight,(double)VIEWWIDTH/panelWidth);

        showGrid = true;

        this.setBackground(Color.GREEN);
        this.setPreferredSize(new Dimension(VIEWWIDTH,VIEWHEIGHT));
    }

    public void increaseZoomLevel()
    {
        if (zoomLevel * ZOOMINCREMENT <= MAXZOOM)
        {
            zoomLevel *= ZOOMINCREMENT;
            repaint();
        }
    }

    public void decreaseZoomLevel()
    {
        if ((zoomLevel / ZOOMINCREMENT * panelWidth >= VIEWWIDTH) || (zoomLevel / ZOOMINCREMENT * panelHeight >= VIEWHEIGHT))
        {
            zoomLevel /= ZOOMINCREMENT;
            repaint();
        }
    }

    public void setShowGrid(boolean state)
    {
        showGrid = state;
    }

    public void toggleShowGrid()
    {
        if(showGrid)
            showGrid = false;
        else
            showGrid = true;
        repaint();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        AffineTransform at = new AffineTransform();
        at.translate(- xPosition * zoomLevel + VIEWWIDTH / 2, - yPosition * zoomLevel + VIEWHEIGHT / 2);
        at.scale(zoomLevel, zoomLevel);

        g2.setTransform(at);

        if(showGrid)
            drawGrid(g2);
    }

    public void drawGrid(Graphics2D g2)
    {
        for (int i = 1; i < worldWidth; i++)
        {
            g2.draw(new Line2D.Double(i * PANELRATIO,0,i * PANELRATIO,panelHeight));
        }

        for (int i = 1; i < worldHeight; i++)
        {
            g2.draw(new Line2D.Double(0, i * PANELRATIO,panelWidth,i * PANELRATIO));
        }
    }

    public void drawMap(Graphics2D g2, Map map)
    {
        ArrayList<View.Area> areaList = map.getAreaList();

        for (int i = 0; i < areaList.size(); i++)
        {
            drawArea(g2, areaList.get(i));
        }
    }

    public void drawArea(Graphics2D g2, Area area)
    {
        double[] topLeft = area.getTopLeft();
        double[] bottomRight = area.getBottomRight();

        g2.draw(new Rectangle());
    }
}
