package game;

import java.awt.Color;
import CS2114.Button;
import CS2114.CircleShape;
import CS2114.Shape;
import CS2114.SquareShape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;
import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * WhackAShape class creates a GUI that can be 
 * interacted with by the user.
 * @author Jonathan Rukaj <jrukaj>
 * @version 6.5.2019
 */
public class WhackAShape {

    private SimpleBagInterface<Shape> bag;
    private Window window;
    private TestableRandom randomGenerator;
    
    /**
     * Initializes WaackAShape constructor when there are no
     * parameters.
     */
    public WhackAShape() {
        randomGenerator = new TestableRandom();
        bag = new SimpleArrayBag<Shape>();
        window = new Window();
        window.setTitle("WhackAShape");
        Button quit = new Button("Quit");
        // Add button to north side of window
        window.addButton(quit, WindowSide.NORTH);
        // Makes button quit program on click
        quit.onClick(this, "clickedQuit");
        bag.add(buildShape("red circle"));
        bag.add(buildShape("red square"));
        bag.add(buildShape("blue circle"));
        bag.add(buildShape("blue square"));
        window.addShape(bag.pick());
    }
    
    /**
     * Initializes the WhackAShape constructor with
     * an array of strings as an input.
     * @param inputs The string input, which would be used
     * to build a shape based on the string
     */
    public WhackAShape(String[] inputs) {
        randomGenerator = new TestableRandom();
        bag = new SimpleArrayBag<Shape>();
        window = new Window();
        window.setTitle("WhackAShape");
        Button quit = new Button("Quit");
        // Add button to north side of the window
        window.addButton(quit,  WindowSide.NORTH);
        // Makes button quit program on click
        quit.onClick(this, "clickedQuit");
        // Iterate through inputs, building the shapes
        // that correlate to the given string
        for (String string: inputs) {
            try {
                bag.add(buildShape(string));
            }
            catch(Exception excep) {
                excep.printStackTrace();
            }
        }
        window.addShape(bag.pick());
    }
    
    /**
     * Parses the provided input to determine 
     * whether to create a Circle or Square shape.
     * @throws IllegalArgumentException
     * @param input the string representing the shape and its color
     * Used to build the given shape
     * @return Shape object
     */
    private Shape buildShape(String input) {
        Shape currentShape;
        // Random size from 100 to 200
        int size = 100 + randomGenerator.nextInt(101);
        int x = randomGenerator.nextInt(window.getGraphPanelWidth() - size);
        int y = randomGenerator.nextInt(window.getGraphPanelHeight() - size);
        // Create blue circle shape 
        if (input.contains("blue") && input.contains("circle")) {
            currentShape = new CircleShape(x, y, size, Color.BLUE);
        }
        // Create blue square shape
        else if (input.contains("blue") && input.contains("square")) {
            currentShape = new SquareShape(x, y, size, Color.BLUE);
        }
        // Create red circle shape
        else if (input.contains("red") && input.contains("circle")) {
            currentShape = new CircleShape(x, y, size, Color.RED);
        }
        // Create red square shape
        else if (input.contains("red") && input.contains("square")) {
            currentShape = new SquareShape(x, y, size, Color.RED);
        }
        // Throw an exception if the argument does not specify 
        // a red or blue circle, or a red or blue square
        else {
            throw new IllegalArgumentException();
        }
        currentShape.onClick(this, "clickedShape");
        return currentShape;
    }
    
    /**
     * Removes the clicked shape from the window and the bag,
     * adding a new one if the next shape is not null.
     * @param shape
     */
    public void clickedShape(Shape shape) {
        // Remove shape from window and bag
        window.removeShape(shape);
        bag.remove(shape);
        Shape nextShape = bag.pick();
        // If next shape is null, display win screen
        if (nextShape == null) {
            int centerX = (int)window.getGraphPanelWidth() / 2;
            int centerY = (int)window.getGraphPanelHeight() / 2;
            TextShape text = new TextShape(centerX, centerY, "Great job! You win!");
            // Format text's color and font
            text.setForegroundColor(Color.BLUE);
            text.setBackgroundColor(Color.WHITE);
            // Add text to the window
            window.addShape(text); 
            // Subtract half the width of the text to center it on the x-axis
            text.setX(centerX - text.getWidth() / 2);
            text.setY(centerY);
        }
        // Otherwise, add the next shape
        else {
            window.addShape(nextShape);
        }
    }
    
    /**
     * Quits the program when the button is clicked.
     * @param button a button object
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }
    
    /**
     * Returns the Window object.
     * @return the window object
     */
    public Window getWindow() {
        return window;
    }
    
    /**
     * Returns the bag abstract data structure
     * @return the bag being used
     */
    public SimpleBagInterface<Shape> getBag(){
        return bag;
    }
    
    
}
