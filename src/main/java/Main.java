import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        ConfigParser.load();

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        ApiContextInitializer.init();
        try {
            telegramBotsApi.registerBot(new Bot());
        } catch (
                TelegramApiRequestException e) {
            e.printStackTrace();
        }

        MouseCoordinates mouseCoordinates = new MouseCoordinates();

        mouseCoordinates.setMouseCoord(0, 0);

        System.out.println("I will waiting for rat");
        while (mouseCoordinates.getMouseCoord() == 0) {
        }

        new WebcamManager().makeCapture();
        new Bot().sendPhotoMessage();
    }

}
