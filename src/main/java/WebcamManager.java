import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class WebcamManager {

    void makeCapture () {

        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(new Dimension(640, 480));

        if (!webcam.isOpen()){
            webcam.open();
        }

        try {
            File photoDir = new File(ConfigParser.getFilePath());
            if (!photoDir.exists()) {
                photoDir.mkdirs();
                System.out.println("Folder \"" + ConfigParser.getFilePath() + "\"" + " is created.");
            }
            ImageIO.write(webcam.getImage(), "PNG", new File(ConfigParser.getFilePath() + "rat.png"));
            System.out.println("Saved image " + ConfigParser.getFilePath() + "rat.png");

        } catch (IOException e) {
            throw new WebcamException(e);
        }
        webcam.close();
    }
}
