import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WebcamManager {

    void makeCapture () {

        String timeStamp = new SimpleDateFormat("d MMMyyyy - ").format(Calendar.getInstance().getTime());
        String filePath = (ConfigParser.getFilePath()+timeStamp);

        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(new Dimension(640, 480));

        if (!webcam.isOpen()){
            webcam.open();
        }

        try {
            for (int i = 0; i < 3; i++)
            {
                ImageIO.write(webcam.getImage(),"PNG", new File(filePath + i + ".png"));
                System.out.println("Saved image "+filePath + i + ".png");
            }
        } catch (IOException e) {
            throw new WebcamException(e);
        }
        webcam.close();
    }
}
