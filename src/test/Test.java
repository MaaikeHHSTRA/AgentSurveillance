package test;

import Backend.Agent;
import Backend.Intruder;
import Backend.Surveillance;
import Controller.PhysicsEngine;
import Controller.Simulator;
import View.Structure;

import java.util.ArrayList;

public class Test {

    public static void main(String args[])
    {
        Surveillance a = new Surveillance(new double[]{2.0, 2.0}, 0);
        Surveillance b = new Surveillance(new double[]{2.0, 2.0}, 180);
        Intruder c = new Intruder(new double[]{3.0, 4.0}, 200);
        Structure house = new Structure("normal", new  double[]{3.0, 3.0}, new double[]{4.0, 0.0});

        ArrayList<Agent> agents = new ArrayList<Agent>();
        ArrayList<Structure> structures = new ArrayList<Structure>();

        agents.add(a);
        agents.add(b);
  //      agents.add(c);
        structures.add(house);

        PhysicsEngine p = new PhysicsEngine(agents, structures);

        p.update();

    }
}
