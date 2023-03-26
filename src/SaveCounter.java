import java.io.*;

public class SaveCounter {
    protected void save(int saveCounter) {
        try (ObjectOutputStream objOStr = new ObjectOutputStream(new FileOutputStream(new CounterService().getFileName()))) {
            objOStr.writeInt(saveCounter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
