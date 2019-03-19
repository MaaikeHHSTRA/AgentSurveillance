package Controller;
import Agents.Agents;
import View.Map;
import View.Structure;

import java.util.ArrayList;

public class Simulator {

    public ArrayList<Agents> agents;
    public ArrayList<Structure> structures;
    public Map map;
    public boolean running;

    public Simulator(){

    }


    //Game loop inspiration from https://www.youtube.com/watch?v=LhUN3EKZiio
    public void run(){

        final double GAME_HERTZ = 60.0;
        final double time_before_update = 1_000_000_000 / GAME_HERTZ;
        double must_update_before_render = 5; //code execution

        double last_update_time = System.nanoTime();
        double last_render_time;

        final double target_fps = 60;
        final double total_time_before_render = 1_000_000_000 / target_fps;

        int frame_count = 0;
        int lastSecondTime = (int) (last_update_time/1_000_000_000);
        int old_frame_count = 0;


        while(running){

            //Updates everything
            double now = System.nanoTime();
            int update_count = 0;
            while((now - last_update_time) > 0 && (update_count < must_update_before_render)){
                update();
                last_update_time += time_before_update;
                update_count ++;
            }

            render();
            draw();

            last_render_time = now;
            frame_count ++;

            //To chill down the CPU if it goes toooo fast
            while(now - last_render_time < total_time_before_render && now - last_update_time < time_before_update){
                Thread.yield();

                try{
                    Thread.sleep(1);
                }catch(Exception e){
                    System.out.println("ERROR: too fast for the CPU");
                }

                now = System.nanoTime();
            }
        }
    }

    //Function that updates all the agents positions, communications, interactions
    public void update(){

    }

    //Function that updates the visuals aka agents positions & communications
    public void render(){

    }

    //Function that redraws every frame
    public void draw(){

    }

}
