import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class WebcamManager {

    void makeCapture (String formatName, File file) {
        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(new Dimension(640, 480));
        if (!webcam.isOpen()){
            webcam.open();
        }

        try {
            ImageIO.write(webcam.getImage(),formatName, file);
            System.out.println("Saved image "+file.getAbsolutePath());
        } catch (IOException e) {
            throw new WebcamException(e);
        }
        webcam.close();
    }
}
