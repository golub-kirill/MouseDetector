import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bot extends TelegramLongPollingBot {
    static long chatID;
    String messageText;
    SendMessage sendMessage;

    public void onUpdateReceived(Update update) {

        chatID = update.getMessage().getChatId().intValue();
        sendMessage = new SendMessage().setChatId(chatID);
        messageText = update.getMessage().getText();

        if (messageText != null && update.getMessage().hasText()) {
            if (messageText.equals("/start")) {
                sendMessage.setText("Hello " + chatID);
            }


        } else sendMessage.setText("Я даже не знаю, что тебе ответить");
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendPhotoMessage() throws FileNotFoundException {
        sendMessage = new SendMessage()
                .setText(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()))
                .setChatId(ConfigParser.getChatId());
        SendPhoto sendPhoto = new SendPhoto()
                .setPhoto("rat", new FileInputStream(new File(ConfigParser.getFilePath()) + "\\rat.png"))
                .setChatId(ConfigParser.getChatId());
        try {
            execute(sendMessage);
            execute(sendPhoto);
            System.out.println("Rat's photo is sending");

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return ConfigParser.getBotUserName();
    }

    public String getBotToken() {
        return ConfigParser.getBotToken();
    }
}
