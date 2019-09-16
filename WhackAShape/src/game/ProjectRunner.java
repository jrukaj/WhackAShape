package game;

/**
 * Initializes the WhackShape() GUI, running the GUI
 * and initializing the abstract data structures that
 * hold the shape objects.
 * 
 * @author Jonathan Rukaj <jrukaj>
 * @version 6.5.2019
 */
public class ProjectRunner {
    

    /**
     * Calls the WhackAShape constructor
     * 
     * @param args
     *            Array of strings representing the command
     *            line input arguments
     */
    public static void main(String[] args) {
        // Calls WhackAShape constructor with parameter if args is not empty
        if (args.length > 0) {
            new WhackAShape(args);
        }
        // Calls the normal WhackAShape constructor
        else {
            new WhackAShape();
        }

    }
}
