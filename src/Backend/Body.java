package Backend;

import Math.Vector2;

//Here will be computed the movement, turning, visual, hearing
public class Body {

    //make part of agent
    private float angleFacing;
    private float velocity;
    private float visualRange;
    private Vector2 position;

    private float restTime;
    private float runTime;
    private boolean canRun;

    public void stand() {
        if (getMovementState() == 2) {
            restTime = System.currentTimeMillis();
        }
        velocity = 0;
    }

    public void walk() {
        if (getMovementState() == 2) {
            restTime = System.currentTimeMillis();
        }
        velocity = 1.4f;
    }

    public void run() {
        if (canRun) {
           velocity = 3.0f;
           runTime = System.currentTimeMillis();
           canRun = false;
        }
    }


    //called in every frame
    public void checkRun() {
        //Must rest for 10 seconds
        if (System.currentTimeMillis() - restTime > 10000) {
            canRun = true;
        }

        //can only run for 5 seconds
        if (getMovementState() == 2) {
            if (System.currentTimeMillis() - runTime > 5000) {
                walk();
            }
        }
    }

    public int getMovementState() {
        // 0 for standing
        // 1 for walking
        // 2 for running/sprint
        if (velocity == 0) {
            return 0;
        } else if (velocity > 2) {
            return 2;
        } else
            return 1;
    }

    


}
