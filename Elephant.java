import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant.
 * 
 * @author Gladys 
 * @version December 2022
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound ("elephantcub.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    String facing = "right";
    
    public Elephant()
    {
        for (int i = 0; i < idleRight.length; i++)
        {
           idleRight[i] = new GreenfootImage ("images/elephant_idle/idle" + i + ".png"); 
           idleRight[i].scale(100, 100);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
        }
        setImage(idleRight[0]);
    }
    
    int imageIndex = 0;
    public void animateElephant()
    {
        if (facing.equals("right"))
        {
            setImage(idle[imageIndex]);
            imageIndex = (imageIndex + 1) % idle.length;
        }
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown ("left"))
        {
            move (-2);
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            move(2);
        }
        
        //Remove apple if elephant eats it
        eat();
        
        //Animate the elephant
        animateElephant();
    }
    
    /**
     * Eat the apple and spawn new apple if an apple is eaten
     */
    public void eat()
    {
        if (isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnApple();
            world.increaseScore();
            elephantSound.play();
        }
    }
}
