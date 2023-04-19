package utilities;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author alpinaro (Alper Çınaroğlu)
 * https://github.com/alpinaro
 */
public class Auxiliary {

    // Static wait in seconds
    public static void wait(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Read file
    public static String read(String file) {

        String content = "";

        try (FileInputStream fis = new FileInputStream(file)) {
            int data;

            while ((data = fis.read()) != -1) {
                content += (char)data;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
