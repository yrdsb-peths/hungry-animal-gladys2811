import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen 
 * @author Gladys
 * @version December 2022
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label ("The Elephant", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(titleLabel, getWidth()/2, 200);

        prepare();
    }

    /**
     * The main world act loop
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,395,98);

        Label label = new Label("Press < space > to start game!", 40);
        addObject(label,310,308);
        Label label2 = new Label("Use keys W, A, S, D to move", 40);
        addObject(label2,315,367);
        label2.setLocation(311,355);
        elephant.setLocation(521,193);
    }
}
