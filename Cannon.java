import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Canon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cannon extends Actor
{
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
           
           double adjacent = canonToMouse.getX();
           double opposite = canonToMouse.getY();
           
           double angleRadians = Math.atan2(opposite, adjacent );
           double angleDegrees = Math.toDegrees(angleRadians);
           
           setRotation((int) angleDegrees);
           
       }
    }
}
