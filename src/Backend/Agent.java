package Backend;
import Math.Vector2;

abstract public class Agent
{
    protected Body body;
    private Brain brain;

    public Agent(Vector2 initPos, float initAngle) {
        this.body = new Body();
        this.brain = new Brain();

        //Components that are the same for intruders and surveillance;
        body.setVelocity(1.4f);
        body.setAngleFacing(initAngle);
        body.setVisualAngle(45.0f);
        body.setPosition(initPos);
    }

    public void changeVisualRangeInShadow(){
        body.setVisualRange(body.getVisualRange()[0]/2,body.getVisualRange()[1]/2);
        body.setVisualAngle(body.getVisualAngle()/2);
    }

    public void changeVisualAngleOutShadow(){
        body.setVisualRange(body.getVisualRange()[0]*2, body.getVisualRange()[1]*2);
        body.setVisualAngle(body.getVisualAngle()*2);
    }

}
