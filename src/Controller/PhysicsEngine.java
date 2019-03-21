package Controller;

import Agents.Agents;
import Backend.Agent;
import Backend.Body;
import Math.MathLib;
import View.Structure;

import java.awt.geom.Line2D;
import java.lang.Math;
import java.util.ArrayList;

public class PhysicsEngine {

    ArrayList<Agent> agents;
    ArrayList<Structure> structures;

    public PhysicsEngine(ArrayList<Agent> a, ArrayList<Structure> s) {
        agents = a;
        structures = s;
    }

    public void update(){
        for (Agent a : agents) {

            Body b = a.getBody();

            ArrayList<Structure> structuresInVision = new ArrayList<Structure>();
            ArrayList<Agent> agentsInVision = new ArrayList<Agent>();

            //Look for every structure to see if there's any collision with its walls during the next step

            double[] oldPos = b.getPosition();
            double[] newPos = newPos(b.getVelocity(), b.getPosition(), b.getAngleFacing());

            boolean bumpIntoWall = false;
            for(Structure s : structures){
                for(double[][] wall : s.getWalls()){

                    if(Line2D.linesIntersect(
                            oldPos[0], oldPos[1], newPos[0], newPos[1],
                            wall[0][0], wall[0][1], wall[1][0], wall[1][1])){

                        //L'agent va intersecter cette structure durant son prochain mouvement
                        System.out.println("You gonna enter in a wall dummie!");
                        bumpIntoWall = true;
                    }
                }
            }

            //If the agent doesnt bump into a wall, update his position
            if(!bumpIntoWall) a.getBody().setPosition(newPos);
        }
    }

    //New position of the agent calculate with its position, velocity and angle
    public double[] newPos(double v, double[] p, double a){

        double updateX = v*Math.cos(Math.toRadians(a));
        double updateY = v*Math.sin(Math.toRadians(a));
        double[] newPos = {p[0] + updateX, p[1] + updateY};

        return newPos;
    }

    public boolean isColision(double[] newPos, double[] endPos, Structure s){
        return false;
    }

    //TAKE CARE OF COLLISIONS
}
