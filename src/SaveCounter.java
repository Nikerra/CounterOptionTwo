import java.io.*;

public class SaveCounter {
    static void save(int saveCounter) {
        try (ObjectOutputStream objOStr = new ObjectOutputStream(new FileOutputStream(CounterService.getFileName()))) {
            objOStr.writeInt(saveCounter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
