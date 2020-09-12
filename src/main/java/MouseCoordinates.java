import java.awt.*;

public class MouseCoordinates {

     void getMouseCoord(){
        PointerInfo pInfo = MouseInfo.getPointerInfo();
        Point point = pInfo.getLocation();

        int xCoord = (int) point.getX();
        int yCoord = (int) point.getY();

        System.out.println("x =" + xCoord);
        System.out.println("y =" + yCoord);
    }

    void setMouseCoord(int xSet, int ySet) {
        Robot robot = null;
        try {
            robot = new Robot();
            robot.mouseMove(xSet, ySet);

            System.out.println("Mouse on zero coordinates");
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }
}
