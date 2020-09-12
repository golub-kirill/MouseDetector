import java.io.File;

public class Main {
    public static void main(String[] args) {
        //new MouseCoordinates().getMouseCoord();
        //new MouseCoordinates().setMouseCoord(0,0);
        new WebcamManager().makeCapture("PNG", new File("C:\\Users\\Fox_x\\Pictures\\test.png"));


    }
}
