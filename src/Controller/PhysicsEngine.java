package Controller;

import Agents.Agents;
import Backend.Agent;
import Backend.Body;
import Math.MathLib;
import View.Structure;

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
            ArrayList<Agent> agentsInVision= new ArrayList<Agent>();

            double[] oldPos = b.getPosition();
            double[] newPos = newPos(b.getVelocity(), b.getPosition(), b.getAngleFacing());

            for(Structure s : structures){

                s.get
            }

        }
    }

    public double[] newPos(double v, double[] p, double a){
        double updateX = v*Math.cos(Math.toRadians(a));
        double updateY = v*Math.sin(Math.toRadians(a));
        double[] newPos = {p[0] + updateX, p[1] + updateY};
        return newPos;
    }



    public double[] hasIntersection(double[] L1P1, double[] L1P2, double[] L2P1, double[] L2P2){

        double a1 = MathLib.lineEquationFromTwoPoints(L1P1, L1P2)[0];
        double b1 = MathLib.lineEquationFromTwoPoints(L1P1, L1P2)[1];
        double a2 = MathLib.lineEquationFromTwoPoints(L2P1, L2P2)[0];
        double b2 = MathLib.lineEquationFromTwoPoints(L2P1, L2P2)[1];

        //If there would be an Intersection it would be here
        double interX = (b2 - b1)/(a2 - a1);
        double interY = a1*interX + b1;
        double[] intersection = {interX, interY};

        double firstLineLength = MathLib.distanceBetweenTwoPoints(L1P1, L1P2);
        double distanceFirstLineFirstPointAndIntersection =
                MathLib.distanceBetweenTwoPoints(L1P1, intersection);

        if(firstLineLength > distanceFirstLineFirstPointAndIntersection)
            return intersection;
        else return null;
    }

    public boolean isColision(double[] newPos, double[] endPos, Structure s){
        return false;
    }

    //TAKE CARE OF COLLISIONS
}
