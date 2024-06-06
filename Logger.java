import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Logger {
    private static PrintWriter writer;

    static {
        try {
            writer = new PrintWriter(new FileWriter("application.log", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(String message) {
        writer.println(LocalDateTime.now() + " - " + message);
        writer.flush();
    }

    public static void logError(String message, Exception e) {
        writer.println(LocalDateTime.now() + " - ERROR: " + message);
        e.printStackTrace(writer);
        writer.flush();
    }
}
