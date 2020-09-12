import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigParser {
    private static final String CONFIG_FILE = "config/config.properties";

    private static String BOT_NAME;
    private static String BOT_TOKEN;
    private static String CHAT_ID;
    private static String FILE_PATH;

    public static void load() {

        Properties properties = new Properties();
        try {
            InputStream is = new FileInputStream(new File(CONFIG_FILE));
            properties.load(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setBotUserName(properties.getProperty("BotUserName"));
        setBotToken(properties.getProperty("BotToken"));
        setChatId(properties.getProperty("ChatID"));
        setFilePath(properties.getProperty("FilePath"));

    }

    public static String getBotUserName() {
        return BOT_NAME;
    }

    public static void setBotUserName(String botName) {
        BOT_NAME = botName;
    }

    public static String getBotToken() {
        return BOT_TOKEN;
    }

    public static void setBotToken(String botToken) {
        BOT_TOKEN = botToken;
    }

    public static String getChatId() {
        return CHAT_ID;
    }

    public static void setChatId(String chatId) {
        CHAT_ID = chatId;
    }

    public static String getFilePath() {
        return FILE_PATH;
    }

    public static void setFilePath(String filePath) {
        FILE_PATH = filePath;
    }

}
