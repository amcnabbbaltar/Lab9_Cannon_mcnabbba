import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Canon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cannon extends Actor
{
    private final static double CANNON_BALL_VELOCITY = 1500.0f;
    /**
     * Act - do whatever the Canon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
       MouseInfo mouse = Greenfoot.getMouseInfo();
       if (mouse != null )
       {
           Vector2D canonToMouse = new Vector2D(mouse.getX()- getX(), mouse.getY()- getY());
           alignWithVector(canonToMouse);
           
           if (Greenfoot.mouseClicked(null))
           {
               canonToMouse.normalize();
               Vector2D canonballVelocity = Vector2D.multiply(canonToMouse , CANNON_BALL_VELOCITY);
               
               CannonBall ball = new CannonBall();
               ball.setVelocity(canonballVelocity);
               getWorld().addObject(ball, getX(), getY());
           }
            
       }
    }
    public void alignWithVector(Vector2D v)
    {
        
           double adjacent = v.getX();
           double opposite = v.getY();
           
           double angleRadians = Math.atan2(opposite, adjacent );
           double angleDegrees = Math.toDegrees(angleRadians);
           
           setRotation((int) angleDegrees);
    }
}
