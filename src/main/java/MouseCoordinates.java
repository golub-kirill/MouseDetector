import java.awt.*;

public class MouseCoordinates {

     int getMouseCoord() {
         PointerInfo pInfo = MouseInfo.getPointerInfo();
         Point point = pInfo.getLocation();

         int xCoord = (int) point.getX();
         int yCoord = (int) point.getY();

         return xCoord + yCoord;

     }


    void setMouseCoord(int xCoord, int yCoord) {

        Robot robot = null;

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        assert robot != null;
        robot.mouseMove(xCoord, yCoord);
    }

}
