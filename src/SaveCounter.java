import java.io.FileWriter;
import java.io.IOException;

public class SaveCounter {
    public static void saveCounter(int counter) {
        try (FileWriter fw = new FileWriter("exemple.txt")) {
            fw.append(String.valueOf(counter));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
