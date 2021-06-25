import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LVertical here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LVertical extends Actor
{
    public LVertical(){
        GreenfootImage linhaHorizontal = new GreenfootImage(2,100);
        linhaHorizontal.setColor(greenfoot.Color.RED);
        linhaHorizontal.fill();
        setImage(linhaHorizontal);
    }
    
    /**
     * Act - do whatever the LVertical wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
