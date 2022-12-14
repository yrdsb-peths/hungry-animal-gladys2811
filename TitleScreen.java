import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen
 * 
 * @author Gladys 
 * @version December 2022
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("The Elephant", 60);
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
        addObject(elephant,507,192);
        elephant.setLocation(476,188);
        elephant.setLocation(423,71);
        Label label = new Label("Use \u2190 and \u2192 to move", 40);
        addObject(label,266,281);
        label.setLocation(387,299);
        Label label2 = new Label("Press < space > to start!", 40);
        addObject(label2,292,322);
        label.setLocation(438,293);
        label.setLocation(398,239);
        label2.setLocation(388,306);
        label.setLocation(161,258);
        label2.setLocation(153,305);
    }
}
