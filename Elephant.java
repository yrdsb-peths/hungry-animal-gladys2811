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
    
    //Direction the elephant is facing
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    
    public Elephant(int speed)
    {
        this.speed = speed;
        for (int i = 0; i < idleRight.length; i++)
        {
           idleRight[i] = new GreenfootImage ("images/elephant_idle/idle" + i + ".png"); 
           idleRight[i].scale(100, 100);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100);
        }
        setImage(idleRight[0]);
    }
    
    int imageIndex = 0;
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        
        if (facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    public void act()
    {
        move();
    }
    public void move()
    {
        int x = getX();
        int y = getY();
        if (Greenfoot.isKeyDown("W"))
        {
            y -=2;
        }
        if (Greenfoot.isKeyDown("A"))
        {
            x-=2;
            facing = "left";
        }

        if (Greenfoot.isKeyDown("right"))
        if (Greenfoot.isKeyDown("S"))
        {
            y+=2;
        }
        if (Greenfoot.isKeyDown("D"))
        {
            x+=2;
            facing = "right";
        }
        if (Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + speed);
        }
        if (Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() - speed);
        }
        
        //Remove apple if elephant eats it

        setLocation(x, y);
        eat();
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
