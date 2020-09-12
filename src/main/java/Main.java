import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //new MouseCoordinates().getMouseCoord();
        //new MouseCoordinates().setMouseCoord(0,0);
        ConfigParser.load();
        new WebcamManager().makeCapture();
        new Bot().sendPhotoMessage();

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        ApiContextInitializer.init();
        try {
            telegramBotsApi.registerBot(new Bot());
        } catch (
                TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

}
